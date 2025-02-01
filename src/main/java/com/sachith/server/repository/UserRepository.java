package com.sachith.server.repository;

import com.sachith.server.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    /*query methods*/
    public List<User> findByName(String name);
    public List<User> findByMobile(String mobile);

    /*jpql*/
    @Query("SELECT u FROM User u WHERE u.name =  :name")
    User findUserByName(@Param("name") String name);

    /*native queries*/
    @Query(value = "SELECT * FROM users WHERE mobile = :mobile", nativeQuery = true)
    User findUserByMobile(@Param("mobile") String mobile);

}
