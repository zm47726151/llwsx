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
import com.thinkgem.jeesite.modules.wexin.entity.RequestImageMessage;
import com.thinkgem.jeesite.modules.wexin.service.RequestImageMessageService;

/**
 * 发送图片消息Controller
 * @author zm47726151@gmail.com
 * @version 2014-11-09
 */
@Controller
@RequestMapping(value = "${adminPath}/wexin/requestImageMessage")
public class RequestImageMessageController extends BaseController {

	@Autowired
	private RequestImageMessageService requestImageMessageService;
	
	@ModelAttribute
	public RequestImageMessage get(@RequestParam(required=false) String id) {
		if (StringUtils.isNotBlank(id)){
			return requestImageMessageService.get(id);
		}else{
			return new RequestImageMessage();
		}
	}
	
	@RequiresPermissions("wexin:requestImageMessage:view")
	@RequestMapping(value = {"list", ""})
	public String list(RequestImageMessage requestImageMessage, HttpServletRequest request, HttpServletResponse response, Model model) {
		User user = UserUtils.getUser();
		if (!user.isAdmin()){
			requestImageMessage.setCreateBy(user);
		}
        Page<RequestImageMessage> page = requestImageMessageService.find(new Page<RequestImageMessage>(request, response), requestImageMessage); 
        model.addAttribute("page", page);
		return "modules/" + "wexin/requestImageMessageList";
	}

	@RequiresPermissions("wexin:requestImageMessage:view")
	@RequestMapping(value = "form")
	public String form(RequestImageMessage requestImageMessage, Model model) {
		model.addAttribute("requestImageMessage", requestImageMessage);
		return "modules/" + "wexin/requestImageMessageForm";
	}

	@RequiresPermissions("wexin:requestImageMessage:edit")
	@RequestMapping(value = "save")
	public String save(RequestImageMessage requestImageMessage, Model model, RedirectAttributes redirectAttributes) {
		if (!beanValidator(model, requestImageMessage)){
			return form(requestImageMessage, model);
		}
		requestImageMessageService.save(requestImageMessage);
		addMessage(redirectAttributes, "保存发送图片消息'" + requestImageMessage.getId() + "'成功");
		return "redirect:"+Global.getAdminPath()+"/wexin/requestImageMessage/?repage";
	}
	
	@RequiresPermissions("wexin:requestImageMessage:edit")
	@RequestMapping(value = "delete")
	public String delete(String id, RedirectAttributes redirectAttributes) {
		requestImageMessageService.delete(id);
		addMessage(redirectAttributes, "删除发送图片消息成功");
		return "redirect:"+Global.getAdminPath()+"/wexin/requestImageMessage/?repage";
	}

}
