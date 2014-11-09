/**
 * There are <a href="https://github.com/thinkgem/jeesite">JeeSite</a> code generation
 */
package com.thinkgem.jeesite.modules.wexin.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.thinkgem.jeesite.common.config.Global;
import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.web.BaseController;
import com.thinkgem.jeesite.common.utils.StringUtils;
import com.thinkgem.jeesite.modules.sys.entity.User;
import com.thinkgem.jeesite.modules.sys.utils.UserUtils;
import com.thinkgem.jeesite.modules.wexin.entity.RequestTextMessage;
import com.thinkgem.jeesite.modules.wexin.service.RequestTextMessageService;

/**
 * 发送图片消息Controller
 * @author zm47726151@gmail.com
 * @version 2014-11-09
 */
@Controller
@RequestMapping(value = "${adminPath}/wexin/requestTextMessage")
public class RequestTextMessageController extends BaseController {

	@Autowired
	private RequestTextMessageService requestTextMessageService;
	
	@ModelAttribute
	public RequestTextMessage get(@RequestParam(required=false) String id) {
		if (StringUtils.isNotBlank(id)){
			return requestTextMessageService.get(id);
		}else{
			return new RequestTextMessage();
		}
	}
	
	@RequiresPermissions("wexin:requestTextMessage:view")
	@RequestMapping(value = {"list", ""})
	public String list(RequestTextMessage requestTextMessage, HttpServletRequest request, HttpServletResponse response, Model model) {
		User user = UserUtils.getUser();
		if (!user.isAdmin()){
			requestTextMessage.setCreateBy(user);
		}
        Page<RequestTextMessage> page = requestTextMessageService.find(new Page<RequestTextMessage>(request, response), requestTextMessage); 
        model.addAttribute("page", page);
		return "modules/" + "wexin/requestTextMessageList";
	}

	@RequiresPermissions("wexin:requestTextMessage:view")
	@RequestMapping(value = "form")
	public String form(RequestTextMessage requestTextMessage, Model model) {
		model.addAttribute("requestTextMessage", requestTextMessage);
		return "modules/" + "wexin/requestTextMessageForm";
	}

	@RequiresPermissions("wexin:requestTextMessage:edit")
	@RequestMapping(value = "save")
	public String save(RequestTextMessage requestTextMessage, Model model, RedirectAttributes redirectAttributes) {
		if (!beanValidator(model, requestTextMessage)){
			return form(requestTextMessage, model);
		}
		requestTextMessageService.save(requestTextMessage);
		addMessage(redirectAttributes, "保存发送图片消息'" + requestTextMessage.getId() + "'成功");
		return "redirect:"+Global.getAdminPath()+"/wexin/requestTextMessage/?repage";
	}
	
	@RequiresPermissions("wexin:requestTextMessage:edit")
	@RequestMapping(value = "delete")
	public String delete(String id, RedirectAttributes redirectAttributes) {
		requestTextMessageService.delete(id);
		addMessage(redirectAttributes, "删除发送图片消息成功");
		return "redirect:"+Global.getAdminPath()+"/wexin/requestTextMessage/?repage";
	}

}
