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
//import com.thinkgem.jeesite.modules.wexin.entity.RequestLinkMessage;
//import com.thinkgem.jeesite.modules.wexin.service.RequestLinkMessageService;
//
///**
// * 发送图片消息Controller
// * @author zm47726151@gmail.com
// * @version 2014-11-09
// */
//@Controller
//@RequestMapping(value = "${adminPath}/wexin/requestLinkMessage")
//public class RequestLinkMessageController extends BaseController {
//
//	@Autowired
//	private RequestLinkMessageService requestLinkMessageService;
//	
//	@ModelAttribute
//	public RequestLinkMessage get(@RequestParam(required=false) String id) {
//		if (StringUtils.isNotBlank(id)){
//			return requestLinkMessageService.get(id);
//		}else{
//			return new RequestLinkMessage();
//		}
//	}
//	
//	@RequiresPermissions("wexin:requestLinkMessage:view")
//	@RequestMapping(value = {"list", ""})
//	public String list(RequestLinkMessage requestLinkMessage, HttpServletRequest request, HttpServletResponse response, Model model) {
//		User user = UserUtils.getUser();
//		if (!user.isAdmin()){
//			requestLinkMessage.setCreateBy(user);
//		}
//        Page<RequestLinkMessage> page = requestLinkMessageService.find(new Page<RequestLinkMessage>(request, response), requestLinkMessage); 
//        model.addAttribute("page", page);
//		return "modules/" + "wexin/requestLinkMessageList";
//	}
//
//	@RequiresPermissions("wexin:requestLinkMessage:view")
//	@RequestMapping(value = "form")
//	public String form(RequestLinkMessage requestLinkMessage, Model model) {
//		model.addAttribute("requestLinkMessage", requestLinkMessage);
//		return "modules/" + "wexin/requestLinkMessageForm";
//	}
//
//	@RequiresPermissions("wexin:requestLinkMessage:edit")
//	@RequestMapping(value = "save")
//	public String save(RequestLinkMessage requestLinkMessage, Model model, RedirectAttributes redirectAttributes) {
//		if (!beanValidator(model, requestLinkMessage)){
//			return form(requestLinkMessage, model);
//		}
//		requestLinkMessageService.save(requestLinkMessage);
//		addMessage(redirectAttributes, "保存发送图片消息'" + requestLinkMessage.getId() + "'成功");
//		return "redirect:"+Global.getAdminPath()+"/wexin/requestLinkMessage/?repage";
//	}
//	
//	@RequiresPermissions("wexin:requestLinkMessage:edit")
//	@RequestMapping(value = "delete")
//	public String delete(String id, RedirectAttributes redirectAttributes) {
//		requestLinkMessageService.delete(id);
//		addMessage(redirectAttributes, "删除发送图片消息成功");
//		return "redirect:"+Global.getAdminPath()+"/wexin/requestLinkMessage/?repage";
//	}
//
//}
