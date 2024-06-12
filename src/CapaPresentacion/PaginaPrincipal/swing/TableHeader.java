
package CapaPresentacion.PaginaPrincipal.swing;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import javax.swing.JLabel;
import javax.swing.border.EmptyBorder;


public class TableHeader extends JLabel{

    public TableHeader(String text) {
        
        super(text);
        setOpaque(false);
        setBackground(Color.WHITE);
        setFont(new Font("roboto light",1,12));
        setForeground(new Color(102, 102, 102));
        setBorder(new EmptyBorder(10,5,10,5));
    }

    @Override
    protected void paintComponent(Graphics grphics) {
        super.paintComponent(grphics); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
        grphics.setColor(new Color(230,230,230));
        grphics.drawLine(0, getHeight()-1, getWidth(), getHeight()-1);
        
    }
    
    
    
}
