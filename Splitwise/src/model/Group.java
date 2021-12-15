package model;

import java.util.List;

public class Group {
    String Id;
    String Name;
    List<User> users;

    public Group(String id, String name, List<User> users) {
        Id = id;
        Name = name;
        this.users = users;
    }

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }
}
