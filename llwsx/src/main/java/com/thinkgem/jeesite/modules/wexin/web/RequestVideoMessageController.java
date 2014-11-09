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
import com.thinkgem.jeesite.modules.wexin.entity.RequestVideoMessage;
import com.thinkgem.jeesite.modules.wexin.service.RequestVideoMessageService;

/**
 * 发送图片消息Controller
 * @author zm47726151@gmail.com
 * @version 2014-11-09
 */
@Controller
@RequestMapping(value = "${adminPath}/wexin/requestVideoMessage")
public class RequestVideoMessageController extends BaseController {

	@Autowired
	private RequestVideoMessageService requestVideoMessageService;
	
	@ModelAttribute
	public RequestVideoMessage get(@RequestParam(required=false) String id) {
		if (StringUtils.isNotBlank(id)){
			return requestVideoMessageService.get(id);
		}else{
			return new RequestVideoMessage();
		}
	}
	
	@RequiresPermissions("wexin:requestVideoMessage:view")
	@RequestMapping(value = {"list", ""})
	public String list(RequestVideoMessage requestVideoMessage, HttpServletRequest request, HttpServletResponse response, Model model) {
		User user = UserUtils.getUser();
		if (!user.isAdmin()){
			requestVideoMessage.setCreateBy(user);
		}
        Page<RequestVideoMessage> page = requestVideoMessageService.find(new Page<RequestVideoMessage>(request, response), requestVideoMessage); 
        model.addAttribute("page", page);
		return "modules/" + "wexin/requestVideoMessageList";
	}

	@RequiresPermissions("wexin:requestVideoMessage:view")
	@RequestMapping(value = "form")
	public String form(RequestVideoMessage requestVideoMessage, Model model) {
		model.addAttribute("requestVideoMessage", requestVideoMessage);
		return "modules/" + "wexin/requestVideoMessageForm";
	}

	@RequiresPermissions("wexin:requestVideoMessage:edit")
	@RequestMapping(value = "save")
	public String save(RequestVideoMessage requestVideoMessage, Model model, RedirectAttributes redirectAttributes) {
		if (!beanValidator(model, requestVideoMessage)){
			return form(requestVideoMessage, model);
		}
		requestVideoMessageService.save(requestVideoMessage);
		addMessage(redirectAttributes, "保存发送图片消息'" + requestVideoMessage.getId() + "'成功");
		return "redirect:"+Global.getAdminPath()+"/wexin/requestVideoMessage/?repage";
	}
	
	@RequiresPermissions("wexin:requestVideoMessage:edit")
	@RequestMapping(value = "delete")
	public String delete(String id, RedirectAttributes redirectAttributes) {
		requestVideoMessageService.delete(id);
		addMessage(redirectAttributes, "删除发送图片消息成功");
		return "redirect:"+Global.getAdminPath()+"/wexin/requestVideoMessage/?repage";
	}

}
