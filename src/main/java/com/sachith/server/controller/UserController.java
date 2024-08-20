package com.sachith.server.controller;

import com.sachith.server.model.User;
import com.sachith.server.repository.UserRepository;
import com.sachith.server.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping()
    public User create(@RequestBody User user) {
        return userService.create(user);
    }

    @GetMapping()
    public List<User> readAll() {
        return userService.readAll();
    }

    @GetMapping("/{id}")
    public Optional<User> readById(@PathVariable Long id) {
        return userService.readById(id);
    }

    @GetMapping("/name")
    public List<User> readByName(@RequestParam(value = "name", required = false) String name) {
        return userService.readByName(name);
    }

    @GetMapping("/count")
    public Long readCountByName(@RequestParam(value = "name", required = false) String name) {
        return userService.readCountByName(name);
    }

    @PutMapping("/{id}")
    public User updateById(@PathVariable Long id, @RequestBody User user) {
        return userService.updateById(id, user);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id) {
        userService.deleteById(id);
    }

    @PatchMapping("/{id}/mobile")
    public User updateMobileById(@PathVariable Long id, @RequestParam(value = "mobile", required = false) String mobile) {
        return userService.updateMobileById(id, mobile);
    }


}
