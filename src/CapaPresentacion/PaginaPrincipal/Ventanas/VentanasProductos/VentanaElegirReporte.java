/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package CapaPresentacion.PaginaPrincipal.Ventanas.VentanasProductos;
import CapaLogica.Almacen.conexionProductoAlmacen;
import CapaLogica.Conexion;
import CapaPresentacion.PaginaPrincipal.Ventanas.Ventana_Personal_Cocina;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.InputStream;
import java.sql.Connection;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.view.JasperViewer;

public class VentanaElegirReporte extends javax.swing.JFrame {
     int xMouse,  yMouse;
     String opcion="T";
    SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
    private String rutaLogo="/Files/logoCafe.png";
    
    
    public VentanaElegirReporte() {
        initComponents();
        inhabilitarCalendarios();
        inhanilitar();
        centrarPantalla();
        
        
    }

    private void centrarPantalla() {
        Dimension tamanioVentana = getSize();
        Dimension tamanioPantalla = Toolkit.getDefaultToolkit().getScreenSize();
        int ejeX = (tamanioPantalla.width-tamanioVentana.width) / 2;
        int ejeY = (tamanioPantalla.height-tamanioVentana.height) / 2;
        
        setLocation(ejeX, ejeY);
    }
    
    
    public void inhabilitarCalendarios(){
        calendarInicio.setVisible(false);
        calendarFin.setVisible(false);
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        grupoElegirReporte = new javax.swing.ButtonGroup();
        calendarInicio = new com.toedter.calendar.JCalendar();
        calendarFin = new com.toedter.calendar.JCalendar();
        Header = new javax.swing.JPanel();
        btnExit = new javax.swing.JPanel();
        txtExit = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        rbtFechas = new javax.swing.JRadioButton();
        rbtTodo = new javax.swing.JRadioButton();
        txtInicio = new javax.swing.JLabel();
        txtFin = new javax.swing.JLabel();
        cajaInicio = new javax.swing.JTextField();
        cajaFin = new javax.swing.JTextField();
        btnInicio = new javax.swing.JButton();
        btnFin = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        btnAceptar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        calendarInicio.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                calendarInicioPropertyChange(evt);
            }
        });
        getContentPane().add(calendarInicio, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 30, -1, -1));

        calendarFin.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                calendarFinPropertyChange(evt);
            }
        });
        getContentPane().add(calendarFin, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 30, -1, -1));

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
            .addGroup(btnExitLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtExit, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        btnExitLayout.setVerticalGroup(
            btnExitLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(txtExit, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jLabel4.setBackground(new java.awt.Color(0, 0, 0));
        jLabel4.setFont(new java.awt.Font("Roboto Medium", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 0, 0));
        jLabel4.setText("Elegir Reporte");

        javax.swing.GroupLayout HeaderLayout = new javax.swing.GroupLayout(Header);
        Header.setLayout(HeaderLayout);
        HeaderLayout.setHorizontalGroup(
            HeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, HeaderLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 201, Short.MAX_VALUE)
                .addComponent(btnExit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        HeaderLayout.setVerticalGroup(
            HeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnExit, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(HeaderLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        getContentPane().add(Header, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 8, 460, -1));

        grupoElegirReporte.add(rbtFechas);
        rbtFechas.setFont(new java.awt.Font("Roboto Medium", 1, 12)); // NOI18N
        rbtFechas.setForeground(new java.awt.Color(0, 0, 0));
        rbtFechas.setText("POR FECHAS");
        rbtFechas.setContentAreaFilled(false);
        rbtFechas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbtFechasActionPerformed(evt);
            }
        });
        getContentPane().add(rbtFechas, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 120, -1, -1));

        grupoElegirReporte.add(rbtTodo);
        rbtTodo.setFont(new java.awt.Font("Roboto Medium", 1, 12)); // NOI18N
        rbtTodo.setForeground(new java.awt.Color(0, 0, 0));
        rbtTodo.setSelected(true);
        rbtTodo.setText("GENERAL");
        rbtTodo.setContentAreaFilled(false);
        rbtTodo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbtTodoActionPerformed(evt);
            }
        });
        getContentPane().add(rbtTodo, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 70, -1, -1));

        txtInicio.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        txtInicio.setForeground(new java.awt.Color(0, 0, 0));
        txtInicio.setText("INICIO");
        getContentPane().add(txtInicio, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 180, -1, -1));

        txtFin.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        txtFin.setForeground(new java.awt.Color(0, 0, 0));
        txtFin.setText("FIN");
        getContentPane().add(txtFin, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 180, -1, -1));

        cajaInicio.setEditable(false);
        cajaInicio.setBackground(new java.awt.Color(255, 255, 255));
        getContentPane().add(cajaInicio, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 180, 83, -1));

        cajaFin.setEditable(false);
        cajaFin.setBackground(new java.awt.Color(255, 255, 255));
        getContentPane().add(cajaFin, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 180, 83, -1));

        btnInicio.setBackground(new java.awt.Color(255, 255, 255));
        btnInicio.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Files/calendario.png"))); // NOI18N
        btnInicio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInicioActionPerformed(evt);
            }
        });
        getContentPane().add(btnInicio, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 180, -1, 30));

        btnFin.setBackground(new java.awt.Color(255, 255, 255));
        btnFin.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Files/calendario.png"))); // NOI18N
        btnFin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFinActionPerformed(evt);
            }
        });
        getContentPane().add(btnFin, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 180, -1, 30));

        btnCancelar.setBackground(new java.awt.Color(0, 0, 0));
        btnCancelar.setFont(new java.awt.Font("Roboto Black", 1, 18)); // NOI18N
        btnCancelar.setForeground(new java.awt.Color(255, 255, 255));
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
        getContentPane().add(btnCancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 230, -1, 30));

        btnAceptar.setBackground(new java.awt.Color(0, 0, 0));
        btnAceptar.setFont(new java.awt.Font("Roboto Black", 1, 18)); // NOI18N
        btnAceptar.setForeground(new java.awt.Color(255, 255, 255));
        btnAceptar.setText("ACEPTAR");
        btnAceptar.setBorderPainted(false);
        btnAceptar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnAceptar.setFocusPainted(false);
        btnAceptar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnAceptarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnAceptarMouseExited(evt);
            }
        });
        btnAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAceptarActionPerformed(evt);
            }
        });
        getContentPane().add(btnAceptar, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 230, 127, 30));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAceptarActionPerformed
         Map parametro = new HashMap();
        parametro.put("logos", this.getClass().getResourceAsStream(rutaLogo));

          if(opcion!=null) {
          try {
                        Conexion SQL = new Conexion();
                        Connection conect = SQL.conectar();
                         InputStream ruta=getClass().getResourceAsStream("/Reportes/ReporteInventarioGeneral.jrxml");
                         if(opcion=="T"){
                             String FechaInicio = new conexionProductoAlmacen().darFechaInicio();
                              String FechaFin = new conexionProductoAlmacen().darFechaFin();
                             parametro.put("FechaInicio",FechaInicio);
                             parametro.put("FechaFin",FechaFin);
                             
                         } else if(opcion=="F"){
                             parametro.put("FechaInicio", cajaInicio.getText());
                             parametro.put("FechaFin", cajaFin.getText());
                           
                         
                         }
                         
                          JasperReport report= JasperCompileManager.compileReport(ruta);

                       // JasperReport reporte = (JasperReport) JRLoader.loadObject(ruta);
                        JasperPrint jprint = JasperFillManager.fillReport(report, parametro, conect);

                        Integer paginas = jprint.getPages().size();

                        if(paginas>0){
                            JasperViewer view = new JasperViewer(jprint,false);
                            JFrame dialog = new JFrame();
                            dialog.setContentPane(view.getContentPane());

                            dialog.setSize(view.getSize());
                            dialog.setTitle("Reporte Almacen");

                            dialog.setVisible(true);

                        }
                           //view.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
                           // view.setVisible(true);

                        } catch (JRException ex) {
                            Logger.getLogger(Ventana_Personal_Cocina.class.getName()).log(Level.SEVERE, null, ex);
                        }
          }
    }//GEN-LAST:event_btnAceptarActionPerformed

    private void btnAceptarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAceptarMouseExited
        btnAceptar.setBackground(new Color(0,0,0));
        btnAceptar.setForeground(new Color(255,255,255));
    }//GEN-LAST:event_btnAceptarMouseExited

    private void btnAceptarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAceptarMouseEntered
        btnAceptar.setBackground(new Color(255,255,255));
        btnAceptar.setForeground(new Color(0,0,0));
    }//GEN-LAST:event_btnAceptarMouseEntered

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        dispose();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnCancelarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCancelarMouseExited

        btnCancelar.setBackground(new Color(0,0,0));
        btnCancelar.setForeground(new Color(255,255,255));
    }//GEN-LAST:event_btnCancelarMouseExited

    private void btnCancelarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCancelarMouseEntered
        btnCancelar.setBackground(new Color(255,255,255));
        btnCancelar.setForeground(new Color(0,0,0));
    }//GEN-LAST:event_btnCancelarMouseEntered

    private void rbtTodoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbtTodoActionPerformed
        opcion="T";
        inhanilitar();
    }//GEN-LAST:event_rbtTodoActionPerformed

    private void rbtFechasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbtFechasActionPerformed
        opcion="F";
        habilitar();
    }//GEN-LAST:event_rbtFechasActionPerformed

    private void HeaderMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_HeaderMousePressed
        xMouse = evt.getX(); //me da la posicion en el eje X de la ventana
        yMouse = evt.getY();//me da la posicion en el eje Y de la ventana
    }//GEN-LAST:event_HeaderMousePressed

    private void HeaderMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_HeaderMouseDragged
        int x = evt.getXOnScreen();//esto captura en todo momento donde se encuentra la ventana
        int y = evt.getYOnScreen();
        // este evento es cuando arrastramos la ventana por la pantalla
        this.setLocation(x-xMouse,y- yMouse);
    }//GEN-LAST:event_HeaderMouseDragged

    private void txtExitMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtExitMouseExited
        btnExit.setBackground(Color.white);
        txtExit.setForeground(Color.black);
    }//GEN-LAST:event_txtExitMouseExited

    private void txtExitMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtExitMouseEntered
        btnExit.setBackground(Color.red);
        txtExit.setForeground(Color.white);
    }//GEN-LAST:event_txtExitMouseEntered

    private void txtExitMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtExitMouseClicked
        dispose();
    }//GEN-LAST:event_txtExitMouseClicked

    private void btnInicioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInicioActionPerformed
       calendarInicio.setVisible(!calendarInicio.isVisible());
    }//GEN-LAST:event_btnInicioActionPerformed

    private void btnFinActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFinActionPerformed
        calendarFin.setVisible(!calendarFin.isVisible());
    }//GEN-LAST:event_btnFinActionPerformed

    private void calendarInicioPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_calendarInicioPropertyChange
        if (evt.getOldValue()!= null) {  //verificamos que hayamos escogido una fecha
            cajaInicio.setText(formato.format(calendarInicio.getCalendar().getTime()));
        } 
    }//GEN-LAST:event_calendarInicioPropertyChange

    private void calendarFinPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_calendarFinPropertyChange
        if (evt.getOldValue()!= null) {  //verificamos que hayamos escogido una fecha
             //damos un formato a la fecha
            cajaFin.setText(formato.format(calendarFin.getCalendar().getTime()));
        } 
    }//GEN-LAST:event_calendarFinPropertyChange

    public void habilitar(){
        txtInicio.setEnabled(true);
        txtFin.setEnabled(true);
        cajaInicio.setEnabled(true);
        cajaFin.setEnabled(true);
        btnInicio.setEnabled(true);
        btnFin.setEnabled(true);
    }
    
    public void inhanilitar(){
    txtInicio.setEnabled(false);
        txtFin.setEnabled(false);
        cajaInicio.setEnabled(false);
        cajaFin.setEnabled(false);
        btnInicio.setEnabled(false);
        btnFin.setEnabled(false);
    }
    
    
    
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
            java.util.logging.Logger.getLogger(VentanaElegirReporte.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VentanaElegirReporte.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VentanaElegirReporte.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VentanaElegirReporte.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VentanaElegirReporte().setVisible(true);
            }
        });
        
      
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Header;
    private javax.swing.JButton btnAceptar;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JPanel btnExit;
    private javax.swing.JButton btnFin;
    private javax.swing.JButton btnInicio;
    private javax.swing.JTextField cajaFin;
    private javax.swing.JTextField cajaInicio;
    private com.toedter.calendar.JCalendar calendarFin;
    private com.toedter.calendar.JCalendar calendarInicio;
    private javax.swing.ButtonGroup grupoElegirReporte;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JRadioButton rbtFechas;
    private javax.swing.JRadioButton rbtTodo;
    private javax.swing.JLabel txtExit;
    private javax.swing.JLabel txtFin;
    private javax.swing.JLabel txtInicio;
    // End of variables declaration//GEN-END:variables
}
