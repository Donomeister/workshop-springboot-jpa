package com.projetoteste.course.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projetoteste.course.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {

}
