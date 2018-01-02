package com.fx.common.api;

import com.fx.common.exception.WxErrorException;

/**
 * WxErrorException处理器.
 */
public interface WxErrorExceptionHandler {

  void handle(WxErrorException e);

}
