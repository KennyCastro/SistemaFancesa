/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package CapaPresentacion.PaginaPrincipal.Ventanas.VentanasProductos;

import CapaDatos.TraspasoAlmacenTienda.datosTraspasoAlmacenTienda;
import CapaLogica.Almacen.conexionProductoAlmacen;
import CapaLogica.Almacen.conexionTienda;
import CapaLogica.TraspasoAlmacenTienda.conexionTraspasoAlmacenTienda;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.text.DecimalFormat;
import java.util.Date;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;

/**
 *
 * @author KENNY
 */
public class VentanaRegistroTraspasoAlmacenTienda extends javax.swing.JFrame {

      int xMouse,  yMouse;
      public static VentanaTraspasoProductos RegistrarTraspaso = new VentanaTraspasoProductos();
     public static datosTraspasoAlmacenTienda traspaso = new datosTraspasoAlmacenTienda();
      
      
      
    public VentanaRegistroTraspasoAlmacenTienda() {
        initComponents();
        centrarPantalla();
        IniciarId();
        
    }

    private void centrarPantalla() {
        Dimension tamanioVentana = getSize();
        Dimension tamanioPantalla = Toolkit.getDefaultToolkit().getScreenSize();
        int ejeX = (tamanioPantalla.width-tamanioVentana.width) / 2;
        int ejeY = (tamanioPantalla.height-tamanioVentana.height) / 2;
        
        setLocation(ejeX, ejeY);
    }
    
    private void IniciarId() {
        generarID();
        mostrarRegistrantes();
        
        
    }
    
    private void generarID(){
        conexionTraspasoAlmacenTienda fun= new conexionTraspasoAlmacenTienda();
        DecimalFormat formato = new DecimalFormat("00000000");
        cajaIdTraspaso.setText(formato.format(fun.generarIdTraspaso()));
    }
    

