package com.fx.wechat.cp.api.impl;

import com.fx.common.bean.WxAccessToken;
import com.fx.common.bean.result.WxError;
import com.fx.common.exception.WxErrorException;
import com.fx.common.util.http.HttpType;
import com.fx.common.util.http.okhttp.OkHttpProxyInfo;
import com.fx.wechat.cp.config.WxCpConfigStorage;
import okhttp3.*;

import java.io.IOException;

public class WxCpServiceOkHttpImpl extends WxCpServiceAbstractImpl<OkHttpClient, OkHttpProxyInfo> {
  protected OkHttpClient httpClient;
  protected OkHttpProxyInfo httpProxy;


  @Override
  public OkHttpClient getRequestHttpClient() {
    return httpClient;
  }

  @Override
  public OkHttpProxyInfo getRequestHttpProxy() {
    return httpProxy;
  }

  @Override
  public HttpType getRequestType() {
    return HttpType.OK_HTTP;
  }

  @Override
  public String getAccessToken(boolean forceRefresh) throws WxErrorException {
    this.log.debug("WxCpServiceOkHttpImpl is running");
    if (this.configStorage.isAccessTokenExpired() || forceRefresh) {
      synchronized (this.globalAccessTokenRefreshLock) {
        if (this.configStorage.isAccessTokenExpired()) {
          String url = "https://qyapi.weixin.qq.com/cgi-bin/gettoken?"
            + "&corpid=" + this.configStorage.getCorpId()
            + "&corpsecret=" + this.configStorage.getCorpSecret();
          //得到httpClient
          OkHttpClient client = getRequestHttpClient();
          //请求的request
          Request request = new Request.Builder().url(url).get().build();
          String resultContent = null;
          try {
            Response response = client.newCall(request).execute();
            resultContent = response.body().string();
          } catch (IOException e) {
            this.log.error(e.getMessage(), e);
          }

          WxError error = WxError.fromJson(resultContent);
          if (error.getErrorCode() != 0) {
            throw new WxErrorException(error);
          }
          WxAccessToken accessToken = WxAccessToken.fromJson(resultContent);
          this.configStorage.updateAccessToken(accessToken.getAccessToken(),
            accessToken.getExpiresIn());
        }
      }
    }
    return this.configStorage.getAccessToken();
  }

  @Override
  public void initHttp() {
    this.log.debug("WxCpServiceOkHttpImpl initHttp");
    //设置代理
    if (configStorage.getHttpProxyHost() != null && configStorage.getHttpProxyPort() > 0) {
      httpProxy = OkHttpProxyInfo.httpProxy(configStorage.getHttpProxyHost(),
        configStorage.getHttpProxyPort(),
        configStorage.getHttpProxyUsername(),
        configStorage.getHttpProxyPassword());
    }

    OkHttpClient.Builder clientBuilder = new OkHttpClient.Builder();
    if (httpProxy != null) {
      clientBuilder.proxy(getRequestHttpProxy().getProxy());

      //设置授权
      clientBuilder.authenticator(new Authenticator() {
        @Override
        public Request authenticate(Route route, Response response) throws IOException {
          String credential = Credentials.basic(httpProxy.getProxyUsername(), httpProxy.getProxyPassword());
          return response.request().newBuilder()
            .header("Authorization", credential)
            .build();
        }
      });
    }
    httpClient = clientBuilder.build();
  }

  @Override
  public WxCpConfigStorage getWxCpConfigStorage() {
    return this.configStorage;
  }
}
