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
import com.thinkgem.jeesite.modules.wexin.dao.WeXinMusicDao;
import com.thinkgem.jeesite.modules.wexin.entity.WeXinMusic;

/**
 * 发送图片消息Service
 * @author zm47726151@gmail.com
 * @version 2014-11-09
 */
@Component
@Transactional(readOnly = true)
public class WeXinMusicService extends BaseService {

	@Autowired
	private WeXinMusicDao weXinMusicDao;
	
	public WeXinMusic get(String id) {
		return weXinMusicDao.get(id);
	}
	
	public Page<WeXinMusic> find(Page<WeXinMusic> page, WeXinMusic music) {
		DetachedCriteria dc = weXinMusicDao.createDetachedCriteria();
		if (StringUtils.isNotEmpty(music.getId())){
			dc.add(Restrictions.like("name", "%"+music.getId()+"%"));
		}
		dc.add(Restrictions.eq(WeXinMusic.FIELD_DEL_FLAG, WeXinMusic.DEL_FLAG_NORMAL));
		dc.addOrder(Order.desc("id"));
		return weXinMusicDao.find(page, dc);
	}
	
	@Transactional(readOnly = false)
	public void save(WeXinMusic music) {
		weXinMusicDao.save(music);
	}
	
	@Transactional(readOnly = false)
	public void delete(String id) {
		weXinMusicDao.deleteById(id);
	}
	
}