     public void mostrarRegistrantes(){
        try{
           DefaultComboBoxModel<String> model = new DefaultComboBoxModel<String>();
           DefaultComboBoxModel<String> model1 = new DefaultComboBoxModel<String>();
           DefaultComboBoxModel<String> modelTienda = new DefaultComboBoxModel<String>();
           JComboBox<String> comboBox = new JComboBox<String>(model);
            conexionProductoAlmacen fun= new conexionProductoAlmacen();
            conexionTienda fun1 = new conexionTienda();
            
            model = (DefaultComboBoxModel<String>) fun.mostrarRegistrante();
            model1 = (DefaultComboBoxModel<String>) fun.mostrarRegistrante();
            modelTienda = (DefaultComboBoxModel<String>)fun1.mostrarTienda();
            cajaTienda.setModel(modelTienda);
            cajaEntregante.setModel(model);
            cajaRecepcionante.setModel(model1);
            

        } catch(Exception e){
            JOptionPane.showConfirmDialog(null,e.getMessage());
        }
     }
     
     
     
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        vent_Inicial_Productos1 = new CapaPresentacion.PaginaPrincipal.Ventanas.VentanasProductos.Vent_Inicial_Productos();
        Header = new javax.swing.JPanel();
        btnExit = new javax.swing.JPanel();
        txtExit = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        cajaIdTraspaso = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        cajaTienda = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        cajaEntregante = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        cajaRecepcionante = new javax.swing.JComboBox<>();
        btnCrear = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        Header.setBackground(new java.awt.Color(255, 255, 255));
        Header.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                HeaderMouseDragged(evt);
            }
        });
        Header.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                HeaderMousePressed(evt);
            }
        });

        btnExit.setBackground(new java.awt.Color(255, 255, 255));

        txtExit.setBackground(new java.awt.Color(255, 255, 255));
        txtExit.setFont(new java.awt.Font("Roboto Black", 0, 24)); // NOI18N
        txtExit.setForeground(new java.awt.Color(0, 0, 0));
        txtExit.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtExit.setText("X");
        txtExit.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        txtExit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtExitMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                txtExitMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                txtExitMouseExited(evt);
            }
        });

        javax.swing.GroupLayout btnExitLayout = new javax.swing.GroupLayout(btnExit);
        btnExit.setLayout(btnExitLayout);
        btnExitLayout.setHorizontalGroup(
            btnExitLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(txtExit, javax.swing.GroupLayout.DEFAULT_SIZE, 49, Short.MAX_VALUE)
        );
        btnExitLayout.setVerticalGroup(
            btnExitLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(txtExit, javax.swing.GroupLayout.DEFAULT_SIZE, 36, Short.MAX_VALUE)
        );

        jLabel4.setBackground(new java.awt.Color(0, 0, 0));
        jLabel4.setFont(new java.awt.Font("Roboto Medium", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 0, 0));
        jLabel4.setText("Registro Traspaso a Tienda");

        javax.swing.GroupLayout HeaderLayout = new javax.swing.GroupLayout(Header);
        Header.setLayout(HeaderLayout);
        HeaderLayout.setHorizontalGroup(
            HeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, HeaderLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 331, Short.MAX_VALUE)
                .addComponent(btnExit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        HeaderLayout.setVerticalGroup(
            HeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnExit, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(HeaderLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel2.setBackground(new java.awt.Color(255, 255, 255));
        jLabel2.setFont(new java.awt.Font("Roboto Medium", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Id:");

        cajaIdTraspaso.setEditable(false);
        cajaIdTraspaso.setBackground(new java.awt.Color(255, 255, 255));
        cajaIdTraspaso.setFont(new java.awt.Font("Roboto Medium", 1, 20)); // NOI18N
        cajaIdTraspaso.setEnabled(false);

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Roboto Medium", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Tienda:");

        cajaTienda.setBackground(new java.awt.Color(255, 255, 255));
        cajaTienda.setFont(new java.awt.Font("Roboto Medium", 1, 14)); // NOI18N
        cajaTienda.setForeground(new java.awt.Color(0, 0, 0));
        cajaTienda.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel3.setBackground(new java.awt.Color(255, 255, 255));
        jLabel3.setFont(new java.awt.Font("Roboto Medium", 1, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Entregante:");

        cajaEntregante.setBackground(new java.awt.Color(255, 255, 255));
        cajaEntregante.setFont(new java.awt.Font("Roboto Medium", 1, 14)); // NOI18N
        cajaEntregante.setForeground(new java.awt.Color(0, 0, 0));
        cajaEntregante.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel5.setBackground(new java.awt.Color(255, 255, 255));
        jLabel5.setFont(new java.awt.Font("Roboto Medium", 1, 24)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Recepcionante:");

        cajaRecepcionante.setBackground(new java.awt.Color(255, 255, 255));
        cajaRecepcionante.setFont(new java.awt.Font("Roboto Medium", 1, 14)); // NOI18N
        cajaRecepcionante.setForeground(new java.awt.Color(0, 0, 0));
        cajaRecepcionante.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        btnCrear.setBackground(new java.awt.Color(0, 0, 0));
        btnCrear.setFont(new java.awt.Font("Roboto Black", 1, 18)); // NOI18N
        btnCrear.setForeground(new java.awt.Color(255, 255, 255));
        btnCrear.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Files/mapas-y-banderas.png"))); // NOI18N
        btnCrear.setText("CREAR");
        btnCrear.setBorderPainted(false);
        btnCrear.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnCrear.setFocusPainted(false);
        btnCrear.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnCrearMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnCrearMouseExited(evt);
            }
        });
        btnCrear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCrearActionPerformed(evt);
            }
        });

        btnCancelar.setBackground(new java.awt.Color(0, 0, 0));
        btnCancelar.setFont(new java.awt.Font("Roboto Black", 1, 18)); // NOI18N
        btnCancelar.setForeground(new java.awt.Color(255, 255, 255));
        btnCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Files/disminucion.png"))); // NOI18N
        btnCancelar.setText("CANCELAR");
        btnCancelar.setBorderPainted(false);
        btnCancelar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnCancelar.setFocusPainted(false);
        btnCancelar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnCancelarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnCancelarMouseExited(evt);
            }
        });
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout vent_Inicial_Productos1Layout = new javax.swing.GroupLayout(vent_Inicial_Productos1);
        vent_Inicial_Productos1.setLayout(vent_Inicial_Productos1Layout);
        vent_Inicial_Productos1Layout.setHorizontalGroup(
            vent_Inicial_Productos1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Header, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(vent_Inicial_Productos1Layout.createSequentialGroup()
                .addGroup(vent_Inicial_Productos1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(vent_Inicial_Productos1Layout.createSequentialGroup()
                        .addGroup(vent_Inicial_Productos1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(vent_Inicial_Productos1Layout.createSequentialGroup()
                                .addGap(193, 193, 193)
                                .addComponent(jLabel2)
                                .addGap(18, 18, 18))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, vent_Inicial_Productos1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(vent_Inicial_Productos1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, vent_Inicial_Productos1Layout.createSequentialGroup()
                                        .addComponent(jLabel1)
                                        .addGap(17, 17, 17))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, vent_Inicial_Productos1Layout.createSequentialGroup()
                                        .addComponent(jLabel3)
                                        .addGap(18, 18, 18))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, vent_Inicial_Productos1Layout.createSequentialGroup()
                                        .addComponent(jLabel5)
                                        .addGap(18, 18, 18)))))
                        .addGroup(vent_Inicial_Productos1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(cajaRecepcionante, javax.swing.GroupLayout.PREFERRED_SIZE, 291, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cajaIdTraspaso, javax.swing.GroupLayout.PREFERRED_SIZE, 291, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cajaTienda, javax.swing.GroupLayout.PREFERRED_SIZE, 291, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cajaEntregante, javax.swing.GroupLayout.PREFERRED_SIZE, 291, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(vent_Inicial_Productos1Layout.createSequentialGroup()
                        .addGap(93, 93, 93)
                        .addComponent(btnCrear, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(58, 58, 58)
                        .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        vent_Inicial_Productos1Layout.setVerticalGroup(
            vent_Inicial_Productos1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(vent_Inicial_Productos1Layout.createSequentialGroup()
                .addComponent(Header, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(48, 48, 48)
                .addGroup(vent_Inicial_Productos1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cajaIdTraspaso, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(35, 35, 35)
                .addGroup(vent_Inicial_Productos1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 32, Short.MAX_VALUE)
                    .addComponent(cajaTienda))
                .addGap(34, 34, 34)
                .addGroup(vent_Inicial_Productos1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cajaEntregante, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(32, 32, 32)
                .addGroup(vent_Inicial_Productos1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cajaRecepcionante, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(33, 33, 33)
                .addGroup(vent_Inicial_Productos1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCrear, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 32, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(vent_Inicial_Productos1, javax.swing.GroupLayout.PREFERRED_SIZE, 606, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(vent_Inicial_Productos1, javax.swing.GroupLayout.DEFAULT_SIZE, 427, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtExitMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtExitMouseClicked
        dispose();
    }//GEN-LAST:event_txtExitMouseClicked

    private void txtExitMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtExitMouseEntered
        btnExit.setBackground(Color.red);
        txtExit.setForeground(Color.white);
    }//GEN-LAST:event_txtExitMouseEntered

    private void txtExitMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtExitMouseExited
        btnExit.setBackground(Color.white);
        txtExit.setForeground(Color.black);
    }//GEN-LAST:event_txtExitMouseExited

    private void HeaderMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_HeaderMouseDragged
        int x = evt.getXOnScreen();//esto captura en todo momento donde se encuentra la ventana
        int y = evt.getYOnScreen();
        // este evento es cuando arrastramos la ventana por la pantalla
        this.setLocation(x-xMouse,y- yMouse);
    }//GEN-LAST:event_HeaderMouseDragged

    private void HeaderMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_HeaderMousePressed
        xMouse = evt.getX(); //me da la posicion en el eje X de la ventana
        yMouse = evt.getY();//me da la posicion en el eje Y de la ventana
    }//GEN-LAST:event_HeaderMousePressed

    private void btnCrearMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCrearMouseEntered
        btnCrear.setBackground(new Color(255,255,255));
        btnCrear.setForeground(new Color(0,0,0));
    }//GEN-LAST:event_btnCrearMouseEntered

    private void btnCrearMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCrearMouseExited

        btnCrear.setBackground(new Color(0,0,0));
        btnCrear.setForeground(new Color(255,255,255));
    }//GEN-LAST:event_btnCrearMouseExited

    private void btnCrearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCrearActionPerformed

        conexionProductoAlmacen fun= new conexionProductoAlmacen();
        conexionTienda fun1 = new conexionTienda();
        
        traspaso.setIdTraspaso(cajaIdTraspaso.getText());
        
        traspaso.setFechaTraspaso(new Date());
        
        String idfTienda = fun1.darIdTienda(cajaTienda.getSelectedItem().toString());
         if(idfTienda==""){
            traspaso.setIdTienda("100");
        } else {
            traspaso.setIdTienda(idfTienda);
        }
        
        
        String idfRegistrante= fun.darIdRegistrante(cajaEntregante.getSelectedItem().toString());
        if(idfRegistrante==""){
            traspaso.setIdPersonaEntrega("0010");
        } else {
            traspaso.setIdPersonaEntrega(idfRegistrante);
        }
        
        String idfRecepcionante= fun.darIdRegistrante(cajaRecepcionante.getSelectedItem().toString());
        if(idfRecepcionante==""){
            traspaso.setIdPersonaRecibe("0010");
        } else {
            traspaso.setIdPersonaRecibe(idfRegistrante);
        }
        
        RegistrarTraspaso=new VentanaTraspasoProductos();
        RegistrarTraspaso.setVisible(true);
         System.out.print(traspaso.getFechaTraspaso()+" fdfddf "+traspaso.getIdTraspaso());
         dispose();
        
    }//GEN-LAST:event_btnCrearActionPerformed

    private void btnCancelarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCancelarMouseEntered
        btnCancelar.setBackground(new Color(255,255,255));
        btnCancelar.setForeground(new Color(0,0,0));
    }//GEN-LAST:event_btnCancelarMouseEntered

    private void btnCancelarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCancelarMouseExited
        btnCancelar.setBackground(new Color(0,0,0));
        btnCancelar.setForeground(new Color(255,255,255));
    }//GEN-LAST:event_btnCancelarMouseExited

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed

        dispose();

    }//GEN-LAST:event_btnCancelarActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(VentanaRegistroTraspasoAlmacenTienda.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VentanaRegistroTraspasoAlmacenTienda.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VentanaRegistroTraspasoAlmacenTienda.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VentanaRegistroTraspasoAlmacenTienda.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VentanaRegistroTraspasoAlmacenTienda().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Header;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnCrear;
    private javax.swing.JPanel btnExit;
    private javax.swing.JComboBox<String> cajaEntregante;
    private javax.swing.JTextField cajaIdTraspaso;
    private javax.swing.JComboBox<String> cajaRecepcionante;
    private javax.swing.JComboBox<String> cajaTienda;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel txtExit;
    private CapaPresentacion.PaginaPrincipal.Ventanas.VentanasProductos.Vent_Inicial_Productos vent_Inicial_Productos1;
    // End of variables declaration//GEN-END:variables
}
