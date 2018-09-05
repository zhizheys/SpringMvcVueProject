package com.me.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.me.entity.User;
import com.me.mapper.UserMapper;
import com.me.service.UserService;
import com.me.service.dto.UserDTO;

@Service("userService")
public class UserServiceImpl implements UserService {

	@Autowired
	private UserMapper userDao;

   @Override
	public UserDTO getUserById(Integer id) {
		UserDTO userDTO= new UserDTO();
		User user =userDao.getUserById(id);
		
		userDTO.setUserId(user.getUserId());
		userDTO.setUserName(user.getUserName());
		userDTO.setUserAge(user.getUserAge());
		userDTO.setUserPassword(user.getUserPassword());
		userDTO.setUserBirthday(user.getUserBirthday());
		userDTO.setUserAddress(user.getUserAddress());
		
		return userDTO;
	}
	
   @Override
	public int addUser(UserDTO user){
		
		User addUser = new User();
		addUser.setUserName(user.getUserName());
		addUser.setUserAge(user.getUserAge());
		addUser.setUserPassword(user.getUserPassword());
		addUser.setUserBirthday(user.getUserBirthday());
		addUser.setUserAddress(user.getUserAddress());
		
		userDao.addUser(addUser);
		
		//返回该对象的自增ID
		return addUser.getUserId();
	}
	
   @Override
	public List<UserDTO> getAllUser() {
		List<UserDTO> userDTOList = new ArrayList<UserDTO>();
		List<User> userList = userDao.getAllUser();
		
		for(User item :userList){
			UserDTO uDto = new UserDTO();
			uDto.setUserId(item.getUserId());
			uDto.setUserName(item.getUserName());
			uDto.setUserAge(item.getUserAge());
			uDto.setUserPassword(item.getUserPassword());
			uDto.setUserBirthday(item.getUserBirthday());
			uDto.setUserAddress(item.getUserAddress());

			userDTOList.add(uDto);
		}
		
		return userDTOList;
	}

}
