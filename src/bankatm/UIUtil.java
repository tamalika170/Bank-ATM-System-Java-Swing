
package bankatm;
import javax.swing.*;
import java.awt.*;

public class UIUtil {
    
    public static JButton sideButton(String text,int x, int y){
        JButton btn=new JButton(text);
        
        btn.setBounds(x,y,160,40);
        btn.setUI(new javax.swing.plaf.basic.BasicButtonUI());
        
        btn.setBackground(new Color(80,80,80));
        btn.setForeground(Color.WHITE);
        
        btn.setFont(new Font("Arial",Font.BOLD,14));
        
        btn.setFocusPainted(false);
        btn.setBorderPainted(false);
        btn.setOpaque(true);
        
        //Hover
        btn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn.setBackground(new Color(120, 120, 120));
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn.setBackground(new Color(80, 80, 80));
            }
        });
        
        return btn;
    }
    
}
