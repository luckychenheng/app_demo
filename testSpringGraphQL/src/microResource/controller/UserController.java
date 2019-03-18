package microResource.controller;

import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.fasterxml.jackson.databind.jsonFormatVisitors.JsonAnyFormatVisitor;

import microResource.model.User;
import microResource.service.UserSerivce;
import microResource.util.FormatToJson;
import net.sf.json.JSONObject;

@Controller
public class UserController {

	private UserSerivce userManager;

	public UserSerivce getUserManager() {
		return userManager;
	}

	@Resource
	public void setUserManager(UserSerivce userManager) {
		this.userManager = userManager;
	}

	@RequestMapping("/user/testGraphQL")
	public void put(@RequestParam("query") String query, HttpServletResponse response) throws Exception {
		System.out.println(query);
		Map<String, Object> map = userManager.getUserInfo(query);
		JSONObject json = JSONObject.fromObject(map);
		response.getWriter().print(FormatToJson.formatJson(json.toString()));
	}

	@RequestMapping("/user/register")
	public String register(HttpServletRequest request, User user) throws Exception {
		return null;
	}

	

}
