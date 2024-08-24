package com.sachith.server.controller;

import com.sachith.server.model.User;
import com.sachith.server.repository.UserRepository;
import com.sachith.server.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin()
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping()
    public List<User> readAll() {
        return userService.readAll();
    }

    @GetMapping("/{id}")
    public User readById(@PathVariable Long id) {
        return userService.readById(id);
    }

    @PostMapping()
    public User create(@RequestBody User user) {
        return userService.create(user);
    }

    @PutMapping("/{id}")
    public User updateById(@PathVariable Long id, @RequestBody User user) {
        return userService.updateById(id, user);
    }

    @PatchMapping("/{id}/mobile")
    public User updateMobileById(@PathVariable Long id, @RequestParam(value = "mobile", required = false) String mobile) {
        return userService.updateMobileById(id, mobile);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id) {
        userService.deleteById(id);
    }




}
