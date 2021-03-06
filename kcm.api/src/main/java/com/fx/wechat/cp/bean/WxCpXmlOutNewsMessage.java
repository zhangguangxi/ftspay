package com.fx.wechat.cp.bean;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamConverter;
import lombok.Data;
import com.fx.common.api.WxConsts;
import com.fx.common.util.xml.XStreamCDataConverter;

import java.util.ArrayList;
import java.util.List;

@XStreamAlias("xml")
@Data
public class WxCpXmlOutNewsMessage extends WxCpXmlOutMessage {
  private static final long serialVersionUID = -5796178637883178826L;

  @XStreamAlias("Articles")
  protected final List<Item> articles = new ArrayList<>();

  @XStreamAlias("ArticleCount")
  protected int articleCount;

  public WxCpXmlOutNewsMessage() {
    this.msgType = WxConsts.XmlMsgType.NEWS;
  }


  public void addArticle(Item item) {
    this.articles.add(item);
    this.articleCount = this.articles.size();
  }

  @XStreamAlias("item")
  @Data
  public static class Item {

    @XStreamAlias("Title")
    @XStreamConverter(value = XStreamCDataConverter.class)
    private String title;

    @XStreamAlias("Description")
    @XStreamConverter(value = XStreamCDataConverter.class)
    private String description;

    @XStreamAlias("PicUrl")
    @XStreamConverter(value = XStreamCDataConverter.class)
    private String picUrl;

    @XStreamAlias("Url")
    @XStreamConverter(value = XStreamCDataConverter.class)
    private String url;

  }

}
