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
//import com.thinkgem.jeesite.modules.wexin.entity.RequestLinkMessage;
//import com.thinkgem.jeesite.modules.wexin.dao.RequestLinkMessageDao;
//
///**
// * 发送图片消息Service
// * @author zm47726151@gmail.com
// * @version 2014-11-09
// */
//@Component
//@Transactional(readOnly = true)
//public class RequestLinkMessageService extends BaseService {
//
//	@Autowired
//	private RequestLinkMessageDao requestLinkMessageDao;
//	
//	public RequestLinkMessage get(String id) {
//		return requestLinkMessageDao.get(id);
//	}
//	
//	public Page<RequestLinkMessage> find(Page<RequestLinkMessage> page, RequestLinkMessage requestLinkMessage) {
//		DetachedCriteria dc = requestLinkMessageDao.createDetachedCriteria();
//		if (StringUtils.isNotEmpty(requestLinkMessage.getId())){
//			dc.add(Restrictions.like("name", "%"+requestLinkMessage.getId()+"%"));
//		}
//		dc.add(Restrictions.eq(RequestLinkMessage.FIELD_DEL_FLAG, RequestLinkMessage.DEL_FLAG_NORMAL));
//		dc.addOrder(Order.desc("id"));
//		return requestLinkMessageDao.find(page, dc);
//	}
//	
//	@Transactional(readOnly = false)
//	public void save(RequestLinkMessage requestLinkMessage) {
//		requestLinkMessageDao.save(requestLinkMessage);
//	}
//	
//	@Transactional(readOnly = false)
//	public void delete(String id) {
//		requestLinkMessageDao.deleteById(id);
//	}
//	
//}
