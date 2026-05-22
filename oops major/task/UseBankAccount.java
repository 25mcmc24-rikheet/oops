class BankAccount
{
    String accountName;
    String accountNumber;
    int pinNumber;
    double depositAmount;
    double interestRate;

    static int staticCounter = 1000;

    BankAccount(
        String accountName,
        int pinNumber,
        double depositAmount,
        double interestRate)
    {
        this.accountName = accountName;

        this.pinNumber = pinNumber;

        this.depositAmount = depositAmount;

        this.interestRate = interestRate;

        this.accountNumber = "ACC" + staticCounter;

        staticCounter++;
    }

    void deposit(double amount)
    {
        if(amount <= 0)
        {
            System.out.println("Invalid Deposit");

            return;
        }

        depositAmount += amount;

        System.out.println(
            "Amount Deposited");
    }

    void withdraw(double amount,int pin)
    {
        if(pin != pinNumber)
        {
            System.out.println("Invalid PIN");

            return;
        }

        if(amount > depositAmount)
        {
            System.out.println(
                "Insufficient Balance");

            return;
        }

        depositAmount -= amount;

        System.out.println(
            "Withdrawal Successful");
    }

    void checkBalance()
    {
        System.out.println(
            "Current Balance : " +
            depositAmount);
    }

    public String toString()
    {
        return
            "Account Name : " +
            accountName +
            "\nAccount Number : " +
            accountNumber +
            "\nBalance : " +
            depositAmount +
            "\nInterest Rate : " +
            interestRate;
    }
}

public class UseBankAccount
{
    public static void main(String[] args)
    {
        BankAccount a1 =
            new BankAccount(
                "Rohit",
                1234,
                5000,
                5.5);

        System.out.println(a1);

        System.out.println();

        a1.deposit(2000);

        a1.checkBalance();

        System.out.println();

        a1.withdraw(3000,1234);

        a1.checkBalance();

        System.out.println();

        BankAccount a2 =
            new BankAccount(
                "Rahul",
                5678,
                10000,
                6.0);

        System.out.println(a2);
    }
}