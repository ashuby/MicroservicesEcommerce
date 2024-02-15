package org.example.Controller;

import org.example.Model.User;
import org.example.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;
    @PostMapping("/register")
    public String addUser(@RequestBody User user) {
        return userService.userRegistration(user);
    }
    @PostMapping("/login")
    public User userLogin(@RequestBody User user) {
        String userEmail = user.getEmail();
        String password = user.getPassword();
        return userService.userLogin(userEmail,password);
    }
    @DeleteMapping("/deleteUser")
    public void deleteUser(@RequestBody User user) {
        userService.deleteUser(user);
    }

    @GetMapping("/allUsers")
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @PostMapping("/updateUser/{id}")
    public String updateUser(@PathVariable String id,@RequestBody User user) {
        return userService.updateUser(id,user);
    }
}
