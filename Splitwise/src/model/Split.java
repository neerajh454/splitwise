package model;

public class Split {
    private String Id;
    private User user;
    double amount;

    public Split(String Id, User user, double amount) {
        this.user = user;
        this.amount = amount;
        this.Id = Id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }
}