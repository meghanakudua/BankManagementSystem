/*package View;

import Controller.TransactionController;
import Model.BankStaff;
import Model.Transaction;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.ArrayList;

public class BankTransactionView extends JFrame {

    private BankStaff staff;
    private JTable transactionTable;
    private DefaultTableModel tableModel;
    private JTextField accountField;
    private JTextField dateField;

    public BankTransactionView(BankStaff staff) {
        this.staff = staff;

        setTitle("Branch Transactions");
        setSize(850, 500);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new BorderLayout());
        getContentPane().setBackground(Color.WHITE);

        // 🔎 Filters panel
        JPanel filterPanel = new JPanel(new FlowLayout());
        filterPanel.setBackground(Color.WHITE);

        accountField = new JTextField(10);
        dateField = new JTextField(10); // Format: YYYY-MM-DD
        JButton searchButton = new JButton("Search");

        filterPanel.add(new JLabel("Account Number:"));
        filterPanel.add(accountField);
        filterPanel.add(new JLabel("Date (YYYY-MM-DD):"));
        filterPanel.add(dateField);
        filterPanel.add(searchButton);

        add(filterPanel, BorderLayout.NORTH);

        // 📋 Table setup
        String[] columnNames = {"Type", "From Account", "To Account", "Timestamp", "Amount", "Balance After"};
        tableModel = new DefaultTableModel(columnNames, 0);
        transactionTable = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(transactionTable);
        add(scrollPane, BorderLayout.CENTER);

        // 🔁 Load initial transactions
        loadTransactions(null, null);

        // 🧠 On Search Click
        searchButton.addActionListener(e -> {
            String acc = accountField.getText().trim();
            String date = dateField.getText().trim();
            loadTransactions(acc, date);
        });

        setVisible(true);
    }

    private void loadTransactions(String accountNumber, String date) {
        tableModel.setRowCount(0); // Clear table

        TransactionController controller = new TransactionController();
        ArrayList<Transaction> transactions = controller.getTransactionsForBranch(staff.getBranch(), accountNumber, date);

        for (Transaction tx : transactions) {
            String fromAcc = "", toAcc = "";

            switch (tx.getType()) {
                case "transfer_out":
                    fromAcc = tx.getAccountNumber();
                    toAcc = tx.getRelatedAccount();
                    break;
                case "transfer_in":
                    fromAcc = tx.getRelatedAccount();
                    toAcc = tx.getAccountNumber();
                    break;
                default:
                    fromAcc = tx.getAccountNumber();
                    toAcc = ""; // Not applicable
            }

            tableModel.addRow(new Object[]{
                    tx.getType(),
                    fromAcc,
                    toAcc,
                    tx.getTimestamp().toString(),
                    "₹" + tx.getAmount(),
                    "₹" + tx.getBalanceAfter()
            });
        }
    }

}*/

package View;

import Controller.BankStaffController;
import Model.BankStaff;
import Model.Transaction;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.List;

public class BankTransactionView extends JFrame {
    private BankStaff loggedInStaff;
    private BankStaffController bankStaffController;

    public BankTransactionView(BankStaff staff) {
        this.loggedInStaff = staff;
        this.bankStaffController = new BankStaffController();
        setTitle("Branch Transactions - " + staff.getBranch());
        setSize(800, 500);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new BorderLayout());

        JLabel heading = new JLabel("Transactions for Branch: " + staff.getBranch(), JLabel.CENTER);
        heading.setFont(new Font("Arial", Font.BOLD, 20));
        heading.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        add(heading, BorderLayout.NORTH);

        // Table setup
        String[] columns = {"Account Number", "Type", "Amount (₹)", "Related Account", "Timestamp"};
        DefaultTableModel tableModel = new DefaultTableModel(columns, 0);
        JTable table = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(table);
        add(scrollPane, BorderLayout.CENTER);

        // Fetch and populate transactions
        List<Transaction> transactions = bankStaffController.getBranchTransactions(loggedInStaff.getBranch());
        for (Transaction tx : transactions) {
            tableModel.addRow(new Object[]{
                    tx.getAccountNumber(),
                    tx.getType(),
                    String.format("₹%.2f", tx.getAmount()),
                    tx.getRelatedAccount() != null ? tx.getRelatedAccount() : "-",
                    tx.getTimestamp()
            });
        }

        setVisible(true);
    }
}

