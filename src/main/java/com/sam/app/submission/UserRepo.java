package com.sam.app.submission;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sam.app.submission.User;


public interface UserRepo extends JpaRepository<User, Long> {


}