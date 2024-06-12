
package CapaPresentacion.PaginaPrincipal.Ventanas;

//@author KENNY

import CapaDatos.Almacen.datosProductoAlmacen;
import CapaLogica.Almacen.conexionProductoAlmacen;
import CapaPresentacion.PaginaPrincipal.Ventanas.VentanasProductos.VentanaRegistroTraspasoAlmacenTienda;
import static CapaPresentacion.PaginaPrincipal.Ventanas.VentanasProductos.VentanaRegistroTraspasoAlmacenTienda.RegistrarTraspaso;
import static CapaPresentacion.PaginaPrincipal.Ventanas.VentanasProductos.VentanaTraspasoProductos.ProductosEnEspera;
import CapaPresentacion.PaginaPrincipal.Ventanas.VentanasProductos.VentanaTraspasoProductos;
import CapaPresentacion.PaginaPrincipal.Ventanas.VentanasProductos.Ventana_Productos_Registro;
import CapaDatos.TraspasoAlmacenTienda.datosDetalleTraspasoTienda;

import CapaPresentacion.PaginaPrincipal.model.EstadoTipo;
import CapaPresentacion.PaginaPrincipal.model.Model_Card;

import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import CapaPresentacion.PaginaPrincipal.swing.ScrollBar;
import java.awt.Component;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
 
public class Ventana_Principal extends javax.swing.JPanel {

    public static String acciones="crear";
    public static String idProducto = "";
    String text;
    JTextField textFiel;
    JLabel logos;
    JLabel logoBuscador;
    JLabel logoMenu;
    VentanaRegistroTraspasoAlmacenTienda aTienda = new VentanaRegistroTraspasoAlmacenTienda();
    
