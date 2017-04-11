package com.rogowiczdawid.gamestore.services;

import java.util.List;
import com.rogowiczdawid.gamestore.entities.User;

public interface UserService {

	public void updateUser(User u);
	public void addUser(User u);
	public void removeUser(int id);
	public User getUser(int id);
	public List<User> getUsersList();
	
}
