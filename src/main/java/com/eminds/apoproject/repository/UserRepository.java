package com.eminds.apoproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.eminds.apoproject.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer>{}