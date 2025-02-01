package com.sachith.server.service.impl;

import com.sachith.server.controller.UserController;
import com.sachith.server.dao.UserDAO;
import com.sachith.server.model.User;
import com.sachith.server.repository.UserRepository;
import com.sachith.server.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserDAO userDAO;

    public List<User> readAll() {
        return userRepository.findAll();
    }

    public User readById(Long id) {

        User user =userDAO.findUserByName("Jagath");
        logger.info("JPQL" +user.getName());

        Optional<User> optionalUser = userRepository.findById(id);
        if(optionalUser.isPresent()){
            return optionalUser.get();
        }
        return null;
    }

    public User create(User user) {
        return userRepository.save(user);
    }

    public User updateById(Long id, User user) {
        try {
            Optional<User> optionalUser = userRepository.findById(id);
            if (optionalUser.isPresent()) {
                User oldUser = optionalUser.get();
                oldUser.setName(user.getName());
                oldUser.setMobile(user.getMobile());
                oldUser.setIsLoyalty(user.getIsLoyalty());
                return userRepository.save(oldUser);
            }
        } catch (Exception ex) {
            return null;
        }
        return null;
    }

    public void deleteById(Long id) {
        userRepository.deleteById(id);
    }


    public User updateMobileById(Long id, String mobile) {
        try{
            Optional<User> optionalUser = userRepository.findById(id);
            if (optionalUser.isPresent()) {
                User user = optionalUser.get();
                user.setMobile(mobile);
                return userRepository.save(user);
            }
        } catch (Exception ex){
            return null;
        }



        return null;
    }


}
