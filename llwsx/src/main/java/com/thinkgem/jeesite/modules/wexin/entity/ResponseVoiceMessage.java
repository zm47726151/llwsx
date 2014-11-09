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
@Table(name = "wexin_responseVoiceMessage")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class ResponseVoiceMessage extends BaseResponseMessage {
	
	private static final long serialVersionUID = 1L;
	private String name; 	// 名称

	public ResponseVoiceMessage() {
		super();
	}

	public ResponseVoiceMessage(String id){
		this();
		this.id = id;
	}
	 
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
}


