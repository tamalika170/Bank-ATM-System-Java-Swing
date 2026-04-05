package bankatm;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class Login extends JFrame implements ActionListener {

    JButton reset_btn, register_btn, login_btn;
    JTextField cardInput_txt;
    JPasswordField pinInput_txt;

    Login() {

        setTitle("SBI ATM Login");
        setSize(600, 400);
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // �CENTER WINDOW
        setLocationRelativeTo(null);

        getContentPane().setBackground(new Color(20, 20, 20));

        //  MAIN PANEL (CARD STYLE)
        JPanel panel = new JPanel();
        panel.setBounds(50, 30, 480, 300);
        panel.setBackground(new Color(40, 40, 40));
        panel.setLayout(null);
        add(panel);

        // 🔷 TITLE
        JLabel title = new JLabel("SBI ATM");
        title.setBounds(180, 20, 200, 30);
        title.setForeground(Color.GREEN);
        title.setFont(new Font("Arial", Font.BOLD, 22));
        panel.add(title);

        JLabel subtitle = new JLabel("Secure Login");
        subtitle.setBounds(180, 50, 200, 20);
        subtitle.setForeground(Color.LIGHT_GRAY);
        panel.add(subtitle);

        //  CARD NUMBER
        JLabel cardText = new JLabel("Card Number");
        cardText.setBounds(50, 100, 150, 20);
        cardText.setForeground(Color.WHITE);
        panel.add(cardText);

        cardInput_txt = new JTextField();
        cardInput_txt.setBounds(200, 100, 200, 30);
        panel.add(cardInput_txt);

        // PIN
        JLabel pinText = new JLabel("PIN");
        pinText.setBounds(50, 150, 150, 20);
        pinText.setForeground(Color.WHITE);
        panel.add(pinText);

        pinInput_txt = new JPasswordField();
        pinInput_txt.setBounds(200, 150, 200, 30);
        panel.add(pinInput_txt);

        //  BUTTON STYLE
        login_btn = createButton("Login", 80, 220);
        register_btn = createButton("Register", 200, 220);
        reset_btn = createButton("Clear", 320, 220);

        panel.add(login_btn);
        panel.add(register_btn);
        panel.add(reset_btn);

        login_btn.addActionListener(this);
        register_btn.addActionListener(this);
        reset_btn.addActionListener(this);

        setVisible(true);
    }

    // 🔥 BUTTON STYLE METHOD
    JButton createButton(String text, int x, int y) {
        JButton btn = new JButton(text);
        btn.setBounds(x, y, 100, 35);

        btn.setBackground(new Color(70, 70, 70));
        btn.setForeground(Color.WHITE);

        btn.setFont(new Font("Arial", Font.BOLD, 12));

        btn.setFocusPainted(false);
        btn.setBorderPainted(false);
        btn.setOpaque(true);

        // Hover effect
        btn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn.setBackground(new Color(100, 100, 100));
            }

            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn.setBackground(new Color(70, 70, 70));
            }
        });

        return btn;
    }

    public static void main(String[] args) {

      //  try {
        //    UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
       // } catch (Exception e) {}

        new Login();
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == reset_btn) {
            cardInput_txt.setText("");
            pinInput_txt.setText("");
        }

        else if (e.getSource() == login_btn) {

            String card = cardInput_txt.getText();
            String pin = new String(pinInput_txt.getPassword());

            try {
                Conn c = new Conn();

                String query = "SELECT * FROM signupthree WHERE cardno='" + card + "' AND pinno='" + pin + "'";
                ResultSet rs = c.s.executeQuery(query);//upore sql import korte hobe

                if (rs.next()) {
                    JOptionPane.showMessageDialog(null, "Login Successful");

                    setVisible(false);
                    new Transactions(card);

                } else {
                    JOptionPane.showMessageDialog(null, "Invalid Card Number or PIN");
                }

            } catch (Exception ex) {
                ex.printStackTrace(); 
            }
        }

        else {
            setVisible(false);
            new SignupFirst().setVisible(true);
        }
    }
}