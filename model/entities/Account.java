package model.entities;

import model.exception.DomainException;

public class Account {

    private Integer number;
    private String holder;
    private Double balance;
    private Double withdrawLimit;

    public Account() {

    }

    public Account(Integer number, String holder, Double balance, Double withdrawLimit) {
        this.number = number;
        this.holder = holder;
        this.balance = balance;
        this.withdrawLimit = withdrawLimit;
    }

    public Integer getNumber() {
        return number;
    }

    public String getHolder() {
        return holder;
    }

    public Double getBalance() {
        return balance;
    }

    public Double getWithdrawLimit() {
        return withdrawLimit;
    }

    public void deposit(Double amount) {

        balance = amount + balance;
    }

    public void withdraw(Double amount) {

        if (amount > withdrawLimit) {

            throw new DomainException(" The amount exceeds withdraw limit");
        } else if (amount > balance) {

            throw new DomainException("Not enough balance");
        }

        else {

            balance = balance - amount;
        }

    }

}