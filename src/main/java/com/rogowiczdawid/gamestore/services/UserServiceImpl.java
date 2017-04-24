package com.rogowiczdawid.gamestore.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.rogowiczdawid.gamestore.dao.IGenericDAO;
import com.rogowiczdawid.gamestore.models.User;

@Service
@Transactional
public class UserServiceImpl implements UserService {
	
	private IGenericDAO<User> dao;
	
	@Autowired
	public void setDao(IGenericDAO<User> daoToSet){
		dao = daoToSet;
		dao.setClazz(User.class);
	}

	@Override
	public void updateUser(User u) {
		this.dao.update(u);
	}

	@Override
	public void addUser(User u) {
		this.dao.create(u);
	}

	@Override
	public void removeUser(int id) {
		this.dao.deleteById(id);
	}

	@Override
	public User getUser(int id) {
		return this.dao.findOne(id);
	}
	
	@Override
	public List<User> getUserByName(String name){
		return this.dao.findByName(name);
	}

	@Override
	public List<User> getUsersList() {
		return this.dao.findAll();
	}

}
