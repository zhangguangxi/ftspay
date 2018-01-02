package com.fx.wechat.cp.bean;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamConverter;
import lombok.Data;
import com.fx.common.api.WxConsts;
import com.fx.common.util.xml.XStreamMediaIdConverter;

@XStreamAlias("xml")
@Data
public class WxCpXmlOutImageMessage extends WxCpXmlOutMessage {
  private static final long serialVersionUID = -1099446240667237313L;

  @XStreamAlias("Image")
  @XStreamConverter(value = XStreamMediaIdConverter.class)
  private String mediaId;

  public WxCpXmlOutImageMessage() {
    this.msgType = WxConsts.XmlMsgType.IMAGE;
  }

}
