package com.rogowiczdawid.gamestore.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.rogowiczdawid.gamestore.entities.User;

@Repository
public class UserDaoImpl implements UserDao {
	
	SessionFactory sessionFactory;
		
	public void setSessionFactory(SessionFactory sf){
		this.sessionFactory = sf;
	}


	@Override
	public void updateUser(User u) {
		Session session = this.sessionFactory.getCurrentSession();
		session.update(u);
	}

	@Override
	public void addUser(User u) {
		Session session = this.sessionFactory.getCurrentSession();
		session.persist(u);
	}
	
	@Override
	public void removeUser(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		User u = (User)session.load(User.class, new Integer(id));
		if(u != null)	session.delete(u);
	}
	
	@Override
	public User getUser(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		User u = (User)session.load(User.class, new Integer(id));
		return u;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<User> getUsersList() {
		Session session = this.sessionFactory.getCurrentSession();
		List<User> userList = session.createQuery("FROM User").list();		
		return userList;
	}

}
