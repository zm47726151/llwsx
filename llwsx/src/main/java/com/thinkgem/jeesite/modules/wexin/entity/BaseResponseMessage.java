/*
 * 文 件 名:  BaseMessage.java
 * 版    权: 北京华通天达科技有限公司 Copyright,  All rights reserved
 * 修 改 人:  wangjinguang
 * 修改时间:  2013-12-19
 */
package com.thinkgem.jeesite.modules.wexin.entity;

import com.thinkgem.jeesite.common.persistence.IdEntity;

/**
 * 
 * @author wangjinguang
 * @version [1.0, 2013-12-19]
 */
public class BaseResponseMessage extends IdEntity<BaseRequestMessage> {

	private static final long serialVersionUID = 1L;
	// 接收方帐号（收到的OpenID）
	private String ToUserName;
	// 开发者微信号
	private String FromUserName;
	// 消息创建时间 （整型）
	private long CreateTime;
	// 消息类型（text/music/news）
	private String MsgType;
	// 位0x0001被标志时，星标刚收到的消息
	private int FuncFlag;


	public String getToUserName() {
		return ToUserName;
	}

	public void setToUserName(String toUserName) {
		ToUserName = toUserName;
	}

	public String getFromUserName() {
		return FromUserName;
	}

	public void setFromUserName(String fromUserName) {
		FromUserName = fromUserName;
	}

	public long getCreateTime() {
		return CreateTime;
	}

	public void setCreateTime(long createTime) {
		CreateTime = createTime;
	}

	public String getMsgType() {
		return MsgType;
	}

	public void setMsgType(String msgType) {
		MsgType = msgType;
	}

	public int getFuncFlag() {
		return FuncFlag;
	}

	public void setFuncFlag(int funcFlag) {
		FuncFlag = funcFlag;
	}
}
