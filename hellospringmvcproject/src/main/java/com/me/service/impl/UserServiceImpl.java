package com.me.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.me.entity.User;
import com.me.entity.UserBook;
import com.me.mapper.UserMapper;
import com.me.service.UserService;
import com.me.service.dto.UserBookDTO;
import com.me.service.dto.UserDTO;

@Service
public class UserServiceImpl implements UserService {

	@Autowired(required = false)
	private UserMapper userDao;

	@Override
	public UserDTO getUserById(int id) {
		UserDTO userDTO = new UserDTO();
		User user = userDao.getUserById(id);

		userDTO.setUserId(user.getUserId());
		userDTO.setUserName(user.getUserName());
		userDTO.setUserAge(user.getUserAge());
		userDTO.setUserPassword(user.getUserPassword());
		userDTO.setUserBirthday(user.getUserBirthday());
		userDTO.setUserAddress(user.getUserAddress());

		return userDTO;
	}

	@Override
	public int addUser(UserDTO user) {

		User addUser = new User();
		addUser.setUserName(user.getUserName());
		addUser.setUserAge(user.getUserAge());
		addUser.setUserPassword(user.getUserPassword());
		addUser.setUserBirthday(user.getUserBirthday());
		addUser.setUserAddress(user.getUserAddress());

		userDao.addUser(addUser);

		// 返回该对象的自增ID
		return addUser.getUserId();
	}

	@Override
	public List<UserDTO> getAllUser() {
		List<UserDTO> userDTOList = new ArrayList<UserDTO>();
		List<User> userList = userDao.getAllUser();

		for (User item : userList) {
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

	@Override
	public Integer deleteUserById(int id) {
        Integer aInteger= userDao.deleteUserById(id);
		
		return 0;

	}

	@Override
	public Integer updateUser(UserDTO user) {

		User updateUser = new User();
		updateUser.setUserName(user.getUserName());
		updateUser.setUserAge(user.getUserAge());
		updateUser.setUserPassword(user.getUserPassword());
		updateUser.setUserBirthday(user.getUserBirthday());
		updateUser.setUserAddress(user.getUserAddress());

		return userDao.updateUser(updateUser);

	}
	
	@Override
	public List<UserBookDTO> getAllUserBook() {
		List<UserBookDTO> userBookDTOList = new ArrayList<UserBookDTO>();
		List<UserBook> userBookList = userDao.getAllUserBook();

		for (UserBook item : userBookList) {
			UserBookDTO uDto = new UserBookDTO();
			uDto.setUserName(item.getUserName());
			uDto.setUserAge(item.getUserAge());
			uDto.setUserBirthday(item.getUserBirthday());
			uDto.setBookName(item.getBookName());
			uDto.setBookPrice(item.getBookPrice());
			userBookDTOList.add(uDto);
		}

		return userBookDTOList;
	}

}
