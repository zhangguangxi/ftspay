package com.fx.wechat.cp.api.impl;

import com.fx.common.bean.result.WxMediaUploadResult;
import com.fx.common.exception.WxErrorException;
import com.fx.common.util.fs.FileUtils;
import com.fx.common.util.http.BaseMediaDownloadRequestExecutor;
import com.fx.common.util.http.MediaUploadRequestExecutor;
import com.fx.wechat.cp.api.WxCpMediaService;
import com.fx.wechat.cp.api.WxCpService;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.UUID;

/**
 * <pre>
 * 媒体管理接口
 * Created by Binary Wang on 2017-6-25.
 * @author <a href="https://github.com/binarywang">Binary Wang</a>
 * </pre>
 */
public class WxCpMediaServiceImpl implements WxCpMediaService {
  private WxCpService mainService;

  public WxCpMediaServiceImpl(WxCpService mainService) {
    this.mainService = mainService;
  }

  @Override
  public WxMediaUploadResult upload(String mediaType, String fileType, InputStream inputStream)
    throws WxErrorException, IOException {
    return this.upload(mediaType, FileUtils.createTmpFile(inputStream, UUID.randomUUID().toString(), fileType));
  }

  @Override
  public WxMediaUploadResult upload(String mediaType, File file) throws WxErrorException {
    String url = "https://qyapi.weixin.qq.com/cgi-bin/media/upload?type=" + mediaType;
    return this.mainService.execute(MediaUploadRequestExecutor.create(this.mainService.getRequestHttp()), url, file);
  }

  @Override
  public File download(String mediaId) throws WxErrorException {
    String url = "https://qyapi.weixin.qq.com/cgi-bin/media/get";
    return this.mainService.execute(
      BaseMediaDownloadRequestExecutor.create(this.mainService.getRequestHttp(),
        this.mainService.getWxCpConfigStorage().getTmpDirFile()),
      url, "media_id=" + mediaId);
  }
}
