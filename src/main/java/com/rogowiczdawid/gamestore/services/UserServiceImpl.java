package com.rogowiczdawid.gamestore.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;

import com.rogowiczdawid.gamestore.dao.UserDao;
import com.rogowiczdawid.gamestore.entities.User;

@Service
@Component("userService")
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserDao userDao;
	
	public void setUserDao(UserDao ud){
		this.userDao = ud;
	}

	@Override
	@Transactional
	public void updateUser(User u) {
		this.userDao.updateUser(u);
	}

	@Override
	@Transactional
	public void addUser(User u) {
		this.userDao.addUser(u);
	}

	@Override
	@Transactional
	public void removeUser(int id) {
		this.userDao.removeUser(id);
	}

	@Override
	@Transactional
	public User getUser(int id) {
		return this.userDao.getUser(id);
	}

	@Override
	@Transactional
	public List<User> getUsersList() {
		return this.userDao.getUsersList();
	}

}
