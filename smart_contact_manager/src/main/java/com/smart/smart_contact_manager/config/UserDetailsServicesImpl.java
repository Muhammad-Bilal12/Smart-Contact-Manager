package com.smart.smart_contact_manager.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.smart.smart_contact_manager.dao.UserRepository;
import com.smart.smart_contact_manager.entity.User;

public class UserDetailsServicesImpl implements UserDetailsService {

    @Autowired
    private UserRepository userRepo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepo.getUserbyUsername(username);

        if (user == null) {

            throw new UnsupportedOperationException("Could not found user");
        }

        CustomUserDetails customUserDetails = new CustomUserDetails(user);

        return customUserDetails;

    }

}
