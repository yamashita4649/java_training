package ch05.ex02;

import org.junit.Test;

import static org.junit.Assert.*;

public class BankAccountTest {

    @Test
    public void deposit() {
        BankAccount testAccount = new BankAccount();
        testAccount.deposit(100);
        String str = testAccount.getHistory().next().toString();
        System.out.println(str);
    }

    @Test
    public void withdraw() {
        BankAccount testAccount = new BankAccount();
        testAccount.withdraw(100);
        String str = testAccount.getHistory().next().toString();
        System.out.println(str);
    }

    @Test
    public void main() {
        BankAccount.main(null);
    }
}