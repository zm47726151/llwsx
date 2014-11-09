/*
 * 文 件 名:  ImageMessage.java
 * 版    权: 北京华通天达科技有限公司 Copyright,  All rights reserved
 * 修 改 人:  wangjinguang
 * 修改时间:  2013-12-19
 */
package com.thinkgem.jeesite.modules.wexin.entity;

import javax.persistence.Entity;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

/**
 * @ClassName: RequesImageMessage
 * @Description: 微信发送语音消息实体类
 * @author zm47726151@gmail.com
 * @date 2014年11月9日 上午10:53:16
 * 
 */
@Entity
@Table(name = "wexin_request_voice_message")
@DynamicInsert
@DynamicUpdate
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class RequestVoiceMessage extends BaseRequestMessage {

	private static final long serialVersionUID = 1L;
	// 语音消息媒体id，可以调用多媒体文件下载接口拉取数据。
	private String MediaId;
	// 语音格式，如amr，speex等
	private String Format;

	public String getMediaId() {
		return MediaId;
	}

	public void setMediaId(String mediaId) {
		MediaId = mediaId;
	}

	public String getFormat() {
		return Format;
	}

	public void setFormat(String format) {
		Format = format;
	}

}
