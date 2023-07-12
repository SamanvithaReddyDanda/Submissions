package com.sam.app.submission;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sam.app.submission.User;
import com.sam.app.submission.UserRepo;

import java.util.List;

@RestController
@RequestMapping("/submissions")
public class ApiControllers {

    @Autowired
    private UserRepo userRepo;
    @Autowired
    private UserService userService;

    @GetMapping
    public List<User> getPage() {
        return userRepo.findAll();
    }

    @GetMapping("/{id}")
    public User getUsers(@PathVariable long id) {
        return userRepo.findById(id).get();
    }

    @PostMapping
    public User saveUser(@RequestBody User user) {
//        System.out.println(user);

//        return userRepo.save(user);
        return this.userService.addNewUser(user);
    }

    @PutMapping(value="/update/{id}")
    public String updateUser(@PathVariable long id, @RequestBody User user)
    {
        User updatedUser = userRepo.findById(id).get();
        updatedUser.setConsultantName(user.getConsultantName());
        updatedUser.setSubmissionDate(user.getSubmissionDate());
        updatedUser.setLeadName(user.getLeadName());
        updatedUser.setRate(user.getRate());
        updatedUser.setSalesPersonName(user.getSalesPersonName());
        updatedUser.setTechnology(user.getTechnology());
        updatedUser.setVendorName(user.getVendorName());

        userRepo.save(updatedUser);
        return "Update Success...";
    }


    @DeleteMapping("/{id}")
    public String deleteUser(@PathVariable long id) {
        User deleteUser = userRepo.findById(id).get();
        userRepo.delete(deleteUser);
        return "Deleted the user with id:" + id;
    }

}

