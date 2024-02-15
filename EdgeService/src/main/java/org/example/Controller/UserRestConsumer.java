package org.example.Controller;

import org.example.Model.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@FeignClient("user-service/user")
public interface UserRestConsumer {
    @PostMapping("/register")
    public String addUser(@RequestBody User user);

    @PostMapping("/login")
    public User userLogin(@RequestBody User user);

    @GetMapping("/allUsers")
    public List<User> getAllUsers();

}
