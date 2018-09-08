package com.me.mapper;

import java.util.List;
import com.me.entity.User;
import com.me.entity.UserBook;

public interface UserMapper {
	public User getUserById(int id);
	public int addUser(User user);
	public List<User> getAllUser();
	public Integer deleteUserById(int id);
	public Integer updateUser(User user);
	public List<UserBook> getAllUserBook();
}
