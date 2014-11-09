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
//import com.thinkgem.jeesite.modules.wexin.entity.RequestVoiceMessage;
//import com.thinkgem.jeesite.modules.wexin.service.RequestVoiceMessageService;
//
///**
// * 发送图片消息Controller
// * @author zm47726151@gmail.com
// * @version 2014-11-09
// */
//@Controller
//@RequestMapping(value = "${adminPath}/wexin/requestVoiceMessage")
//public class RequestVoiceMessageController extends BaseController {
//
//	@Autowired
//	private RequestVoiceMessageService requestVoiceMessageService;
//	
//	@ModelAttribute
//	public RequestVoiceMessage get(@RequestParam(required=false) String id) {
//		if (StringUtils.isNotBlank(id)){
//			return requestVoiceMessageService.get(id);
//		}else{
//			return new RequestVoiceMessage();
//		}
//	}
//	
//	@RequiresPermissions("wexin:requestVoiceMessage:view")
//	@RequestMapping(value = {"list", ""})
//	public String list(RequestVoiceMessage requestVoiceMessage, HttpServletRequest request, HttpServletResponse response, Model model) {
//		User user = UserUtils.getUser();
//		if (!user.isAdmin()){
//			requestVoiceMessage.setCreateBy(user);
//		}
//        Page<RequestVoiceMessage> page = requestVoiceMessageService.find(new Page<RequestVoiceMessage>(request, response), requestVoiceMessage); 
//        model.addAttribute("page", page);
//		return "modules/" + "wexin/requestVoiceMessageList";
//	}
//
//	@RequiresPermissions("wexin:requestVoiceMessage:view")
//	@RequestMapping(value = "form")
//	public String form(RequestVoiceMessage requestVoiceMessage, Model model) {
//		model.addAttribute("requestVoiceMessage", requestVoiceMessage);
//		return "modules/" + "wexin/requestVoiceMessageForm";
//	}
//
//	@RequiresPermissions("wexin:requestVoiceMessage:edit")
//	@RequestMapping(value = "save")
//	public String save(RequestVoiceMessage requestVoiceMessage, Model model, RedirectAttributes redirectAttributes) {
//		if (!beanValidator(model, requestVoiceMessage)){
//			return form(requestVoiceMessage, model);
//		}
//		requestVoiceMessageService.save(requestVoiceMessage);
//		addMessage(redirectAttributes, "保存发送图片消息'" + requestVoiceMessage.getId() + "'成功");
//		return "redirect:"+Global.getAdminPath()+"/wexin/requestVoiceMessage/?repage";
//	}
//	
//	@RequiresPermissions("wexin:requestVoiceMessage:edit")
//	@RequestMapping(value = "delete")
//	public String delete(String id, RedirectAttributes redirectAttributes) {
//		requestVoiceMessageService.delete(id);
//		addMessage(redirectAttributes, "删除发送图片消息成功");
//		return "redirect:"+Global.getAdminPath()+"/wexin/requestVoiceMessage/?repage";
//	}
//
//}
