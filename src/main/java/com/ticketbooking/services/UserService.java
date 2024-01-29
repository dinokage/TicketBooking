package com.ticketbooking.services;

import java.util.List;

import com.ticketbooking.dto.SignInDTO;
import com.ticketbooking.dto.UserCheckDTO;
import com.ticketbooking.dto.UserDTO;
import com.ticketbooking.entities.User;

public interface UserService {

    void saveUser(UserDTO userDTO);

    User findById(int id);

	List<User> listAll();
	
	UserCheckDTO validate(SignInDTO signInDTO);

}
