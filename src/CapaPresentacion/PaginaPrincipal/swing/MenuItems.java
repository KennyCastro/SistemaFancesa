
package CapaPresentacion.PaginaPrincipal.swing;
 //@author KENNY
import CapaPresentacion.PaginaPrincipal.model.Model_Menu;
import java.awt.Color;
import java.awt.Font;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;


public class MenuItems extends javax.swing.JPanel {

   

    

    private boolean ItemSeleccionado;
    
    
    private boolean pintarItem;
    
    public MenuItems(Model_Menu data) {
        initComponents();
        //lo que estamos haciendo aqui es pasarle los items (opciones del menu)usando la clase MODEL:MENU (que son los datos del menu)
        setOpaque(false);
        if (data.getType()==Model_Menu.MenuTipo.MENU){
            labelIcono.setIcon(data.toIcon());
            labelNombreIcono.setText(data.getNombre());
        } else if (data.getType()==Model_Menu.MenuTipo.TITLE){
            labelIcono.setText(data.getNombre());
            labelIcono.setFont(new Font("roboto black",1,12));
            labelNombreIcono.setVisible(false);
        } else{
            labelNombreIcono.setText(" ");
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        labelIcono = new javax.swing.JLabel();
        labelNombreIcono = new javax.swing.JLabel();

        labelIcono.setForeground(new java.awt.Color(255, 255, 255));

        labelNombreIcono.setForeground(new java.awt.Color(255, 255, 255));
        labelNombreIcono.setText("Menu Name ");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(labelIcono)
                .addGap(18, 18, 18)
                .addComponent(labelNombreIcono)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(labelIcono, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(labelNombreIcono, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    @Override
    protected void paintComponent(Graphics grphics){
        if (ItemSeleccionado || pintarItem){
            Graphics2D g2= (Graphics2D) grphics;
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            
            if(ItemSeleccionado) {
                g2.setColor(new Color(255,255,255,80));
            } else {
                g2.setColor(new Color(255,255,255,20));
            }
            
            g2.fillRoundRect(10, 0, getWidth()-20, getHeight(), 5, 5 );
        }
    
        super.paintComponent(grphics);
        
    }
    
    
    public void setItemSeleccionado(boolean ItemSeleccionado) {
        this.ItemSeleccionado = ItemSeleccionado;
        repaint();
    }
    
    public void setPintarItem (boolean pintarItem){
        this.pintarItem=pintarItem;
        repaint();
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel labelIcono;
    private javax.swing.JLabel labelNombreIcono;
    // End of variables declaration//GEN-END:variables
}
