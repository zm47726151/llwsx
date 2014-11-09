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
@Table(name = "wexin_responseTextMessage")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class ResponseTextMessage extends BaseResponseMessage { 

	private static final long serialVersionUID = 1L;
	// 消息内容 
    private String Content; 
 
    public ResponseTextMessage() {
		super();
	}

	public ResponseTextMessage(String id){
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


