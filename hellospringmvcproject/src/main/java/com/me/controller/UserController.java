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
import org.springframework.web.bind.annotation.RequestBody;
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
import com.me.controller.viewobject.UserBookVO;
import com.me.entity.User;
import com.me.service.UserService;
import com.me.service.dto.UserBookDTO;
import com.me.service.dto.UserDTO;

@Controller
@RequestMapping("/user")
public class UserController extends BaseController {

	@Autowired
	private UserService userService;
	protected final static Log logger = LogFactory.getLog(UserController.class);

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
	public ApiResult getUserById(@PathVariable("id") int id) {
		int userId = id;
		ApiResult apiResult = new ApiResult();
		UserDTO user = new UserDTO();
		user = userService.getUserById(userId);

		apiResult.setIsSuccess(true);
		apiResult.setMessage("success");
		apiResult.setData(user);

		return apiResult;
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
	
	
	@RequestMapping(value = "/adduser", method = RequestMethod.POST)
	@ResponseBody
	public ApiResult addUser(HttpServletRequest request,@Valid @RequestBody UserVO user,BindingResult result) {
		ApiResult apiResult = new ApiResult();
		List<ObjectError> allErrors=null;
		List<String> errorList=new ArrayList<String>();
		String message="";
		Boolean isSuccess=true;
		
		if(result.hasErrors()){
			logger.error("===========================add user valid error");
			isSuccess=false;
			message="validation error";
			allErrors = result.getAllErrors();
			
			for(ObjectError obj: allErrors){
				errorList.add(obj.getDefaultMessage());
			}
		}
	
		if(isSuccess){
			Date date = new Date();
			UserDTO addUser = new UserDTO();
			addUser.setUserName(user.getUserName());
			addUser.setUserAge(user.getUserAge());
			addUser.setUserAddress(user.getUserAddress());
			addUser.setUserPassword(user.getUserPassword());
			addUser.setUserBirthday(date);

			int userId = userService.addUser(addUser);
		}
		
		apiResult.setIsSuccess(isSuccess);
		apiResult.setMessage(message);
		apiResult.setData(errorList);
		 
		return apiResult;
	}
	
	@RequestMapping(value = "/deleteuser/{id}", method = RequestMethod.DELETE)
	@ResponseBody
	public ApiResult deleteUserById(@PathVariable("id") int id) {
		ApiResult apiResult = new ApiResult();
		userService.deleteUserById(id);
		
		apiResult.setIsSuccess(true);
		apiResult.setMessage("success");
		apiResult.setData(null);

		return apiResult;
	}

	@RequestMapping(value = "/updateuser", method = RequestMethod.PUT)
	@ResponseBody
	public ApiResult updateUser(HttpServletRequest request,@Valid @RequestBody UserVO user,BindingResult result) {
		ApiResult apiResult = new ApiResult();
		List<String> errorList=new ArrayList<String>();
		List<ObjectError> allErrors=null;
		String message="";
		Boolean isSuccess=true;
		
		logger.error("===========================update user");
		
		if(result.hasErrors()){
			isSuccess=false;
			message="validation error";
			allErrors = result.getAllErrors();
			
			for(ObjectError obj: allErrors){
				errorList.add(obj.getDefaultMessage());
			}
		}
	
		if(isSuccess){
			UserDTO updateUser = new UserDTO();
			updateUser.setUserId(user.getUserId());
			updateUser.setUserName(user.getUserName());
			updateUser.setUserAge(user.getUserAge());
			updateUser.setUserAddress(user.getUserAddress());
			updateUser.setUserPassword(user.getUserPassword());
			updateUser.setUserBirthday(user.getUserBirthday());
            userService.updateUser(updateUser);
		}

		apiResult.setIsSuccess(isSuccess);
		apiResult.setMessage(message);
		apiResult.setData(errorList);
		 
		return apiResult;
	}
	
	@RequestMapping(value = "/showalluserbook", method = RequestMethod.GET)
	@ResponseBody
	public ApiResult showAllUserBook(HttpServletRequest request,HttpServletResponse response) {

		ApiResult apiResult = new ApiResult();
		List<UserBookVO> userBookVOList = new ArrayList<UserBookVO>();
		List<UserBookDTO> userBookList = userService.getAllUserBook();
		
		for(UserBookDTO item : userBookList){
			UserBookVO userVO = new UserBookVO();
			userVO.setUserName(item.getUserName());
			userVO.setUserAge(item.getUserAge());
			userVO.setUserBirthday(item.getUserBirthday());
			userVO.setBookName(item.getBookName());
			userVO.setBookPrice(item.getBookPrice());
			userBookVOList.add(userVO);
		}
		
		apiResult.setIsSuccess(true);
		apiResult.setMessage("success");
		apiResult.setData(userBookVOList);
		
		return apiResult;
	}
	
}
