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
//import com.thinkgem.jeesite.common.utils.StringUtils;
//import com.thinkgem.jeesite.common.web.BaseController;
//import com.thinkgem.jeesite.modules.sys.entity.User;
//import com.thinkgem.jeesite.modules.sys.utils.UserUtils;
//import com.thinkgem.jeesite.modules.wexin.entity.WeXinMusic;
//import com.thinkgem.jeesite.modules.wexin.service.WeXinMusicService;
//
///**
// * 发送图片消息Controller
// * @author zm47726151@gmail.com
// * @version 2014-11-09
// */
//@Controller
//@RequestMapping(value = "${adminPath}/wexin/WeXinMusic")
//public class WeXinMusicController extends BaseController {
//
//	@Autowired
//	private WeXinMusicService weXinMusicService;
//	
//	@ModelAttribute
//	public WeXinMusic get(@RequestParam(required=false) String id) {
//		if (StringUtils.isNotBlank(id)){
//			return weXinMusicService.get(id);
//		}else{
//			return new WeXinMusic();
//		}
//	}
//	
//	@RequiresPermissions("wexin:WeXinMusic:view")
//	@RequestMapping(value = {"list", ""})
//	public String list(WeXinMusic weXinMusic, HttpServletRequest request, HttpServletResponse response, Model model) {
//		User user = UserUtils.getUser();
//		if (!user.isAdmin()){
//			weXinMusic.setCreateBy(user);
//		}
//        Page<WeXinMusic> page = weXinMusicService.find(new Page<WeXinMusic>(request, response), weXinMusic); 
//        model.addAttribute("page", page);
//		return "modules/" + "wexin/WeXinMusicList";
//	}
//
//	@RequiresPermissions("wexin:WeXinMusic:view")
//	@RequestMapping(value = "form")
//	public String form(WeXinMusic WeXinMusic, Model model) {
//		model.addAttribute("WeXinMusic", WeXinMusic);
//		return "modules/" + "wexin/WeXinMusicForm";
//	}
//
//	@RequiresPermissions("wexin:WeXinMusic:edit")
//	@RequestMapping(value = "save")
//	public String save(WeXinMusic weXinMusic, Model model, RedirectAttributes redirectAttributes) {
//		if (!beanValidator(model, weXinMusic)){
//			return form(weXinMusic, model);
//		}
//		weXinMusicService.save(weXinMusic);
//		addMessage(redirectAttributes, "保存发送图片消息'" + weXinMusic.getId() + "'成功");
//		return "redirect:"+Global.getAdminPath()+"/wexin/WeXinMusic/?repage";
//	}
//	
//	@RequiresPermissions("wexin:WeXinMusic:edit")
//	@RequestMapping(value = "delete")
//	public String delete(String id, RedirectAttributes redirectAttributes) {
//		weXinMusicService.delete(id);
//		addMessage(redirectAttributes, "删除发送图片消息成功");
//		return "redirect:"+Global.getAdminPath()+"/wexin/WeXinMusic/?repage";
//	}
//
//}
