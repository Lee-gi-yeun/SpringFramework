package com.ohgiraffers.springsecurity.command.repository;

import com.ohgiraffers.springsecurity.command.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {


}
