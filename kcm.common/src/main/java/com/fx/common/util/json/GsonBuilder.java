package com.fx.common.util.json;

import com.fx.common.bean.result.WxError;
import com.fx.common.util.ErrorAdapter;
import com.google.gson.Gson;

/**
 * Created by JONES on 2017/12/28.
 */
public class GsonBuilder {
    public static final com.google.gson.GsonBuilder INSTANCE = new com.google.gson.GsonBuilder();

    static {
        INSTANCE.disableHtmlEscaping();
        INSTANCE.registerTypeAdapter(WxError.class, new ErrorAdapter());
    }

    public static Gson create() {
        return INSTANCE.create();
    }
}
