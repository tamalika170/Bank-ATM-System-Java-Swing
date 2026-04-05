
package bankatm;

import javax.swing.*;
import java.awt.*;
public class ATMFrame extends JFrame{
    
    protected JPanel screen;// Jpanel is under jframe
    
    public ATMFrame(){//constructor
        
        setTitle("SBI ATM");
        setSize(1000,650);
        setLayout(null);
        
        setLocationRelativeTo(null);
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setBackground(new Color(30,30,30));
        
        //screen panel
        
        screen=new JPanel();
        screen.setBounds(200,80,600,400);
        screen.setBackground(new Color(10,10,10));
        screen.setLayout(null);
        
        
        
        add(screen);
        setVisible(true);
    } 
   // public static void main(String args[]){
        
    
}
    

