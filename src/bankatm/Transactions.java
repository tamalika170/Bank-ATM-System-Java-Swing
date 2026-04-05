package bankatm;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Transactions extends ATMFrame implements ActionListener{
    JButton b1,b2,b3,b4,b5,b6;
    String cardno;
    
    Transactions(String cardno){
        
        super();
        
        this.cardno=cardno;
        
        JLabel text=new JLabel("Welcome to SBI ATM");
        text.setBounds(150, 40, 300, 30);
        text.setBackground(Color.GREEN);
        text.setFont(new Font("Arial",Font.BOLD,22));
        
        
        screen.add(text);
        
        //LEFT SIDE BUTTONS
        b1=UIUtil.sideButton("Deposit",20,150);
        b2=UIUtil.sideButton("Withdraw",20,220);
        b3=UIUtil.sideButton("Mini Statement",20,290);
        
        //RIGHT SIDE BUTTONS
        
        b4=UIUtil.sideButton("Fast Cash",820,150);
        b5=UIUtil.sideButton("Balance",820,220);
        b6=UIUtil.sideButton("Exit",820,290);
        
        add(b1);
        add(b2);
        add(b3);
        add(b4);
        add(b5);
        add(b6);
        
        b1.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);
        b4.addActionListener(this);
        b5.addActionListener(this);
        b6.addActionListener(this);
        
    }
    public void actionPerformed(ActionEvent e){
        if(e.getSource()==b1){
            setVisible(false);
            new Deposit(cardno);
        }
        else if(e.getSource()==b2){
            setVisible(false);
            new Withdraw(cardno);
        }
        else if(e.getSource()==b3){
            setVisible(false);
            new MiniStatement(cardno);
        }
        else if(e.getSource()==b4){
            setVisible(false);
            new FastCash(cardno);
        }
        else if(e.getSource()==b5){
            setVisible(false);
            new BalanceEnquiry(cardno);
        }
        
    }
}
