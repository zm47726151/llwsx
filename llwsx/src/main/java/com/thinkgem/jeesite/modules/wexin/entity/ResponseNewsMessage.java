/**
 * There are <a href="https://github.com/thinkgem/jeesite">JeeSite</a> code generation
 */
package com.thinkgem.jeesite.modules.wexin.entity;

import javax.persistence.Entity;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.validator.constraints.Length;

import com.thinkgem.jeesite.common.persistence.IdEntity;

/**
 * 发送图片消息Entity
 * @author zm47726151@gmail.com
 * @version 2014-11-09
 */
@Entity
@Table(name = "wexin_responseNewsMessage")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class ResponseNewsMessage extends IdEntity<ResponseNewsMessage> {
	
	private static final long serialVersionUID = 1L;
	private String id; 		// 编号
	private String name; 	// 名称

	public ResponseNewsMessage() {
		super();
	}

	public ResponseNewsMessage(String id){
		this();
		this.id = id;
	}
	 
	@Length(min=1, max=200)
	public String getId() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
}


