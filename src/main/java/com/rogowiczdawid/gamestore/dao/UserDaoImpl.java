package com.rogowiczdawid.gamestore.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.rogowiczdawid.gamestore.models.User;

@Repository
public class UserDaoImpl implements UserDao {

	@Autowired
	SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public Session getSession() {
		return this.sessionFactory.getCurrentSession();
	}

	@Override
	public void updateUser(User u) {
		Session session = getSession();
		session.update(u);
	}

	@Override
	public void addUser(User u) {
		Session session = getSession();
		session.persist(u);
	}

	@Override
	public void removeUser(int id) {
		Session session = getSession();
		User u = (User) session.get(User.class, id);
		if (u != null)
			session.delete(u);
	}

	@Override
	public User getUser(int id) {
		User u = null;
		Session session = getSession();
		u = (User) session.get(User.class, id);

		return u;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<User> getUsersList() {
		Session session = getSession();
		List<User> userList = session.createQuery("FROM User").list();
		return userList;
	}

}
