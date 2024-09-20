package com.sachith.server.service;

import com.sachith.server.model.User;
import com.sachith.server.model.UserPrincipal;
import com.sachith.server.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class MyUserDetailsService implements UserDetailsService {

    Logger logger = LoggerFactory.getLogger(MyUserDetailsService.class);

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        User user = userRepository.findByName(username);
        if(user == null){
            logger.error("User Not Found");
            throw new UsernameNotFoundException("user not found");
        }
        return new UserPrincipal(user);
    }
}
