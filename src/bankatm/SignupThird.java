package bankatm;

import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.awt.event.*;

import java.awt.event.ActionListener;

public class SignupThird extends JFrame implements ActionListener {

    long randNumber;
    JRadioButton radio_saving,radio_Fd,radio_current,radio_rd;
    JButton btn_submit,btn_cancel;
    JCheckBox atm,ib,mb,email_sms;
    String formno;

    SignupThird( String formno)
    {
        this.formno=formno;
        setLocation(400, 300);
        setSize(800,600);
        setLayout(null);
        
        // Random rand = new Random();
        //randNumber = Math.abs(rand.nextLong() % 9000L + 1000L);
       
        JLabel application_Number = new JLabel("Application Number is " + this.formno);
        application_Number.setBounds(180, 20, 400, 30);
        application_Number.setFont(new Font("Arial Black", Font.BOLD, 22));
        add(application_Number);   
        
        JLabel Personal_Details =  new JLabel("Account Details  Page -3");
        Personal_Details.setBounds(180,70,250,30);
        Personal_Details.setFont(new Font("Arial Black", Font.BOLD, 16));
        add(Personal_Details);
        
        
        
        JLabel name =  new JLabel("Account Type :");
        name.setBounds(50,120,200,30);
        name.setFont(new Font("Arial Black", Font.BOLD, 20));
        add(name);
        
        radio_saving = new JRadioButton("Savings Account");
        radio_saving.setBounds(50, 150, 200, 30);
        radio_saving.setFont(new Font("Arial Black",Font.BOLD,16));
        add(radio_saving);
        
        
        radio_Fd = new JRadioButton("Fixed Deposite");
        radio_Fd.setBounds(300, 150, 200, 30);
        radio_Fd.setFont(new Font("Arial Black",Font.BOLD,16));
        add(radio_Fd);
       
        radio_current = new JRadioButton("Current Account");
        radio_current.setBounds(50, 190, 200, 30);
        radio_current.setFont(new Font("Arial Black",Font.BOLD,16));
        add(radio_current);
        
        radio_rd = new JRadioButton("Recurring Deposite");
        radio_rd.setBounds(300, 190, 210, 30);
        radio_rd.setFont(new Font("Arial Black",Font.BOLD,16));
        add(radio_rd);
        
       
        
        JLabel card =  new JLabel("Card Number: ");
        card.setBounds(50,220,250,30);
        card.setFont(new Font("Arial Black", Font.BOLD, 20));
        add(card);
        
        JLabel card_no =  new JLabel("XXXX-XXXX-XXXX-1234 ");
        card_no.setBounds(330,220,250,30);
        card_no.setFont(new Font("Arial Black", Font.BOLD, 16));
        add(card_no);
        
        
        JLabel pin =  new JLabel("PIN :");
        pin.setBounds(50,270,200,30);
        pin.setFont(new Font("Arial Black", Font.BOLD, 20));
        add(pin);
        
        
        JLabel pin_no =  new JLabel("XXXX");
        pin_no.setBounds(330,270,250,30);
        pin_no.setFont(new Font("Arial Black", Font.BOLD, 16));
        add(pin_no);
        
        
        
        
        JLabel sr =  new JLabel("Services Required : ");
        sr.setBounds(50,320,250,30);
        sr.setFont(new Font("Arial Black", Font.BOLD, 20));
        add(sr);


        atm = new JCheckBox("ATM CARD");
        atm.setBounds(50,370,200,30);
        atm.setFont(new Font("Arial Black", Font.BOLD, 16));
        add(atm);
        
        
        
        ib = new JCheckBox("Internet Banking");
        ib.setBounds(300,370,200,30);
        ib.setFont(new Font("Arial Black", Font.BOLD, 16));
        add(ib);
        
        
        mb = new JCheckBox("Mobile Banking");
        mb.setBounds(50,420,200,30);
        mb.setFont(new Font("Arial Black", Font.BOLD, 16));
        add(mb);
        
        
        
        email_sms = new JCheckBox("Email & Sms");
         email_sms .setBounds(300,420,200,30);
         email_sms .setFont(new Font("Arial Black", Font.BOLD, 16));
        add( email_sms );
        

        
        

        btn_submit=new JButton("submit");
        btn_submit.setBackground(Color.BLACK);
        btn_submit.setForeground(Color.WHITE);
        btn_submit.setFont(new Font("arial",Font.BOLD,14));
        btn_submit.setBounds(350,480,100,40);
        btn_submit.addActionListener(this);
        add(btn_submit);
        
        btn_cancel=new JButton("cancel");
        btn_cancel.setBackground(Color.BLACK);
        btn_cancel.setForeground(Color.WHITE);
        btn_cancel.setFont(new Font("arial",Font.BOLD,14));
        btn_cancel.setBounds(480,480,100,40);
        btn_cancel.addActionListener(this);
        add(btn_cancel);
        setVisible(true);
        

        
        
        setVisible(true);
    }
    
    @Override
    public void actionPerformed(ActionEvent ae)
    {
     if(ae.getSource()== btn_submit)
     {
         String accounttype="";
         if(radio_saving.isSelected())
         {
            accounttype="savings Account"; 
        }
         else if(radio_Fd.isSelected())
         {
             accounttype="Fixed Deposite";
         }
         else if(radio_current.isSelected())
                 {
                 accounttype="current Account";
                 }
         else if(radio_rd.isSelected())
                 {
                 accounttype="recurring Account";
                 }
    
           Random random=new Random();
           String cardno=""+Math.abs(random.nextLong()%90000000L+505098110000000000L);
           String pinNo=""+Math.abs(random.nextInt()%9000L+1000L);
           
           String facility="";
           if(atm.isSelected())
           {
               facility=facility+"ATM Card";
               
           } if(ib.isSelected())
           {
             
               facility=facility+"Internet Banking";
               
           }if(mb.isSelected())
           {
               
               facility=facility+"Mobile Banking";
               
           } if(email_sms.isSelected())
           {
               
               facility=facility+"Email$sms";
               
           }
           try{
               if(accounttype.equals(""))
                   
               {
                   JOptionPane.showMessageDialog(null,"please Select Account Type");
               }else{
                   Conn conn=new Conn();
                   String sql="insert into signupthree values('"+formno+"','"+accounttype+"','"+cardno+"','"+pinNo+"','"+facility+"')";
                   conn.s.executeUpdate(sql);
                   JOptionPane.showMessageDialog(null,"Account created");
                   this.setVisible(false);
               }
                   
           }
           catch(Exception e)
        
        {
            System.out.println(e); 
        }
            
     }
     else if(ae.getSource()==btn_cancel)
     {
         
     }
        
        
    }
    
    
    public static void main(String[] args) {
    //    new SignupThird();
    }
    
}