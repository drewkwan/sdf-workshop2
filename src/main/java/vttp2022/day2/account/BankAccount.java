package vttp2022.day2.account;

import java.time.LocalDateTime;
import java.util.List;
import java.util.LinkedList;
//package to generate uuid
import java.util.UUID;

public class BankAccount {
    //this is the bank account
    private final String name;
    private final String acctID = UUID.randomUUID().toString().substring(0, 8);
    private float balance= 0f;
    private List<String> transaction = new LinkedList<>();
    private boolean isClosed = false;
   
   
    //
    private LocalDateTime accountCreationDate;
    private LocalDateTime accountClosingDate;

    //first constructor with BankAccount name - is this a must for the second to exist?
    public BankAccount(String name) {
        this.name=name;
        this.balance = 0;
    }
    //end constructor with bank account name and the initial balance
    public BankAccount (String name, float initialBal) {
        this.name = name;
        this.balance = initialBal;

    }

    //Getter and setters for name
    public String getName() {
        return name;
    }
 
    /* The assignment requires that the account name and account ID cannot be changed. So we must delete the setters for the name and account id
    public void setName(String name) {
        this.name = name;
    }
    */

    public String getAcctID() {
        return acctID;
    }

    /* The assignment requires that the account name and account ID cannot be changed. So we must delete the setters for the name and account id
    public void setAcctID(String acctID) {
        this.acctID = acctID;
    }
    */

    public float getBalance() {
        return balance;
    }

    public void setBalance(float balance) {
        this.balance = balance;

    }
    public List<String> getTransaction() {
        return transaction;
    }

    public void setTransaction(List<String> transaction) {
        this.transaction = transaction;
    } 

    public boolean isClosed() {
        return isClosed;
    }

    public void setClosed(boolean isClosed) {
        this.isClosed = isClosed;
    }

    public LocalDateTime getAccountCreationDate() {
        return accountCreationDate;
    }

    public void setAccountCreationDate(LocalDateTime accountCreationDate) {
        this.accountCreationDate = accountCreationDate;
    }
    public LocalDateTime getAccountClosingDate() {
        return accountClosingDate;
    }
    public void setAccountClosingDate(LocalDateTime accountClosedDate) {
        this.accountClosingDate = accountClosedDate;
    }

    public float withdraw (String withdrawAmt) {
        Float withdrawAmtF = null;
        try {
            withdrawAmtF = Float.parseFloat(withdrawAmt);
            if (withdrawAmtF.floatValue() <= 0) {
                throw new IllegalArgumentException("Withdrawal amount caanot be negative or zero");
            }

            if (this.isClosed()) {
                throw new IllegalArgumentException("The account is closed.");
            }
            this.balance = this.balance - withdrawAmtF.floatValue();
            //Construct the transaction history event log
            StringBuilder txnStrbld = new StringBuilder();
            txnStrbld.append("Withdraw $");
            txnStrbld.append(withdrawAmtF.floatValue());
            txnStrbld.append(" at ");
            txnStrbld.append(LocalDateTime.now());
            System.out.println(txnStrbld.toString());
            // save the event log into the txn linkedList 
            transaction.add(txnStrbld.toString());
            // update the deposit amount

        } catch (NumberFormatException e) {
            System.err.print(e);
            throw new IllegalArgumentException("Invalid withdraw amount");
        }
        return this.balance;
        
    }

    public void deposit(String depositAmt) {
        try {
              Float depositAmtF= Float.parseFloat(depositAmt);
              if (depositAmtF.floatValue()<= 0) {
                  throw new IllegalArgumentException("Deposit amount cannot be zero or negative");
              }  
              if (this.isClosed()) {
                  throw new IllegalArgumentException("This account is closed."); 
              }

              this.balance = this.balance + depositAmtF.floatValue();
              // Construct the transaction history event log 
              StringBuilder txnStrbld = new StringBuilder();
              txnStrbld.append("Deposit $");
              txnStrbld.append(depositAmtF.floatValue());
              txnStrbld.append(" at ");
              txnStrbld.append(LocalDateTime.now());
              System.out.println(txnStrbld.toString());
              // save the event log into the txn linkedList 
              transaction.add(txnStrbld.toString());
              // update the deposit amount

        } catch(NumberFormatException e) {
            System.err.print(e);
            throw new IllegalArgumentException("Invalid deposit amount");
        }

    }
}

    
