package com.example.back.service;

import com.example.back.domain.Users;
import com.example.back.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Service
public class UserService {


    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    //list
    public List<Users> userList() {
        return userRepository.findAll();
    }

    //save
    public Users saveUser(Users user) {
        return userRepository.save(user);
    }

    //search
    public Users searchUser(Integer id){

       return userRepository.findAllById(id);

    }

    //update
    public Users updateUser(Integer id, Users update){
        Users users = userRepository.findAllById(id);
        users.setFirstName(update.getFirstName());
        users.setLastName(update.getLastName());
        users.setAge(update.getAge());
        users.setSalary(update.getSalary());

        return userRepository.save(users);
    }

    //delete
    public void deleteUser(Integer id){
        Users user = userRepository.findAllById(id);
        userRepository.delete(user);

    }
}
