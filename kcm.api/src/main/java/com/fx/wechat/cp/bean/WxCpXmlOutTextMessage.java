package com.fx.wechat.cp.bean;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamConverter;
import lombok.Data;
import com.fx.common.api.WxConsts;
import com.fx.common.util.xml.XStreamCDataConverter;

@XStreamAlias("xml")
@Data
public class WxCpXmlOutTextMessage extends WxCpXmlOutMessage {
  private static final long serialVersionUID = 2569239617185930232L;

  @XStreamAlias("Content")
  @XStreamConverter(value = XStreamCDataConverter.class)
  private String content;

  public WxCpXmlOutTextMessage() {
    this.msgType = WxConsts.XmlMsgType.TEXT;
  }

}
