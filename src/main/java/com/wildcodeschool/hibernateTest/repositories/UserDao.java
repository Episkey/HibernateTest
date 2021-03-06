package com.wildcodeschool.hibernateTest.repositories;

import com.wildcodeschool.hibernateTest.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDao extends JpaRepository<User, Long> {

}