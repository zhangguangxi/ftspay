package com.fx.wechat.cp.api.impl;

import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;
import com.fx.common.exception.WxErrorException;
import com.fx.common.util.json.GsonHelper;
import com.fx.wechat.cp.api.WxCpDepartmentService;
import com.fx.wechat.cp.api.WxCpService;
import com.fx.wechat.cp.bean.WxCpDepart;
import com.fx.wechat.cp.util.json.WxCpGsonBuilder;

import java.util.List;

/**
 * <pre>
 *  部门管理接口
 *  Created by BinaryWang on 2017/6/24.
 * </pre>
 *
 * @author <a href="https://github.com/binarywang">Binary Wang</a>
 */
public class WxCpDepartmentServiceImpl implements WxCpDepartmentService {
  private WxCpService mainService;

  public WxCpDepartmentServiceImpl(WxCpService mainService) {
    this.mainService = mainService;
  }

  @Override
  public Integer create(WxCpDepart depart) throws WxErrorException {
    String url = "https://qyapi.weixin.qq.com/cgi-bin/department/create";
    String responseContent = this.mainService.post(url, depart.toJson());
    JsonElement tmpJsonElement = new JsonParser().parse(responseContent);
    return GsonHelper.getAsInteger(tmpJsonElement.getAsJsonObject().get("id"));
  }

  @Override
  public void update(WxCpDepart group) throws WxErrorException {
    String url = "https://qyapi.weixin.qq.com/cgi-bin/department/update";
    this.mainService.post(url, group.toJson());
  }

  @Override
  public void delete(Integer departId) throws WxErrorException {
    String url = "https://qyapi.weixin.qq.com/cgi-bin/department/delete?id=" + departId;
    this.mainService.get(url, null);
  }

  @Override
  public List<WxCpDepart> listAll() throws WxErrorException {
    String url = "https://qyapi.weixin.qq.com/cgi-bin/department/list";
    String responseContent = this.mainService.get(url, null);
    /*
     * 操蛋的微信API，创建时返回的是 { group : { id : ..., name : ...} }
     * 查询时返回的是 { groups : [ { id : ..., name : ..., count : ... }, ... ] }
     */
    JsonElement tmpJsonElement = new JsonParser().parse(responseContent);
    return WxCpGsonBuilder.INSTANCE.create()
      .fromJson(tmpJsonElement.getAsJsonObject().get("department"),
        new TypeToken<List<WxCpDepart>>() {
        }.getType()
      );
  }
}
