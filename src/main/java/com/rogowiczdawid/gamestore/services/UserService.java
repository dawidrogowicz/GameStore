package com.rogowiczdawid.gamestore.services;

import com.rogowiczdawid.gamestore.models.User;
import com.rogowiczdawid.gamestore.models.UserDTO;
import com.rogowiczdawid.gamestore.validation.EmailExistsException;

public interface UserService {

	public User registerNewUser(UserDTO accountDto) throws EmailExistsException;
	
}
