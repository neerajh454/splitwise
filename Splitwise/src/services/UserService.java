package services;

import model.User;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class UserService {
    Map<String, User> users;

    public UserService() {
        this.users = new HashMap<>();
    }

    public User createUser(String name, String email, String phone){
        String Id = UUID.randomUUID().toString();
        User user = new User(Id, name, email, phone);
        users.put(Id, user);
        return user;
    }

    public User getUser(String Id){
        if (users.containsKey(Id)){
            return users.get(Id);
        }
        return null;
    }

}
