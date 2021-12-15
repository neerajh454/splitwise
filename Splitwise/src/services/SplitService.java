package services;

import model.Split;
import model.ExpenseType;
import model.User;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class SplitService {
    Map<String, Split> splits;

    public SplitService() {
        this.splits = new HashMap<>();
    }

    public Split CreateSplit(User user, double amount){
        String Id = UUID.randomUUID().toString();
        Split split = new Split(Id, user, amount);
        splits.put(Id, split);
        return split;
    }

    public void updateSplit(String Id, User user, ExpenseType type, double amount){
        Split split = splits.get(Id);
        split.setUser(user);
        split.setAmount(amount);
    }
}
