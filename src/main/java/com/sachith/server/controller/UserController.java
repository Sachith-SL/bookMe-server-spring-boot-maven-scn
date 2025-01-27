package com.sachith.server.controller;

import com.sachith.server.model.User;
import com.sachith.server.service.UserService;
import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin()
@RequestMapping("/api/users")
public class UserController {

    private UserService userService;

    private final Logger logger = LoggerFactory.getLogger(UserController.class);

//    @Autowired
//    public UserController(UserService userService){
//        this.userService=userService;
//    }

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @PostConstruct
    public void init() {
        logger.info("UserController: Initialization Logic");
    }

    @PreDestroy
    public void cleanup() {
        logger.info("UserController: Cleanup Logic");
    }

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
