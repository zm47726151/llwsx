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
//import com.thinkgem.jeesite.modules.wexin.dao.WeXinArticleDao;
//import com.thinkgem.jeesite.modules.wexin.entity.WeXinArticle;
//
///**
// * 发送图片消息Service
// * @author zm47726151@gmail.com
// * @version 2014-11-09
// */
//@Component
//@Transactional(readOnly = true)
//public class WeXinArticleService extends BaseService {
//
//	@Autowired
//	private WeXinArticleDao weXinArticleDao;
//	
//	public WeXinArticle get(String id) {
//		return weXinArticleDao.get(id);
//	}
//	
//	public Page<WeXinArticle> find(Page<WeXinArticle> page, WeXinArticle weXinArticle) {
//		DetachedCriteria dc = weXinArticleDao.createDetachedCriteria();
//		if (StringUtils.isNotEmpty(weXinArticle.getId())){
//			dc.add(Restrictions.like("name", "%"+weXinArticle.getId()+"%"));
//		}
//		dc.add(Restrictions.eq(WeXinArticle.FIELD_DEL_FLAG, WeXinArticle.DEL_FLAG_NORMAL));
//		dc.addOrder(Order.desc("id"));
//		return weXinArticleDao.find(page, dc);
//	}
//	
//	@Transactional(readOnly = false)
//	public void save(WeXinArticle article) {
//		weXinArticleDao.save(article);
//	}
//	
//	@Transactional(readOnly = false)
//	public void delete(String id) {
//		weXinArticleDao.deleteById(id);
//	}
//	
//}
