package bankatm;

import javax.swing.*;
import java.awt.*;
//import java.util.*;
import java.awt.event.*;

//import com.toedter.calendar.JDateChooser;
import java.awt.event.ActionListener;

public class SignupSecond  extends JFrame implements ActionListener {

   
    JTextField txt_pan;
    String formno;
    JComboBox religion,category,income,education,occupation;
    
  
    JButton btn_Next;
    SignupSecond(String formno)
    {
        this.formno=formno;
        setLocation(400, 300);
        setSize(800,600);
        setLayout(null);
        setTitle("Personal Details Page-2");
        
        
         JLabel application_Number = new JLabel("Application Number is " + formno);
        application_Number.setBounds(180, 20, 400, 30);
        application_Number.setFont(new Font("Arial Black", Font.BOLD, 22));
        add(application_Number);   
  
        
        JLabel Personal_Details =  new JLabel("Personal Details  Page -2");
        Personal_Details.setBounds(250,70,250,30);
        Personal_Details.setFont(new Font("Arial Black", Font.BOLD, 16));
        add(Personal_Details);
        
        
        
        JLabel lbl_religion =  new JLabel("Select Religion");
        lbl_religion.setBounds(50,120,200,30);
        lbl_religion.setFont(new Font("Arial Black", Font.BOLD, 16));
        add(lbl_religion);
        
       
        
        
        JLabel lbl_category=  new JLabel("Select Category");
        lbl_category.setBounds(50,170,250,30);
        lbl_category.setFont(new Font("Arial Black", Font.BOLD, 16));
        add(lbl_category);
        
        JLabel lbl_income =  new JLabel("Select Income ");
        lbl_income.setBounds(50,220,250,30);
        lbl_income.setFont(new Font("Arial Black", Font.BOLD, 16));
        add(lbl_income);
        
        
        JLabel lbl_education =  new JLabel("Select Education ");
        lbl_education.setBounds(50,270,250,30);
        lbl_education.setFont(new Font("Arial Black", Font.BOLD, 16));
        add(lbl_education);
        
        
        JLabel lbl_occupation =  new JLabel("Select Occupation ");
        lbl_occupation.setBounds(50,320,250,30);
        lbl_occupation.setFont(new Font("Arial Black", Font.BOLD, 16));
        add(lbl_occupation);
        
        JLabel lbl_pan =  new JLabel("Enter PAN NUMBER ");
        lbl_pan.setBounds(50,370,250,30);
        lbl_pan.setFont(new Font("Arial Black", Font.BOLD, 16));
        add(lbl_pan);
        
        String value_of_religion[]={"Hindu","Muslim","Sikh","others"};
        
        religion = new JComboBox(value_of_religion);
        religion.setBounds(330, 120, 300, 30);
        religion.setFont(new Font("Times New Roman", Font.BOLD, 16));
        religion.setBackground(Color.white);
        add(religion);
        
        
        
        String value_of_category[]={"General","OBC","SC","ST","Others"};
        category = new JComboBox(value_of_category);
        category.setBounds(330, 170, 300, 30);
        category.setFont(new Font("Times New Roman", Font.BOLD, 16));
        add(category);
        
        
        String value_of_income[]={"<1,50,000","<3,00,000","<5,00,000","<12,00,000","Greater than 12,00,000"};
        income = new JComboBox(value_of_income);
        income.setBounds(330, 220, 300, 30);
        income.setFont(new Font("Times New Roman", Font.BOLD, 16));
        add(income);
        
        
        String value_of_education[]={"12th","Graduation","Post Graduation","Masters","Others"};
        education = new JComboBox(value_of_education);
        education.setBounds(330, 270, 300, 30);
        education.setFont(new Font("Times New Roman", Font.BOLD, 16));
        add(education);

        
        String value_of_occupation[]={"Business","Self-Employed","Salarised","Others"};
        occupation = new JComboBox(value_of_occupation);
        occupation.setBounds(330, 320, 300, 30);
        occupation.setFont(new Font("Times New Roman", Font.BOLD, 16));
        add(occupation);
        
       
        
        
        txt_pan = new JTextField();
        txt_pan.setBounds(330, 380, 300, 30);
        txt_pan.setFont(new Font("Times New Roman", Font.BOLD, 16));
        add(txt_pan);
        
      
        
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
     
        
        String religion_value=religion.getSelectedItem().toString();
        String category_value=category.getSelectedItem().toString();
        String income_value=income.getSelectedItem().toString();
        String education_value=education.getSelectedItem().toString();
        String occupation_value=occupation.getSelectedItem().toString();
        String pan=txt_pan.getText();
        
        try
        {
            if(pan.equals("")){
                JOptionPane.showMessageDialog(null, "PAN can not be blank");
            }
            
            else
            {
                Conn c = new Conn();
               String sql="insert into signupsecond values('"+formno+"','"+religion_value+"','"+category_value+"','"+income_value+"','"+education_value+"','"+occupation_value+"','"+pan+"')";
               c.s.executeUpdate(sql);
               this.setVisible(false);
               new SignupThird(formno);
            }
            
        }
        catch (Exception e)
        {
            System.out.println(e); 
        }
            
        
        
        
    }
    
    
    public static void main(String[] args) {
      //  new SignupSecond();
    }
    
}

