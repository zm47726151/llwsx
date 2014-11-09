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
//import com.thinkgem.jeesite.modules.wexin.entity.RequestVideoMessage;
//import com.thinkgem.jeesite.modules.wexin.dao.RequestVideoMessageDao;
//
///**
// * 发送图片消息Service
// * @author zm47726151@gmail.com
// * @version 2014-11-09
// */
//@Component
//@Transactional(readOnly = true)
//public class RequestVideoMessageService extends BaseService {
//
//	@Autowired
//	private RequestVideoMessageDao requestVideoMessageDao;
//	
//	public RequestVideoMessage get(String id) {
//		return requestVideoMessageDao.get(id);
//	}
//	
//	public Page<RequestVideoMessage> find(Page<RequestVideoMessage> page, RequestVideoMessage requestVideoMessage) {
//		DetachedCriteria dc = requestVideoMessageDao.createDetachedCriteria();
//		if (StringUtils.isNotEmpty(requestVideoMessage.getId())){
//			dc.add(Restrictions.like("name", "%"+requestVideoMessage.getId()+"%"));
//		}
//		dc.add(Restrictions.eq(RequestVideoMessage.FIELD_DEL_FLAG, RequestVideoMessage.DEL_FLAG_NORMAL));
//		dc.addOrder(Order.desc("id"));
//		return requestVideoMessageDao.find(page, dc);
//	}
//	
//	@Transactional(readOnly = false)
//	public void save(RequestVideoMessage requestVideoMessage) {
//		requestVideoMessageDao.save(requestVideoMessage);
//	}
//	
//	@Transactional(readOnly = false)
//	public void delete(String id) {
//		requestVideoMessageDao.deleteById(id);
//	}
//	
//}
