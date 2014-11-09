/*
 * 文 件 名:  TextMessage.java
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
 * @ClassName: RequesTextMessage
 * @Description: 微信发送文本消息实体类
 * @author zm47726151@gmail.com
 * @date 2014年11月9日 上午10:57:21
 * 
 */
@Entity
@Table(name = "wexin_request_text_message")
@DynamicInsert
@DynamicUpdate
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class RequestTextMessage extends BaseRequestMessage {

	private static final long serialVersionUID = 1L;
	// 消息内容
	private String Content;

	public RequestTextMessage() {
		super();
	}

	public RequestTextMessage(String id) {
		this();
		this.id = id;
	}

	public String getContent() {
		return Content;
	}

	public void setContent(String content) {
		Content = content;
	}
}
