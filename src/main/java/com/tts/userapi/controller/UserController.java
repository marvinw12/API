package com.tts.userapi.controller;

import java.util.List;
import java.util.Optional;

import com.tts.userapi.model.User;
import com.tts.userapi.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    
    @Autowired
    UserRepository userRepository;

    @GetMapping("/users")
        public List<User> getUsers(@RequestParam(value="state", required=false) String state){
        if (state != null) {
        return (List<User>) userRepository.findByState(state);
        }
        return (List<User>) userRepository.findAll();
    }

    @GetMapping("/user/{id}")
    public User getUser(@PathVariable(value = "id") Long id){

        Optional<User> user = userRepository.findById(id);

        if(user.isPresent()){

            return user.get();
        } else {

            
        }
		return null;
    }

    @PostMapping("/users")
    public void createUser(@RequestBody User user){

        userRepository.save(user);
    }

    @PutMapping("/users/{id}")
    public void createUser(@PathVariable(value="id") Long id, @RequestBody User user){
        userRepository.save(user);
    }

    @DeleteMapping("/users/{id}")
    public void createUser(@PathVariable(value="id") Long id){
        userRepository.deleteById(id);
}
}
