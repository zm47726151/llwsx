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
//import com.thinkgem.jeesite.modules.wexin.entity.ResponseNewsMessage;
//import com.thinkgem.jeesite.modules.wexin.dao.ResponseNewsMessageDao;
//
///**
// * 发送图片消息Service
// * @author zm47726151@gmail.com
// * @version 2014-11-09
// */
//@Component
//@Transactional(readOnly = true)
//public class ResponseNewsMessageService extends BaseService {
//
//	@Autowired
//	private ResponseNewsMessageDao responseNewsMessageDao;
//	
//	public ResponseNewsMessage get(String id) {
//		return responseNewsMessageDao.get(id);
//	}
//	
//	public Page<ResponseNewsMessage> find(Page<ResponseNewsMessage> page, ResponseNewsMessage responseNewsMessage) {
//		DetachedCriteria dc = responseNewsMessageDao.createDetachedCriteria();
//		if (StringUtils.isNotEmpty(responseNewsMessage.getId())){
//			dc.add(Restrictions.like("name", "%"+responseNewsMessage.getId()+"%"));
//		}
//		dc.add(Restrictions.eq(ResponseNewsMessage.FIELD_DEL_FLAG, ResponseNewsMessage.DEL_FLAG_NORMAL));
//		dc.addOrder(Order.desc("id"));
//		return responseNewsMessageDao.find(page, dc);
//	}
//	
//	@Transactional(readOnly = false)
//	public void save(ResponseNewsMessage responseNewsMessage) {
//		responseNewsMessageDao.save(responseNewsMessage);
//	}
//	
//	@Transactional(readOnly = false)
//	public void delete(String id) {
//		responseNewsMessageDao.deleteById(id);
//	}
//	
//}
