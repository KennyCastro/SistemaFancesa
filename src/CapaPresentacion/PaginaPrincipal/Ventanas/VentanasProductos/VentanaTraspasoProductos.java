/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package CapaPresentacion.PaginaPrincipal.Ventanas.VentanasProductos;

import CapaDatos.Almacen.datosProductoAlmacen;
import CapaDatos.TraspasoAlmacenTienda.datosDetalleTraspasoTienda;
import CapaLogica.Almacen.conexionProductoAlmacen;
import CapaLogica.TraspasoAlmacenTienda.conexionDetalleTraspasoAlmacenTienda;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.Color;
import java.awt.Component;
import java.text.DecimalFormat;
import java.util.ArrayList;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import static CapaPresentacion.PaginaPrincipal.Ventanas.VentanasProductos.VentanaRegistroTraspasoAlmacenTienda.traspaso;

public class VentanaTraspasoProductos extends javax.swing.JFrame {

    int xMouse,  yMouse;
     String text;
    JTextField textFiel;
    JTextField textFiel1;
    JLabel logos;
    JLabel logoBuscador;
    JLabel logos1;
     JLabel logoBuscador1;
     String IdDetalleTraspaso="";
     
     public static ArrayList<datosDetalleTraspasoTienda> ProductosEnEspera = new ArrayList<datosDetalleTraspasoTienda>();
     
     
    
    public VentanaTraspasoProductos() {
        initComponents();
        centrarPantalla();
        Iniciar();
        IniciarBusqueda();
        mostrarTableAlmacen("");
        mostrarTableTienda("");
    }

    
     private void centrarPantalla() {
        Dimension tamanioVentana = getSize();
        Dimension tamanioPantalla = Toolkit.getDefaultToolkit().getScreenSize();
        int ejeX = (tamanioPantalla.width-tamanioVentana.width) / 2;
        int ejeY = (tamanioPantalla.height-tamanioVentana.height) / 2;
        
        setLocation(ejeX, ejeY);
    }
     
     private void Iniciar(){
         cajaIdProductoAlmacen.setEnabled(false);
         cajaProductoAlmacen.setEnabled(false);
         cajaIdProductoTienda.setEnabled(false);
         cajaProductoTienda.setEnabled(false);
         cajaUnidadProductoAlmacen.setEnabled(false);
         
     
     }
     
