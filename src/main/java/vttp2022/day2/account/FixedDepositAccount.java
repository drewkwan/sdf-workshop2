package vttp2022.day2.account;

//Extend the BankAccount and adopt the methods
public class FixedDepositAccount extends BankAccount {
    //Set a default interest and duration to be 3 and 6. Create a durationInterestCounter because you can only change the values once. 
    private float interest = 3;
    private int duration = 6;
    private int durationInterestCounter = 0;

    //Create a new FixedDepositAccount that adopts the properties of the bank account, so use "super". Give the account a duration interest counter
    public FixedDepositAccount(String name, float initialAmount) {
        super(name, initialAmount);
        this.durationInterestCounter = 0;
    }

    //overload with an interest function
    public FixedDepositAccount(String name, float initialAmount, float interest) {
        super(name, initialAmount);
        this.interest = interest;
        this.durationInterestCounter = 0;
    }

    //overload with duration. Is it a must for me to overload one by one.
    //When overloading, you overload one by one to create flexibility in the code. If I want to call the second, I pass through 3 instances. If I want to call the thid, I pass 2 instances.
    public FixedDepositAccount(String name, float initialAmount, float interest, int duration) {
        super(name, initialAmount);
        this.interest = interest;
        this.duration = duration;
        this.durationInterestCounter = 0;
    }

    //getters and setters
    public int getDuration() {
        return duration;
    }

    //you can set the duration once, but it cannot be negative. as far as getters and setters are automatic, do still check each condition. 
    private void setDuration(int duration) {
        if (duration <0) {
            throw new IllegalArgumentException("Unsupported duration.");
        }
        this.duration = duration;
    }

    //interest same, cannot be negative. 
    private void setInterest(float interest) {
        if (interest < 0) {
            throw new IllegalArgumentException("Unsupported interest.");
        }
        this.interest = interest;
    }

    //Throw an error once my change counter hits 1
    public void setDurationandInterest(float interest, int duration) {
        if (durationInterestCounter == 1) {
                throw new IllegalArgumentException("You cannot change your plan once committed");
        }
        //I get what this is, but I don't know why it's done this way. How come I don't set the counter above or in a for loop. 
        setInterest(interest);
        setDuration(duration);
        durationInterestCounter++;
    }

    
    
    //Can't withdraw or deposit for FD
    @Override 
    public float withdraw(String withdrawAmt) {
        //NOP
        return 0;
    }
    //why here no return? because the BankAccount file has indicated a return. 
    //if i want to return a value, i can just indicate a return value in the override here, but i'll also have to update the bankaccount.java file. 
    @Override
    public void deposit(String withdrawAmt) {
        //NOP
    }

    @Override
    public float getBalance() {
        return super.getBalance() + interest;
    }
}

