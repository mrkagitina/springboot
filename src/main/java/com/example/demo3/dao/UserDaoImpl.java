package com.example.demo3.dao;

import com.example.demo3.model.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {
    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    @Override
    public List<User> getAllUsers() {
        return entityManager.createQuery("SELECT user FROM User user", User.class).getResultList();
    }

    @Transactional
    @Override
    public void createUser(User user) {
        entityManager.merge(user);
        entityManager.flush();
    }

    @Transactional
    @Override
    public void updateUser(User user) {
        entityManager.merge(user);
        entityManager.flush();
    }

    @Transactional
    @Override
    public User findUser(Long id) {
        return entityManager.find(User.class, id);
    }

    @Transactional
    @Override
    public void deleteUser(Long id) {
        User user = findUser(id);
        entityManager.remove(user);
        entityManager.flush();
        if (user == null) {
            throw new IllegalArgumentException("User with id " + id + " not found");
        }
    }
}
