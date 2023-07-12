package com.sam.app.submission;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private final UserRepo userRepo;
    @Autowired
    public UserService(UserRepo userRepo) {
        this.userRepo = userRepo;
    }
    public User addNewUser(User user){
        this.userRepo.save(user);
        return user;
    }
}
