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
//import org.hibernate.validator.constraints.Length;
//
//import com.thinkgem.jeesite.common.persistence.IdEntity;
//
///**
// * 发送图片消息Entity
// * 
// * @author zm47726151@gmail.com
// * @version 2014-11-09
// */
//@Entity
//@Table(name = "wexin_music")
//@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
//public class WeXinMusic extends IdEntity<WeXinMusic> {
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
//	public WeXinMusic() {
//		super();
//	}
//
//	public WeXinMusic(String id) {
//		this();
//		this.id = id;
//	}
//
//	@Length(min = 1, max = 200)
//	public String getTitle() {
//		return Title;
//	}
//
//	public void setTitle(String title) {
//		Title = title;
//	}
//
//	@Length(min = 1, max = 200)
//	public String getDescription() {
//		return Description;
//	}
//
//	public void setDescription(String description) {
//		Description = description;
//	}
//
//	@Length(min = 1, max = 200)
//	public String getMusicUrl() {
//		return MusicUrl;
//	}
//
//	public void setMusicUrl(String musicUrl) {
//		MusicUrl = musicUrl;
//	}
//
//	@Length(min = 1, max = 200)
//	public String getHQMusicUrl() {
//		return HQMusicUrl;
//	}
//
//	public void setHQMusicUrl(String musicUrl) {
//		HQMusicUrl = musicUrl;
//	}
//
//}
