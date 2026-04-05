package bankatm;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Date;

public class FastCash extends ATMFrame implements ActionListener {

    JButton b1, b2, b3, b4, back;
    String cardno;

    FastCash(String cardno) {
        this.cardno = cardno;

        // TITLE (CENTERED)
        JLabel text = new JLabel("Select Amount");
        text.setBounds(200, 40, 300, 30);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("Arial", Font.BOLD, 20));
        screen.add(text);

        // BUTTONS INSIDE SCREEN (CENTER GRID)
        b1 = createBtn("₹ 500", 150, 120);
        b2 = createBtn("₹ 1000", 320, 120);
        b3 = createBtn("₹ 2000", 150, 200);
        b4 = createBtn("₹ 5000", 320, 200);

        screen.add(b1);
        screen.add(b2);
        screen.add(b3);
        screen.add(b4);

        // BACK BUTTON (OUTSIDE - LEFT SIDE ATM)
        back = UIUtil.sideButton("Back", 20, 250);
        add(back);

        back.addActionListener(this);

        setVisible(true);
    }

    // CENTER BUTTON STYLE
    JButton createBtn(String text, int x, int y) {
        JButton btn = new JButton(text);

        btn.setBounds(x, y, 120, 50);
        btn.setBackground(new Color(70, 70, 70));
        btn.setForeground(Color.WHITE);

        btn.setFont(new Font("Arial", Font.BOLD, 14));

        btn.setFocusPainted(false);
        btn.setBorderPainted(false);
        btn.setOpaque(true);

        btn.addActionListener(this);

        return btn;
    }

    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == back) {
            setVisible(false);
            new Transactions(cardno);
            return;
        }

        String amt = ((JButton)e.getSource()).getText().replace("₹ ", "");

        try {
            Conn c = new Conn();

            // CHECK BALANCE
            int balance = 0;
            var rs = c.s.executeQuery("SELECT * FROM bank WHERE cardno='" + cardno + "'");

            while (rs.next()) {
                if (rs.getString("type").equals("Deposit"))
                    balance += Integer.parseInt(rs.getString("amount"));
                else
                    balance -= Integer.parseInt(rs.getString("amount"));
            }

            if (balance < Integer.parseInt(amt)) {
                JOptionPane.showMessageDialog(null, "Insufficient Balance");
                return;
            }

            c.s.executeUpdate("INSERT INTO bank VALUES('" + cardno + "','" + new Date() + "','Withdraw','" + amt + "')");

            JOptionPane.showMessageDialog(null, "₹ " + amt + " Withdrawn");

        } catch (Exception ex) {
         
        }
    }
}
