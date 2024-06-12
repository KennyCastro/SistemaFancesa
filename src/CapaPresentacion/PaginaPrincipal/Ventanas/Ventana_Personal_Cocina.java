




package CapaPresentacion.PaginaPrincipal.Ventanas;

import CapaDatos.Usuarios_Personal.datosPersonalCocina;
import CapaLogica.Conexion;
import CapaLogica.Usuarios_Personal.conexionPersonalCocina;

import CapaPresentacion.PaginaPrincipal.Ventanas.VentanasUsuarios.Ventana_PersonalCocina_Registro;
import static CapaPresentacion.PaginaPrincipal.main.Principal.cocina;
import static CapaPresentacion.PaginaPrincipal.main.Principal.containerVentanas;
import static CapaPresentacion.PaginaPrincipal.main.Principal.users;
import CapaPresentacion.PaginaPrincipal.model.Model_Card;
import CapaPresentacion.PaginaPrincipal.swing.ScrollBar;

import java.awt.Color;
import java.awt.Component;
import java.io.InputStream;
import java.sql.Connection;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.AbstractButton;
import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
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
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;




public class Ventana_Personal_Cocina extends javax.swing.JPanel {

    String tipo="A";
    private String rutaLogo="/Files/logoCafe.png";
   String text;
    JTextField textFiel;
    JLabel logos;
    JLabel logoBuscador;
    JLabel logoMenu;
    
    public static String accion = "crear";
    
    public static String idBuscar = "";
    
