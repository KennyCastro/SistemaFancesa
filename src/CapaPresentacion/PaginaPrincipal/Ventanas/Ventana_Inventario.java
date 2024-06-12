/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package CapaPresentacion.PaginaPrincipal.Ventanas;

import CapaDatos.Almacen.datosProductoAlmacen;
import CapaDatos.Almacen.datosUnidadProducto;
import CapaLogica.Almacen.conexionProductoAlmacen;
import CapaLogica.Almacen.conexionUnidadProducto;
import CapaLogica.Conexion;
import CapaPresentacion.PaginaPrincipal.Ventanas.VentanasProductos.Ventana_Productos_Registro;
import CapaPresentacion.PaginaPrincipal.componentes.PieChart3DDemo;
import java.awt.Color;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import org.jfree.chart.title.TextTitle;
import static CapaPresentacion.PaginaPrincipal.Ventanas.Ventana_Principal.acciones;
import CapaPresentacion.PaginaPrincipal.Ventanas.VentanasProductos.VentanaElegirReporte;
import CapaPresentacion.PaginaPrincipal.Ventanas.VentanasProductos.VentanaRegistroTipo;
import CapaPresentacion.PaginaPrincipal.Ventanas.VentanasProductos.VentanaRegistroUnidad;
import CapaPresentacion.PaginaPrincipal.Ventanas.VentanasUsuarios.Ventana_PersonalCocina_Pagos;
import CapaPresentacion.PaginaPrincipal.swing.ScrollBar;
import java.awt.Component;
import java.io.InputStream;
import java.sql.Connection;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.view.JasperViewer;


/**
 *
 * @author KENNY
 */
