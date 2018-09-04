package com.me.service;

import java.util.List;
import com.me.service.dto.UserDTO;

public interface UserService {
	public UserDTO getUserById(Integer id);
	public int addUser(UserDTO user);
	public List<UserDTO> getAllUser();
}
