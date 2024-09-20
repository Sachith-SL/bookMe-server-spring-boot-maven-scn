package com.sachith.server.service;

import com.sachith.server.dto.UserDTO;
import com.sachith.server.model.User;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


public interface UserService {

    public User create(UserDTO user) ;

    public List<User> readAll() ;

    public Optional<User> readById(Long id) ;

    public User readByName(String name) ;

    public Long readCountByName(String name) ;

    public User updateById(Long id,User user) ;

    public void deleteById(Long id) ;

    public User updateMobileById(Long id,String mobile) ;

    public Boolean checkUserAvailabilityByMobile(String mobile);


}
