package com.sachith.server.service;

import com.sachith.server.model.User;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


public interface UserService {

    public List<User> readAll() ;

    public User readById(Long id) ;

    public User create(User user) ;

    public User updateById(Long id,User user) ;

    public User updateMobileById(Long id,String mobile) ;

    public void deleteById(Long id) ;




}
