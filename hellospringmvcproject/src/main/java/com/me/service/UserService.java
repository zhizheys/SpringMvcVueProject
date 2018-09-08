package com.me.service;

import java.util.List;

import com.me.service.dto.UserBookDTO;
import com.me.service.dto.UserDTO;

public interface UserService {
	public UserDTO getUserById(int id);
	public int addUser(UserDTO user);
	public List<UserDTO> getAllUser();
	public Integer deleteUserById(int id);
	public Integer updateUser(UserDTO user);
	public List<UserBookDTO> getAllUserBook();
}
