package services;

import model.Expense;
import model.ExpenseType;
import model.Split;
import model.User;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public class ExpenseService {

    Map<String, Expense> expenses;

    public ExpenseService() {
        this.expenses = new HashMap<>();
    }

    public Expense CreateExpense(double total_amount, User paidby, List<Split> Splits, ExpenseType type){
        String Id = UUID.randomUUID().toString();
        Expense expense = new Expense(total_amount, paidby, Splits, type);
        expenses.put(Id, expense);
        return expense;
    }

    public void updateExpense(String Id, double total_amount, User paidby, List<Split> Splits){
        Expense expense = expenses.get(Id);
        expense.setAmount(total_amount);
        expense.setSplits(Splits);
        expense.setPaidBy(paidby);
    }
}
