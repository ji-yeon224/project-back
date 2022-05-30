package com.example.back.controller;

import com.example.back.domain.Users;
import com.example.back.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins ="*", maxAge = 3600)
@RestController
@RequestMapping("/users")
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService){
        this.userService = userService;
    }

    @PostMapping
    public ResponseEntity<Users> saveUser(@RequestBody Users user){
        return ResponseEntity.ok(userService.saveUser(user));
    }

    @GetMapping
    public ResponseEntity<List<Users>> userList(){
        return ResponseEntity.ok(userService.userList());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Users> searchUser(@PathVariable Integer id){
        return ResponseEntity.ok(userService.searchUser(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Users> updateUser(@PathVariable Integer id, @RequestBody Users update){
        return ResponseEntity.ok(userService.updateUser(id, update));
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Integer id){
        userService.deleteUser(id);
    }

}
