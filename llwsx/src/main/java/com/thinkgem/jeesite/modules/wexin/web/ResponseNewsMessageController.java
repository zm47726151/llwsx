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
//import com.thinkgem.jeesite.modules.wexin.entity.ResponseNewsMessage;
//import com.thinkgem.jeesite.modules.wexin.service.ResponseNewsMessageService;
//
///**
// * 发送图片消息Controller
// * @author zm47726151@gmail.com
// * @version 2014-11-09
// */
//@Controller
//@RequestMapping(value = "${adminPath}/wexin/responseNewsMessage")
//public class ResponseNewsMessageController extends BaseController {
//
//	@Autowired
//	private ResponseNewsMessageService responseNewsMessageService;
//	
//	@ModelAttribute
//	public ResponseNewsMessage get(@RequestParam(required=false) String id) {
//		if (StringUtils.isNotBlank(id)){
//			return responseNewsMessageService.get(id);
//		}else{
//			return new ResponseNewsMessage();
//		}
//	}
//	
//	@RequiresPermissions("wexin:responseNewsMessage:view")
//	@RequestMapping(value = {"list", ""})
//	public String list(ResponseNewsMessage responseNewsMessage, HttpServletRequest request, HttpServletResponse response, Model model) {
//		User user = UserUtils.getUser();
//		if (!user.isAdmin()){
//			responseNewsMessage.setCreateBy(user);
//		}
//        Page<ResponseNewsMessage> page = responseNewsMessageService.find(new Page<ResponseNewsMessage>(request, response), responseNewsMessage); 
//        model.addAttribute("page", page);
//		return "modules/" + "wexin/responseNewsMessageList";
//	}
//
//	@RequiresPermissions("wexin:responseNewsMessage:view")
//	@RequestMapping(value = "form")
//	public String form(ResponseNewsMessage responseNewsMessage, Model model) {
//		model.addAttribute("responseNewsMessage", responseNewsMessage);
//		return "modules/" + "wexin/responseNewsMessageForm";
//	}
//
//	@RequiresPermissions("wexin:responseNewsMessage:edit")
//	@RequestMapping(value = "save")
//	public String save(ResponseNewsMessage responseNewsMessage, Model model, RedirectAttributes redirectAttributes) {
//		if (!beanValidator(model, responseNewsMessage)){
//			return form(responseNewsMessage, model);
//		}
//		responseNewsMessageService.save(responseNewsMessage);
//		addMessage(redirectAttributes, "保存发送图片消息'" + responseNewsMessage.getId() + "'成功");
//		return "redirect:"+Global.getAdminPath()+"/wexin/responseNewsMessage/?repage";
//	}
//	
//	@RequiresPermissions("wexin:responseNewsMessage:edit")
//	@RequestMapping(value = "delete")
//	public String delete(String id, RedirectAttributes redirectAttributes) {
//		responseNewsMessageService.delete(id);
//		addMessage(redirectAttributes, "删除发送图片消息成功");
//		return "redirect:"+Global.getAdminPath()+"/wexin/responseNewsMessage/?repage";
//	}
//
//}