      private void generarID(){
        conexionDetalleTraspasoAlmacenTienda fun= new conexionDetalleTraspasoAlmacenTienda();
        DecimalFormat formato = new DecimalFormat("00000000");
        IdDetalleTraspaso=formato.format(fun.generarIdTienda());
    }

     
      public void IniciarBusqueda(){
          for (Component comp : buscadorAlmacen.getComponents()) {
            if (comp instanceof JTextField) {
                textFiel = (JTextField) comp;
            }
            else if(comp instanceof JLabel){
                logos = (JLabel) comp;
                if("logoSearch".equals(logos.getName())){
                    logoBuscador = logos;
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
        mostrarTableAlmacen(text);
    } 
    
    private void textFielKeyReleased(java.awt.event.KeyEvent evt) { //esto es para que cada vez que escribamos una letra en el fuscador se actualice autpmaticamente la tabla
        text=textFiel.getText();
         mostrarTableAlmacen(text);
    }
    
    
     
    
     
     
     public void mostrarTableAlmacen(String buscar){
         tableAlmacen.setDefaultEditor(Object.class, null);
        try{
            DefaultTableModel modelo;
            conexionProductoAlmacen fun= new conexionProductoAlmacen();
            modelo = fun.mostrarTablaAlmacen(buscar);
            tableAlmacen.setModel(modelo);
            
        } catch(Exception e){
            JOptionPane.showConfirmDialog(null,e.getMessage());
        }
        
    }
    
     
      public void mostrarTableTienda(String buscar){
         tableTienda.setDefaultEditor(Object.class, null);
        try{
            DefaultTableModel modelo;
            conexionProductoAlmacen fun= new conexionProductoAlmacen();
            modelo = fun.mostrarTablaTienda(buscar);
            tableTienda.setModel(modelo);
            
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
        buscadorAlmacen = new CapaPresentacion.PaginaPrincipal.componentes.Header();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableTienda = new CapaPresentacion.PaginaPrincipal.swing.Table();
        jScrollPane2 = new javax.swing.JScrollPane();
        tableAlmacen = new CapaPresentacion.PaginaPrincipal.swing.Table();
        buscadorTienda = new CapaPresentacion.PaginaPrincipal.componentes.Header();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtCantidadProductoAlmacen = new javax.swing.JLabel();
        cajaCantidadProductoAlmacen = new javax.swing.JTextField();
        txtProductoAlmacen = new javax.swing.JLabel();
        cajaProductoAlmacen = new javax.swing.JTextField();
        txtIdProductoAlmacen = new javax.swing.JLabel();
        cajaIdProductoAlmacen = new javax.swing.JTextField();
        txtUnidadProductoAlmacen = new javax.swing.JLabel();
        btnMandar = new javax.swing.JButton();
        btnEnviarTienda = new javax.swing.JButton();
        btnDevolver = new javax.swing.JButton();
        txtIdProductoTienda = new javax.swing.JLabel();
        cajaIdProductoTienda = new javax.swing.JTextField();
        txtProductoTienda = new javax.swing.JLabel();
        cajaProductoTienda = new javax.swing.JTextField();
        cajaUnidadProductoAlmacen = new javax.swing.JTextField();

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
            .addComponent(txtExit, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jLabel4.setBackground(new java.awt.Color(0, 0, 0));
        jLabel4.setFont(new java.awt.Font("Roboto Medium", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 0, 0));
        jLabel4.setText("Traspaso Productos a Tienda");

        javax.swing.GroupLayout HeaderLayout = new javax.swing.GroupLayout(Header);
        Header.setLayout(HeaderLayout);
        HeaderLayout.setHorizontalGroup(
            HeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, HeaderLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 266, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnExit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        HeaderLayout.setVerticalGroup(
            HeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnExit, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(HeaderLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, 32, Short.MAX_VALUE)
                .addContainerGap())
        );

        tableTienda.setBackground(new java.awt.Color(255, 255, 255));
        tableTienda.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tableTienda);

        tableAlmacen.setBackground(new java.awt.Color(255, 255, 255));
        tableAlmacen.setModel(new javax.swing.table.DefaultTableModel(
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
        tableAlmacen.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableAlmacenMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tableAlmacen);

        jLabel1.setFont(new java.awt.Font("Roboto Medium", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("PRODUCTOS EN ALMACEN");

        jLabel2.setFont(new java.awt.Font("Roboto Medium", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("PRODUCTOS EN TIENDA");

        txtCantidadProductoAlmacen.setFont(new java.awt.Font("Roboto Medium", 1, 18)); // NOI18N
        txtCantidadProductoAlmacen.setForeground(new java.awt.Color(255, 255, 255));
        txtCantidadProductoAlmacen.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtCantidadProductoAlmacen.setText("CANTIDAD:");

        cajaCantidadProductoAlmacen.setBackground(new java.awt.Color(255, 255, 255));
        cajaCantidadProductoAlmacen.setFont(new java.awt.Font("Roboto Medium", 1, 24)); // NOI18N
        cajaCantidadProductoAlmacen.setForeground(new java.awt.Color(0, 0, 0));

        txtProductoAlmacen.setFont(new java.awt.Font("Roboto Medium", 1, 18)); // NOI18N
        txtProductoAlmacen.setForeground(new java.awt.Color(255, 255, 255));
        txtProductoAlmacen.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtProductoAlmacen.setText("PRODUCTO:");

        cajaProductoAlmacen.setEditable(false);
        cajaProductoAlmacen.setBackground(new java.awt.Color(255, 255, 255));
        cajaProductoAlmacen.setFont(new java.awt.Font("Roboto Medium", 1, 14)); // NOI18N

        txtIdProductoAlmacen.setFont(new java.awt.Font("Roboto Medium", 1, 18)); // NOI18N
        txtIdProductoAlmacen.setForeground(new java.awt.Color(255, 255, 255));
        txtIdProductoAlmacen.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtIdProductoAlmacen.setText("ID:");

        cajaIdProductoAlmacen.setEditable(false);
        cajaIdProductoAlmacen.setBackground(new java.awt.Color(255, 255, 255));
        cajaIdProductoAlmacen.setFont(new java.awt.Font("Roboto Medium", 1, 14)); // NOI18N

        txtUnidadProductoAlmacen.setFont(new java.awt.Font("Roboto Medium", 1, 18)); // NOI18N
        txtUnidadProductoAlmacen.setForeground(new java.awt.Color(255, 255, 255));
        txtUnidadProductoAlmacen.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtUnidadProductoAlmacen.setText("UNIDADES:");

        btnMandar.setBackground(new java.awt.Color(0, 0, 0));
        btnMandar.setFont(new java.awt.Font("Segoe UI Semibold", 1, 48)); // NOI18N
        btnMandar.setForeground(new java.awt.Color(255, 255, 255));
        btnMandar.setText("→");
        btnMandar.setBorderPainted(false);
        btnMandar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnMandar.setFocusPainted(false);
        btnMandar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnMandarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnMandarMouseExited(evt);
            }
        });
        btnMandar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMandarActionPerformed(evt);
            }
        });

        btnEnviarTienda.setBackground(new java.awt.Color(0, 0, 0));
        btnEnviarTienda.setFont(new java.awt.Font("Roboto Black", 1, 18)); // NOI18N
        btnEnviarTienda.setForeground(new java.awt.Color(255, 255, 255));
        btnEnviarTienda.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Files/IconoEnviarProductos.png"))); // NOI18N
        btnEnviarTienda.setText("ENVIAR A TIENDA");
        btnEnviarTienda.setBorderPainted(false);
        btnEnviarTienda.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnEnviarTienda.setFocusPainted(false);
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

        btnDevolver.setBackground(new java.awt.Color(0, 0, 0));
        btnDevolver.setFont(new java.awt.Font("Segoe UI Semibold", 1, 48)); // NOI18N
        btnDevolver.setForeground(new java.awt.Color(255, 255, 255));
        btnDevolver.setText("←");
        btnDevolver.setBorderPainted(false);
        btnDevolver.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnDevolver.setFocusPainted(false);
        btnDevolver.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnDevolverMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnDevolverMouseExited(evt);
            }
        });
        btnDevolver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDevolverActionPerformed(evt);
            }
        });

        txtIdProductoTienda.setFont(new java.awt.Font("Roboto Medium", 1, 18)); // NOI18N
        txtIdProductoTienda.setForeground(new java.awt.Color(255, 255, 255));
        txtIdProductoTienda.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtIdProductoTienda.setText("ID:");

        cajaIdProductoTienda.setEditable(false);
        cajaIdProductoTienda.setBackground(new java.awt.Color(255, 255, 255));

        txtProductoTienda.setFont(new java.awt.Font("Roboto Medium", 1, 18)); // NOI18N
        txtProductoTienda.setForeground(new java.awt.Color(255, 255, 255));
        txtProductoTienda.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtProductoTienda.setText("PRODUCTO:");

        cajaProductoTienda.setEditable(false);
        cajaProductoTienda.setBackground(new java.awt.Color(255, 255, 255));

        cajaUnidadProductoAlmacen.setEditable(false);
        cajaUnidadProductoAlmacen.setBackground(new java.awt.Color(255, 255, 255));
        cajaUnidadProductoAlmacen.setFont(new java.awt.Font("Roboto Medium", 1, 14)); // NOI18N

        javax.swing.GroupLayout vent_Inicial_Productos1Layout = new javax.swing.GroupLayout(vent_Inicial_Productos1);
        vent_Inicial_Productos1.setLayout(vent_Inicial_Productos1Layout);
        vent_Inicial_Productos1Layout.setHorizontalGroup(
            vent_Inicial_Productos1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Header, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(vent_Inicial_Productos1Layout.createSequentialGroup()
                .addGroup(vent_Inicial_Productos1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(vent_Inicial_Productos1Layout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addGroup(vent_Inicial_Productos1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(buscadorAlmacen, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addGroup(vent_Inicial_Productos1Layout.createSequentialGroup()
                                .addGroup(vent_Inicial_Productos1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(txtIdProductoAlmacen)
                                    .addComponent(txtProductoAlmacen)
                                    .addComponent(txtCantidadProductoAlmacen, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtUnidadProductoAlmacen, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(29, 29, 29)
                                .addGroup(vent_Inicial_Productos1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(cajaCantidadProductoAlmacen)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, vent_Inicial_Productos1Layout.createSequentialGroup()
                                        .addGap(0, 0, Short.MAX_VALUE)
                                        .addComponent(cajaIdProductoAlmacen, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(cajaUnidadProductoAlmacen)))))
                    .addGroup(vent_Inicial_Productos1Layout.createSequentialGroup()
                        .addGap(164, 164, 164)
                        .addComponent(cajaProductoAlmacen)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(vent_Inicial_Productos1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnMandar, javax.swing.GroupLayout.DEFAULT_SIZE, 77, Short.MAX_VALUE)
                    .addComponent(btnDevolver, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(vent_Inicial_Productos1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, vent_Inicial_Productos1Layout.createSequentialGroup()
                        .addComponent(btnEnviarTienda, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(116, 116, 116))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, vent_Inicial_Productos1Layout.createSequentialGroup()
                        .addGroup(vent_Inicial_Productos1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(vent_Inicial_Productos1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(vent_Inicial_Productos1Layout.createSequentialGroup()
                                    .addGroup(vent_Inicial_Productos1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(txtIdProductoTienda)
                                        .addComponent(txtProductoTienda))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(cajaIdProductoTienda, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(vent_Inicial_Productos1Layout.createSequentialGroup()
                                    .addGap(133, 133, 133)
                                    .addComponent(cajaProductoTienda, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(vent_Inicial_Productos1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                                .addComponent(buscadorTienda, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 340, Short.MAX_VALUE)))
                        .addGap(62, 62, 62))))
        );
        vent_Inicial_Productos1Layout.setVerticalGroup(
            vent_Inicial_Productos1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(vent_Inicial_Productos1Layout.createSequentialGroup()
                .addComponent(Header, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 39, Short.MAX_VALUE)
                .addGroup(vent_Inicial_Productos1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(buscadorAlmacen, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buscadorTienda, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25)
                .addGroup(vent_Inicial_Productos1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addGroup(vent_Inicial_Productos1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(vent_Inicial_Productos1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(vent_Inicial_Productos1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 310, Short.MAX_VALUE)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)))
                    .addGroup(vent_Inicial_Productos1Layout.createSequentialGroup()
                        .addGap(122, 122, 122)
                        .addComponent(btnMandar, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnDevolver, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(vent_Inicial_Productos1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(vent_Inicial_Productos1Layout.createSequentialGroup()
                        .addGroup(vent_Inicial_Productos1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cajaIdProductoAlmacen, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtIdProductoAlmacen, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(vent_Inicial_Productos1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cajaProductoAlmacen, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtProductoAlmacen, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(11, 11, 11))
                    .addGroup(vent_Inicial_Productos1Layout.createSequentialGroup()
                        .addGroup(vent_Inicial_Productos1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cajaIdProductoTienda, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtIdProductoTienda, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(vent_Inicial_Productos1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cajaProductoTienda, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtProductoTienda, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addGroup(vent_Inicial_Productos1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(vent_Inicial_Productos1Layout.createSequentialGroup()
                        .addGroup(vent_Inicial_Productos1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtCantidadProductoAlmacen, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cajaCantidadProductoAlmacen, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(vent_Inicial_Productos1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtUnidadProductoAlmacen, javax.swing.GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE)
                            .addComponent(cajaUnidadProductoAlmacen, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(12, 12, 12))
                    .addGroup(vent_Inicial_Productos1Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(btnEnviarTienda, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(vent_Inicial_Productos1, javax.swing.GroupLayout.DEFAULT_SIZE, 862, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(vent_Inicial_Productos1, javax.swing.GroupLayout.DEFAULT_SIZE, 695, Short.MAX_VALUE)
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

    private void btnMandarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnMandarMouseEntered
        btnMandar.setBackground(new Color(255,255,255));
        btnMandar.setForeground(new Color(0,0,0));
    }//GEN-LAST:event_btnMandarMouseEntered

    private void btnMandarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnMandarMouseExited

        btnMandar.setBackground(new Color(0,0,0));
        btnMandar.setForeground(new Color(255,255,255));
    }//GEN-LAST:event_btnMandarMouseExited

    private void btnMandarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMandarActionPerformed
        
        /*datosProductoAlmacen datos = new datosProductoAlmacen();
         conexionProductoAlmacen fun = new conexionProductoAlmacen();
         
         datos = fun.devolverDatos(cajaIdProductoAlmacen.getText());
         datosDetalleTraspasoTienda aux = new datosDetalleTraspasoTienda(traspaso.getIdTraspaso(),"A",cajaIdProductoAlmacen.getText(),Integer.parseInt(cajaCantidadProductoAlmacen.getText()),cajaUnidadProductoAlmacen.getText());
         ProductosEnEspera.add(aux);
         
         mostrarTableTienda("");*/
    }//GEN-LAST:event_btnMandarActionPerformed

    private void btnEnviarTiendaMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEnviarTiendaMouseEntered
        btnEnviarTienda.setBackground(new Color(255,255,255));
        btnEnviarTienda.setForeground(new Color(0,0,0));
    }//GEN-LAST:event_btnEnviarTiendaMouseEntered

    private void btnEnviarTiendaMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEnviarTiendaMouseExited

        btnEnviarTienda.setBackground(new Color(0,0,0));
        btnEnviarTienda.setForeground(new Color(255,255,255));
    }//GEN-LAST:event_btnEnviarTiendaMouseExited

    private void btnEnviarTiendaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEnviarTiendaActionPerformed
         
        
        
    }//GEN-LAST:event_btnEnviarTiendaActionPerformed

    private void btnDevolverMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnDevolverMouseEntered
         btnDevolver.setBackground(new Color(255,255,255));
        btnDevolver.setForeground(new Color(0,0,0));
    }//GEN-LAST:event_btnDevolverMouseEntered

    private void btnDevolverMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnDevolverMouseExited
        btnDevolver.setBackground(new Color(0,0,0));
        btnDevolver.setForeground(new Color(255,255,255));
    }//GEN-LAST:event_btnDevolverMouseExited

    private void btnDevolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDevolverActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnDevolverActionPerformed

    private void tableAlmacenMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableAlmacenMouseClicked
         
            int fila = tableAlmacen.rowAtPoint(evt.getPoint());; // Obtiene la fila seleccionada
            
             conexionProductoAlmacen fun = new conexionProductoAlmacen();

            cajaIdProductoAlmacen.setText(tableAlmacen.getValueAt(fila, 0).toString());
            cajaProductoAlmacen.setText(tableAlmacen.getValueAt(fila, 1).toString());
            cajaUnidadProductoAlmacen.setText(tableAlmacen.getValueAt(fila, 3).toString());
    }//GEN-LAST:event_tableAlmacenMouseClicked

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
            java.util.logging.Logger.getLogger(VentanaTraspasoProductos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VentanaTraspasoProductos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VentanaTraspasoProductos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VentanaTraspasoProductos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VentanaTraspasoProductos().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Header;
    private javax.swing.JButton btnDevolver;
    private javax.swing.JButton btnEnviarTienda;
    private javax.swing.JPanel btnExit;
    private javax.swing.JButton btnMandar;
    private CapaPresentacion.PaginaPrincipal.componentes.Header buscadorAlmacen;
    private CapaPresentacion.PaginaPrincipal.componentes.Header buscadorTienda;
    private javax.swing.JTextField cajaCantidadProductoAlmacen;
    private javax.swing.JTextField cajaIdProductoAlmacen;
    private javax.swing.JTextField cajaIdProductoTienda;
    private javax.swing.JTextField cajaProductoAlmacen;
    private javax.swing.JTextField cajaProductoTienda;
    private javax.swing.JTextField cajaUnidadProductoAlmacen;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private CapaPresentacion.PaginaPrincipal.swing.Table tableAlmacen;
    private CapaPresentacion.PaginaPrincipal.swing.Table tableTienda;
    private javax.swing.JLabel txtCantidadProductoAlmacen;
    private javax.swing.JLabel txtExit;
    private javax.swing.JLabel txtIdProductoAlmacen;
    private javax.swing.JLabel txtIdProductoTienda;
    private javax.swing.JLabel txtProductoAlmacen;
    private javax.swing.JLabel txtProductoTienda;
    private javax.swing.JLabel txtUnidadProductoAlmacen;
    private CapaPresentacion.PaginaPrincipal.Ventanas.VentanasProductos.Vent_Inicial_Productos vent_Inicial_Productos1;
    // End of variables declaration//GEN-END:variables
}
