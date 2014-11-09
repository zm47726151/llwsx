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
import com.thinkgem.jeesite.modules.wexin.entity.RequestImageMessage;
import com.thinkgem.jeesite.modules.wexin.dao.RequestImageMessageDao;

/**
 * 发送图片消息Service
 * @author zm47726151@gmail.com
 * @version 2014-11-09
 */
@Component
@Transactional(readOnly = true)
public class RequestImageMessageService extends BaseService {

	@Autowired
	private RequestImageMessageDao requestImageMessageDao;
	
	public RequestImageMessage get(String id) {
		return requestImageMessageDao.get(id);
	}
	
	public Page<RequestImageMessage> find(Page<RequestImageMessage> page, RequestImageMessage requestImageMessage) {
		DetachedCriteria dc = requestImageMessageDao.createDetachedCriteria();
		if (StringUtils.isNotEmpty(requestImageMessage.getId())){
			dc.add(Restrictions.like("name", "%"+requestImageMessage.getId()+"%"));
		}
		dc.add(Restrictions.eq(RequestImageMessage.FIELD_DEL_FLAG, RequestImageMessage.DEL_FLAG_NORMAL));
		dc.addOrder(Order.desc("id"));
		return requestImageMessageDao.find(page, dc);
	}
	
	@Transactional(readOnly = false)
	public void save(RequestImageMessage requestImageMessage) {
		requestImageMessageDao.save(requestImageMessage);
	}
	
	@Transactional(readOnly = false)
	public void delete(String id) {
		requestImageMessageDao.deleteById(id);
	}
	
}
