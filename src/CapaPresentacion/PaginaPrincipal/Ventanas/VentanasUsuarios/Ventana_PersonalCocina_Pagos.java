/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package CapaPresentacion.PaginaPrincipal.Ventanas.VentanasUsuarios;

import CapaDatos.Usuarios_Personal.datosPagoPersonal;
import CapaDatos.Usuarios_Personal.datosPersonalCocina;
import CapaLogica.Conexion;
import CapaLogica.ExpresionesRegulares;
import CapaLogica.Usuarios_Personal.conexionPagoPersonal;
import CapaLogica.Usuarios_Personal.conexionPersonalCocina;
import CapaLogica.Usuarios_Personal.conexionUsuarios;
import static CapaPresentacion.PaginaPrincipal.Ventanas.Ventana_Personal_Cocina.idBuscar;
import static CapaPresentacion.PaginaPrincipal.Ventanas.VentanasUsuarios.Ventana_PersonalCocina_Registro.IdPersonaBuscar;
import CapaPresentacion.PaginaPrincipal.swing.ScrollBar;
import groovyjarjarasm.asm.tree.ParameterNode;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Enumeration;
import javax.swing.AbstractButton;
import javax.swing.ButtonModel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.io.InputStream;
import java.sql.Connection;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;

public class Ventana_PersonalCocina_Pagos extends javax.swing.JFrame {
    private String rutaLogo="/Files/logoCafe.png";
    int xMouse,  yMouse;
    String IDPersonaPago="";
    String tipo="X";
     ExpresionesRegulares expresiones= new ExpresionesRegulares();
     String IDPago="";
     String Acciones="crear";
     String PagoMess;
     String DescuentoMes;
     
     
    public Ventana_PersonalCocina_Pagos() {
        
        initComponents();
        centrarPantalla();
        StyleTable();
        IniciarId();
        mostrarTabla(IDPersonaPago,tipo);
        inhabilitar();
        
    }

    
    private void centrarPantalla() {
        Dimension tamanioVentana = getSize();
        Dimension tamanioPantalla = Toolkit.getDefaultToolkit().getScreenSize();
        int ejeX = (tamanioPantalla.width-tamanioVentana.width) / 2;
        int ejeY = (tamanioPantalla.height-tamanioVentana.height) / 2;
        
        setLocation(ejeX, ejeY);
    }
    
    public void StyleTable(){
       ScrollPaneTablePagos.setVerticalScrollBar(new ScrollBar());
        ScrollPaneTablePagos.getVerticalScrollBar().setBackground(Color.WHITE);
        ScrollPaneTablePagos.getViewport().setBackground(Color.WHITE);//esto es para que cuando no haya datos suficientes para tener scroll todo el panel se vea blanco
        JPanel p= new JPanel();
        p.setBackground(Color.WHITE);
        ScrollPaneTablePagos.setCorner(ScrollPaneTablePagos.UPPER_RIGHT_CORNER, p);
        
        ScrollPaneDescuentos.setVerticalScrollBar(new ScrollBar());
        ScrollPaneDescuentos.getVerticalScrollBar().setBackground(Color.WHITE);
        ScrollPaneDescuentos.getViewport().setBackground(Color.WHITE);//esto es para que cuando no haya datos suficientes para tener scroll todo el panel se vea blanco
        JPanel pp= new JPanel();
        pp.setBackground(Color.WHITE);
        ScrollPaneDescuentos.setCorner(ScrollPaneDescuentos.UPPER_RIGHT_CORNER, pp);
     }
    
    public void IniciarId(){
       conexionPersonalCocina fun = new conexionPersonalCocina();
       datosPersonalCocina registro = fun.devolverDatos(IdPersonaBuscar);
            if(registro!= null) {
                IDPersonaPago=IdPersonaBuscar;
                txtNombrePersona.setText(registro.getNombre()+" "+registro.getApellidoP()+" "+registro.getApellidoM());
            }
       IdPersonaBuscar="";
       
       
       
        cajaSueldo.addKeyListener(new java.awt.event.KeyAdapter() {
            @Override
            public void keyReleased(java.awt.event.KeyEvent evt) {
                cajaSueldoKeyReleased(evt);
            }
         });
        
        cajaDescuento.addKeyListener(new java.awt.event.KeyAdapter() {
            @Override
            public void keyReleased(java.awt.event.KeyEvent evt) {
                cajaDescuentoKeyReleased(evt);
            }
         });
       
       
       
    }
    
