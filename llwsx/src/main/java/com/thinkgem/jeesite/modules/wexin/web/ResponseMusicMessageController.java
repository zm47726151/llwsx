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
//import com.thinkgem.jeesite.modules.wexin.entity.ResponseMusicMessage;
//import com.thinkgem.jeesite.modules.wexin.service.ResponseMusicMessageService;
//
///**
// * 发送图片消息Controller
// * @author zm47726151@gmail.com
// * @version 2014-11-09
// */
//@Controller
//@RequestMapping(value = "${adminPath}/wexin/responseMusicMessage")
//public class ResponseMusicMessageController extends BaseController {
//
//	@Autowired
//	private ResponseMusicMessageService responseMusicMessageService;
//	
//	@ModelAttribute
//	public ResponseMusicMessage get(@RequestParam(required=false) String id) {
//		if (StringUtils.isNotBlank(id)){
//			return responseMusicMessageService.get(id);
//		}else{
//			return new ResponseMusicMessage();
//		}
//	}
//	
//	@RequiresPermissions("wexin:responseMusicMessage:view")
//	@RequestMapping(value = {"list", ""})
//	public String list(ResponseMusicMessage responseMusicMessage, HttpServletRequest request, HttpServletResponse response, Model model) {
//		User user = UserUtils.getUser();
//		if (!user.isAdmin()){
//			responseMusicMessage.setCreateBy(user);
//		}
//        Page<ResponseMusicMessage> page = responseMusicMessageService.find(new Page<ResponseMusicMessage>(request, response), responseMusicMessage); 
//        model.addAttribute("page", page);
//		return "modules/" + "wexin/responseMusicMessageList";
//	}
//
//	@RequiresPermissions("wexin:responseMusicMessage:view")
//	@RequestMapping(value = "form")
//	public String form(ResponseMusicMessage responseMusicMessage, Model model) {
//		model.addAttribute("responseMusicMessage", responseMusicMessage);
//		return "modules/" + "wexin/responseMusicMessageForm";
//	}
//
//	@RequiresPermissions("wexin:responseMusicMessage:edit")
//	@RequestMapping(value = "save")
//	public String save(ResponseMusicMessage responseMusicMessage, Model model, RedirectAttributes redirectAttributes) {
//		if (!beanValidator(model, responseMusicMessage)){
//			return form(responseMusicMessage, model);
//		}
//		responseMusicMessageService.save(responseMusicMessage);
//		addMessage(redirectAttributes, "保存发送图片消息'" + responseMusicMessage.getId() + "'成功");
//		return "redirect:"+Global.getAdminPath()+"/wexin/responseMusicMessage/?repage";
//	}
//	
//	@RequiresPermissions("wexin:responseMusicMessage:edit")
//	@RequestMapping(value = "delete")
//	public String delete(String id, RedirectAttributes redirectAttributes) {
//		responseMusicMessageService.delete(id);
//		addMessage(redirectAttributes, "删除发送图片消息成功");
//		return "redirect:"+Global.getAdminPath()+"/wexin/responseMusicMessage/?repage";
//	}
//
//}