    public Ventana_Personal_Cocina() {
        initComponents();
        StyleTable();
       IniciarTarget();
        mostrarTabla("",tipo);
        inhabilitar();
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
    
    
    
    
    
    public void StyleTable (){
        ScrollPanelTable.setVerticalScrollBar(new ScrollBar());
        ScrollPanelTable.getVerticalScrollBar().setBackground(Color.WHITE);
        ScrollPanelTable.getViewport().setBackground(Color.WHITE);//esto es para que cuando no haya datos suficientes para tener scroll todo el panel se vea blanco
        JPanel p= new JPanel();
        p.setBackground(Color.WHITE);
        ScrollPanelTable.setCorner(ScrollPanelTable.UPPER_RIGHT_CORNER, p);
    
    }
    
    public void IniciarTarget(){
        conexionPersonalCocina fun = new conexionPersonalCocina();
        int n = fun.countPersonalActivo();
        int m= fun.countPersonalInactivo();
        cards1.setDatos(new Model_Card(new ImageIcon(getClass().getResource("/Files/IconoCardPersonaCocina.png")),"Personal Total",Integer.toString(n),"Personal Inactivo: "+Integer.toString(m)));
    
    }
    public void mostrarTabla(String buscar, String tipo){
        table1.setDefaultEditor(Object.class, null);
        try{
            DefaultTableModel modelo;
            conexionPersonalCocina fun= new conexionPersonalCocina();
            modelo = fun.mostrarTablaPersonalCocina(buscar,tipo);
            table1.setModel(modelo);
        } catch(Exception e){
            JOptionPane.showConfirmDialog(null,e.getMessage());
        }
    }
    
    
   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        rdbtnGrupoPersonalActivo = new javax.swing.ButtonGroup();
        ScrollPanelTable = new javax.swing.JScrollPane();
        table1 = new CapaPresentacion.PaginaPrincipal.swing.Table();
        btnCrear = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        btnEditar = new javax.swing.JButton();
        btnExportar = new javax.swing.JButton();
        cards1 = new CapaPresentacion.PaginaPrincipal.componentes.Cards();
        cajaNombre = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        txtId = new javax.swing.JLabel();
        txtNombre = new javax.swing.JLabel();
        cajaCi = new javax.swing.JTextField();
        jSeparator2 = new javax.swing.JSeparator();
        txtCi = new javax.swing.JLabel();
        cajaApP = new javax.swing.JTextField();
        jSeparator3 = new javax.swing.JSeparator();
        txtApP = new javax.swing.JLabel();
        cajaId = new javax.swing.JTextField();
        jSeparator4 = new javax.swing.JSeparator();
        cajaApM = new javax.swing.JTextField();
        txtApM = new javax.swing.JLabel();
        jSeparator5 = new javax.swing.JSeparator();
        header1 = new CapaPresentacion.PaginaPrincipal.componentes.Header();
        jLabel1 = new javax.swing.JLabel();
        rdbtnPersonalActivo = new javax.swing.JRadioButton();
        rdbtnPersonalInactivo = new javax.swing.JRadioButton();

        setBackground(new java.awt.Color(242, 242, 242));
        setPreferredSize(new java.awt.Dimension(921, 640));

        table1.setBackground(new java.awt.Color(255, 255, 255));
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
        ));
        table1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                table1MouseClicked(evt);
            }
        });
        ScrollPanelTable.setViewportView(table1);

        btnCrear.setBackground(new java.awt.Color(64, 0, 17));
        btnCrear.setFont(new java.awt.Font("Roboto Black", 1, 14)); // NOI18N
        btnCrear.setForeground(new java.awt.Color(255, 255, 255));
        btnCrear.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Files/anadir-amigo.png"))); // NOI18N
        btnCrear.setText("Crear Personal");
        btnCrear.setBorder(null);
        btnCrear.setBorderPainted(false);
        btnCrear.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnCrear.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnCrearMouseClicked(evt);
            }
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

        btnEliminar.setBackground(new java.awt.Color(64, 0, 17));
        btnEliminar.setFont(new java.awt.Font("Roboto Black", 1, 14)); // NOI18N
        btnEliminar.setForeground(new java.awt.Color(255, 255, 255));
        btnEliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Files/borrar.png"))); // NOI18N
        btnEliminar.setText("Eliminar Personal");
        btnEliminar.setBorder(null);
        btnEliminar.setBorderPainted(false);
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

        btnEditar.setBackground(new java.awt.Color(64, 0, 17));
        btnEditar.setFont(new java.awt.Font("Roboto Black", 1, 14)); // NOI18N
        btnEditar.setForeground(new java.awt.Color(255, 255, 255));
        btnEditar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Files/lapiz.png"))); // NOI18N
        btnEditar.setText("Editar Personal");
        btnEditar.setBorder(null);
        btnEditar.setBorderPainted(false);
        btnEditar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnEditar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnEditarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnEditarMouseExited(evt);
            }
        });
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });

        btnExportar.setBackground(new java.awt.Color(64, 0, 17));
        btnExportar.setFont(new java.awt.Font("Roboto Black", 1, 14)); // NOI18N
        btnExportar.setForeground(new java.awt.Color(255, 255, 255));
        btnExportar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Files/eliminar-carpeta.png"))); // NOI18N
        btnExportar.setText("Exportar");
        btnExportar.setBorder(null);
        btnExportar.setBorderPainted(false);
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

        cards1.setColor1(new java.awt.Color(64, 0, 17));
        cards1.setColor2(new java.awt.Color(143, 27, 48));

        cajaNombre.setEditable(false);
        cajaNombre.setBackground(new java.awt.Color(243, 243, 243));
        cajaNombre.setFont(new java.awt.Font("Roboto Light", 2, 14)); // NOI18N
        cajaNombre.setForeground(new java.awt.Color(0, 0, 0));
        cajaNombre.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        cajaNombre.setBorder(null);
        cajaNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cajaNombreActionPerformed(evt);
            }
        });

        txtId.setBackground(new java.awt.Color(243, 243, 243));
        txtId.setFont(new java.awt.Font("Roboto Light", 1, 14)); // NOI18N
        txtId.setForeground(new java.awt.Color(0, 0, 0));
        txtId.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtId.setText("ID");

        txtNombre.setBackground(new java.awt.Color(243, 243, 243));
        txtNombre.setFont(new java.awt.Font("Roboto Light", 1, 14)); // NOI18N
        txtNombre.setForeground(new java.awt.Color(0, 0, 0));
        txtNombre.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtNombre.setText("Nombre");

        cajaCi.setEditable(false);
        cajaCi.setBackground(new java.awt.Color(243, 243, 243));
        cajaCi.setFont(new java.awt.Font("Roboto Light", 2, 14)); // NOI18N
        cajaCi.setForeground(new java.awt.Color(0, 0, 0));
        cajaCi.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        cajaCi.setBorder(null);
        cajaCi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cajaCiActionPerformed(evt);
            }
        });

        txtCi.setBackground(new java.awt.Color(243, 243, 243));
        txtCi.setFont(new java.awt.Font("Roboto Light", 1, 14)); // NOI18N
        txtCi.setForeground(new java.awt.Color(0, 0, 0));
        txtCi.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtCi.setText("CI");

        cajaApP.setEditable(false);
        cajaApP.setBackground(new java.awt.Color(243, 243, 243));
        cajaApP.setFont(new java.awt.Font("Roboto Light", 2, 14)); // NOI18N
        cajaApP.setForeground(new java.awt.Color(0, 0, 0));
        cajaApP.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        cajaApP.setBorder(null);
        cajaApP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cajaApPActionPerformed(evt);
            }
        });

        txtApP.setBackground(new java.awt.Color(243, 243, 243));
        txtApP.setFont(new java.awt.Font("Roboto Light", 1, 14)); // NOI18N
        txtApP.setForeground(new java.awt.Color(0, 0, 0));
        txtApP.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtApP.setText("Apellido Paterno");

        cajaId.setEditable(false);
        cajaId.setBackground(new java.awt.Color(243, 243, 243));
        cajaId.setFont(new java.awt.Font("Roboto Light", 2, 14)); // NOI18N
        cajaId.setForeground(new java.awt.Color(0, 0, 0));
        cajaId.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        cajaId.setBorder(null);
        cajaId.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cajaIdActionPerformed(evt);
            }
        });

        cajaApM.setEditable(false);
        cajaApM.setBackground(new java.awt.Color(243, 243, 243));
        cajaApM.setFont(new java.awt.Font("Roboto Light", 2, 14)); // NOI18N
        cajaApM.setForeground(new java.awt.Color(0, 0, 0));
        cajaApM.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        cajaApM.setToolTipText("");
        cajaApM.setBorder(null);
        cajaApM.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cajaApMActionPerformed(evt);
            }
        });

        txtApM.setBackground(new java.awt.Color(243, 243, 243));
        txtApM.setFont(new java.awt.Font("Roboto Light", 1, 14)); // NOI18N
        txtApM.setForeground(new java.awt.Color(0, 0, 0));
        txtApM.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtApM.setText("Apellido Materno");

        jLabel1.setFont(new java.awt.Font("Roboto Black", 0, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setText("Mostrar Personal:");

        rdbtnGrupoPersonalActivo.add(rdbtnPersonalActivo);
        rdbtnPersonalActivo.setFont(new java.awt.Font("Roboto Black", 0, 12)); // NOI18N
        rdbtnPersonalActivo.setForeground(new java.awt.Color(0, 0, 0));
        rdbtnPersonalActivo.setSelected(true);
        rdbtnPersonalActivo.setText("Activo");
        rdbtnPersonalActivo.setContentAreaFilled(false);
        rdbtnPersonalActivo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdbtnPersonalActivoActionPerformed(evt);
            }
        });

        rdbtnGrupoPersonalActivo.add(rdbtnPersonalInactivo);
        rdbtnPersonalInactivo.setFont(new java.awt.Font("Roboto Black", 0, 12)); // NOI18N
        rdbtnPersonalInactivo.setForeground(new java.awt.Color(0, 0, 0));
        rdbtnPersonalInactivo.setText("Inactivo");
        rdbtnPersonalInactivo.setContentAreaFilled(false);
        rdbtnPersonalInactivo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdbtnPersonalInactivoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(72, 72, 72)
                        .addComponent(btnCrear, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(48, 48, 48)
                        .addComponent(btnEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(48, 48, 48)
                        .addComponent(btnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(48, 48, 48)
                        .addComponent(btnExportar, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(45, 45, 45)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(ScrollPanelTable, javax.swing.GroupLayout.PREFERRED_SIZE, 884, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(cards1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(20, 20, 20)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(18, 18, 18)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addGap(25, 25, 25)
                                                .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addGap(33, 33, 33)
                                                .addComponent(txtApP, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(63, 63, 63)
                                                .addComponent(txtApM, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(layout.createSequentialGroup()
                                                .addGap(18, 18, 18)
                                                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(jSeparator5, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(109, 109, 109)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                    .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(cajaId, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGap(75, 75, 75)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(jSeparator3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(cajaCi, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                            .addGroup(layout.createSequentialGroup()
                                                .addGap(19, 19, 19)
                                                .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(110, 110, 110)
                                                .addComponent(txtCi, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(cajaNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(cajaApP, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(cajaApM, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(rdbtnPersonalActivo)
                                .addGap(18, 18, 18)
                                .addComponent(rdbtnPersonalInactivo)))))
                .addGap(20, 20, 20))
            .addComponent(header1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(header1, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(cards1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtNombre)
                            .addComponent(txtApP)
                            .addComponent(txtApM))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cajaNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cajaApP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cajaApM, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jSeparator5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtCi)
                            .addComponent(txtId))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cajaCi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cajaId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(8, 8, 8)
                                .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(40, 40, 40)
                .addComponent(ScrollPanelTable, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rdbtnPersonalActivo)
                    .addComponent(rdbtnPersonalInactivo))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCrear, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnExportar, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void cajaNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cajaNombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cajaNombreActionPerformed

    private void btnExportarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExportarActionPerformed
        
       
        Map parametro = new HashMap();
        parametro.put("logos", this.getClass().getResourceAsStream(rutaLogo));
        
        Object seleccion = JOptionPane.showInputDialog(null, "¿Qué reporte desea realizar?","Reporte Persona",JOptionPane.QUESTION_MESSAGE,null,new Object[]{"Datos Persona","Pagos"},"Datos Persona");
          if(seleccion!=null) {
          try {
                        Conexion SQL = new Conexion();
                        Connection conect = SQL.conectar();
                         InputStream ruta=getClass().getResourceAsStream("/Reportes/ReportePersonaCocina.jrxml");
                         if(seleccion.equals("Datos Persona")){
                             parametro.put("EstadoPersona",tipo);
                             
                         } else if(seleccion.equals("Pagos")){
                             parametro.put("estado", tipo);
                            ruta=getClass().getResourceAsStream("/Reportes/ReportePagoPersonaGrupal.jrxml");
                         
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
                            dialog.setTitle("Reporte Personal");

                            dialog.setVisible(true);

                        }
                           //view.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
                           // view.setVisible(true);

                        } catch (JRException ex) {
                            Logger.getLogger(Ventana_Personal_Cocina.class.getName()).log(Level.SEVERE, null, ex);
                        }
          }
         
    }//GEN-LAST:event_btnExportarActionPerformed

    private void btnCrearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCrearActionPerformed
       //aqui abrir la ventana de creacion o edicion del personal
       Ventana_PersonalCocina_Registro crearRegistro = new Ventana_PersonalCocina_Registro();
       accion="crear";
       crearRegistro.setVisible(true);
    }//GEN-LAST:event_btnCrearActionPerformed

    private void cajaCiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cajaCiActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cajaCiActionPerformed

    private void cajaApPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cajaApPActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cajaApPActionPerformed

    private void cajaIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cajaIdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cajaIdActionPerformed

    private void cajaApMActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cajaApMActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cajaApMActionPerformed

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
          idBuscar = cajaId.getText();
          accion="guardar";
         
         Ventana_PersonalCocina_Registro editarRegistro = new Ventana_PersonalCocina_Registro();
         editarRegistro.setVisible(true);
         
    }//GEN-LAST:event_btnEditarActionPerformed

    private void btnCrearMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCrearMouseEntered
        btnCrear.setBackground(new Color(143,27,48));
        
        
    }//GEN-LAST:event_btnCrearMouseEntered

    private void btnCrearMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCrearMouseExited
        btnCrear.setBackground(new Color(64,0,17)); //[64,87,68]
    }//GEN-LAST:event_btnCrearMouseExited

    private void btnEditarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEditarMouseEntered
        btnEditar.setBackground(new Color(143,27,48));
    }//GEN-LAST:event_btnEditarMouseEntered

    private void btnEditarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEditarMouseExited
        btnEditar.setBackground(new Color(64,0,17));
    }//GEN-LAST:event_btnEditarMouseExited

    private void btnEliminarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEliminarMouseEntered
        btnEliminar.setBackground(new Color(143,27,48));
    }//GEN-LAST:event_btnEliminarMouseEntered

    private void btnEliminarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEliminarMouseExited
        btnEliminar.setBackground(new Color(64,0,17));
    }//GEN-LAST:event_btnEliminarMouseExited

    private void btnExportarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnExportarMouseEntered
        btnExportar.setBackground(new Color(143,27,48));
    }//GEN-LAST:event_btnExportarMouseEntered

    private void btnExportarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnExportarMouseExited
        btnExportar.setBackground(new Color(64,0,17));
    }//GEN-LAST:event_btnExportarMouseExited

    private void table1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_table1MouseClicked
        habilitar();
        int fila= table1.rowAtPoint(evt.getPoint());
        cajaNombre.setText(table1.getValueAt(fila,1).toString());
        cajaApP.setText(table1.getValueAt(fila, 2).toString());
        cajaApM.setText(table1.getValueAt(fila, 3).toString());
        cajaId.setText(table1.getValueAt(fila, 0).toString());
        cajaCi.setText(table1.getValueAt(fila, 4).toString());
 
    }//GEN-LAST:event_table1MouseClicked

    private void btnCrearMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCrearMouseClicked
      
    }//GEN-LAST:event_btnCrearMouseClicked

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        datosPersonalCocina datos = new datosPersonalCocina();
        conexionPersonalCocina fun = new conexionPersonalCocina();
        if (fun.verificarRegistroExistente(cajaId.getText())==1){
            int confirmacion = JOptionPane.showConfirmDialog(null, "¿Desea eliminar a la persona?","Confirmar",2);
            if(confirmacion==0){
                    datos.setIdPersona(cajaId.getText());
                    fun.eliminarDatos(datos);
                    JOptionPane.showConfirmDialog(null, "Personal eliminado","Aceptar",2);
                    mostrarTabla("",tipo);
                }
                    users= new Ventana_Usuarios();
                    setForm(users);
                    cocina = new Ventana_Personal_Cocina();
                    setForm(cocina);
        }
        else {
             JOptionPane.showConfirmDialog(null, "No existe la persona","Aceptar",2);
        }
        
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void rdbtnPersonalActivoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdbtnPersonalActivoActionPerformed
         tipo="A";
        mostrarTabla("",tipo);
    }//GEN-LAST:event_rdbtnPersonalActivoActionPerformed

    private void rdbtnPersonalInactivoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdbtnPersonalInactivoActionPerformed
        tipo="X";
        mostrarTabla("",tipo);
    }//GEN-LAST:event_rdbtnPersonalInactivoActionPerformed

    
    private void setForm(JComponent com){
                   containerVentanas.removeAll();
                    containerVentanas.add(com); ///TENER CUIDADO CON ESTO O MODIFICARLO, REVISAR BIEN, ES PARA VOLVER A PINTAR LAS VENTANAS EN CASO DE MODIFICACIONES
                    containerVentanas.repaint();
                    containerVentanas.revalidate();
    
    }
    
    
    
    
   
    
    
    
    
   

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane ScrollPanelTable;
    private javax.swing.JButton btnCrear;
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnExportar;
    private javax.swing.JTextField cajaApM;
    private javax.swing.JTextField cajaApP;
    private javax.swing.JTextField cajaCi;
    private javax.swing.JTextField cajaId;
    private javax.swing.JTextField cajaNombre;
    private CapaPresentacion.PaginaPrincipal.componentes.Cards cards1;
    private CapaPresentacion.PaginaPrincipal.componentes.Header header1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.ButtonGroup rdbtnGrupoPersonalActivo;
    private javax.swing.JRadioButton rdbtnPersonalActivo;
    private javax.swing.JRadioButton rdbtnPersonalInactivo;
    private CapaPresentacion.PaginaPrincipal.swing.Table table1;
    private javax.swing.JLabel txtApM;
    private javax.swing.JLabel txtApP;
    private javax.swing.JLabel txtCi;
    private javax.swing.JLabel txtId;
    private javax.swing.JLabel txtNombre;
    // End of variables declaration//GEN-END:variables
   
    public void inhabilitar(){
        btnEditar.setEnabled(false);
        btnEliminar.setEnabled(false);
    }
    
    public void habilitar(){
        btnEditar.setEnabled(true);
        btnEliminar.setEnabled(true);
    }
    
    
    private void logoBuscadorMouseClicked(java.awt.event.MouseEvent evt) {       //esto es para que cuando se presione la lupa, busque(queda innecesario con la funcion de abajo, pero por si acaso esta aqui)
        text=textFiel.getText();
        mostrarTabla(text,tipo);
        
    } 
    
    private void textFielKeyReleased(java.awt.event.KeyEvent evt) { //esto es para que cada vez que escribamos una letra en el fuscador se actualice autpmaticamente la tabla
        text=textFiel.getText();
        mostrarTabla(text,tipo);
    }
    
}



