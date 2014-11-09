///*
//* 文 件 名:  LocationMessage.java
//* 版    权: 北京华通天达科技有限公司 Copyright,  All rights reserved
//* 修 改 人:  wangjinguang
//* 修改时间:  2013-12-19
//*/
//package com.thinkgem.jeesite.modules.wexin.entity;
//
//import javax.persistence.Entity;
//import javax.persistence.Table;
//
//import org.hibernate.annotations.Cache;
//import org.hibernate.annotations.CacheConcurrencyStrategy;
//import org.hibernate.annotations.DynamicInsert;
//import org.hibernate.annotations.DynamicUpdate;
//
//import com.thinkgem.jeesite.common.persistence.IdEntity;
//import com.thinkgem.jeesite.modules.sys.entity.User;
//
//
///**
// * @ClassName: RequestLocationMessage
//* @Description: TODO(这里用一句话描述这个类的作用)
//* @author zm47726151@gmail.com
//* @date 2014年11月9日 上午11:06:17
//*
// */
//@Entity
//@Table(name = "wexin_request_location_message")
//@DynamicInsert @DynamicUpdate
//@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
//public class RequestLocationMessage extends IdEntity<User> { 
//
//	private static final long serialVersionUID = 1L;
//	// 地理位置维度 
//    private String Location_X; 
//    // 地理位置经度 
//    private String Location_Y; 
//    // 地图缩放大小 
//    private String Scale; 
//    // 地理位置信息 
//    private String Label; 
// 
//    public RequestLocationMessage() {
//		super();
//	}
//	
//	public RequestLocationMessage(String id) {
//		this();
//		this.id = id;
//	}
//    public String getLocation_X() { 
//        return Location_X; 
//    } 
// 
//    public void setLocation_X(String location_X) { 
//        Location_X = location_X; 
//    } 
// 
//    public String getLocation_Y() { 
//        return Location_Y; 
//    } 
// 
//    public void setLocation_Y(String location_Y) { 
//        Location_Y = location_Y; 
//    } 
// 
//    public String getScale() { 
//        return Scale; 
//    } 
// 
//    public void setScale(String scale) { 
//        Scale = scale; 
//    } 
// 
//    public String getLabel() { 
//        return Label; 
//    } 
// 
//    public void setLabel(String label) { 
//        Label = label; 
//    } 
//} 
//
//
