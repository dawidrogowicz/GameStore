package com.rogowiczdawid.gamestore.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rogowiczdawid.gamestore.dao.UserDao;
import com.rogowiczdawid.gamestore.models.User;

@Service
@Transactional
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserDao userDao;
	
	public void setUserDao(UserDao ud){
		this.userDao = ud;
	}

	@Override
	public void updateUser(User u) {
		this.userDao.updateUser(u);
	}

	@Override
	public void addUser(User u) {
		this.userDao.addUser(u);
	}

	@Override
	public void removeUser(int id) {
		this.userDao.removeUser(id);
	}

	@Override
	public User getUser(int id) {
		return this.userDao.getUser(id);
	}

	@Override
	public List<User> getUsersList() {
		return this.userDao.getUsersList();
	}

}
