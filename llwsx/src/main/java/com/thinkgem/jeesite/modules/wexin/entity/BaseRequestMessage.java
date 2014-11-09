///*
// * 文 件 名:  BaseMessage.java
// * 版    权: 北京华通天达科技有限公司 Copyright,  All rights reserved
// * 修 改 人:  wangjinguang
// * 修改时间:  2013-12-19
// */
//package com.thinkgem.jeesite.modules.wexin.entity;
//
//import javax.validation.constraints.NotNull;
//
//import org.hibernate.validator.constraints.Length;
//
//import com.thinkgem.jeesite.common.persistence.IdEntity;
//import com.thinkgem.jeesite.common.utils.excel.annotation.ExcelField;
//
///**
//* 
//* @ClassName: BaseRequestMessage
//* @Description: 微信发送消息基础类
//* @author zm47726151@gmail.com
//* @date 2014年11月9日 上午10:50:50
//*
// */
//public class BaseRequestMessage extends IdEntity<BaseRequestMessage> {
//
//	private static final long serialVersionUID = 1L;
//
//	// 开发者微信号
//	private String ToUserName;
//	// 发送方帐号（一个OpenID）
//	private String FromUserName;
//	// 消息创建时间 （整型）
//	private long CreateTime;
//	// 消息类型（text/image/location/link）
//	private String MsgType;
//	// 消息id，64位整型
//	private long MsgId;
//
//	@Length(min = 1, max = 100)
//	@ExcelField(title = "开发者微信号", align = 2, sort = 10)
//	@NotNull
//	public String getToUserName() {
//		return ToUserName;
//	}
//
//	public void setToUserName(String toUserName) {
//		ToUserName = toUserName;
//	}
//
//	@Length(min = 1, max = 100)
//	@ExcelField(title = "发送方帐号", align = 2, sort = 10)
//	@NotNull
//	public String getFromUserName() {
//		return FromUserName;
//	}
//
//	public void setFromUserName(String fromUserName) {
//		FromUserName = fromUserName;
//	}
//
//	@Length(min = 1, max = 100)
//	@ExcelField(title = "消息创建时间", align = 2, sort = 10)
//	@NotNull
//	public long getCreateTime() {
//		return CreateTime;
//	}
//
//	public void setCreateTime(long createTime) {
//		CreateTime = createTime;
//	}
//
//	@Length(min = 1, max = 100)
//	@ExcelField(title = "发送消息类型", align = 2, sort = 10)
//	@NotNull
//	public String getMsgType() {
//		return MsgType;
//	}
//
//	public void setMsgType(String msgType) {
//		MsgType = msgType;
//	}
//
//	@Length(min = 1, max = 64)
//	@ExcelField(title = "消息id，64位整型", align = 2, sort = 10)
//	public long getMsgId() {
//		return MsgId;
//	}
//
//	public void setMsgId(long msgId) {
//		MsgId = msgId;
//	}
//}
