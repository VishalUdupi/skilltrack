package com.skilltrack.services;

import com.skilltrack.exceptions.UserNotFoundException;
import com.skilltrack.model.User;
import com.skilltrack.repository.UserRepository;

import java.util.ArrayList;
import java.util.List;

public class UserService {
    UserRepository userRepository = new UserRepository();
    public void addUser(User user){
        userRepository.addUser(user);
    }
    public User getUserById(int id) throws UserNotFoundException{
        if(userRepository.getUser(id) != null){
            return userRepository.getUser(id);
        }
        else{
            throw new UserNotFoundException("User not found");
        }
    }
    public List<User> getAllUsers(){
        return userRepository.getAllUsers();
    }
    public void deleteUser(int id) throws UserNotFoundException{
        if(userRepository.getUser(id) != null){
            userRepository.deleteUser(id);
        }
        else{
            throw new UserNotFoundException("Cannot delete User. User not found");
        }
    }
}
