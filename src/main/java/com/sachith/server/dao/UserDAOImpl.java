package com.sachith.server.dao;

import com.sachith.server.model.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Component;

@Component
public class UserDAOImpl implements UserDAO {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public User findUserByName(String name){
        String jpql = "SELECT u FROM User u WHERE u.name= :name";

        return entityManager.createQuery(jpql,User.class)
                .setParameter("name", name)
                .getSingleResult();
    }
}
