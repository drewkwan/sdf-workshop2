package vttp2022.day2.account;

import java.time.LocalDateTime;
import java.util.List;
import java.util.LinkedList;
//package to generate uuid
import java.util.UUID;

public class BankAccount {
    //this is the bank account. As detailed in the assignment, this cannot be changed, hence the final.
    private final String name;
    //Create a bank account using UUID. Convert it to a string and keep the first 8 numbers. Also cannot be changed.
    private final String acctID = UUID.randomUUID().toString().substring(0, 8);
    private float balance= 0f;
    private List<String> transaction = new LinkedList<>();
    private boolean isClosed = false;
   
   
    //Create a timestamp for the account creation and close dates
    private LocalDateTime accountCreationDate;
    private LocalDateTime accountClosingDate;

    //first constructor with BankAccount name. Need to use this so that I can continue to update value when I instantiate a new Bank Account
    public BankAccount(String name) {
        this.name=name;
        this.balance = 0;
    }
    //2nd constructor with bank account name and the initial balance
    public BankAccount (String name, float initialBal) {
        this.name = name;
        this.balance = initialBal;

    }

    /*Getter and setters for name. Get is to retrieve data, set is to change a value. highlight, source action, getters and setters.
     Delete the setters for the values that should not be changed, i.e. accountID and name
     */

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

    //Notice that getters have return functions while setters are all void because you don't need anything retrieved
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

    // Withdraw Method -- null is just a reference to an unset value.
    public float withdraw (String withdrawAmt) {
        Float withdrawAmtF = null;
        //Convert the withdraw amount to a float value. 
        try {
            withdrawAmtF = Float.parseFloat(withdrawAmt);
            //If the float value is less than or equal to 0, throw an error message
            if (withdrawAmtF.floatValue() <= 0) {
                throw new IllegalArgumentException("Withdrawal amount caanot be negative or zero");
            }
            //If the account is closed, meaning that the earlier set boolean is true, throw error message
            if (this.isClosed()) {
                throw new IllegalArgumentException("The account is closed.");
            }
            //the new balance = previous balance - withdrawn amount
            this.balance = this.balance - withdrawAmtF.floatValue();
            //Construct the transaction history event log
            //append is a method that comes from the StringBuilder class that's alr in Java. Append works to help concatanate strings together
            StringBuilder txnStrbld = new StringBuilder();
            txnStrbld.append("Withdraw $");
            txnStrbld.append(withdrawAmtF.floatValue());
            txnStrbld.append(" at ");
            txnStrbld.append(LocalDateTime.now());
            System.out.println(txnStrbld.toString());
            // save the event log into the txn linkedList 
            transaction.add(txnStrbld.toString());
            // update the deposit amount
        //Next, gotta try and catch in case a non-number value is typed in. Throw numberformatexception error.        
        } catch (NumberFormatException e) {
            //System.err.print and System.out.print is almost the same, except sometimes err.print will print in a different format, like red or sth
            System.err.print(e);
            throw new IllegalArgumentException("Invalid withdraw amount");
        }
        return this.balance;
        
    }
    //deposit method
    public void deposit(String depositAmt) {
        try {
            //Parse the string into a float. if deposit value is negative or zero, throw error
              Float depositAmtF= Float.parseFloat(depositAmt);
              if (depositAmtF.floatValue()<= 0) {
                  throw new IllegalArgumentException("Deposit amount cannot be zero or negative");
              }  
            //if account is closed, throw an error
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
        //Catch the errors. Bear in mind that a try does not necessarily need a catch.
        } catch(NumberFormatException e) {
            System.err.print(e);
            throw new IllegalArgumentException("Invalid deposit amount");
        }

    }
}

    
