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
//import com.thinkgem.jeesite.modules.wexin.entity.RequestLocationMessage;
//import com.thinkgem.jeesite.modules.wexin.service.RequestLocationMessageService;
//
///**
// * 发送图片消息Controller
// * @author zm47726151@gmail.com
// * @version 2014-11-09
// */
//@Controller
//@RequestMapping(value = "${adminPath}/wexin/requestLocationMessage")
//public class RequestLocationMessageController extends BaseController {
//
//	@Autowired
//	private RequestLocationMessageService requestLocationMessageService;
//	
//	@ModelAttribute
//	public RequestLocationMessage get(@RequestParam(required=false) String id) {
//		if (StringUtils.isNotBlank(id)){
//			return requestLocationMessageService.get(id);
//		}else{
//			return new RequestLocationMessage();
//		}
//	}
//	
//	@RequiresPermissions("wexin:requestLocationMessage:view")
//	@RequestMapping(value = {"list", ""})
//	public String list(RequestLocationMessage requestLocationMessage, HttpServletRequest request, HttpServletResponse response, Model model) {
//		User user = UserUtils.getUser();
//		if (!user.isAdmin()){
//			requestLocationMessage.setCreateBy(user);
//		}
//        Page<RequestLocationMessage> page = requestLocationMessageService.find(new Page<RequestLocationMessage>(request, response), requestLocationMessage); 
//        model.addAttribute("page", page);
//		return "modules/" + "wexin/requestLocationMessageList";
//	}
//
//	@RequiresPermissions("wexin:requestLocationMessage:view")
//	@RequestMapping(value = "form")
//	public String form(RequestLocationMessage requestLocationMessage, Model model) {
//		model.addAttribute("requestLocationMessage", requestLocationMessage);
//		return "modules/" + "wexin/requestLocationMessageForm";
//	}
//
//	@RequiresPermissions("wexin:requestLocationMessage:edit")
//	@RequestMapping(value = "save")
//	public String save(RequestLocationMessage requestLocationMessage, Model model, RedirectAttributes redirectAttributes) {
//		if (!beanValidator(model, requestLocationMessage)){
//			return form(requestLocationMessage, model);
//		}
//		requestLocationMessageService.save(requestLocationMessage);
//		addMessage(redirectAttributes, "保存发送图片消息'" + requestLocationMessage.getId() + "'成功");
//		return "redirect:"+Global.getAdminPath()+"/wexin/requestLocationMessage/?repage";
//	}
//	
//	@RequiresPermissions("wexin:requestLocationMessage:edit")
//	@RequestMapping(value = "delete")
//	public String delete(String id, RedirectAttributes redirectAttributes) {
//		requestLocationMessageService.delete(id);
//		addMessage(redirectAttributes, "删除发送图片消息成功");
//		return "redirect:"+Global.getAdminPath()+"/wexin/requestLocationMessage/?repage";
//	}
//
//}