    public Ventana_Principal() {
        initComponents();
        StyleTable();
        mostrarTablaProductoAlmacenes("");
        IniciarBusqueda();
        IniciarTarget();
        
        
       
        cards2.setDatos(new Model_Card(new ImageIcon(getClass().getResource("/CapaPresentacion/PaginaPrincipal/iconos/profit.png")),"Caja General","$20000",""));
        cards3.setDatos(new Model_Card(new ImageIcon(getClass().getResource("/CapaPresentacion/PaginaPrincipal/iconos/flag.png")),"Caja Chica","$20000",""));
       
       
       
    }

    
     public void StyleTable(){
        ScrollPanelTableInventario.setVerticalScrollBar(new ScrollBar());
        ScrollPanelTableInventario.getVerticalScrollBar().setBackground(Color.WHITE);
        ScrollPanelTableInventario.getViewport().setBackground(Color.WHITE);//esto es para que cuando no haya datos suficientes para tener scroll todo el panel se vea blanco
        JPanel p= new JPanel();
        p.setBackground(Color.WHITE);
        ScrollPanelTableInventario.setCorner(ScrollPanelTableInventario.UPPER_RIGHT_CORNER, p);
        
         ScrollPanelTableInventario.setVerticalScrollBar(new ScrollBar());
        ScrollPanelTableInventario.getVerticalScrollBar().setBackground(Color.WHITE);
        ScrollPanelTableInventario.getViewport().setBackground(Color.WHITE);//esto es para que cuando no haya datos suficientes para tener scroll todo el panel se vea blanco
        JPanel pp= new JPanel();
        pp.setBackground(Color.WHITE);
        ScrollPanelTableInventario.setCorner(ScrollPanelTableInventario.UPPER_RIGHT_CORNER, pp);
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
     
     
      public void IniciarTarget(){
        conexionProductoAlmacen fun = new conexionProductoAlmacen();
        int n = fun.totalCantidad();
        cards1.setDatos(new Model_Card(new ImageIcon(getClass().getResource("/CapaPresentacion/PaginaPrincipal/iconos/stock.png")),"Stock Total",Integer.toString(n)+" Productos",""));
    
    }
     
     
     
     
     public void mostrarTablaProductoAlmacenes(String buscar){
         tableInventario.setDefaultEditor(Object.class, null);
        try{
            DefaultTableModel modelo;
            conexionProductoAlmacen fun= new conexionProductoAlmacen();
            modelo = fun.mostrarTablaProductoAlmacen(buscar);
            tableInventario.setModel(modelo);
            
        } catch(Exception e){
            JOptionPane.showConfirmDialog(null,e.getMessage());
        }
        
    }
    
     
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelContainerCards = new javax.swing.JLayeredPane();
        cards2 = new CapaPresentacion.PaginaPrincipal.componentes.Cards();
        cards3 = new CapaPresentacion.PaginaPrincipal.componentes.Cards();
        cards1 = new CapaPresentacion.PaginaPrincipal.componentes.Cards();
        panelBorder1 = new CapaPresentacion.PaginaPrincipal.swing.PanelBorder();
        jLabel1 = new javax.swing.JLabel();
        ScrollPanelTableInventario = new javax.swing.JScrollPane();
        tableInventario = new CapaPresentacion.PaginaPrincipal.swing.Table();
        btnEnviarTienda = new javax.swing.JButton();
        header1 = new CapaPresentacion.PaginaPrincipal.componentes.Header();

        setBackground(new java.awt.Color(242, 242, 242));

        panelContainerCards.setLayout(new java.awt.GridLayout(1, 0, 15, 0));

        cards2.setColor1(new java.awt.Color(20, 44, 44));
        cards2.setColor2(new java.awt.Color(224, 226, 226));
        panelContainerCards.add(cards2);

        cards3.setColor1(new java.awt.Color(76, 83, 101));
        cards3.setColor2(new java.awt.Color(245, 245, 245));
        panelContainerCards.add(cards3);

        cards1.setColor1(new java.awt.Color(6, 57, 112));
        cards1.setColor2(new java.awt.Color(224, 240, 240));
        panelContainerCards.add(cards1);

        panelBorder1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Roboto Black", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(127, 127, 127));
        jLabel1.setText("Inventario Resumen");

        ScrollPanelTableInventario.setBorder(null);

        tableInventario.setBackground(new java.awt.Color(255, 255, 255));
        tableInventario.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tableInventario.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableInventarioMouseClicked(evt);
            }
        });
        ScrollPanelTableInventario.setViewportView(tableInventario);

        btnEnviarTienda.setBackground(new java.awt.Color(64, 0, 17));
        btnEnviarTienda.setFont(new java.awt.Font("Roboto Black", 1, 14)); // NOI18N
        btnEnviarTienda.setForeground(new java.awt.Color(255, 255, 255));
        btnEnviarTienda.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Files/IconoEnviarProductos.png"))); // NOI18N
        btnEnviarTienda.setText("Enviar Tienda");
        btnEnviarTienda.setBorder(null);
        btnEnviarTienda.setBorderPainted(false);
        btnEnviarTienda.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnEnviarTienda.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnEnviarTiendaMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnEnviarTiendaMouseExited(evt);
            }
        });
        btnEnviarTienda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEnviarTiendaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelBorder1Layout = new javax.swing.GroupLayout(panelBorder1);
        panelBorder1.setLayout(panelBorder1Layout);
        panelBorder1Layout.setHorizontalGroup(
            panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBorder1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelBorder1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnEnviarTienda, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(ScrollPanelTableInventario))
                .addContainerGap())
        );
        panelBorder1Layout.setVerticalGroup(
            panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBorder1Layout.createSequentialGroup()
                .addGroup(panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelBorder1Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(jLabel1))
                    .addGroup(panelBorder1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btnEnviarTienda, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(ScrollPanelTableInventario, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(header1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panelBorder1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panelContainerCards, javax.swing.GroupLayout.DEFAULT_SIZE, 882, Short.MAX_VALUE))
                .addGap(20, 20, 20))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(header1, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33)
                .addComponent(panelContainerCards, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(50, 50, 50)
                .addComponent(panelBorder1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void tableInventarioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableInventarioMouseClicked
        if (evt.getClickCount() == 2) { // Verifica que sea doble clic
            JTable target = (JTable)evt.getSource();
            int fila = tableInventario.rowAtPoint(evt.getPoint());; // Obtiene la fila seleccionada
            
            idProducto = tableInventario.getValueAt(fila, 0).toString();
           acciones="guardar";
            Ventana_Productos_Registro VentProductos = new Ventana_Productos_Registro();
            VentProductos.setVisible(true);
        }
    }//GEN-LAST:event_tableInventarioMouseClicked

    private void btnEnviarTiendaMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEnviarTiendaMouseEntered
        btnEnviarTienda.setBackground(new Color(143,27,48));
    }//GEN-LAST:event_btnEnviarTiendaMouseEntered

    private void btnEnviarTiendaMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEnviarTiendaMouseExited
        btnEnviarTienda.setBackground(new Color(64,0,17)); //[64,87,68]
    }//GEN-LAST:event_btnEnviarTiendaMouseExited

    private void btnEnviarTiendaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEnviarTiendaActionPerformed
       aTienda.dispose();
       RegistrarTraspaso.dispose();
       ProductosEnEspera=new ArrayList<datosDetalleTraspasoTienda>();
        aTienda = new VentanaRegistroTraspasoAlmacenTienda();
        aTienda.setVisible(true);
       
    }//GEN-LAST:event_btnEnviarTiendaActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane ScrollPanelTableInventario;
    private javax.swing.JButton btnEnviarTienda;
    private CapaPresentacion.PaginaPrincipal.componentes.Cards cards1;
    private CapaPresentacion.PaginaPrincipal.componentes.Cards cards2;
    private CapaPresentacion.PaginaPrincipal.componentes.Cards cards3;
    private CapaPresentacion.PaginaPrincipal.componentes.Header header1;
    private javax.swing.JLabel jLabel1;
    private CapaPresentacion.PaginaPrincipal.swing.PanelBorder panelBorder1;
    private javax.swing.JLayeredPane panelContainerCards;
    private CapaPresentacion.PaginaPrincipal.swing.Table tableInventario;
    // End of variables declaration//GEN-END:variables

    private void logoBuscadorMouseClicked(java.awt.event.MouseEvent evt) {       //esto es para que cuando se presione la lupa, busque(queda innecesario con la funcion de abajo, pero por si acaso esta aqui)
        text=textFiel.getText();
        mostrarTablaProductoAlmacenes(text);
     
 
    } 
    
    private void textFielKeyReleased(java.awt.event.KeyEvent evt) { //esto es para que cada vez que escribamos una letra en el fuscador se actualice autpmaticamente la tabla
        text=textFiel.getText();
  
        mostrarTablaProductoAlmacenes(text);

    }
    


}
