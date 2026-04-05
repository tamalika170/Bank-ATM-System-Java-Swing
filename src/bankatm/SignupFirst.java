package bankatm;

import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.awt.event.*;

import com.toedter.calendar.JDateChooser;
import java.awt.event.ActionListener;

public class SignupFirst extends JFrame implements ActionListener {

    long randNumber;
    JTextField txt_Name,txt_FName,txt_phone,txt_city;
    JDateChooser dt;
    JRadioButton radio_Male,radio_Female;
    JButton btn_Next;
    SignupFirst()
    {
        
        setLocation(400, 300);
        setSize(800,600);
        setLayout(null);
        
         Random rand = new Random();
        randNumber = Math.abs(rand.nextLong() % 9000L + 1000L);
       
        JLabel application_Number = new JLabel("Application Number is " + randNumber);
        application_Number.setBounds(180, 20, 400, 30);
        application_Number.setFont(new Font("Arial Black", Font.BOLD, 22));
        add(application_Number);   
        
        JLabel Personal_Details =  new JLabel("Personal Details  Page -1");
        Personal_Details.setBounds(180,70,250,30);
        Personal_Details.setFont(new Font("Arial Black", Font.BOLD, 16));
        add(Personal_Details);
        
        
        
        JLabel name =  new JLabel("Enter your Name");
        name.setBounds(50,120,200,30);
        name.setFont(new Font("Arial Black", Font.BOLD, 16));
        add(name);
        
       
        
        
        JLabel fname =  new JLabel("Enter your Father's Name");
        fname.setBounds(50,170,250,30);
        fname.setFont(new Font("Arial Black", Font.BOLD, 16));
        add(fname);
        
        JLabel dob =  new JLabel("Select Date of Birth ");
        dob.setBounds(50,220,250,30);
        dob.setFont(new Font("Arial Black", Font.BOLD, 16));
        add(dob);
        
        
        JLabel lbl_gender =  new JLabel("Select Gender ");
        lbl_gender.setBounds(50,270,250,30);
        lbl_gender.setFont(new Font("Arial Black", Font.BOLD, 16));
        add(lbl_gender);
        
        
        JLabel phone =  new JLabel("Enter Phone Number ");
        phone.setBounds(50,320,250,30);
        phone.setFont(new Font("Arial Black", Font.BOLD, 16));
        add(phone);
        
        JLabel city =  new JLabel("Enter City ");
        city.setBounds(50,370,250,30);
        city.setFont(new Font("Arial Black", Font.BOLD, 16));
        add(city);
        
    
        txt_Name = new JTextField();
        txt_Name.setBounds(330, 120, 300, 30);
        txt_Name.setFont(new Font("Times New Roman", Font.BOLD, 16));
        add(txt_Name);
        
        
         txt_FName = new JTextField();
        txt_FName.setBounds(330, 170, 300, 30);
        txt_FName.setFont(new Font("Times New Roman", Font.BOLD, 16));
        add(txt_FName);
        
        dt = new JDateChooser();
        dt.setBounds(330, 220, 200, 40);
        add(dt);

        radio_Male = new JRadioButton("Male");
        radio_Male.setBounds(330, 280, 100, 30);
        add(radio_Male);
        
        
        radio_Female = new JRadioButton("Female");
        radio_Female.setBounds(450, 280, 100, 30);
        add(radio_Female);

        
        txt_phone = new JTextField();
        txt_phone.setBounds(330, 330, 300, 30);
        txt_phone.setFont(new Font("Times New Roman", Font.BOLD, 16));
        add(txt_phone);
        
        
        txt_city = new JTextField();
        txt_city.setBounds(330, 380, 300, 30);
        txt_city.setFont(new Font("Times New Roman", Font.BOLD, 16));
        add(txt_city);
        
        ButtonGroup gender_ButtonGroup = new ButtonGroup();
        gender_ButtonGroup.add(radio_Male);
        gender_ButtonGroup.add(radio_Female);
        
        
        btn_Next = new JButton("Next");
        btn_Next.setBounds(600, 430, 100, 40);
        btn_Next.setFont(new Font("Arial", Font.BOLD, 16));
        btn_Next.setBackground(Color.GREEN);
        btn_Next.setBorderPainted(false);
        btn_Next.setOpaque(true);
        btn_Next.addActionListener(this);
        add(btn_Next);

        
        
        setVisible(true);
    }
    
    @Override
    public void actionPerformed(ActionEvent ae)
    {
        String formno=""+randNumber;
        String name=txt_Name.getText();
        String fname= txt_FName.getText();
        String dob = ((JTextField)dt.getDateEditor().getUiComponent()).getText();
        String gender=null;
        if(radio_Male.isSelected())
        {
            gender="Male";
        }
        else
        {
            gender="Female";
        }
        String phonenumber=txt_phone.getText();
        String city=txt_city.getText();
        
        try
        {
            if(name.equals("")){
                JOptionPane.showMessageDialog(null, "Name can not be blank");
            }
            else if (fname.equals(""))
            {
                JOptionPane.showMessageDialog(null, "Father's Name Can not be blank");
                
            }
            else
            {
                Conn c = new Conn();
                String sql="insert into signup values('"+formno+"','"+name+"','"+fname+"','"+dob+"','"+gender+"','"+phonenumber+"','"+city+"')";
                c.s.executeUpdate(sql);
                this.setVisible(false);
                new SignupSecond(formno);
            }
            
        }
        catch (Exception e)
        {
            System.out.println(e); 
        }
            
        
        
        
    }
    
    
    public static void main(String[] args) {
        new SignupFirst();
    }
    
}
