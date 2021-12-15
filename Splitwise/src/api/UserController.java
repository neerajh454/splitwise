package api;

import model.User;
import services.GroupService;
import services.UserService;

import java.util.ArrayList;
import java.util.List;

public class UserController {

    services.UserService userService;
    services.GroupService groupService;

    public UserController() {
        this.userService = new UserService();
        this.groupService = new GroupService();
    }

    public String createUser(String name, String email, String phone_no){
        return userService.createUser(name, email, phone_no).getId();
    }

    public String createGroup(String name, List<String> usersIds){
        List<User> users = new ArrayList<>();
        for (String userId: usersIds){
            users.add(userService.getUser(userId));
        }
        return groupService.createGroup(name, users).getId();
    }
}
