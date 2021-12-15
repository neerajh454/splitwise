import api.ExpenseController;
import api.UserController;
import model.ExpenseType;

import java.util.*;

public class EquallExpenseTest {
    public static void main(String[] args) {
        UserController userController = new UserController();
        ExpenseController expenseController = new ExpenseController(userController);
        String user1 = userController.createUser("user1", "user1@gmail.com", "1234");
        String user2 = userController.createUser("user2", "user2@gmail.com", "1234");
        String user3 = userController.createUser("user3", "user3@gmail.com", "1234");
        String user4 =  userController.createUser("user4", "user4@gmail.com", "1234");

        String group1 = userController.createGroup("group1", Arrays.asList(user1, user2, user3, user4));
        String group2 = userController.createGroup("group2", Arrays.asList(user1, user2, user3));
        String group3 = userController.createGroup("group3", Arrays.asList(user1, user3, user4));

        expenseController.balanceSheet.put(user1,  new HashMap<String, Double>());
        expenseController.balanceSheet.put(user2,  new HashMap<String, Double>());
        expenseController.balanceSheet.put(user3,  new HashMap<String, Double>());
        expenseController.balanceSheet.put(user4,  new HashMap<String, Double>());


        // user1 paid 100rs to user2
        Map<String, Double> usermap = new HashMap<>();
        usermap.put(user2, 100.0);
        System.out.println(user2);
        expenseController.addExpense(ExpenseType.EXACT,100.0, user1, usermap);

        // user1 paid 1000 rs to user2, user3, user4 in equal portion
        Map<String, Double> usermap2 = new HashMap<>();
        // let's devide amount into portion and map to user;
        usermap2.put(user2, 250.0);
        usermap2.put(user3, 250.0);
        usermap2.put(user4, 250.0);
        expenseController.addExpense(ExpenseType.EQUAL,1000.0, user1, usermap2);
        expenseController.showBalance(user1);



    }
}
