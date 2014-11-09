/**
 * There are <a href="https://github.com/thinkgem/jeesite">JeeSite</a> code generation
 */
package com.thinkgem.jeesite.modules.wexin.entity;

import javax.persistence.Entity;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

/**
 * 发送图片消息Entity
 * @author zm47726151@gmail.com
 * @version 2014-11-09
 */
@Entity
@Table(name = "wexin_responseNewsMessage")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class ResponseNewsMessage extends BaseResponseMessage {
	
	private static final long serialVersionUID = 1L;
    // 图文消息名称 
    private String Title; 
    // 图文消息描述 
    private String Description; 
    // 图片链接，支持JPG、PNG格式，较好的效果为大图640*320，小图80*80，限制图片链接的域名需要与开发者填写的基本资料中的Url一致 
    private String PicUrl; 
    // 点击图文消息跳转链接 
    private String Url; 
    // 图文消息个数，限制为10条以内 
    private int ArticleCount; 

	public ResponseNewsMessage() {
		super();
	}

	public ResponseNewsMessage(String id){
		this();
		this.id = id;
	}

	public String getTitle() {
		return Title;
	}

	public void setTitle(String title) {
		Title = title;
	}

	public String getDescription() {
		return Description;
	}

	public void setDescription(String description) {
		Description = description;
	}

	public String getPicUrl() {
		return PicUrl;
	}

	public void setPicUrl(String picUrl) {
		PicUrl = picUrl;
	}

	public String getUrl() {
		return Url;
	}

	public void setUrl(String url) {
		Url = url;
	}

	public int getArticleCount() {
		return ArticleCount;
	}

	public void setArticleCount(int articleCount) {
		ArticleCount = articleCount;
	}
	 
	
	
}


