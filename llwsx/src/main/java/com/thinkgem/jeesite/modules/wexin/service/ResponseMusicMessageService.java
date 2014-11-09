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
import com.thinkgem.jeesite.modules.wexin.entity.ResponseMusicMessage;
import com.thinkgem.jeesite.modules.wexin.dao.ResponseMusicMessageDao;

/**
 * 发送图片消息Service
 * @author zm47726151@gmail.com
 * @version 2014-11-09
 */
@Component
@Transactional(readOnly = true)
public class ResponseMusicMessageService extends BaseService {

	@Autowired
	private ResponseMusicMessageDao responseMusicMessageDao;
	
	public ResponseMusicMessage get(String id) {
		return responseMusicMessageDao.get(id);
	}
	
	public Page<ResponseMusicMessage> find(Page<ResponseMusicMessage> page, ResponseMusicMessage responseMusicMessage) {
		DetachedCriteria dc = responseMusicMessageDao.createDetachedCriteria();
		if (StringUtils.isNotEmpty(responseMusicMessage.getId())){
			dc.add(Restrictions.like("name", "%"+responseMusicMessage.getId()+"%"));
		}
		dc.add(Restrictions.eq(ResponseMusicMessage.FIELD_DEL_FLAG, ResponseMusicMessage.DEL_FLAG_NORMAL));
		dc.addOrder(Order.desc("id"));
		return responseMusicMessageDao.find(page, dc);
	}
	
	@Transactional(readOnly = false)
	public void save(ResponseMusicMessage responseMusicMessage) {
		responseMusicMessageDao.save(responseMusicMessage);
	}
	
	@Transactional(readOnly = false)
	public void delete(String id) {
		responseMusicMessageDao.deleteById(id);
	}
	
}
