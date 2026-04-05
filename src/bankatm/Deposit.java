package bankatm;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Date;

public class Deposit extends ATMFrame implements ActionListener {

    JTextField amount;
    JButton submit, back;
    String cardno;

    Deposit(String cardno) {
        this.cardno = cardno;

        JLabel text = new JLabel("Enter Amount to Deposit");
        text.setBounds(180, 80, 300, 30);
        text.setForeground(Color.WHITE);
        screen.add(text);

        amount = new JTextField();
        amount.setBounds(180, 130, 200, 30);
        screen.add(amount);

        submit = UIUtil.sideButton("Submit", 810, 200);
        back = UIUtil.sideButton("Back", 30, 200);

        add(submit);
        add(back);

        submit.addActionListener(this);
        back.addActionListener(this);
    }

    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == submit) {
            String amt = amount.getText();

            try {
                Conn c = new Conn();
                c.s.executeUpdate("INSERT INTO bank VALUES('" + cardno + "','" + new Date() + "','Deposit','" + amt + "')");

                JOptionPane.showMessageDialog(null, "₹ " + amt + " Deposited");

            } catch (Exception ex) {
                ex.printStackTrace();
            }
        } else {
            setVisible(false);
            new Transactions(cardno);
        }
    }
}
