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
        System.out.println( "My ATM Machine - POSSBank" );
        BankAccount bkAcc = new BankAccount("Andrew's Bank Account");
        bkAcc.deposit ("1000");
        System.out.println("Withdraw 20 -> My new account balance >" 
        + bkAcc.withdraw("20"));
    System.out.println("Withdraw 500 -> My new account balance >" 
        + bkAcc.withdraw("500"));

        FixedDepositAccount fdAcc = 
            new FixedDepositAccount("My FD acc", 10000);

        System.out.println("1. Fixed Deposit Acc balance" + fdAcc.getBalance());
        fdAcc.setDurationandInterest(4, 12);

    }
}
