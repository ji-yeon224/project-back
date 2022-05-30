package com.example.back.service;

import com.example.back.domain.Users;
import com.example.back.repository.UserRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class UserServiceTest {
    @Autowired
    private UserService userService;
    @Autowired
    private UserRepository userRepository;

    @Test
    void save() {

        //given
        Users users = new Users();
        users.setPassword("1234");
        users.setFirstName("kim");
        users.setLastName("jiyeon");
        users.setAge(20);
        users.setSalary(10000);

        //when
        Users u = userService.saveUser(users);


        //then
        Assertions.assertThat(users).isEqualTo(u);

    }
}
