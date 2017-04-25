package com.rogowiczdawid.gamestore.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.rogowiczdawid.gamestore.dao.IGenericDAO;
import com.rogowiczdawid.gamestore.models.User;
import com.rogowiczdawid.gamestore.models.UserDTO;
import com.rogowiczdawid.gamestore.validation.EmailExistsException;

@Service
@Transactional
public class UserServiceImpl implements UserService {

	private IGenericDAO<User> dao;

	@Autowired
	public void setDao(IGenericDAO<User> daoToSet) {
		dao = daoToSet;
		dao.setClazz(User.class);
	}

	@Override
	public User registerNewUser(UserDTO accountDto) throws EmailExistsException {

		if (emailExists(accountDto.getEmail()))
			throw new EmailExistsException("account with email: " + accountDto.getEmail() + " already exists");

		User user = new User();
		user.setName(accountDto.getName());
		user.setPassword(accountDto.getPassword());
		user.setEmail(accountDto.getEmail());

		return dao.create(user);
	}

	private boolean emailExists(String email) {

		List<User> users = dao.findByEmail(email);
		if (users.size() > 0)
			return true;

		return false;
	}

}
