package com.sachith.server.repository;

import com.sachith.server.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    public List<User> findByName(String name);
    public List<User> findByMobile(String mobile);

    public  Long countByName(String name);
}
