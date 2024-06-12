
package CapaPresentacion.PaginaPrincipal.componentes;

 //@author KENNY

import CapaPresentacion.PaginaPrincipal.swing.Buscador;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import javax.naming.directory.SearchResult;
import javax.swing.JLabel;


 
public class Header extends javax.swing.JPanel {

    
    public Header() {
        initComponents();
        setOpaque(false);
        
        buscador1.setName("Search");//esto es para saber como se llama el componente desde otro lado
        
    }

    

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        labelBuscador = new javax.swing.JLabel();
        buscador1 = new CapaPresentacion.PaginaPrincipal.swing.Buscador();
        labelMenu = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setPreferredSize(new java.awt.Dimension(400, 50));

        labelBuscador.setIcon(new javax.swing.ImageIcon(getClass().getResource("/CapaPresentacion/PaginaPrincipal/iconos/search.png"))); // NOI18N
        labelBuscador.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        labelBuscador.setName("logoSearch"); // NOI18N

        buscador1.setFont(new java.awt.Font("Roboto Light", 2, 14)); // NOI18N

        labelMenu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/CapaPresentacion/PaginaPrincipal/iconos/menu.png"))); // NOI18N
        labelMenu.setBorder(javax.swing.BorderFactory.createEmptyBorder(5, 5, 5, 5));
        labelMenu.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        labelMenu.setName("logoMenu"); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(labelBuscador)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(buscador1, javax.swing.GroupLayout.DEFAULT_SIZE, 766, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(labelMenu))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(labelBuscador, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(buscador1, javax.swing.GroupLayout.DEFAULT_SIZE, 39, Short.MAX_VALUE)
                .addContainerGap())
            .addComponent(labelMenu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    @Override
    protected void paintComponent(Graphics grphics) {
        Graphics2D g2= (Graphics2D) grphics;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setColor(getBackground());
        g2.fillRoundRect(0, 0, getWidth(), getHeight(), 15, 15 );
        g2.fillRect(0, 0, 25, getHeight());
        g2.fillRect(getWidth()-25, getHeight()-25, getWidth(), getHeight());
        super.paintComponent(grphics);
    }
    
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private CapaPresentacion.PaginaPrincipal.swing.Buscador buscador1;
    private javax.swing.JLabel labelBuscador;
    private javax.swing.JLabel labelMenu;
    // End of variables declaration//GEN-END:variables
}


