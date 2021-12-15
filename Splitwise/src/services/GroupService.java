package services;

import model.Group;
import model.User;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public class GroupService {
    Map<String, Group> groups;

    public GroupService() {
        this.groups = new HashMap<>();
    }

    public Group createGroup(String name, List<User> users){
        String Id = UUID.randomUUID().toString();
        Group group = new Group(Id, name, users);
        groups.put(Id, group);
        return group;
    }

    public void updateGroup(String Id, String name, List<User> users){
        Group group = groups.get(Id);
        group.setName(name);
        group.setUsers(users);
    }

}
