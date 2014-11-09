///**
// * There are <a href="https://github.com/thinkgem/jeesite">JeeSite</a> code generation
// */
//package com.thinkgem.jeesite.modules.wexin.web;
//
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
//import org.apache.shiro.authz.annotation.RequiresPermissions;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.ModelAttribute;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.servlet.mvc.support.RedirectAttributes;
//
//import com.thinkgem.jeesite.common.config.Global;
//import com.thinkgem.jeesite.common.persistence.Page;
//import com.thinkgem.jeesite.common.web.BaseController;
//import com.thinkgem.jeesite.common.utils.StringUtils;
//import com.thinkgem.jeesite.modules.sys.entity.User;
//import com.thinkgem.jeesite.modules.sys.utils.UserUtils;
//import com.thinkgem.jeesite.modules.wexin.entity.WeXinArticle;
//import com.thinkgem.jeesite.modules.wexin.service.WeXinArticleService;
//
///**
// * 发送图片消息Controller
// * @author zm47726151@gmail.com
// * @version 2014-11-09
// */
//@Controller
//@RequestMapping(value = "${adminPath}/wexin/article")
//public class WeXinArticleController extends BaseController {
//
//	@Autowired
//	private WeXinArticleService weXinArticleService;
//	
//	@ModelAttribute
//	public WeXinArticle get(@RequestParam(required=false) String id) {
//		if (StringUtils.isNotBlank(id)){
//			return weXinArticleService.get(id);
//		}else{
//			return new WeXinArticle();
//		}
//	}
//	
//	@RequiresPermissions("wexin:article:view")
//	@RequestMapping(value = {"list", ""})
//	public String list(WeXinArticle weXinArticle, HttpServletRequest request, HttpServletResponse response, Model model) {
//		User user = UserUtils.getUser();
//		if (!user.isAdmin()){
//			weXinArticle.setCreateBy(user);
//		}
//        Page<WeXinArticle> page = weXinArticleService.find(new Page<WeXinArticle>(request, response), weXinArticle); 
//        model.addAttribute("page", page);
//		return "modules/" + "wexin/articleList";
//	}
//
//	@RequiresPermissions("wexin:article:view")
//	@RequestMapping(value = "form")
//	public String form(WeXinArticle weXinArticle, Model model) {
//		model.addAttribute("article", weXinArticle);
//		return "modules/" + "wexin/articleForm";
//	}
//
//	@RequiresPermissions("wexin:article:edit")
//	@RequestMapping(value = "save")
//	public String save(WeXinArticle weXinArticle, Model model, RedirectAttributes redirectAttributes) {
//		if (!beanValidator(model, weXinArticle)){
//			return form(weXinArticle, model);
//		}
//		weXinArticleService.save(weXinArticle);
//		addMessage(redirectAttributes, "保存发送图片消息'" + weXinArticle.getId() + "'成功");
//		return "redirect:"+Global.getAdminPath()+"/wexin/article/?repage";
//	}
//	
//	@RequiresPermissions("wexin:article:edit")
//	@RequestMapping(value = "delete")
//	public String delete(String id, RedirectAttributes redirectAttributes) {
//		weXinArticleService.delete(id);
//		addMessage(redirectAttributes, "删除发送图片消息成功");
//		return "redirect:"+Global.getAdminPath()+"/wexin/article/?repage";
//	}
//
//}
