package vttp2022.day2;

import vttp2022.day2.account.BankAccount;
import vttp2022.day2.account.FixedDepositAccount;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        //Instantiate a new bank account and use this to test out your functions
        System.out.println( "My ATM Machine - POSSBank" );
        BankAccount bkAcc = new BankAccount("Andrew's Bank Account");
        bkAcc.deposit ("1000");
        System.out.println("Withdraw 20 -> My new account balance >" 
        + bkAcc.withdraw("20"));
        System.out.println("Withdraw 500 -> My new account balance >" 
        + bkAcc.withdraw("500"));
        //test the Fixed Deposit
        FixedDepositAccount fdAcc = new FixedDepositAccount("My FD acc", 10000);

        System.out.println("1. Fixed Deposit Acc balance" + fdAcc.getBalance());
        fdAcc.setDurationandInterest(4, 12);
        System.out.println("2. Fixed Deposit Acc balance > " + fdAcc.getBalance());
       
    }
}