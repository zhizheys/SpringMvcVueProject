package com.me.controller;

import java.awt.event.ItemEvent;
import java.awt.im.spi.InputMethod;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.me.controller.viewobject.UserVO;
import com.me.controller.framework.BaseController;
import com.me.controller.viewobject.ApiResult;
import com.me.entity.User;
import com.me.service.UserService;
import com.me.service.dto.UserDTO;

@Controller
@RequestMapping("/user")
public class UserController extends BaseController {

	@Autowired
	private UserService userService;

	@RequestMapping(value = "/show", method = RequestMethod.GET)
	@ResponseBody
	public String show() {
		String result = "hello world";
		
		logger.debug("DEBUG ...............................");
		logger.info("INFO ................................."+ "user/show controller info");
		logger.warn("warn ................................."+ "user/show controller info");
		logger.error("ERROR ..............................." + "user/show controller error");

		return result;
	}
	
	
	//restful url 风格http://localhost:8080/TestSpringMybatis/user/userinfo/10
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
	
	@RequestMapping(value = "/showalluser", method = RequestMethod.GET)
	@ResponseBody
	public ApiResult showAllUser(HttpServletRequest request,HttpServletResponse response) {

		ApiResult apiResult = new ApiResult();
		UserDTO userDTO = new UserDTO();
		List<UserVO> userVOList = new ArrayList<UserVO>();
		List<UserDTO> userList = userService.getAllUser();
		
		for(UserDTO item : userList){
			UserVO userVO = new UserVO();
			userVO.setUserId(item.getUserId());
			userVO.setUserName(item.getUserName());
			userVO.setUserAge(item.getUserAge());
			userVO.setUserAddress(item.getUserAddress());
			userVO.setUserPassword(item.getUserPassword());
			userVO.setUserBirthday(item.getUserBirthday());
			userVOList.add(userVO);
		}
		
		apiResult.setIsSuccess(true);
		apiResult.setMessage("success");
		apiResult.setData(userVOList);
		
		return apiResult;
	}
	
	
//	@RequestMapping(value = "/adduser", method = RequestMethod.POST)
//	public ModelAndView addUser(HttpServletRequest request,@Valid @ModelAttribute UserViewModel user,BindingResult result) {
//		ModelAndView modelAndView = new ModelAndView();
//		List<ObjectError> allErrors=null;
//		
//		if(result.hasErrors()){
//			logger.error("===========================add user valid error");
//			allErrors = result.getAllErrors();
//			modelAndView.addObject("allErrors", allErrors);
//			modelAndView.setViewName("user/registeruser");
//			return modelAndView;
//		}
//		
//
//		Date date = new Date();
//		User addUser = new User();
//		addUser.setUserName(user.getUserName());
//		addUser.setUserAge(user.getUserAge());
//		addUser.setUserAddress(user.getUserAddress());
//		addUser.setUserPassword(user.getUserPassword());
//		addUser.setUserBirthday(user.getUserBirthday());
//
//		int userId = userService.addUser(addUser);
//		User userFind = userService.getUserById(userId);
//		System.out.println("==============================add user id is :" + userFind.getUserId());
//
//		//return "redirect:/user/showalluser";
//		 modelAndView = new ModelAndView("redirect:/user/showalluser");
//		 
//		 return modelAndView;
//	}


}
