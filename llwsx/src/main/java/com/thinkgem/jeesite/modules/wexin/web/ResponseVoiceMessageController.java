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
import com.thinkgem.jeesite.modules.wexin.entity.ResponseVoiceMessage;
import com.thinkgem.jeesite.modules.wexin.service.ResponseVoiceMessageService;

/**
 * 发送图片消息Controller
 * @author zm47726151@gmail.com
 * @version 2014-11-09
 */
@Controller
@RequestMapping(value = "${adminPath}/wexin/responseVoiceMessage")
public class ResponseVoiceMessageController extends BaseController {

	@Autowired
	private ResponseVoiceMessageService responseVoiceMessageService;
	
	@ModelAttribute
	public ResponseVoiceMessage get(@RequestParam(required=false) String id) {
		if (StringUtils.isNotBlank(id)){
			return responseVoiceMessageService.get(id);
		}else{
			return new ResponseVoiceMessage();
		}
	}
	
	@RequiresPermissions("wexin:responseVoiceMessage:view")
	@RequestMapping(value = {"list", ""})
	public String list(ResponseVoiceMessage responseVoiceMessage, HttpServletRequest request, HttpServletResponse response, Model model) {
		User user = UserUtils.getUser();
		if (!user.isAdmin()){
			responseVoiceMessage.setCreateBy(user);
		}
        Page<ResponseVoiceMessage> page = responseVoiceMessageService.find(new Page<ResponseVoiceMessage>(request, response), responseVoiceMessage); 
        model.addAttribute("page", page);
		return "modules/" + "wexin/responseVoiceMessageList";
	}

	@RequiresPermissions("wexin:responseVoiceMessage:view")
	@RequestMapping(value = "form")
	public String form(ResponseVoiceMessage responseVoiceMessage, Model model) {
		model.addAttribute("responseVoiceMessage", responseVoiceMessage);
		return "modules/" + "wexin/responseVoiceMessageForm";
	}

	@RequiresPermissions("wexin:responseVoiceMessage:edit")
	@RequestMapping(value = "save")
	public String save(ResponseVoiceMessage responseVoiceMessage, Model model, RedirectAttributes redirectAttributes) {
		if (!beanValidator(model, responseVoiceMessage)){
			return form(responseVoiceMessage, model);
		}
		responseVoiceMessageService.save(responseVoiceMessage);
		addMessage(redirectAttributes, "保存发送图片消息'" + responseVoiceMessage.getId() + "'成功");
		return "redirect:"+Global.getAdminPath()+"/wexin/responseVoiceMessage/?repage";
	}
	
	@RequiresPermissions("wexin:responseVoiceMessage:edit")
	@RequestMapping(value = "delete")
	public String delete(String id, RedirectAttributes redirectAttributes) {
		responseVoiceMessageService.delete(id);
		addMessage(redirectAttributes, "删除发送图片消息成功");
		return "redirect:"+Global.getAdminPath()+"/wexin/responseVoiceMessage/?repage";
	}

}
