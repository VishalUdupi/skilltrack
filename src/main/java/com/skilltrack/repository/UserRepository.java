package com.skilltrack.repository;

import com.skilltrack.model.User;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class UserRepository {
    private Map<Integer, User> users = new HashMap<Integer,User>();

    public void addUser(User user){
        users.put(user.getId(), user);
    }
    public User getUser(int id){
        return users.get(id);
    }
    public List<User> getAllUsers(){
        return users.values().stream().toList();
    }
    public boolean deleteUser(int id){
        return users.remove(id) != null;
    }
}
