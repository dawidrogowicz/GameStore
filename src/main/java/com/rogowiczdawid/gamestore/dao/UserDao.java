package com.rogowiczdawid.gamestore.dao;

import java.util.List;

import com.rogowiczdawid.gamestore.models.User;

public interface UserDao {
	public User getUser(int id);
	public void updateUser(User u);
	public void addUser(User u);
	public void removeUser(int id);
	public List<User> getUsersList();
}
