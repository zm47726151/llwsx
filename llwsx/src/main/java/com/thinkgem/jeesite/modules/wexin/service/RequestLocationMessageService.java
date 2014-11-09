/**
 * There are <a href="https://github.com/thinkgem/jeesite">JeeSite</a> code generation
 */
package com.thinkgem.jeesite.modules.wexin.service;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.service.BaseService;
import com.thinkgem.jeesite.common.utils.StringUtils;
import com.thinkgem.jeesite.modules.wexin.entity.RequestLocationMessage;
import com.thinkgem.jeesite.modules.wexin.dao.RequestLocationMessageDao;

/**
 * 发送图片消息Service
 * @author zm47726151@gmail.com
 * @version 2014-11-09
 */
@Component
@Transactional(readOnly = true)
public class RequestLocationMessageService extends BaseService {

	@Autowired
	private RequestLocationMessageDao requestLocationMessageDao;
	
	public RequestLocationMessage get(String id) {
		return requestLocationMessageDao.get(id);
	}
	
	public Page<RequestLocationMessage> find(Page<RequestLocationMessage> page, RequestLocationMessage requestLocationMessage) {
		DetachedCriteria dc = requestLocationMessageDao.createDetachedCriteria();
		if (StringUtils.isNotEmpty(requestLocationMessage.getId())){
			dc.add(Restrictions.like("name", "%"+requestLocationMessage.getId()+"%"));
		}
		dc.add(Restrictions.eq(RequestLocationMessage.FIELD_DEL_FLAG, RequestLocationMessage.DEL_FLAG_NORMAL));
		dc.addOrder(Order.desc("id"));
		return requestLocationMessageDao.find(page, dc);
	}
	
	@Transactional(readOnly = false)
	public void save(RequestLocationMessage requestLocationMessage) {
		requestLocationMessageDao.save(requestLocationMessage);
	}
	
	@Transactional(readOnly = false)
	public void delete(String id) {
		requestLocationMessageDao.deleteById(id);
	}
	
}
