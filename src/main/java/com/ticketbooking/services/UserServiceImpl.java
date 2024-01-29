package com.ticketbooking.services;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ticketbooking.dto.SignInDTO;
import com.ticketbooking.dto.UserCheckDTO;
import com.ticketbooking.dto.UserDTO;
import com.ticketbooking.entities.User;
import com.ticketbooking.globalexception.InvalidEntityException;
import com.ticketbooking.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, ModelMapper modelMapper) throws InvalidEntityException{
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public void saveUser(UserDTO userDTO) throws InvalidEntityException{
    	User user = modelMapper.map(userDTO, User.class);
        userRepository.save(user);
    }

    @Override
    public User findById(int id) throws InvalidEntityException {
        return userRepository.getById(id);
    }

	@Override
	public List<User> listAll() throws InvalidEntityException {
		// TODO Auto-generated method stub
		return userRepository.findAll();
	}
	@Override
	public UserCheckDTO validate(SignInDTO signInDTO) throws InvalidEntityException{
		User user = userRepository.findByEmail(signInDTO.getEmailId());
		if(user!=null && user.getPassword().equals(signInDTO.getPassword())) {
			UserCheckDTO userCheckDTO = modelMapper.map(user,UserCheckDTO.class);
			return userCheckDTO;
		} else {
			return null;
		}
	}
}
