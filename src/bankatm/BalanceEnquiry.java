package bankatm;

import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.awt.event.*;

public class BalanceEnquiry extends ATMFrame implements ActionListener {

    String cardno;
    JButton back;

    BalanceEnquiry(String cardno) {
        this.cardno = cardno;

        int balance = 0;

        try {
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("SELECT * FROM bank WHERE cardno='" + cardno + "'");

            while (rs.next()) {
                if (rs.getString("type").equals("Deposit"))
                    balance += Integer.parseInt(rs.getString("amount"));
                else
                    balance -= Integer.parseInt(rs.getString("amount"));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        // TEXT INSIDE SCREEN
        JLabel text = new JLabel("Available Balance");
        text.setBounds(200, 100, 300, 30);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("Arial", Font.BOLD, 18));
        screen.add(text);

        JLabel bal = new JLabel("₹ " + balance);
        bal.setBounds(220, 150, 300, 30);
        bal.setForeground(Color.GREEN);
        bal.setFont(new Font("Arial", Font.BOLD, 22));
        screen.add(bal);

        // BACK BUTTON (SIDE ATM BUTTON)
        back = UIUtil.sideButton("Back", 20, 250);
        add(back);

        back.addActionListener(this);

        setVisible(true); // 🔥 IMPORTANT
    }

    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == back) {
            setVisible(false);
            new Transactions(cardno);
        }
    }
}