    private void  cajaSueldoKeyReleased(java.awt.event.KeyEvent evt) { //esto es para que cada vez que escribamos una letra en el fuscador se actualice autpmaticamente la tabla
         escucharSueldos();
    }
    
    private void  cajaDescuentoKeyReleased(java.awt.event.KeyEvent evt) { //esto es para que cada vez que escribamos una letra en el fuscador se actualice autpmaticamente la tabla
         escucharSueldos(); 
    }
    
    private void escucharSueldos(){
         PagoMess= cajaSueldo.getText();
         DescuentoMes= cajaDescuento.getText();
         if(expresiones.validarPrecio(PagoMess) && expresiones.validarPrecio(DescuentoMes)){
             cajaTotalMes.setText(String.valueOf(Integer.parseInt(PagoMess)-Integer.parseInt(DescuentoMes)));
         } else { 
             cajaTotalMes.setText("ERROR");
         } 
    }
    
    
    public void mostrarTabla(String buscar, String tipo){
         table1.setDefaultEditor(Object.class, null);
        try{
            DefaultTableModel modelo;
            conexionPagoPersonal fun= new conexionPagoPersonal();
            modelo = fun.mostrarTablaPagoPersona(buscar,tipo);
            table1.setModel(modelo);
            
            ArrayList<String> sumas = fun.SumarCantidades(IDPersonaPago, tipo);
            if(sumas.isEmpty()){
                cajaTotalMeses.setText("0");
                cajaTotalDescuento.setText("0");
                cajaTotalTotal.setText("0");
            } else {
                cajaTotalMeses.setText(sumas.get(0));
                cajaTotalDescuento.setText(sumas.get(1));
                cajaTotalTotal.setText(sumas.get(2));
            }
            
            
        } catch(Exception e){
            JOptionPane.showConfirmDialog(null,e.getMessage());
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnGroupEstado = new javax.swing.ButtonGroup();
        vent_Inicial1 = new CapaPresentacion.PaginaPrincipal.Ventanas.VentanasUsuarios.Vent_Inicial();
        headerVentana = new javax.swing.JPanel();
        btnExit = new javax.swing.JPanel();
        txtExit = new javax.swing.JLabel();
        txtNombrePersona = new javax.swing.JLabel();
        cajaMesPago = new javax.swing.JComboBox<>();
        cajaSueldo = new javax.swing.JTextField();
        cajaDescuento = new javax.swing.JTextField();
        ScrollPaneDescuentos = new javax.swing.JScrollPane();
        cajaDetalleDescuento = new javax.swing.JTextArea();
        txtNombrePersona1 = new javax.swing.JLabel();
        cajaTotalMes = new javax.swing.JTextField();
        ScrollPaneTablePagos = new javax.swing.JScrollPane();
        table1 = new CapaPresentacion.PaginaPrincipal.swing.Table();
        btnCrear = new javax.swing.JButton();
        btnGuardar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        btnExportar = new javax.swing.JButton();
        txtNombrePersona2 = new javax.swing.JLabel();
        cajaTotalMeses = new javax.swing.JTextField();
        txtNombrePersona3 = new javax.swing.JLabel();
        cajaTotalDescuento = new javax.swing.JTextField();
        txtNombrePersona4 = new javax.swing.JLabel();
        cajaTotalTotal = new javax.swing.JTextField();
        txtNombrePersona5 = new javax.swing.JLabel();
        txtNombrePersona6 = new javax.swing.JLabel();
        txtNombrePersona7 = new javax.swing.JLabel();
        btnRdPagado = new javax.swing.JRadioButton();
        btnRdNoPagado = new javax.swing.JRadioButton();
        cajaAnio = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        headerVentana.setOpaque(false);
        headerVentana.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                headerVentanaMouseDragged(evt);
            }
        });
        headerVentana.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                headerVentanaMousePressed(evt);
            }
        });

        btnExit.setOpaque(false);

        txtExit.setFont(new java.awt.Font("Roboto Black", 1, 24)); // NOI18N
        txtExit.setForeground(new java.awt.Color(255, 255, 255));
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
                .addComponent(txtExit, javax.swing.GroupLayout.DEFAULT_SIZE, 34, Short.MAX_VALUE)
                .addContainerGap())
        );
        btnExitLayout.setVerticalGroup(
            btnExitLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, btnExitLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtExit, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout headerVentanaLayout = new javax.swing.GroupLayout(headerVentana);
        headerVentana.setLayout(headerVentanaLayout);
        headerVentanaLayout.setHorizontalGroup(
            headerVentanaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, headerVentanaLayout.createSequentialGroup()
                .addContainerGap(861, Short.MAX_VALUE)
                .addComponent(btnExit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        headerVentanaLayout.setVerticalGroup(
            headerVentanaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(headerVentanaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnExit, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        txtNombrePersona.setFont(new java.awt.Font("Roboto Black", 1, 24)); // NOI18N
        txtNombrePersona.setForeground(new java.awt.Color(0, 0, 0));
        txtNombrePersona.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtNombrePersona.setText(".");

        cajaMesPago.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "ENERO", "FEBRERO", "MARZO", "ABRIL", "MAYO", "JUNIO", "JULIO", "AGOSTO", "SEPTIEMBRE", "OCTUBRE", "NOVIEMBRE", "DICIEMBRE" }));

        cajaSueldo.setFont(new java.awt.Font("Roboto Black", 1, 14)); // NOI18N

        cajaDescuento.setFont(new java.awt.Font("Roboto Black", 1, 14)); // NOI18N

        cajaDetalleDescuento.setColumns(20);
        cajaDetalleDescuento.setRows(5);
        ScrollPaneDescuentos.setViewportView(cajaDetalleDescuento);

        txtNombrePersona1.setFont(new java.awt.Font("Roboto Black", 1, 15)); // NOI18N
        txtNombrePersona1.setForeground(new java.awt.Color(0, 0, 0));
        txtNombrePersona1.setText("TOTAL SUELDO");

        cajaTotalMes.setEditable(false);
        cajaTotalMes.setFont(new java.awt.Font("Roboto Black", 0, 16)); // NOI18N
        cajaTotalMes.setForeground(new java.awt.Color(0, 0, 0));
        cajaTotalMes.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        cajaTotalMes.setBorder(null);
        cajaTotalMes.setOpaque(true);

        table1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
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
        table1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                table1MouseClicked(evt);
            }
        });
        ScrollPaneTablePagos.setViewportView(table1);

        btnCrear.setBackground(new java.awt.Color(204, 204, 204));
        btnCrear.setFont(new java.awt.Font("Roboto Black", 1, 18)); // NOI18N
        btnCrear.setForeground(new java.awt.Color(0, 0, 0));
        btnCrear.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Files/archivo-nuevo.png"))); // NOI18N
        btnCrear.setText("CREAR");
        btnCrear.setBorder(null);
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

        btnGuardar.setBackground(new java.awt.Color(204, 204, 204));
        btnGuardar.setFont(new java.awt.Font("Roboto Black", 1, 18)); // NOI18N
        btnGuardar.setForeground(new java.awt.Color(0, 0, 0));
        btnGuardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Files/disquete.png"))); // NOI18N
        btnGuardar.setText("GUARDAR");
        btnGuardar.setBorder(null);
        btnGuardar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnGuardar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnGuardarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnGuardarMouseExited(evt);
            }
        });
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

        btnEliminar.setBackground(new java.awt.Color(204, 204, 204));
        btnEliminar.setFont(new java.awt.Font("Roboto Black", 1, 18)); // NOI18N
        btnEliminar.setForeground(new java.awt.Color(0, 0, 0));
        btnEliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Files/eliminar-carpeta.png"))); // NOI18N
        btnEliminar.setText("ELIMINAR");
        btnEliminar.setBorder(null);
        btnEliminar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnEliminar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnEliminarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnEliminarMouseExited(evt);
            }
        });
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        btnExportar.setBackground(new java.awt.Color(204, 204, 204));
        btnExportar.setFont(new java.awt.Font("Roboto Black", 1, 18)); // NOI18N
        btnExportar.setForeground(new java.awt.Color(0, 0, 0));
        btnExportar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Files/exportar.png"))); // NOI18N
        btnExportar.setText("EXPORTAR");
        btnExportar.setBorder(null);
        btnExportar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnExportar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnExportarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnExportarMouseExited(evt);
            }
        });
        btnExportar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExportarActionPerformed(evt);
            }
        });

        txtNombrePersona2.setFont(new java.awt.Font("Roboto Black", 1, 15)); // NOI18N
        txtNombrePersona2.setForeground(new java.awt.Color(0, 0, 0));
        txtNombrePersona2.setText("TOTAL MES:");

        cajaTotalMeses.setEditable(false);
        cajaTotalMeses.setFont(new java.awt.Font("Roboto Black", 1, 24)); // NOI18N

        txtNombrePersona3.setFont(new java.awt.Font("Roboto Black", 1, 15)); // NOI18N
        txtNombrePersona3.setForeground(new java.awt.Color(0, 0, 0));
        txtNombrePersona3.setText("TOTAL DESCUENTO:");

        cajaTotalDescuento.setEditable(false);
        cajaTotalDescuento.setFont(new java.awt.Font("Roboto Black", 1, 24)); // NOI18N

        txtNombrePersona4.setFont(new java.awt.Font("Roboto Black", 1, 15)); // NOI18N
        txtNombrePersona4.setForeground(new java.awt.Color(0, 0, 0));
        txtNombrePersona4.setText("TOTAL:");

        cajaTotalTotal.setEditable(false);
        cajaTotalTotal.setFont(new java.awt.Font("Roboto Black", 1, 24)); // NOI18N

        txtNombrePersona5.setFont(new java.awt.Font("Roboto Black", 1, 15)); // NOI18N
        txtNombrePersona5.setForeground(new java.awt.Color(0, 0, 0));
        txtNombrePersona5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtNombrePersona5.setText("SUELDO");

        txtNombrePersona6.setFont(new java.awt.Font("Roboto Black", 1, 15)); // NOI18N
        txtNombrePersona6.setForeground(new java.awt.Color(0, 0, 0));
        txtNombrePersona6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtNombrePersona6.setText("DESCUENTO");

        txtNombrePersona7.setFont(new java.awt.Font("Roboto Black", 1, 15)); // NOI18N
        txtNombrePersona7.setForeground(new java.awt.Color(0, 0, 0));
        txtNombrePersona7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtNombrePersona7.setText("DETALLE DESCUENTO");

        btnGroupEstado.add(btnRdPagado);
        btnRdPagado.setFont(new java.awt.Font("Roboto Light", 1, 12)); // NOI18N
        btnRdPagado.setForeground(new java.awt.Color(0, 0, 0));
        btnRdPagado.setText("Pagado");
        btnRdPagado.setContentAreaFilled(false);
        btnRdPagado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRdPagadoActionPerformed(evt);
            }
        });

        btnGroupEstado.add(btnRdNoPagado);
        btnRdNoPagado.setFont(new java.awt.Font("Roboto Light", 1, 12)); // NOI18N
        btnRdNoPagado.setForeground(new java.awt.Color(0, 0, 0));
        btnRdNoPagado.setSelected(true);
        btnRdNoPagado.setText("No pagado");
        btnRdNoPagado.setContentAreaFilled(false);
        btnRdNoPagado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRdNoPagadoActionPerformed(evt);
            }
        });

        cajaAnio.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "2000", "2001", "2002", "2003", "2004", "2005", "2006", "2007", "2008", "2009", "2010", "2011", "2012", "2013", "2014", "2015", "2016", "2017", "2018", "2019", "2020", "2021", "2022", "2023", "2024", "2025", "2026", "2027", "2028", "2029", "2030", "2031", "2032", "2033", "2034", "2035", "2036", "2037", "2038", "2039", "2040", "2041", "2042", "2043", "2044", "2045", "2046", "2047", "2048", "2049", "2050", " ", " ", " " }));
        cajaAnio.setSelectedIndex(24);

        javax.swing.GroupLayout vent_Inicial1Layout = new javax.swing.GroupLayout(vent_Inicial1);
        vent_Inicial1.setLayout(vent_Inicial1Layout);
        vent_Inicial1Layout.setHorizontalGroup(
            vent_Inicial1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(headerVentana, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(vent_Inicial1Layout.createSequentialGroup()
                .addGap(51, 51, 51)
                .addGroup(vent_Inicial1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(vent_Inicial1Layout.createSequentialGroup()
                        .addComponent(txtNombrePersona2)
                        .addGap(18, 18, 18)
                        .addComponent(cajaTotalMeses, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(38, 38, 38)
                        .addComponent(txtNombrePersona3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cajaTotalDescuento, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(48, 48, 48)
                        .addComponent(txtNombrePersona4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cajaTotalTotal))
                    .addGroup(vent_Inicial1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(ScrollPaneTablePagos, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 811, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(vent_Inicial1Layout.createSequentialGroup()
                            .addGroup(vent_Inicial1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(vent_Inicial1Layout.createSequentialGroup()
                                    .addComponent(btnCrear, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(30, 30, 30)
                                    .addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 46, Short.MAX_VALUE)
                                    .addComponent(btnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(vent_Inicial1Layout.createSequentialGroup()
                                    .addGroup(vent_Inicial1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(vent_Inicial1Layout.createSequentialGroup()
                                            .addGroup(vent_Inicial1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                .addComponent(txtNombrePersona5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(cajaSueldo, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 120, Short.MAX_VALUE))
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addGroup(vent_Inicial1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                .addComponent(cajaDescuento)
                                                .addComponent(txtNombrePersona6, javax.swing.GroupLayout.DEFAULT_SIZE, 122, Short.MAX_VALUE))
                                            .addGap(0, 0, Short.MAX_VALUE))
                                        .addGroup(vent_Inicial1Layout.createSequentialGroup()
                                            .addComponent(cajaMesPago, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                            .addComponent(cajaAnio, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(0, 0, Short.MAX_VALUE)))
                                    .addGroup(vent_Inicial1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(ScrollPaneDescuentos, javax.swing.GroupLayout.DEFAULT_SIZE, 298, Short.MAX_VALUE)
                                        .addComponent(txtNombrePersona7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                            .addGroup(vent_Inicial1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(vent_Inicial1Layout.createSequentialGroup()
                                    .addGap(71, 71, 71)
                                    .addComponent(txtNombrePersona1))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, vent_Inicial1Layout.createSequentialGroup()
                                    .addGap(33, 33, 33)
                                    .addGroup(vent_Inicial1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addGroup(vent_Inicial1Layout.createSequentialGroup()
                                            .addComponent(btnRdPagado)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(btnRdNoPagado))
                                        .addGroup(vent_Inicial1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(btnExportar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(cajaTotalMes, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE))))))))
                .addContainerGap(45, Short.MAX_VALUE))
            .addGroup(vent_Inicial1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtNombrePersona, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        vent_Inicial1Layout.setVerticalGroup(
            vent_Inicial1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(vent_Inicial1Layout.createSequentialGroup()
                .addComponent(headerVentana, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtNombrePersona)
                .addGap(19, 19, 19)
                .addGroup(vent_Inicial1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, vent_Inicial1Layout.createSequentialGroup()
                        .addGroup(vent_Inicial1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtNombrePersona7)
                            .addComponent(txtNombrePersona1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(vent_Inicial1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(ScrollPaneDescuentos, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(vent_Inicial1Layout.createSequentialGroup()
                                .addComponent(cajaTotalMes, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addGroup(vent_Inicial1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(btnRdPagado)
                                    .addComponent(btnRdNoPagado)))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, vent_Inicial1Layout.createSequentialGroup()
                        .addGroup(vent_Inicial1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cajaMesPago, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cajaAnio, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(vent_Inicial1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtNombrePersona5)
                            .addComponent(txtNombrePersona6))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(vent_Inicial1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cajaDescuento, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cajaSueldo, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(vent_Inicial1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCrear, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnExportar, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addComponent(ScrollPaneTablePagos, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addGroup(vent_Inicial1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtNombrePersona2)
                    .addComponent(cajaTotalMeses, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNombrePersona3)
                    .addComponent(cajaTotalDescuento, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNombrePersona4)
                    .addComponent(cajaTotalTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(vent_Inicial1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(vent_Inicial1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 6, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtExitMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtExitMouseClicked
        //idBuscar="";
        dispose();
    }//GEN-LAST:event_txtExitMouseClicked

    private void txtExitMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtExitMouseEntered
        //btnExit.setBackground(Color.red);
        txtExit.setForeground(Color.RED);
    }//GEN-LAST:event_txtExitMouseEntered

    private void txtExitMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtExitMouseExited
        //btnExit.setBackground(Color.white);
        txtExit.setForeground(Color.WHITE);
    }//GEN-LAST:event_txtExitMouseExited

    private void headerVentanaMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_headerVentanaMouseDragged
        int x = evt.getXOnScreen();//esto captura en todo momento donde se encuentra la ventana
        int y = evt.getYOnScreen();
        // este evento es cuando arrastramos la ventana por la pantalla
        this.setLocation(x-xMouse,y- yMouse);
    }//GEN-LAST:event_headerVentanaMouseDragged

    private void headerVentanaMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_headerVentanaMousePressed
        xMouse = evt.getX(); //me da la posicion en el eje X de la ventana
        yMouse = evt.getY();//me da la posicion en el eje Y de la ventana
    }//GEN-LAST:event_headerVentanaMousePressed

    private void btnCrearMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCrearMouseEntered
        btnCrear.setBackground(new Color(33,33,33));
        btnCrear.setForeground(Color.WHITE);
    }//GEN-LAST:event_btnCrearMouseEntered

    private void btnCrearMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCrearMouseExited
        btnCrear.setBackground(new Color(204,204,204));
        btnCrear.setForeground(Color.BLACK);
    }//GEN-LAST:event_btnCrearMouseExited

    private void btnCrearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCrearActionPerformed
        habilitar();
        Acciones="crear";
        limpiarCampos();
        generarID();   
        btnCrear.setEnabled(false);

    }//GEN-LAST:event_btnCrearActionPerformed

    private void btnGuardarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnGuardarMouseEntered
         btnGuardar.setBackground(new Color(33,33,33));
        btnGuardar.setForeground(Color.WHITE);
    }//GEN-LAST:event_btnGuardarMouseEntered

    private void btnGuardarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnGuardarMouseExited
        btnGuardar.setBackground(new Color(204,204,204));
        btnGuardar.setForeground(Color.BLACK);
    }//GEN-LAST:event_btnGuardarMouseExited

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
      if(cajaSueldo.getText().length()==0) {//esta vacio
            JOptionPane.showConfirmDialog(null, "Ingrese sueldo del mes","VENTANA DE INFORMACIÓN", JOptionPane.CLOSED_OPTION, JOptionPane.INFORMATION_MESSAGE);
            cajaSueldo.requestFocus();
            return;
        }
        if(!expresiones.validarPrecio(cajaSueldo.getText())){
            JOptionPane.showConfirmDialog(null, "Ingrese un sueldo correcto","VENTANA DE INFORMACIÓN", JOptionPane.CLOSED_OPTION, JOptionPane.INFORMATION_MESSAGE);
            cajaSueldo.requestFocus();
            return;
        } 
        
        if(cajaDescuento.getText().length()==0) {//esta vacio
            cajaDescuento.setText("0");
            return;
        } else if(!expresiones.validarPrecio(cajaDescuento.getText())){
            JOptionPane.showConfirmDialog(null, "Ingrese un descuento correcto","VENTANA DE INFORMACIÓN", JOptionPane.CLOSED_OPTION, JOptionPane.INFORMATION_MESSAGE);
            cajaDescuento.requestFocus();
            return;
        } 
        
        datosPagoPersonal datos = new datosPagoPersonal();
        conexionPagoPersonal fun = new conexionPagoPersonal();
        
        
        datos.setIDPago(IDPago);
        datos.setIdPersona(IDPersonaPago);
        datos.setMesPago(cajaMesPago.getSelectedItem().toString());
        datos.setAnio(Integer.parseInt(cajaAnio.getSelectedItem().toString()));
        BigDecimal bd = new BigDecimal(cajaSueldo.getText());
        datos.setPago(bd);
        
        bd = new BigDecimal(cajaDescuento.getText());
        datos.setDescuento(bd);
        
        
        datos.setDetalleDecuento(cajaDetalleDescuento.getText());
        
         bd = new BigDecimal(cajaTotalMes.getText());
        datos.setTotal(bd);
        
        Enumeration<AbstractButton> btnGrp = btnGroupEstado.getElements();
                            String resultado = "";
                            while(btnGrp.hasMoreElements()){
                                JRadioButton btnAux = (JRadioButton)btnGrp.nextElement();
                                if(btnAux.isSelected()){
                                    resultado = btnAux.getText();
                                    break;
                                }
                            }
                            String res="A";
                            if(resultado=="No pagado"){
                                res="X";
                            }
              datos.setActivo(res);
         
          bd = new BigDecimal(cajaTotalMes.getText());    
         datos.setTotal(bd);
         
        if(Acciones == "crear"){
                 if(fun.insertarDatos(datos)){
                      JOptionPane.showConfirmDialog(null, "Pago registrado","VENTANA DE INFORMACIÓN", JOptionPane.CLOSED_OPTION, JOptionPane.INFORMATION_MESSAGE);
                      limpiarCampos();
                      mostrarTabla(IDPersonaPago, tipo);
                      inhabilitar();
                  }
              } else {
                
                  if(fun.editarDatos(datos)){
                      JOptionPane.showConfirmDialog(null, "Pago editado","VENTANA DE INFORMACIÓN", JOptionPane.CLOSED_OPTION, JOptionPane.INFORMATION_MESSAGE);
                        limpiarCampos();
                         mostrarTabla(IDPersonaPago, tipo);
                      inhabilitar();
                  }
                   
              }
        
        
        
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void btnEliminarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEliminarMouseEntered
        btnEliminar.setBackground(new Color(33,33,33));
        btnEliminar.setForeground(Color.WHITE);
    }//GEN-LAST:event_btnEliminarMouseEntered

    private void btnEliminarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEliminarMouseExited
        btnEliminar.setBackground(new Color(204,204,204));
        btnEliminar.setForeground(Color.BLACK);
    }//GEN-LAST:event_btnEliminarMouseExited

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        datosPagoPersonal datos = new datosPagoPersonal();
        conexionPagoPersonal fun = new conexionPagoPersonal();
            int confirmacion = JOptionPane.showConfirmDialog(rootPane, "Desea eliminar el pago?","Confirmar",2);
            if(confirmacion==0){
                    datos.setIDPago(IDPago);
                    fun.eliminarDatos(datos);
                    JOptionPane.showConfirmDialog(null, "Pago eliminado","VENTANA DE INFORMACIÓN", JOptionPane.CLOSED_OPTION, JOptionPane.INFORMATION_MESSAGE);
                    mostrarTabla(IDPersonaPago, tipo);
                    inhabilitar();
                    limpiarCampos();
                }
        
        
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnExportarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnExportarMouseEntered
        btnExportar.setBackground(new Color(33,33,33));
        btnExportar.setForeground(Color.WHITE);
    }//GEN-LAST:event_btnExportarMouseEntered

    private void btnExportarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnExportarMouseExited
        btnExportar.setBackground(new Color(204,204,204));
        btnExportar.setForeground(Color.BLACK);
    }//GEN-LAST:event_btnExportarMouseExited

    private void btnExportarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExportarActionPerformed
        Map parametro = new HashMap();
        parametro.put("logos", this.getClass().getResourceAsStream(rutaLogo));
        parametro.put("idPersona", IDPersonaPago);
        parametro.put("estado", tipo);
        parametro.put("nombre",txtNombrePersona.getText());
        parametro.put("TOTALMESS",cajaTotalMeses.getText());
        parametro.put("TOTALDESC",cajaTotalDescuento.getText());
        parametro.put("TOTAL",cajaTotalTotal.getText());

        
        try {
            Conexion SQL = new Conexion();
            Connection conect = SQL.conectar();
            InputStream ruta=getClass().getResourceAsStream("/Reportes/ReportePagoPersonaIndividual.jrxml");
         
            JasperReport report= JasperCompileManager.compileReport(ruta);
            
            
            JasperPrint jprint = JasperFillManager.fillReport(report, parametro, conect);
            
            Integer paginas = jprint.getPages().size();
            
            if(paginas>0){
                JasperViewer view = new JasperViewer(jprint,false);
                JFrame dialog = new JFrame();
                dialog.setContentPane(view.getContentPane());
                
                dialog.setSize(view.getSize());
                dialog.setTitle("Reporte Pago Individual");
                
                dialog.setVisible(true);
            
            }
            
            
            
            
            
            
            
        } catch (JRException ex) {
            Logger.getLogger(Ventana_PersonalCocina_Pagos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnExportarActionPerformed

    private void btnRdPagadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRdPagadoActionPerformed
        tipo="A";
        mostrarTabla(IDPersonaPago, tipo);
    }//GEN-LAST:event_btnRdPagadoActionPerformed

    private void btnRdNoPagadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRdNoPagadoActionPerformed
        tipo="X";
        mostrarTabla(IDPersonaPago, tipo);
    }//GEN-LAST:event_btnRdNoPagadoActionPerformed

    private void table1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_table1MouseClicked
         if (evt.getClickCount() == 2) { // Verifica que sea doble clic
            JTable target = (JTable)evt.getSource();
            int fila = table1.rowAtPoint(evt.getPoint());
            Acciones="guardar";
            
            conexionPagoPersonal fun = new conexionPagoPersonal();
            IDPago =  fun.DevolverId(IDPersonaPago,table1.getValueAt(fila,0).toString(), table1.getValueAt(fila,1).toString());
            
            cajaMesPago.setSelectedItem(table1.getValueAt(fila,0).toString());
            cajaAnio.setSelectedItem(table1.getValueAt(fila,1).toString());
            cajaSueldo.setText(table1.getValueAt(fila,2).toString());
            cajaDescuento.setText(table1.getValueAt(fila,3).toString());
            cajaDetalleDescuento.setText(table1.getValueAt(fila,4).toString());
            cajaTotalMes.setText(table1.getValueAt(fila,5).toString());
            
            habilitar();
            btnCrear.setEnabled(false);
            btnEliminar.setEnabled(true);
                    
         }
    }//GEN-LAST:event_table1MouseClicked

    
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
            java.util.logging.Logger.getLogger(Ventana_PersonalCocina_Pagos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Ventana_PersonalCocina_Pagos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Ventana_PersonalCocina_Pagos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Ventana_PersonalCocina_Pagos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Ventana_PersonalCocina_Pagos().setVisible(true);
            }
        });
    }
 
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane ScrollPaneDescuentos;
    private javax.swing.JScrollPane ScrollPaneTablePagos;
    private javax.swing.JButton btnCrear;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JPanel btnExit;
    private javax.swing.JButton btnExportar;
    private javax.swing.ButtonGroup btnGroupEstado;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JRadioButton btnRdNoPagado;
    private javax.swing.JRadioButton btnRdPagado;
    private javax.swing.JComboBox<String> cajaAnio;
    private javax.swing.JTextField cajaDescuento;
    private javax.swing.JTextArea cajaDetalleDescuento;
    private javax.swing.JComboBox<String> cajaMesPago;
    private javax.swing.JTextField cajaSueldo;
    private javax.swing.JTextField cajaTotalDescuento;
    private javax.swing.JTextField cajaTotalMes;
    private javax.swing.JTextField cajaTotalMeses;
    private javax.swing.JTextField cajaTotalTotal;
    private javax.swing.JPanel headerVentana;
    private CapaPresentacion.PaginaPrincipal.swing.Table table1;
    private javax.swing.JLabel txtExit;
    private javax.swing.JLabel txtNombrePersona;
    private javax.swing.JLabel txtNombrePersona1;
    private javax.swing.JLabel txtNombrePersona2;
    private javax.swing.JLabel txtNombrePersona3;
    private javax.swing.JLabel txtNombrePersona4;
    private javax.swing.JLabel txtNombrePersona5;
    private javax.swing.JLabel txtNombrePersona6;
    private javax.swing.JLabel txtNombrePersona7;
    private CapaPresentacion.PaginaPrincipal.Ventanas.VentanasUsuarios.Vent_Inicial vent_Inicial1;
    // End of variables declaration//GEN-END:variables

     public void habilitar(){
        cajaMesPago.setEnabled(true);
        cajaAnio.setEnabled(true);
        cajaSueldo.setEnabled(true);
        cajaDescuento.setEnabled(true);
        cajaDetalleDescuento.setEnabled(true); 
        btnGuardar.setEnabled(true);
        
    }
     
     public void inhabilitar(){
         Acciones="crear";
         cajaMesPago.setEnabled(false);
         cajaAnio.setEnabled(false);
        cajaSueldo.setEnabled(false);
        cajaDescuento.setEnabled(false);
        cajaDetalleDescuento.setEnabled(false); 
        cajaTotalDescuento.setEnabled(false);
        cajaTotalMes.setEnabled(false);
        cajaTotalMeses.setEnabled(false);
        cajaTotalTotal.setEnabled(false);
        btnCrear.setEnabled(true);
        btnGuardar.setEnabled(false);
        btnEliminar.setEnabled(false);
     
     }
     
     public void limpiarCampos(){
         cajaSueldo.setText("");
         cajaDescuento.setText("");
         cajaDetalleDescuento.setText("");
         cajaTotalMes.setText("");
     
     }
             
     
      private void generarID(){
        conexionPagoPersonal fun= new conexionPagoPersonal();
        DecimalFormat formato = new DecimalFormat("0000000");
        IDPago= formato.format(fun.generarIdPago());
        
       
    }
    
}
