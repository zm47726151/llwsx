/*
* 文 件 名:  TextMessage.java
* 版    权: 北京华通天达科技有限公司 Copyright,  All rights reserved
* 修 改 人:  wangjinguang
* 修改时间:  2013-12-19
*/
package com.thinkgem.jeesite.modules.weixin.resp;

/**
 *
 * @author  wangjinguang
 * @version  [1.0, 2013-12-19]
 */
public class ResponseTextMessage extends BaseResponseMessage { 
	
	private static final long serialVersionUID = 1L;
	// 回复的消息内容 
    private String Content; 
 
    public String getContent() { 
        return Content; 
    } 
 
    public void setContent(String content) { 
        Content = content; 
    } 
} 