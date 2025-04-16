/*package Model;

import java.sql.Timestamp;

public class Transaction {
    private String accountNumber;
    private String type;
    private double amount;
    private Timestamp timestamp;
    private double balanceAfter;
    private String relatedAccount;
    private String description;

    public Transaction(String accountNumber, String type, double amount, Timestamp timestamp,
                       double balanceAfter, String relatedAccount, String description) {
        this.accountNumber = accountNumber;
        this.type = type;
        this.amount = amount;
        this.timestamp = timestamp;
        this.balanceAfter = balanceAfter;
        this.relatedAccount = relatedAccount;
        this.description = description;
    }

    public Transaction(String accountNumber, String type, String fromAccount, String toAccount, String timestamp, double balance) {
        this.accountNumber = accountNumber;
        this.type = type;

        // We assume fromAccount or toAccount will be passed depending on whether it's a transfer_out or transfer_in
        if (type.equals("transfer_out")) {
            this.relatedAccount = toAccount;
        } else if (type.equals("transfer_in")) {
            this.relatedAccount = fromAccount;
        } else {
            this.relatedAccount = null; // not a transfer
        }

        this.timestamp = Timestamp.valueOf(timestamp);
        this.balanceAfter = balance;
    }


    public String getAccountNumber() {
        return accountNumber;
    }

    public String getType() {
        return type;
    }

    public double getAmount() {
        return amount;
    }

    public Timestamp getTimestamp() {
        return timestamp;
    }

    public double getBalanceAfter() {
        return balanceAfter;
    }

    public String getRelatedAccount() {
        return relatedAccount;
    }

    public String getDescription() {
        return description;
    }
}*/

/*package Model;

public class Transaction {
    private String accountNumber;
    private String type;
    private String fromAccount; // optional
    private String toAccount;   // optional
    private String timestamp;
    private double balanceAfter;
    private double amount;

    public Transaction(String accountNumber, String type, String fromAccount, String toAccount, String timestamp, double balanceAfter) {
        this.accountNumber = accountNumber;
        this.type = type;
        this.fromAccount = fromAccount;
        this.toAccount = toAccount;
        this.timestamp = timestamp;
        this.balanceAfter = balanceAfter;
        //private double amount;
    }

    public Transaction(String accountNumber, String type, double amount, String relatedAccount, String timestamp) {
        this.accountNumber = accountNumber;
        this.type = type;
        this.amount = amount;
        // Use fromAccount/toAccount logic based on type
        if (type.equals("transfer_out")) {
            this.toAccount = relatedAccount;
        } else if (type.equals("transfer_in")) {
            this.fromAccount = relatedAccount;
        }
        this.timestamp = timestamp;
    }

    // ✅ Add getter
    public double getAmount() {
        return amount;
    }


    public String getAccountNumber() { return accountNumber; }
    public String getType() { return type; }
    public String getFromAccount() { return fromAccount; }
    public String getToAccount() { return toAccount; }
    public String getTimestamp() { return timestamp; }
    public double getBalanceAfter() { return balanceAfter; }
}*/

package Model;

public class Transaction {
    private String accountNumber;
    private String type;
    private double amount;
    private String timestamp;
    private String relatedAccount;

    public Transaction(String accountNumber, String type, double amount, String timestamp, String relatedAccount) {
        this.accountNumber = accountNumber;
        this.type = type;
        this.amount = amount;
        this.timestamp = timestamp;
        this.relatedAccount = relatedAccount;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public String getType() {
        return type;
    }

    public double getAmount() {
        return amount;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public String getRelatedAccount() {
        return relatedAccount;
    }
}


