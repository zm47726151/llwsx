///**
// * There are <a href="https://github.com/thinkgem/jeesite">JeeSite</a> code generation
// */
//package com.thinkgem.jeesite.modules.wexin.service;
//
//import org.hibernate.criterion.DetachedCriteria;
//import org.hibernate.criterion.Order;
//import org.hibernate.criterion.Restrictions;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Component;
//import org.springframework.transaction.annotation.Transactional;
//
//import com.thinkgem.jeesite.common.persistence.Page;
//import com.thinkgem.jeesite.common.service.BaseService;
//import com.thinkgem.jeesite.common.utils.StringUtils;
//import com.thinkgem.jeesite.modules.wexin.entity.RequestTextMessage;
//import com.thinkgem.jeesite.modules.wexin.dao.RequestTextMessageDao;
//
///**
// * 发送图片消息Service
// * @author zm47726151@gmail.com
// * @version 2014-11-09
// */
//@Component
//@Transactional(readOnly = true)
//public class RequestTextMessageService extends BaseService {
//
//	@Autowired
//	private RequestTextMessageDao requestTextMessageDao;
//	
//	public RequestTextMessage get(String id) {
//		return requestTextMessageDao.get(id);
//	}
//	
//	public Page<RequestTextMessage> find(Page<RequestTextMessage> page, RequestTextMessage requestTextMessage) {
//		DetachedCriteria dc = requestTextMessageDao.createDetachedCriteria();
//		if (StringUtils.isNotEmpty(requestTextMessage.getId())){
//			dc.add(Restrictions.like("name", "%"+requestTextMessage.getId()+"%"));
//		}
//		dc.add(Restrictions.eq(RequestTextMessage.FIELD_DEL_FLAG, RequestTextMessage.DEL_FLAG_NORMAL));
//		dc.addOrder(Order.desc("id"));
//		return requestTextMessageDao.find(page, dc);
//	}
//	
//	@Transactional(readOnly = false)
//	public void save(RequestTextMessage requestTextMessage) {
//		requestTextMessageDao.save(requestTextMessage);
//	}
//	
//	@Transactional(readOnly = false)
//	public void delete(String id) {
//		requestTextMessageDao.deleteById(id);
//	}
//	
//}
