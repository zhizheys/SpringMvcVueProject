package com.me.mapper;

import java.util.List;
import com.me.entity.User;

public interface UserMapper {
	public User getUserById(int id);
	public int addUser(User user);
	public List<User> getAllUser();
}
