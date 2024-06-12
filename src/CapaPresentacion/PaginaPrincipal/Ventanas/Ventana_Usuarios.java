/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package CapaPresentacion.PaginaPrincipal.Ventanas;



import CapaDatos.Usuarios_Personal.datosUsuarios;
import CapaLogica.Conexion;
import CapaLogica.Usuarios_Personal.conexionUsuarios;
import CapaPresentacion.PaginaPrincipal.Ventanas.VentanasUsuarios.Ventana_PersonalCocina_Registro;
import CapaPresentacion.PaginaPrincipal.componentes.Header;

import CapaPresentacion.PaginaPrincipal.swing.Buscador;
import CapaPresentacion.PaginaPrincipal.swing.ScrollBar;
import java.awt.Color;
import java.awt.Component;
import java.awt.event.KeyEvent;
import java.io.InputStream;
import java.sql.Connection;
import java.text.DecimalFormat;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.AbstractButton;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;
import javax.swing.table.DefaultTableModel;
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
public class Ventana_Usuarios extends javax.swing.JPanel {
    private String rutaLogo="/Files/logoCafe.png";
    String text;
    JTextField textFiel;
    JLabel logos;
    JLabel logoBuscador;
    JLabel logoMenu;
    private String action = "crear";
    public Ventana_Usuarios() {
       
        initComponents();
        StyleTable();
        mostrarTablaPersona("");
        mostrarTablaUsuario("");
        generarID();
        inhabilitar();
        iniciarImagen();
        IniciarBusqueda();
        

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
    
    public void StyleTable(){
        ScrollPanelTableUser.setVerticalScrollBar(new ScrollBar());
        ScrollPanelTableUser.getVerticalScrollBar().setBackground(Color.WHITE);
        ScrollPanelTableUser.getViewport().setBackground(Color.WHITE);//esto es para que cuando no haya datos suficientes para tener scroll todo el panel se vea blanco
        JPanel p= new JPanel();
        p.setBackground(Color.WHITE);
        ScrollPanelTableUser.setCorner(ScrollPanelTableUser.UPPER_RIGHT_CORNER, p);
        
         ScrollPanelTablePersona.setVerticalScrollBar(new ScrollBar());
        ScrollPanelTablePersona.getVerticalScrollBar().setBackground(Color.WHITE);
        ScrollPanelTablePersona.getViewport().setBackground(Color.WHITE);//esto es para que cuando no haya datos suficientes para tener scroll todo el panel se vea blanco
        JPanel pp= new JPanel();
        pp.setBackground(Color.WHITE);
        ScrollPanelTablePersona.setCorner(ScrollPanelTableUser.UPPER_RIGHT_CORNER, pp);
    
    }
    
    
    
     public void mostrarTablaPersona(String buscar){
         tablePersona.setDefaultEditor(Object.class, null);
        try{
            DefaultTableModel modelo;
            conexionUsuarios fun= new conexionUsuarios();
            modelo = fun.mostrarTablaPersona(buscar);
            tablePersona.setModel(modelo);
            
        } catch(Exception e){
            JOptionPane.showConfirmDialog(null,e.getMessage());
        }
        
    }
    
     
     public void mostrarTablaUsuario(String buscar){
         tableUser.setDefaultEditor(Object.class, null);
        try{
            DefaultTableModel modelo;
            conexionUsuarios fun= new conexionUsuarios();
            modelo = fun.mostrarTablaUsuario(buscar);
            tableUser.setModel(modelo);
        } catch(Exception e){
            JOptionPane.showConfirmDialog(null,e.getMessage());
        }
    }
    
    
    
    
    
    
    
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnGroupUser = new javax.swing.ButtonGroup();
        header1 = new CapaPresentacion.PaginaPrincipal.componentes.Header();
        ScrollPanelTableUser = new javax.swing.JScrollPane();
        tableUser = new CapaPresentacion.PaginaPrincipal.swing.Table();
        cajaImagen = new javax.swing.JLabel();
        txtNombre = new javax.swing.JLabel();
        txtContraseña = new javax.swing.JLabel();
        txtEstado = new javax.swing.JLabel();
        jbtnActivoUs = new javax.swing.JRadioButton();
        btnCrearUsuario = new javax.swing.JButton();
        btnGuardarUsuario = new javax.swing.JButton();
        btnEliminarUsuario = new javax.swing.JButton();
        txtCI = new javax.swing.JLabel();
        txttitulo1 = new javax.swing.JLabel();
        ScrollPanelTablePersona = new javax.swing.JScrollPane();
        tablePersona = new CapaPresentacion.PaginaPrincipal.swing.Table();
        txttitulo2 = new javax.swing.JLabel();
        txtID = new javax.swing.JLabel();
        cajaID = new javax.swing.JTextField();
        cajaCI = new javax.swing.JTextField();
        cajaUsername = new javax.swing.JTextField();
        cajaPass = new javax.swing.JPasswordField();
        btnExportarUsuario = new javax.swing.JButton();

        setBackground(new java.awt.Color(242, 242, 242));

        tableUser.setBackground(new java.awt.Color(255, 255, 255));
        tableUser.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3"
            }
        ));
        tableUser.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableUserMouseClicked(evt);
            }
        });
        ScrollPanelTableUser.setViewportView(tableUser);

        cajaImagen.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Files/usuarios.png"))); // NOI18N

        txtNombre.setBackground(new java.awt.Color(243, 243, 243));
        txtNombre.setFont(new java.awt.Font("Roboto Light", 1, 14)); // NOI18N
        txtNombre.setForeground(new java.awt.Color(0, 0, 0));
        txtNombre.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        txtNombre.setText("  User Name:");

        txtContraseña.setBackground(new java.awt.Color(243, 243, 243));
        txtContraseña.setFont(new java.awt.Font("Roboto Light", 1, 14)); // NOI18N
        txtContraseña.setForeground(new java.awt.Color(0, 0, 0));
        txtContraseña.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        txtContraseña.setText("Contraseña:");

        txtEstado.setBackground(new java.awt.Color(243, 243, 243));
        txtEstado.setFont(new java.awt.Font("Roboto Light", 1, 14)); // NOI18N
        txtEstado.setForeground(new java.awt.Color(0, 0, 0));
        txtEstado.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtEstado.setText("Estado:");

        btnGroupUser.add(jbtnActivoUs);
        jbtnActivoUs.setFont(new java.awt.Font("Roboto Medium", 0, 12)); // NOI18N
        jbtnActivoUs.setForeground(new java.awt.Color(0, 0, 0));
        jbtnActivoUs.setSelected(true);
        jbtnActivoUs.setText("Activo");

        btnCrearUsuario.setBackground(new java.awt.Color(64, 0, 17));
        btnCrearUsuario.setFont(new java.awt.Font("Roboto Black", 1, 18)); // NOI18N
        btnCrearUsuario.setForeground(new java.awt.Color(255, 255, 255));
        btnCrearUsuario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Files/anadir-amigo.png"))); // NOI18N
        btnCrearUsuario.setText("Crear Usuario");
        btnCrearUsuario.setBorderPainted(false);
        btnCrearUsuario.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnCrearUsuario.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnCrearUsuarioMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnCrearUsuarioMouseExited(evt);
            }
        });
        btnCrearUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCrearUsuarioActionPerformed(evt);
            }
        });

        btnGuardarUsuario.setBackground(new java.awt.Color(64, 0, 17));
        btnGuardarUsuario.setFont(new java.awt.Font("Roboto Black", 1, 18)); // NOI18N
        btnGuardarUsuario.setForeground(new java.awt.Color(255, 255, 255));
        btnGuardarUsuario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Files/disquete.png"))); // NOI18N
        btnGuardarUsuario.setText("Guardar Usuario");
        btnGuardarUsuario.setBorderPainted(false);
        btnGuardarUsuario.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnGuardarUsuario.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnGuardarUsuarioMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnGuardarUsuarioMouseExited(evt);
            }
        });
        btnGuardarUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarUsuarioActionPerformed(evt);
            }
        });

        btnEliminarUsuario.setBackground(new java.awt.Color(64, 0, 17));
        btnEliminarUsuario.setFont(new java.awt.Font("Roboto Black", 1, 18)); // NOI18N
        btnEliminarUsuario.setForeground(new java.awt.Color(255, 255, 255));
        btnEliminarUsuario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Files/despedido.png"))); // NOI18N
        btnEliminarUsuario.setText("Eliminar Usuario");
        btnEliminarUsuario.setBorderPainted(false);
        btnEliminarUsuario.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnEliminarUsuario.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnEliminarUsuarioMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnEliminarUsuarioMouseExited(evt);
            }
        });
        btnEliminarUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarUsuarioActionPerformed(evt);
            }
        });

        txtCI.setBackground(new java.awt.Color(243, 243, 243));
        txtCI.setFont(new java.awt.Font("Roboto Light", 1, 14)); // NOI18N
        txtCI.setForeground(new java.awt.Color(0, 0, 0));
        txtCI.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        txtCI.setText("CI:");

        txttitulo1.setBackground(new java.awt.Color(243, 243, 243));
        txttitulo1.setFont(new java.awt.Font("Roboto Light", 1, 18)); // NOI18N
        txttitulo1.setForeground(new java.awt.Color(0, 0, 0));
        txttitulo1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txttitulo1.setText("Lista De usuarios");

        tablePersona.setBackground(new java.awt.Color(255, 255, 255));
        tablePersona.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3"
            }
        ));
        tablePersona.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablePersonaMouseClicked(evt);
            }
        });
        ScrollPanelTablePersona.setViewportView(tablePersona);

        txttitulo2.setBackground(new java.awt.Color(243, 243, 243));
        txttitulo2.setFont(new java.awt.Font("Roboto Light", 1, 18)); // NOI18N
        txttitulo2.setForeground(new java.awt.Color(0, 0, 0));
        txttitulo2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txttitulo2.setText("Lista De personas");

        txtID.setBackground(new java.awt.Color(243, 243, 243));
        txtID.setFont(new java.awt.Font("Roboto Light", 1, 14)); // NOI18N
        txtID.setForeground(new java.awt.Color(0, 0, 0));
        txtID.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        txtID.setText("ID:");

        btnExportarUsuario.setBackground(new java.awt.Color(64, 0, 17));
        btnExportarUsuario.setFont(new java.awt.Font("Roboto Black", 1, 18)); // NOI18N
        btnExportarUsuario.setForeground(new java.awt.Color(255, 255, 255));
        btnExportarUsuario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Files/exportar.png"))); // NOI18N
        btnExportarUsuario.setText("Exportar Usuarios");
        btnExportarUsuario.setBorderPainted(false);
        btnExportarUsuario.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnExportarUsuario.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnExportarUsuarioMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnExportarUsuarioMouseExited(evt);
            }
        });
        btnExportarUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExportarUsuarioActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(header1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(44, 44, 44)
                                .addComponent(ScrollPanelTableUser, javax.swing.GroupLayout.PREFERRED_SIZE, 338, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(btnGuardarUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 231, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnEliminarUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 231, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnCrearUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 231, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnExportarUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 231, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(49, 49, 49)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(80, 80, 80)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(txtNombre, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(txtContraseña, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(txtCI, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(18, 18, 18)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(cajaCI)
                                            .addComponent(cajaUsername)
                                            .addComponent(cajaPass)))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                        .addComponent(txtID, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(cajaID))))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txttitulo2, javax.swing.GroupLayout.PREFERRED_SIZE, 231, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(txtEstado, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(jbtnActivoUs)))
                                .addGap(19, 19, 19)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cajaImagen, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(402, Short.MAX_VALUE)
                        .addComponent(ScrollPanelTablePersona, javax.swing.GroupLayout.PREFERRED_SIZE, 520, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(42, 42, 42))
            .addGroup(layout.createSequentialGroup()
                .addGap(87, 87, 87)
                .addComponent(txttitulo1, javax.swing.GroupLayout.PREFERRED_SIZE, 231, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(header1, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtID)
                            .addComponent(cajaID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txtCI)
                                    .addComponent(cajaCI, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txtNombre)
                                    .addComponent(cajaUsername, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txtContraseña)
                                    .addComponent(cajaPass, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(2, 2, 2)
                                .addComponent(cajaImagen, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtEstado)
                            .addComponent(jbtnActivoUs))
                        .addGap(18, 18, 18)
                        .addComponent(txttitulo2)
                        .addGap(38, 38, 38))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(txttitulo1)
                        .addGap(18, 18, 18)
                        .addComponent(ScrollPanelTableUser, javax.swing.GroupLayout.PREFERRED_SIZE, 234, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(ScrollPanelTablePersona, javax.swing.GroupLayout.PREFERRED_SIZE, 283, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addComponent(btnCrearUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30)
                        .addComponent(btnGuardarUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30)
                        .addComponent(btnEliminarUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30)
                        .addComponent(btnExportarUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(47, 47, 47))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnCrearUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCrearUsuarioActionPerformed
        habilitar();
        action="guardar";
        limpiarCampos();
        generarID();
        
        
    }//GEN-LAST:event_btnCrearUsuarioActionPerformed

    private void btnGuardarUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarUsuarioActionPerformed
        if(cajaCI.getText().length()==0){
            JOptionPane.showConfirmDialog(null, "Ingrese Ci de la persona","VENTANA DE INFORMACIÓN", JOptionPane.CLOSED_OPTION, JOptionPane.INFORMATION_MESSAGE);
            cajaCI.requestFocus();
            return;
        }
        
        if(cajaUsername.getText().length()==0){
            JOptionPane.showConfirmDialog(null, "Ingrese nombre de usuario","VENTANA DE INFORMACIÓN", JOptionPane.CLOSED_OPTION, JOptionPane.INFORMATION_MESSAGE);
            cajaUsername.requestFocus();
            return;
        }
        String valorPass = new String(cajaPass.getPassword());
        if(valorPass.equals("")){
            JOptionPane.showConfirmDialog(null, "Ingrese contraseña","VENTANA DE INFORMACIÓN", JOptionPane.CLOSED_OPTION, JOptionPane.INFORMATION_MESSAGE);
            cajaPass.requestFocus();
            return;
        }
        
        datosUsuarios datos = new datosUsuarios();
        conexionUsuarios fun = new conexionUsuarios();
        
        datos.setIdUsuario(cajaID.getText());
        datos.setCiUs(cajaCI.getText());
        datos.setNomUsuario(cajaUsername.getText());
        datos.setPassUs(valorPass);
        
        /*Enumeration<AbstractButton> btnGrp = btnGroupUser.getElements();
                            String resultado = "";
                            while(btnGrp.hasMoreElements()){
                                JRadioButton btnAux = (JRadioButton)btnGrp.nextElement();
                                if(btnAux.isSelected()){
                                    resultado = btnAux.getText();
                                    break;
                                }
                            }
                            String res="A";
                            if(resultado=="Inactivo"){
                                res="X";
                            }*/
        String res="A";
         datos.setEstadoUs(res);
        
        if(fun.insertarUsuario(datos)){
                JOptionPane.showConfirmDialog(null, "Usuario Registrado","VENTANA DE INFORMACIÓN", JOptionPane.CLOSED_OPTION, JOptionPane.INFORMATION_MESSAGE);
                mostrarTablaUsuario("");
                
                limpiarCampos();
                inhabilitar();
         }
        else {
            //JOptionPane.showConfirmDialog(null, "No existe persona con ese CI","VENTANA DE INFORMACIÓN", JOptionPane.CLOSED_OPTION, JOptionPane.INFORMATION_MESSAGE);
            limpiarCampos();
            
        }
    }//GEN-LAST:event_btnGuardarUsuarioActionPerformed

    private void btnEliminarUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarUsuarioActionPerformed
        datosUsuarios datos = new datosUsuarios();
        conexionUsuarios fun = new conexionUsuarios();
       
            int confirmacion = JOptionPane.showConfirmDialog(null, "¿Desea eliminar al usuario?","Confirmar",2);
            if(confirmacion==0){
                    datos.setIdUsuario(cajaID.getText());
                    fun.eliminarDatos(datos);
                    JOptionPane.showConfirmDialog(null, "Usuario eliminado","VENTANA DE INFORMACIÓN", JOptionPane.CLOSED_OPTION, JOptionPane.INFORMATION_MESSAGE);
                    mostrarTablaUsuario("");
                    
                    limpiarCampos();
                    btnEliminarUsuario.setEnabled(false);
                }
        
      
    }//GEN-LAST:event_btnEliminarUsuarioActionPerformed

    private void tableUserMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableUserMouseClicked
        inhabilitar();
        int fila= tableUser.rowAtPoint(evt.getPoint());
        cajaID.setText(tableUser.getValueAt(fila,0).toString());
        cajaCI.setText(tableUser.getValueAt(fila, 3).toString());
        btnEliminarUsuario.setEnabled(true);
        btnCrearUsuario.setEnabled(true);
    }//GEN-LAST:event_tableUserMouseClicked

    private void btnExportarUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExportarUsuarioActionPerformed
        
        /*try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
            Logger.getLogger(Ventana_PersonalCocina_Registro.class.getName()).log(Level.SEVERE, null, ex);
        }*/
        
        //desde aqui es el reporte
        Map parametro = new HashMap();
        parametro.put("logos", this.getClass().getResourceAsStream(rutaLogo));

        
        try {
            Conexion SQL = new Conexion();
            Connection conect = SQL.conectar();
            InputStream ruta=getClass().getResourceAsStream("/Reportes/reporteUsuario.jrxml");
         
            JasperReport report= JasperCompileManager.compileReport(ruta);
            
            
            JasperPrint jprint = JasperFillManager.fillReport(report, parametro, conect);
            
            Integer paginas = jprint.getPages().size();
            
            if(paginas>0){
                JasperViewer view = new JasperViewer(jprint,false);
                JFrame dialog = new JFrame();
                dialog.setContentPane(view.getContentPane());
                
                dialog.setSize(view.getSize());
                dialog.setTitle("Reporte Usuario");
                
                dialog.setVisible(true);
            
            }
            
            
            
            
            
            
            
        } catch (JRException ex) {
            Logger.getLogger(Ventana_Personal_Cocina.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnExportarUsuarioActionPerformed

    private void btnCrearUsuarioMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCrearUsuarioMouseEntered
         btnCrearUsuario.setBackground(new Color(143,27,48));
    }//GEN-LAST:event_btnCrearUsuarioMouseEntered

    private void btnCrearUsuarioMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCrearUsuarioMouseExited
         btnCrearUsuario.setBackground(new Color(64,0,17));
    }//GEN-LAST:event_btnCrearUsuarioMouseExited

    private void btnGuardarUsuarioMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnGuardarUsuarioMouseEntered
         btnGuardarUsuario.setBackground(new Color(143,27,48));
    }//GEN-LAST:event_btnGuardarUsuarioMouseEntered

    private void btnGuardarUsuarioMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnGuardarUsuarioMouseExited
        btnGuardarUsuario.setBackground(new Color(64,0,17));
    }//GEN-LAST:event_btnGuardarUsuarioMouseExited

    private void btnEliminarUsuarioMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEliminarUsuarioMouseEntered
        btnEliminarUsuario.setBackground(new Color(143,27,48));
    }//GEN-LAST:event_btnEliminarUsuarioMouseEntered

    private void btnEliminarUsuarioMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEliminarUsuarioMouseExited
        btnEliminarUsuario.setBackground(new Color(64,0,17));
    }//GEN-LAST:event_btnEliminarUsuarioMouseExited

    private void btnExportarUsuarioMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnExportarUsuarioMouseEntered
       btnExportarUsuario.setBackground(new Color(143,27,48));
    }//GEN-LAST:event_btnExportarUsuarioMouseEntered

    private void btnExportarUsuarioMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnExportarUsuarioMouseExited
        btnExportarUsuario.setBackground(new Color(64,0,17));
    }//GEN-LAST:event_btnExportarUsuarioMouseExited

    private void tablePersonaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablePersonaMouseClicked

        JTable target = (JTable)evt.getSource();
        int fila = tablePersona.rowAtPoint(evt.getPoint());
        cajaCI.setText(tablePersona.getValueAt(fila,4).toString());
    }//GEN-LAST:event_tablePersonaMouseClicked

 
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane ScrollPanelTablePersona;
    private javax.swing.JScrollPane ScrollPanelTableUser;
    private javax.swing.JButton btnCrearUsuario;
    private javax.swing.JButton btnEliminarUsuario;
    private javax.swing.JButton btnExportarUsuario;
    private javax.swing.ButtonGroup btnGroupUser;
    private javax.swing.JButton btnGuardarUsuario;
    private javax.swing.JTextField cajaCI;
    private javax.swing.JTextField cajaID;
    private javax.swing.JLabel cajaImagen;
    private javax.swing.JPasswordField cajaPass;
    private javax.swing.JTextField cajaUsername;
    private CapaPresentacion.PaginaPrincipal.componentes.Header header1;
    private javax.swing.JRadioButton jbtnActivoUs;
    private CapaPresentacion.PaginaPrincipal.swing.Table tablePersona;
    private CapaPresentacion.PaginaPrincipal.swing.Table tableUser;
    private javax.swing.JLabel txtCI;
    private javax.swing.JLabel txtContraseña;
    private javax.swing.JLabel txtEstado;
    private javax.swing.JLabel txtID;
    private javax.swing.JLabel txtNombre;
    private javax.swing.JLabel txttitulo1;
    private javax.swing.JLabel txttitulo2;
    // End of variables declaration//GEN-END:variables
    

    public void inhabilitar(){
        cajaID.setEnabled(false);
        cajaCI.setEnabled(false);
        cajaUsername.setEnabled(false);
        cajaPass.setEnabled(false);
        
        btnGuardarUsuario.setEnabled(false);
        btnEliminarUsuario.setEnabled(false);
       
    }
    
    public void habilitar(){
        cajaCI.setEnabled(true);
        cajaUsername.setEnabled(true);
        cajaPass.setEnabled(true);
        btnCrearUsuario.setEnabled(false);
        btnGuardarUsuario.setEnabled(true);
        btnExportarUsuario.setEnabled(true);
        
    }

    private void generarID(){
        conexionUsuarios fun= new conexionUsuarios();
        DecimalFormat formato = new DecimalFormat("0000");
        cajaID.setText(formato.format(fun.generarIdUsuario()));
        
       
    }
    
    private void limpiarCampos(){
        cajaCI.setText("");
        cajaUsername.setText("");
        cajaPass.setText("");
        
    }
    
    public void iniciarImagen(){
          ImageIcon image = new ImageIcon(getClass().getResource("/Files/usuarios.png"));
         Icon icono = new ImageIcon(image.getImage().getScaledInstance(120, 120, 0));
        cajaImagen.setIcon(icono);
    
    }
    
     
    
    private void logoBuscadorMouseClicked(java.awt.event.MouseEvent evt) {       //esto es para que cuando se presione la lupa, busque(queda innecesario con la funcion de abajo, pero por si acaso esta aqui)
        text=textFiel.getText();
        mostrarTablaUsuario(text);
        mostrarTablaPersona(text);
 
    } 
    
    private void textFielKeyReleased(java.awt.event.KeyEvent evt) { //esto es para que cada vez que escribamos una letra en el fuscador se actualice autpmaticamente la tabla
        text=textFiel.getText();
  
        mostrarTablaUsuario(text);
        mostrarTablaPersona(text);
    }
    
    
}
