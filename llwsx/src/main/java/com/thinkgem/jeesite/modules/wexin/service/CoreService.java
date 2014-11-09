///*
// * 文 件 名:  CoreService.java
// * 版    权: 北京华通天达科技有限公司 Copyright,  All rights reserved
// * 修 改 人:  wangjinguang
// * 修改时间:  2013-12-19
// */
//package com.thinkgem.jeesite.modules.wexin.service;
//
//import java.util.Date;
//import java.util.Map;
//import java.util.regex.Matcher;
//import java.util.regex.Pattern;
//
//import javax.servlet.http.HttpServletRequest;
//
//import com.thinkgem.jeesite.modules.wexin.entity.ResponseTextMessage;
//import com.thinkgem.jeesite.modules.wexin.util.MessageUtil;
//
//public class CoreService {
//	/**
//	 * 处理微信发来的请求
//	 * 
//	 * @param request
//	 * @return
//	 */
//	public static String processRequest(HttpServletRequest request) {
//		String respMessage = null;
//		try {
//			// 默认返回的文本消息内容
//			String respContent = "";
//
//			// xml请求解析
//			Map<String, String> requestMap = MessageUtil.parseXml(request);
//
//			// 发送方帐号（open_id）
//			String fromUserName = requestMap.get("FromUserName");
//			// 公众帐号
//			String toUserName = requestMap.get("ToUserName");
//			// 消息类型
//			String msgType = requestMap.get("MsgType");
//
//			// 回复文本消息
//			ResponseTextMessage textMessage = new ResponseTextMessage();
//			textMessage.setToUserName(fromUserName);
//			textMessage.setFromUserName(toUserName);
//			textMessage.setCreateTime(new Date().getTime());
//			textMessage.setMsgType(MessageUtil.RESP_MESSAGE_TYPE_TEXT);
//			textMessage.setFuncFlag(0);
//			if ("".equals(requestMap.get("content"))) {
//				return null;
//			}
//
//			// 文本消息
//			if (msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_TEXT)) {
//				respContent = "您发送的是文本消息！";
//			}
//			// 图片消息
//			else if (msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_IMAGE)) {
//				respContent = "您发送的是图片消息！";
//			}
//			// 地理位置消息
//			else if (msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_LOCATION)) {
//				respContent = "您发送的是地理位置消息！";
//			}
//			// 链接消息
//			else if (msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_LINK)) {
//				respContent = "您发送的是链接消息！";
//			}
//			// 音频消息
//			else if (msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_VOICE)) {
//				respContent = "您发送的是音频消息！";
//			}
//			// 事件推送
//			else if (msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_EVENT)) {
//				// 事件类型
//				String eventType = requestMap.get("Event");
//				// 订阅
//				if (eventType.equals(MessageUtil.EVENT_TYPE_SUBSCRIBE)) {
//					respContent = "谢谢您的关注！";
//				}
//				// 取消订阅
//				else if (eventType.equals(MessageUtil.EVENT_TYPE_UNSUBSCRIBE)) {
//					// TODO 取消订阅后用户再收不到公众号发送的消息，因此不需要回复消息
//				}
//				// 自定义菜单点击事件
//				else if (eventType.equals(MessageUtil.EVENT_TYPE_CLICK)) {
//					// 事件KEY值，与创建自定义菜单时指定的KEY值对应
////					String eventKey = requestMap.get("EventKey");
////
////					if (eventKey.equals("11")) {
////						respContent = "天气预报菜单项被点击！";
////					} else if (eventKey.equals("12")) {
////						respContent = "公交查询菜单项被点击！";
////					} else if (eventKey.equals("13")) {
////						respContent = "周边搜索菜单项被点击！";
////					} else if (eventKey.equals("14")) {
////						respContent = "历史上的今天菜单项被点击！";
////					} else if (eventKey.equals("21")) {
////						respContent = "歌曲点播菜单项被点击！";
////					} else if (eventKey.equals("22")) {
////						respContent = "经典游戏菜单项被点击！";
////					} else if (eventKey.equals("23")) {
////						respContent = "美女电台菜单项被点击！";
////					} else if (eventKey.equals("24")) {
////						respContent = "人脸识别菜单项被点击！";
////					} else if (eventKey.equals("25")) {
////						respContent = "聊天唠嗑菜单项被点击！";
////					} else if (eventKey.equals("31")) {
////						respContent = "Q友圈菜单项被点击！";
////					} else if (eventKey.equals("32")) {
////						respContent = "电影排行榜菜单项被点击！";
////					} else if (eventKey.equals("33")) {
////						respContent = "幽默笑话菜单项被点击！";
////					}
//				}
//			}
//
//			textMessage.setContent(respContent);
//			respMessage = MessageUtil.textMessageToXml(textMessage);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//
//		return respMessage;
//	}
//
//	/**
//	 * emoji表情转换(hex -> utf-16)
//	 * 
//	 * @param hexEmoji
//	 * @return
//	 */
//	public static String emoji(int hexEmoji) {
//		return String.valueOf(Character.toChars(hexEmoji));
//	}
//
//	/**
//	 * 判断是否是QQ表情
//	 * 
//	 * @param content
//	 * @return
//	 */
//	public static boolean isQqFace(String content) {
//		boolean result = false;
//
//		// 判断QQ表情的正则表达式
//		String qqfaceRegex = "/::\\)|/::~|/::B|/::\\||/:8-\\)|/::<|/::$|/::X|/::Z|/::'\\(|/::-\\||/::@|/::P|/::D|/::O|/::\\(|/::\\+|/:--b|/::Q|/::T|/:,@P|/:,@-D|/::d|/:,@o|/::g|/:\\|-\\)|/::!|/::L|/::>|/::,@|/:,@f|/::-S|/:\\?|/:,@x|/:,@@|/::8|/:,@!|/:!!!|/:xx|/:bye|/:wipe|/:dig|/:handclap|/:&-\\(|/:B-\\)|/:<@|/:@>|/::-O|/:>-\\||/:P-\\(|/::'\\||/:X-\\)|/::\\*|/:@x|/:8\\*|/:pd|/:<W>|/:beer|/:basketb|/:oo|/:coffee|/:eat|/:pig|/:rose|/:fade|/:showlove|/:heart|/:break|/:cake|/:li|/:bome|/:kn|/:footb|/:ladybug|/:shit|/:moon|/:sun|/:gift|/:hug|/:strong|/:weak|/:share|/:v|/:@\\)|/:jj|/:@@|/:bad|/:lvu|/:no|/:ok|/:love|/:<L>|/:jump|/:shake|/:<O>|/:circle|/:kotow|/:turn|/:skip|/:oY|/:#-0|/:hiphot|/:kiss|/:<&|/:&>";
//		Pattern p = Pattern.compile(qqfaceRegex);
//		Matcher m = p.matcher(content);
//		if (m.matches()) {
//			result = true;
//		}
//		return result;
//	}
//}
