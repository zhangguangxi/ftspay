package com.fx.wechat.cp.bean.messagebuilder;

import com.fx.common.api.WxConsts;
import com.fx.wechat.cp.bean.WxCpMessage;
import com.fx.wechat.cp.bean.article.NewArticle;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 图文消息builder
 * <pre>
 * 用法:
 * WxCustomMessage m = WxCustomMessage.NEWS().addArticle(article).toUser(...).build();
 * </pre>
 *
 * @author Daniel Qian
 */
public final class NewsBuilder extends BaseBuilder<NewsBuilder> {

  private List<NewArticle> articles = new ArrayList<>();

  public NewsBuilder() {
    this.msgType = WxConsts.KefuMsgType.NEWS;
  }

  public NewsBuilder addArticle(NewArticle... articles) {
    Collections.addAll(this.articles, articles);
    return this;
  }

  public NewsBuilder articles(List<NewArticle> articles) {
    this.articles = articles;
    return this;
  }

  @Override
  public WxCpMessage build() {
    WxCpMessage m = super.build();
    m.setArticles(this.articles);
    return m;
  }
}
