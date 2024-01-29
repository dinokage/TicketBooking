package com.ticketbooking.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ticketbooking.entities.User;

@Repository
public interface UserRepository extends JpaRepository<User,Integer> {
	User findByUserIdAndPassword(int userId, String password);
	User findByUserNameAndPassword(String userName, String password);
	User findByUserId(int userId);
	User findByEmail(String email);
}
