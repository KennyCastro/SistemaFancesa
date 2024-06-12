
package CapaPresentacion.PaginaPrincipal.componentes;
//@author KENNY

import CapaPresentacion.PaginaPrincipal.model.Model_Card;
import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import javax.swing.JLabel;


public class Cards extends javax.swing.JPanel {

    
    private Color color1;
    private Color color2;

    public Cards(Color color1, Color color2, JLabel txtDescripcion, JLabel txtIcono, JLabel txtTitulo, JLabel txtValor) {
        this.color1 = color1;
        this.color2 = color2;
        this.txtDescripcion = txtDescripcion;
        this.txtIcono = txtIcono;
        this.txtTitulo = txtTitulo;
        this.txtValor = txtValor;
    }

    public Color getColor1() {
        return color1;
    }

    public void setColor1(Color color1) {
        this.color1 = color1;
    }

    public Color getColor2() {
        return color2;
    }

    public void setColor2(Color color2) {
        this.color2 = color2;
    }

    public JLabel getTxtDescripcion() {
        return txtDescripcion;
    }

    public void setTxtDescripcion(JLabel txtDescripcion) {
        this.txtDescripcion = txtDescripcion;
    }

    public JLabel getTxtIcono() {
        return txtIcono;
    }

    public void setTxtIcono(JLabel txtIcono) {
        this.txtIcono = txtIcono;
    }

    public JLabel getTxtTitulo() {
        return txtTitulo;
    }

    public void setTxtTitulo(JLabel txtTitulo) {
        this.txtTitulo = txtTitulo;
    }

    public JLabel getTxtValor() {
        return txtValor;
    }

    public void setTxtValor(JLabel txtValor) {
        this.txtValor = txtValor;
    }
    
    
    
    public Cards() {
        initComponents();
        setOpaque(false);
        color1=Color.BLACK;
        color2=Color.WHITE;
    }

    public void setDatos(Model_Card datos){
        txtIcono.setIcon(datos.getIcono());
        txtTitulo.setText(datos.getTitulo());
        txtValor.setText(datos.getValor());
        txtDescripcion.setText(datos.getDescripcion());
    }
  
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtIcono = new javax.swing.JLabel();
        txtTitulo = new javax.swing.JLabel();
        txtValor = new javax.swing.JLabel();
        txtDescripcion = new javax.swing.JLabel();

        txtIcono.setIcon(new javax.swing.ImageIcon(getClass().getResource("/CapaPresentacion/PaginaPrincipal/iconos/stock.png"))); // NOI18N
        txtIcono.setPreferredSize(new java.awt.Dimension(35, 35));

        txtTitulo.setFont(new java.awt.Font("Roboto Medium", 1, 14)); // NOI18N
        txtTitulo.setForeground(new java.awt.Color(255, 255, 255));
        txtTitulo.setText("Title");

        txtValor.setFont(new java.awt.Font("Roboto Medium", 1, 18)); // NOI18N
        txtValor.setForeground(new java.awt.Color(255, 255, 255));
        txtValor.setText("Value");

        txtDescripcion.setFont(new java.awt.Font("Roboto Medium", 0, 13)); // NOI18N
        txtDescripcion.setForeground(new java.awt.Color(255, 255, 255));
        txtDescripcion.setText("Descripcion");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtDescripcion)
                    .addComponent(txtValor)
                    .addComponent(txtTitulo)
                    .addComponent(txtIcono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(159, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(txtIcono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtTitulo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtValor)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtDescripcion)
                .addContainerGap(17, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    @Override
    protected void paintComponent(Graphics grphics) {
        Graphics2D g2= (Graphics2D) grphics;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        GradientPaint g=new GradientPaint(0, 0, color1, 0, getHeight(), color2);
        g2.setPaint(g);
        g2.fillRoundRect(0, 0, getWidth(), getHeight(), 15, 15 );
        g2.setColor(new Color(255,255,255,50)); //desde aqui es para darle efecto de bolitas a las tarjetas
        g2.fillOval(getWidth()-(getHeight()/2), 10, getHeight(), getHeight()); //bolita 1
        g2.fillOval(getWidth()-(getHeight()/2)-20, getHeight()/2+20, getHeight(), getHeight()); //bolita2
        
        super.paintComponent(grphics); 
    }
    
    
    
    
    
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel txtDescripcion;
    private javax.swing.JLabel txtIcono;
    private javax.swing.JLabel txtTitulo;
    private javax.swing.JLabel txtValor;
    // End of variables declaration//GEN-END:variables
}
