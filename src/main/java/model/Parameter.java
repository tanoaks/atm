package model;

import java.util.List;

public class Parameter {
    private User user;
    private int amount;
    private int available_amount;
    private List<Integer> supported;
    private int preference;

    public Parameter(User user, int amount, int available_amount, List<Integer> supported, int preference) {
        this.user = user;
        this.amount = amount;
        this.available_amount = available_amount;
        this.supported = supported;
        this.preference = preference;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public int getAvailable_amount() {
        return available_amount;
    }

    public void setAvailable_amount(int available_amount) {
        this.available_amount = available_amount;
    }

    public List<Integer> getSupported() {
        return supported;
    }

    public void setSupported(List<Integer> supported) {
        this.supported = supported;
    }

    public int getPreference() {
        return preference;
    }

    public void setPreference(int preference) {
        this.preference = preference;
    }
}
