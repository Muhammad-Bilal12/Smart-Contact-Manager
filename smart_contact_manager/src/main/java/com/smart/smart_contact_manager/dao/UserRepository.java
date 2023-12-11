package com.smart.smart_contact_manager.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.smart.smart_contact_manager.entity.User;

public interface UserRepository extends JpaRepository<User, Integer> {
    @Query("select u from User where u.email = :email")
    public User getUserbyUsername(@Param("email") String email);

}
