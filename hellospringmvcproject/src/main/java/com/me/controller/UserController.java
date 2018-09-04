package com.me.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.me.controller.viewobject.ApiResult;
import com.me.service.UserService;
import com.me.service.dto.*;

public class UserController {
	
	@Autowired
	private UserService userService;
	
	// restful url 风格http://localhost:8080/TestSpringMybatis/user/userinfo/10
	@RequestMapping(value = "/userinfo/{id}", method = RequestMethod.GET)
	@ResponseBody
	public String getUserById(@PathVariable("id") int id) {
		int userId = id;
		String result = null;
		UserDTO user = new UserDTO();
		user = userService.getUserById(userId);

		ApiResult apiResult = new ApiResult();
		apiResult.setIsSuccess(true);
		apiResult.setMessage("success");
		apiResult.setData(user);

		ObjectMapper objectMapper = new ObjectMapper();

		try {
			result = objectMapper.writeValueAsString(apiResult);
		} catch (Exception ex) {
			result = ex.getMessage();
		}

		return result;
	}
	

}
