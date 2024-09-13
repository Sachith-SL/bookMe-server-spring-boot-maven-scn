package com.sachith.server.service.impl;

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

    Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

    @Autowired
    private UserRepository userRepository;


    public User create(User user) {
        try {
            return userRepository.save(user);
        } catch (Exception ex) {
            logger.error("", ex);
            return null;
        }

    }


    public List<User> readAll() {
        return userRepository.findAll();
    }


    public Optional<User> readById(Long id) {
        return userRepository.findById(id);
    }


    public List<User> readByName(String name) {
        return userRepository.findByName(name);
    }

    public Long readCountByName(String name) {
        return userRepository.countByName(name);
    }

    public User updateById(Long id,User user) {
        Optional<User> optionalUser = userRepository.findById(id);
        if(optionalUser.isPresent()){
            User oldUser =optionalUser.get();
            oldUser.setName(user.getName());
            oldUser.setMobile(user.getMobile());
            oldUser.setRole(user.getRole());

            return userRepository.save(oldUser);
        }
        return null;
    }

    public void deleteById(Long id) {
        userRepository.deleteById(id);
    }


    public User updateMobileById(Long id,String mobile) {
        Optional<User> optionalUser = userRepository.findById(id);
        if(optionalUser.isPresent()){
            User user = optionalUser.get();
            user.setMobile(mobile);
            return userRepository.save(user);
        }
        return null;
    }

    @Override
    public Boolean checkUserAvailabilityByMobile(String mobile) {
        return !userRepository.findByMobile(mobile).isEmpty();
    }
}
