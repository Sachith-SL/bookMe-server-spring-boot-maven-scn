package com.sachith.server.controller;

import com.sachith.server.model.User;
import com.sachith.server.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @PostMapping()
    public User create(@RequestBody User user) {
        return userRepository.save(user);
    }

    @GetMapping()
    public List<User> readAll() {
        return userRepository.findAll();
    }

    @GetMapping("/{id}")
    public Optional<User> readById(@PathVariable Long id) {
        return userRepository.findById(id);
    }
    @GetMapping("/name")
    public List<User> readByName(@RequestParam(value = "name", required = false) String name) {
        return userRepository.findByName(name);
    }
    @GetMapping("/count")
    public Long readCountByName(@RequestParam(value = "name", required = false) String name) {
        return userRepository.countByName(name);
    }
    @PutMapping("/{id}")
    public User updateById(@PathVariable Long id,@RequestBody User user) {
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
    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id) {
        userRepository.deleteById(id);
    }

    @PatchMapping("/{id}/mobile")
    public User updateMobileById(@PathVariable Long id,@RequestParam(value = "mobile", required = false) String mobile) {
        Optional<User> optionalUser = userRepository.findById(id);
        if(optionalUser.isPresent()){
            User user = optionalUser.get();
            user.setMobile(mobile);
            return userRepository.save(user);
        }
        return null;
    }


}
