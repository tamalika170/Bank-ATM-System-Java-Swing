
package bankatm;

import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.awt.event.*;
public class MiniStatement extends ATMFrame implements ActionListener {
    JTextArea area;
    JButton back;
    String cardno;
    
    MiniStatement(String cardno){// constructor fire
        this.cardno=cardno;
        
        area=new JTextArea();
        area.setBounds(50,50,500,300);
        
        area.setBackground(Color.BLACK);
        area.setForeground(Color.GREEN);
        area.setFont(new Font("Monospaced",Font.BOLD,14));
        
        screen.add(area);
        
        back=UIUtil.sideButton("Back",20, 250);
        add(back);
        
        back.addActionListener(this);
        
        try{
            Conn c=new Conn();

            ResultSet rs = c.s.executeQuery("SELECT * FROM bank WHERE cardno='" + cardno + "' ORDER BY date DESC LIMIT 10"
);

while (rs.next()) {
    area.append(
        rs.getString("date") + "    "
        + rs.getString("type") + "    "
        + rs.getString("amount") + "\n"
    );
}
        }catch(Exception e){
            
        }
        setVisible(true);
        
    }
    public void actionPerformed(ActionEvent e){
        if(e.getSource()==back){
            setVisible(false);
            new Transactions(cardno);
        }
    }
    
}
