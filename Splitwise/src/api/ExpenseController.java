package api;

import model.Expense;
import model.ExpenseType;
import model.Split;
import model.User;
import services.ExpenseService;
import services.SplitService;
import services.UserService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ExpenseController {

    public Map<String, Map<String, Double>> balanceSheet;
    public Map<String, Map<String, Double>> groupbalanceSheet;    // Map<UserID, <GroupId, Amount>>
    ExpenseService expenseService;
    SplitService splitService;
    UserController userController;


    public ExpenseController(UserController userController) {
        this.expenseService = new ExpenseService();
        this.splitService = new SplitService();
        this.userController = userController;
        this.balanceSheet = new HashMap<String, Map<String, Double>>();
    }

    public void addExpense(ExpenseType expenseType, double amount, String paidBy, Map<String, Double> userAmounts) {
        List<Split> splits = new ArrayList<>();

        for (Map.Entry<String, Double> userAmount: userAmounts.entrySet()){
            splits.add(splitService.CreateSplit(userController.userService.getUser(userAmount.getKey()), userAmount.getValue()));
        }
        Expense expense = expenseService.CreateExpense(amount, userController.userService.getUser(paidBy), splits, expenseType);

        for (Split split : expense.getSplits()) {
            String paidTo = split.getUser().getId();
            if (!balanceSheet.containsKey(paidBy)) {
                balanceSheet.put(paidBy, null);
            }
            Map<String, Double> balances = balanceSheet.get(paidBy);

            if (balances==null || ! balances.containsKey(paidTo)) {
                balances.put(paidTo, 0.0);
            }
            balances.put(paidTo, balances.get(paidTo) + split.getAmount());

            balances = balanceSheet.get(paidTo);
            if (!balances.containsKey(paidBy)) {
                balances.put(paidBy, 0.0);
            }
            balances.put(paidBy, balances.get(paidBy) - split.getAmount());
        }

    }
    public void showBalance(String userId) {
        boolean isEmpty = true;
        for (Map.Entry<String, Double> userBalance : balanceSheet.get(userId).entrySet()) {
            if (userBalance.getValue() != 0) {
                isEmpty = false;
                System.out.println(userController.userService.getUser(userBalance.getKey()).getName());
                System.out.println(userBalance.getValue());
            }
        }
        if (isEmpty) {
            System.out.println("No balances");
        }
    }
}
