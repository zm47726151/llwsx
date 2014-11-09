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
import com.thinkgem.jeesite.modules.wexin.entity.ResponseTextMessage;
import com.thinkgem.jeesite.modules.wexin.dao.ResponseTextMessageDao;

/**
 * 发送图片消息Service
 * @author zm47726151@gmail.com
 * @version 2014-11-09
 */
@Component
@Transactional(readOnly = true)
public class ResponseTextMessageService extends BaseService {

	@Autowired
	private ResponseTextMessageDao responseTextMessageDao;
	
	public ResponseTextMessage get(String id) {
		return responseTextMessageDao.get(id);
	}
	
	public Page<ResponseTextMessage> find(Page<ResponseTextMessage> page, ResponseTextMessage responseTextMessage) {
		DetachedCriteria dc = responseTextMessageDao.createDetachedCriteria();
		if (StringUtils.isNotEmpty(responseTextMessage.getId())){
			dc.add(Restrictions.like("name", "%"+responseTextMessage.getId()+"%"));
		}
		dc.add(Restrictions.eq(ResponseTextMessage.FIELD_DEL_FLAG, ResponseTextMessage.DEL_FLAG_NORMAL));
		dc.addOrder(Order.desc("id"));
		return responseTextMessageDao.find(page, dc);
	}
	
	@Transactional(readOnly = false)
	public void save(ResponseTextMessage responseTextMessage) {
		responseTextMessageDao.save(responseTextMessage);
	}
	
	@Transactional(readOnly = false)
	public void delete(String id) {
		responseTextMessageDao.deleteById(id);
	}
	
}
