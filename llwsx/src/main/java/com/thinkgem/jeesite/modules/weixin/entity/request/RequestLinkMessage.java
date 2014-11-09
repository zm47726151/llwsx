/*
* 文 件 名:  LinkMessage.java
* 版    权: 北京华通天达科技有限公司 Copyright,  All rights reserved
* 修 改 人:  wangjinguang
* 修改时间:  2013-12-19
*/
package com.thinkgem.jeesite.modules.weixin.entity.request;

import javax.persistence.Entity;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

/**
 * @ClassName: RequesLinkMessage
* @Description: 微信发送链接消息实体类
* @author zm47726151@gmail.com
* @date 2014年11月9日 上午10:55:47
*
 */
@Entity
@Table(name = "wexin_request_link_message")
@DynamicInsert @DynamicUpdate
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class RequestLinkMessage extends BaseRequestMessage { 

	private static final long serialVersionUID = 1L;
	// 消息标题 
    private String Title; 
    // 消息描述 
    private String Description; 
    // 消息链接 
    private String Url; 
 
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
 
    public String getUrl() { 
        return Url; 
    } 
 
    public void setUrl(String url) { 
        Url = url; 
    } 
} 