public class Ventana_Inventario extends javax.swing.JPanel {
    public static String accionUnidad = "guardar";
    public static String accionTipo = "guardar";
    public static String IdUnidad="";
    public static String IdTipo="";
    private String rutaLogo="/Files/logoCafe.png";
     String text;
     JLabel logos;
    JTextField textFiel;
    JLabel logoBuscador;
    JLabel logoMenu;
    
   
    public Ventana_Inventario() {
        initComponents();
        IniciarGrafico();
        IniciarBusqueda();
        mostrarTablaProductos("");
        mostrarUnidades("");
        mostrarTipos("");
        StyleTable();
    }

    
     public void IniciarBusqueda(){
          for (Component comp : header1.getComponents()) {
            if (comp instanceof JTextField) {
                textFiel = (JTextField) comp;
            }
            else if(comp instanceof JLabel){
                logos = (JLabel) comp;
                if("logoSearch".equals(logos.getName())){
                    logoBuscador = logos;
                }
                else{
                    logoMenu= logos;
                }
            
            }
        }
        
         logoBuscador.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                logoBuscadorMouseClicked(evt);
            }
            

        });
         
         textFiel.addKeyListener(new java.awt.event.KeyAdapter() {
            @Override
            public void keyReleased(java.awt.event.KeyEvent evt) {
                textFielKeyReleased(evt);
            }
         });
    }
     
     private void logoBuscadorMouseClicked(java.awt.event.MouseEvent evt) {       //esto es para que cuando se presione la lupa, busque(queda innecesario con la funcion de abajo, pero por si acaso esta aqui)
        text=textFiel.getText();
        mostrarTablaProductos(text);
         mostrarTipos(text);
         mostrarUnidades(text);
    } 
    
    private void textFielKeyReleased(java.awt.event.KeyEvent evt) { //esto es para que cada vez que escribamos una letra en el fuscador se actualice autpmaticamente la tabla
        text=textFiel.getText();
        mostrarTablaProductos(text);
         mostrarTipos(text);
         mostrarUnidades(text);
    }
    
    
    
    
    
     public void StyleTable(){
        jScrollPaneUnidad.setVerticalScrollBar(new ScrollBar());
        jScrollPaneUnidad.getVerticalScrollBar().setBackground(Color.WHITE);
        jScrollPaneUnidad.getViewport().setBackground(Color.WHITE);//esto es para que cuando no haya datos suficientes para tener scroll todo el panel se vea blanco
        JPanel p= new JPanel();
        p.setBackground(Color.WHITE);
        jScrollPaneUnidad.setCorner(jScrollPaneUnidad.UPPER_RIGHT_CORNER, p);
        
         jScrollPaneInvent.setVerticalScrollBar(new ScrollBar());
        jScrollPaneInvent.getVerticalScrollBar().setBackground(Color.WHITE);
        jScrollPaneInvent.getViewport().setBackground(Color.WHITE);//esto es para que cuando no haya datos suficientes para tener scroll todo el panel se vea blanco
        JPanel pp= new JPanel();
        pp.setBackground(Color.WHITE);
        jScrollPaneInvent.setCorner(jScrollPaneInvent.UPPER_RIGHT_CORNER, pp);
        
        jScrollPaneTipos.setVerticalScrollBar(new ScrollBar());
        jScrollPaneTipos.getVerticalScrollBar().setBackground(Color.WHITE);
        jScrollPaneTipos.getViewport().setBackground(Color.WHITE);//esto es para que cuando no haya datos suficientes para tener scroll todo el panel se vea blanco
        JPanel ppp= new JPanel();
        ppp.setBackground(Color.WHITE);
        jScrollPaneTipos.setCorner(jScrollPaneTipos.UPPER_RIGHT_CORNER, ppp);
     }
    
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        header1 = new CapaPresentacion.PaginaPrincipal.componentes.Header();
        btnCrearUnd = new javax.swing.JButton();
        graficoInventario = new CapaPresentacion.PaginaPrincipal.componentes.PieChart3DDemo();
        btnCrear = new javax.swing.JButton();
        btnCrearTipo = new javax.swing.JButton();
        btnReport = new javax.swing.JButton();
        jScrollPaneUnidad = new javax.swing.JScrollPane();
        tableUnidades = new CapaPresentacion.PaginaPrincipal.swing.Table();
        jScrollPaneInvent = new javax.swing.JScrollPane();
        tableProductosEscasos = new CapaPresentacion.PaginaPrincipal.swing.Table();
        jScrollPaneTipos = new javax.swing.JScrollPane();
        tableTipos = new CapaPresentacion.PaginaPrincipal.swing.Table();
        jLabel1 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(242, 242, 242));
        setPreferredSize(new java.awt.Dimension(921, 640));

        btnCrearUnd.setBackground(new java.awt.Color(64, 0, 17));
        btnCrearUnd.setFont(new java.awt.Font("Roboto Black", 1, 14)); // NOI18N
        btnCrearUnd.setForeground(new java.awt.Color(255, 255, 255));
        btnCrearUnd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Files/anadir-amigo.png"))); // NOI18N
        btnCrearUnd.setText("Crear Unidad");
        btnCrearUnd.setBorder(null);
        btnCrearUnd.setBorderPainted(false);
        btnCrearUnd.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnCrearUnd.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnCrearUndMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnCrearUndMouseExited(evt);
            }
        });
        btnCrearUnd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCrearUndActionPerformed(evt);
            }
        });

        btnCrear.setBackground(new java.awt.Color(64, 0, 17));
        btnCrear.setFont(new java.awt.Font("Roboto Black", 1, 14)); // NOI18N
        btnCrear.setForeground(new java.awt.Color(255, 255, 255));
        btnCrear.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Files/anadir-amigo.png"))); // NOI18N
        btnCrear.setText("Crear Producto");
        btnCrear.setBorder(null);
        btnCrear.setBorderPainted(false);
        btnCrear.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
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

        btnCrearTipo.setBackground(new java.awt.Color(64, 0, 17));
        btnCrearTipo.setFont(new java.awt.Font("Roboto Black", 1, 14)); // NOI18N
        btnCrearTipo.setForeground(new java.awt.Color(255, 255, 255));
        btnCrearTipo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Files/anadir-amigo.png"))); // NOI18N
        btnCrearTipo.setText("Crear Tipo ");
        btnCrearTipo.setBorder(null);
        btnCrearTipo.setBorderPainted(false);
        btnCrearTipo.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnCrearTipo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnCrearTipoMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnCrearTipoMouseExited(evt);
            }
        });
        btnCrearTipo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCrearTipoActionPerformed(evt);
            }
        });

        btnReport.setBackground(new java.awt.Color(64, 0, 17));
        btnReport.setFont(new java.awt.Font("Roboto Black", 1, 14)); // NOI18N
        btnReport.setForeground(new java.awt.Color(255, 255, 255));
        btnReport.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Files/anadir-amigo.png"))); // NOI18N
        btnReport.setText("Ver reportes");
        btnReport.setBorder(null);
        btnReport.setBorderPainted(false);
        btnReport.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnReport.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnReportMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnReportMouseExited(evt);
            }
        });
        btnReport.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReportActionPerformed(evt);
            }
        });

        tableUnidades.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tableUnidades.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableUnidadesMouseClicked(evt);
            }
        });
        jScrollPaneUnidad.setViewportView(tableUnidades);

        tableProductosEscasos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPaneInvent.setViewportView(tableProductosEscasos);

        tableTipos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tableTipos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableTiposMouseClicked(evt);
            }
        });
        jScrollPaneTipos.setViewportView(tableTipos);

        jLabel1.setBackground(new java.awt.Color(204, 204, 204));
        jLabel1.setFont(new java.awt.Font("Roboto Medium", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("PRODUCTOS ESCASOS");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(header1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(graficoInventario, javax.swing.GroupLayout.PREFERRED_SIZE, 589, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(jScrollPaneUnidad, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPaneTipos, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 290, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPaneInvent, javax.swing.GroupLayout.PREFERRED_SIZE, 290, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(22, 22, 22))
            .addGroup(layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addComponent(btnCrear, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(37, 37, 37)
                .addComponent(btnCrearUnd, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(37, 37, 37)
                .addComponent(btnCrearTipo, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(37, 37, 37)
                .addComponent(btnReport, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(header1, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(graficoInventario, javax.swing.GroupLayout.PREFERRED_SIZE, 474, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPaneInvent, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(36, 36, 36)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPaneUnidad, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPaneTipos, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCrear, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCrearUnd, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCrearTipo, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnReport, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(8, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnCrearUndMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCrearUndMouseEntered
        btnCrearUnd.setBackground(new Color(143,27,48));

    }//GEN-LAST:event_btnCrearUndMouseEntered

    private void btnCrearUndMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCrearUndMouseExited
        btnCrearUnd.setBackground(new Color(64,0,17)); //[64,87,68]
    }//GEN-LAST:event_btnCrearUndMouseExited

    private void btnCrearUndActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCrearUndActionPerformed
        accionUnidad="crear";
        VentanaRegistroUnidad vent = new VentanaRegistroUnidad();
        vent.setVisible(true);
        
    }//GEN-LAST:event_btnCrearUndActionPerformed

    private void btnCrearMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCrearMouseEntered
         btnCrear.setBackground(new Color(143,27,48));
    }//GEN-LAST:event_btnCrearMouseEntered

    private void btnCrearMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCrearMouseExited
       btnCrear.setBackground(new Color(64,0,17)); //[64,87,68]
    }//GEN-LAST:event_btnCrearMouseExited

    private void btnCrearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCrearActionPerformed
       Ventana_Productos_Registro productosReg = new Ventana_Productos_Registro();
       productosReg.setVisible(true);
    }//GEN-LAST:event_btnCrearActionPerformed

    private void btnCrearTipoMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCrearTipoMouseEntered
       btnCrearTipo.setBackground(new Color(143,27,48));
    }//GEN-LAST:event_btnCrearTipoMouseEntered

    private void btnCrearTipoMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCrearTipoMouseExited
        btnCrearTipo.setBackground(new Color(64,0,17)); //[64,87,68]
    }//GEN-LAST:event_btnCrearTipoMouseExited

    private void btnCrearTipoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCrearTipoActionPerformed
        accionTipo="crear";
        VentanaRegistroTipo vent1= new VentanaRegistroTipo();
        vent1.setVisible(true);
    }//GEN-LAST:event_btnCrearTipoActionPerformed

    private void btnReportMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnReportMouseEntered
        btnReport.setBackground(new Color(143,27,48));
    }//GEN-LAST:event_btnReportMouseEntered

    private void btnReportMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnReportMouseExited
       btnReport.setBackground(new Color(64,0,17)); //[64,87,68]
    }//GEN-LAST:event_btnReportMouseExited

    private void btnReportActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReportActionPerformed
        
       VentanaElegirReporte elegirReporte = new VentanaElegirReporte();
       elegirReporte.setVisible(true);

    }//GEN-LAST:event_btnReportActionPerformed

    private void tableUnidadesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableUnidadesMouseClicked
         if (evt.getClickCount() == 2) { // Verifica que sea doble clic
            JTable target = (JTable)evt.getSource();
            int fila = tableUnidades.rowAtPoint(evt.getPoint());; // Obtiene la fila seleccionada
            
             conexionProductoAlmacen fun = new conexionProductoAlmacen();

            IdUnidad = fun.darIdUnidad(tableUnidades.getValueAt(fila, 0).toString());
           accionUnidad="guardar";
            VentanaRegistroUnidad Vent = new VentanaRegistroUnidad();
            Vent.setVisible(true);
        }
    }//GEN-LAST:event_tableUnidadesMouseClicked

    private void tableTiposMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableTiposMouseClicked
         if (evt.getClickCount() == 2) { // Verifica que sea doble clic
            JTable target = (JTable)evt.getSource();
            int fila = tableTipos.rowAtPoint(evt.getPoint());; // Obtiene la fila seleccionada
            
             conexionProductoAlmacen fun = new conexionProductoAlmacen();

            IdTipo = fun.darIdTipo(tableTipos.getValueAt(fila, 0).toString());
           accionUnidad="guardar";
            VentanaRegistroTipo Vent1 = new VentanaRegistroTipo();
            Vent1.setVisible(true);
        }
    }//GEN-LAST:event_tableTiposMouseClicked

    public void IniciarGrafico(){
        ArrayList<datosProductoAlmacen> datos = new ArrayList<datosProductoAlmacen>();
        conexionProductoAlmacen fun = new conexionProductoAlmacen();
        graficoInventario.crearGrafico("Gráfico Inventarios","Cantidad en Unidades");
        datos = fun.productosMayorCantidad();
        if (datos!=null){
            for(datosProductoAlmacen d: datos){
                    graficoInventario.addElement(d.getNombreProducto(),d.getCantidad());
                }
        } else {
            graficoInventario.addElement("No hay datos", 0);
        }
        
        
    
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCrear;
    private javax.swing.JButton btnCrearTipo;
    private javax.swing.JButton btnCrearUnd;
    private javax.swing.JButton btnReport;
    private CapaPresentacion.PaginaPrincipal.componentes.PieChart3DDemo graficoInventario;
    private CapaPresentacion.PaginaPrincipal.componentes.Header header1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPaneInvent;
    private javax.swing.JScrollPane jScrollPaneTipos;
    private javax.swing.JScrollPane jScrollPaneUnidad;
    private CapaPresentacion.PaginaPrincipal.swing.Table tableProductosEscasos;
    private CapaPresentacion.PaginaPrincipal.swing.Table tableTipos;
    private CapaPresentacion.PaginaPrincipal.swing.Table tableUnidades;
    // End of variables declaration//GEN-END:variables

     public void mostrarTablaProductos(String buscar){
         tableProductosEscasos.setDefaultEditor(Object.class, null);
         
        try{
            DefaultTableModel modelo;
            conexionProductoAlmacen fun= new conexionProductoAlmacen();
            modelo = fun.mostrarTablaProductosEscasos(buscar);
            tableProductosEscasos.setModel(modelo);

        } catch(Exception e){
            JOptionPane.showConfirmDialog(null,e.getMessage());
        }
        
    }
     
     public void mostrarUnidades(String buscar){
         tableUnidades.setDefaultEditor(Object.class, null);
         
        try{
            DefaultTableModel modelo;
            conexionProductoAlmacen fun= new conexionProductoAlmacen();
            modelo = fun.mostrarTablaUnidades(buscar);
            tableUnidades.setModel(modelo);

        } catch(Exception e){
            JOptionPane.showConfirmDialog(null,e.getMessage());
        }
        
    }
     
     
     public void mostrarTipos(String buscar){
         tableTipos.setDefaultEditor(Object.class, null);
         
        try{
            DefaultTableModel modelo;
            conexionProductoAlmacen fun= new conexionProductoAlmacen();
            modelo = fun.mostrarTablaTipos(buscar);
            tableTipos.setModel(modelo);

        } catch(Exception e){
            JOptionPane.showConfirmDialog(null,e.getMessage());
        }
        
    }




}
