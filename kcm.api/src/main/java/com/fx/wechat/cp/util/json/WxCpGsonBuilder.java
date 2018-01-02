package com.fx.wechat.cp.util.json;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.fx.common.bean.menu.WxMenu;
import com.fx.common.bean.result.WxError;
import com.fx.common.util.json.WxErrorAdapter;
import com.fx.wechat.cp.bean.WxCpDepart;
import com.fx.wechat.cp.bean.WxCpMessage;
import com.fx.wechat.cp.bean.WxCpTag;
import com.fx.wechat.cp.bean.WxCpUser;

public class WxCpGsonBuilder {

  public static final GsonBuilder INSTANCE = new GsonBuilder();

  static {
    INSTANCE.disableHtmlEscaping();
    INSTANCE.registerTypeAdapter(WxCpMessage.class, new WxCpMessageGsonAdapter());
    INSTANCE.registerTypeAdapter(WxCpDepart.class, new WxCpDepartGsonAdapter());
    INSTANCE.registerTypeAdapter(WxCpUser.class, new WxCpUserGsonAdapter());
    INSTANCE.registerTypeAdapter(WxError.class, new WxErrorAdapter());
    INSTANCE.registerTypeAdapter(WxMenu.class, new WxCpMenuGsonAdapter());
    INSTANCE.registerTypeAdapter(WxCpTag.class, new WxCpTagGsonAdapter());
  }

  public static Gson create() {
    return INSTANCE.create();
  }

}
