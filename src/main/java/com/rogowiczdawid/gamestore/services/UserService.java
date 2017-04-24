package com.rogowiczdawid.gamestore.services;

import java.util.List;

import com.rogowiczdawid.gamestore.models.User;
import com.rogowiczdawid.gamestore.models.UserDTO;

public interface UserService {

	public void updateUser(User u);
	public void addUser(User u);
	public void removeUser(int id);
	public User getUser(int id);
	public List<User> getUsersList();
	List<User> getUserByName(String name);
	public User registerNewUser(UserDTO accountDto);
	
}
