package com.fx.common.util.http.okhttp;

import com.fx.common.bean.result.WxError;
import com.fx.common.exception.WxErrorException;
import com.fx.common.util.http.RequestHttp;
import com.fx.common.util.http.SimplePostRequestExecutor;
import lombok.extern.slf4j.Slf4j;
import okhttp3.*;

import java.io.IOException;

/**
 * Created by ecoolper on 2017/5/4.
 */
@Slf4j
public class OkHttpSimplePostRequestExecutor extends SimplePostRequestExecutor<OkHttpClient, OkHttpProxyInfo> {

  public OkHttpSimplePostRequestExecutor(RequestHttp requestHttp) {
    super(requestHttp);
  }

  @Override
  public String execute(String uri, String postEntity) throws WxErrorException, IOException {
    log.debug("OkHttpSimplePostRequestExecutor running");
    //得到httpClient
    OkHttpClient client = requestHttp.getRequestHttpClient();

    MediaType mediaType = MediaType.parse("text/plain; charset=utf-8");
    RequestBody body = RequestBody.create(mediaType, postEntity);

    Request request = new Request.Builder().url(uri).post(body).build();

    Response response = client.newCall(request).execute();
    String responseContent = response.body().string();
    WxError error = WxError.fromJson(responseContent);
    if (error.getErrorCode() != 0) {
      throw new WxErrorException(error);
    }
    return responseContent;
  }

}
