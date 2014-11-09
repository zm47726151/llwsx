///**
// * There are <a href="https://github.com/thinkgem/jeesite">JeeSite</a> code generation
// */
//package com.thinkgem.jeesite.modules.wexin.entity;
//
//import javax.persistence.Entity;
//import javax.persistence.Table;
//
//import org.hibernate.annotations.Cache;
//import org.hibernate.annotations.CacheConcurrencyStrategy;
//
//import com.thinkgem.jeesite.common.persistence.IdEntity;
//import com.thinkgem.jeesite.modules.sys.entity.User;
//
///**
// * 发送图片消息Entity
// * 
// * @author zm47726151@gmail.com
// * @version 2014-11-09
// */
//@Entity
//@Table(name = "wexin_responseMusicMessage")
//@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
//public class ResponseMusicMessage extends IdEntity<User> {
//
//	private static final long serialVersionUID = 1L;
//	// 音乐名称
//	private String Title;
//	// 音乐描述
//	private String Description;
//	// 音乐链接
//	private String MusicUrl;
//	// 高质量音乐链接，WIFI环境优先使用该链接播放音乐
//	private String HQMusicUrl;
//
//	public ResponseMusicMessage() {
//		super();
//	}
//
//	public ResponseMusicMessage(String id) {
//		this();
//		this.id = id;
//	}
//
//	public String getTitle() {
//		return Title;
//	}
//
//	public void setTitle(String title) {
//		Title = title;
//	}
//
//	public String getDescription() {
//		return Description;
//	}
//
//	public void setDescription(String description) {
//		Description = description;
//	}
//
//	public String getMusicUrl() {
//		return MusicUrl;
//	}
//
//	public void setMusicUrl(String musicUrl) {
//		MusicUrl = musicUrl;
//	}
//
//	public String getHQMusicUrl() {
//		return HQMusicUrl;
//	}
//
//	public void setHQMusicUrl(String hQMusicUrl) {
//		HQMusicUrl = hQMusicUrl;
//	}
//
//}
