package application;

import java.util.Scanner;

import model.entities.Account;
import model.exception.DomainException;

public class Program {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter account data");

        try {
            System.out.print("Number: ");
            Integer nunber = sc.nextInt();

            System.out.print("Holder: ");
            sc.nextLine();
            String holder = sc.nextLine();

            System.out.print("Initial balance: ");
            Double balance = sc.nextDouble();

            System.out.print("Withdraw limit :");
            Double withdrawLimit = sc.nextDouble();

            Account ac = new Account(nunber, holder, balance, withdrawLimit);

            System.out.println("");
            System.out.print("Enter amount for withdraw: ");
            Double amount = sc.nextDouble();

            ac.withdraw(amount);

            System.out.println("New balance: $" + ac.getBalance());
        } catch (DomainException e) {

            System.out.println("Withdraw error: " + e.getMessage());
        } catch (RuntimeException e) {
            System.out.println("Unexpected error");
        }
        sc.close();
    }

}
