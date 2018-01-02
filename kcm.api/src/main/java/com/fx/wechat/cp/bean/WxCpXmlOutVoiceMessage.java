package com.fx.wechat.cp.bean;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamConverter;
import lombok.Data;
import com.fx.common.api.WxConsts;
import com.fx.common.util.xml.XStreamMediaIdConverter;

@XStreamAlias("xml")
@Data
public class WxCpXmlOutVoiceMessage extends WxCpXmlOutMessage {
  private static final long serialVersionUID = -7947384031546099340L;

  @XStreamAlias("Voice")
  @XStreamConverter(value = XStreamMediaIdConverter.class)
  private String mediaId;

  public WxCpXmlOutVoiceMessage() {
    this.msgType = WxConsts.XmlMsgType.VOICE;
  }

}
