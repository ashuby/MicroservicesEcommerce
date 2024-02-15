package org.example.Service;

import org.bson.types.ObjectId;
import org.example.Model.User;
import org.example.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private UserRepository userRepo;



    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepo = userRepository;
    }

    public String userRegistration(User user) {
        User savedUser = userRepo.save(user);
        return "{" +
                "\"message\":"+"Successfully added User Details\",\n"+
                "\"data\":"+savedUser+",\n"+
                "}";
    }
    public User userLogin(String email, String password) {
        boolean foundUsers = existByEmail(email);
        if(foundUsers) {
            User user = userRepo.getUserByUserName(email);
            if(user.getPassword().equals(password)) {
                return user;
            }
        }
        return null;
    }

    public User findUserByUserName(User user) {
        String email = user.getEmail();
        User foundUser = userRepo.getUserByUserName(email);
        if(foundUser.getPassword()!=user.getPassword()) {
            return null;
        }
        return userRepo.getUserByUserName(email);
    }
    public Boolean  existByEmail(String email){
        Optional<User> usersObj = Optional.ofNullable(userRepo.getUserByUserName(email));
//        System.out.println(usersObj);
        if(!usersObj.isEmpty()){
            return true;
        }
        return false;
    }
    public List<User> getAllUsers() {
        return userRepo.findAll();
    }

    public void deleteUser(User user) {
        userRepo.delete(user);
    }

    public String updateUser(String id, User user) {
        ObjectId foundObj = new ObjectId(id);
        Optional<User> optionalUser = userRepo.findById(foundObj);
        if(optionalUser.isEmpty()) throw new RuntimeException("Given movie doesn't exist");
        User foundUser = optionalUser.get();
        if(user.getUserName()!=null) {
            foundUser.setUserName(user.getUserName());
        }
        if(user.getEmail()!=null) {
            foundUser.setEmail(user.getEmail());
        }
        if(user.getPassword()!=null) {
            foundUser.setPassword(user.getPassword());
        }
        User resultUser = userRepo.save(foundUser);
        return "{" +
                "\"message\":"+"Successfully updated Movie Details\",\n"+
                "\"data\":"+resultUser+",\n"+
                "}";
    }
    public boolean existbyid(ObjectId id){
        return userRepo.existsById(id);
    }
}

