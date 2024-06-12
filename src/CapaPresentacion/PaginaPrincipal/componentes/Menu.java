
package CapaPresentacion.PaginaPrincipal.componentes;

import CapaPresentacion.PaginaPrincipal.event.EventMenuSelected;
import CapaPresentacion.PaginaPrincipal.model.Model_Menu;
import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import javax.swing.JFrame;

public class Menu extends javax.swing.JPanel {

    private EventMenuSelected evento; //nos ayudará a cambiar de paginas (pestañas)
    
    public void addEventMenuSelected (EventMenuSelected evento) {
        this.evento = evento;
        listaMenu1.addEventMenuSelected(evento);
    }
    
    
    
    public Menu() {
        initComponents();
        setOpaque(false);
        listaMenu1.setOpaque(false);
        init();
    }

    private void init(){
        //listaMenu1.addItem(new Model_Menu("nombreDeLaImagen","TituloDelItemEnElMenu","tipoDeItem"));
        listaMenu1.addItem(new Model_Menu("1","Principal",Model_Menu.MenuTipo.MENU));
        listaMenu1.addItem(new Model_Menu("2","Inventarios",Model_Menu.MenuTipo.MENU));
        listaMenu1.addItem(new Model_Menu("3","Ventas",Model_Menu.MenuTipo.MENU));
        listaMenu1.addItem(new Model_Menu("4","Caja",Model_Menu.MenuTipo.MENU));
        listaMenu1.addItem(new Model_Menu("","",Model_Menu.MenuTipo.EMPTY));
        
        listaMenu1.addItem(new Model_Menu("5","Personal",Model_Menu.MenuTipo.TITLE));
        listaMenu1.addItem(new Model_Menu("","",Model_Menu.MenuTipo.EMPTY));
        listaMenu1.addItem(new Model_Menu("6","Personal Fancesa",Model_Menu.MenuTipo.MENU));
        listaMenu1.addItem(new Model_Menu("7","Personal Cocina",Model_Menu.MenuTipo.MENU));
        listaMenu1.addItem(new Model_Menu("8","Usuarios",Model_Menu.MenuTipo.MENU));
        listaMenu1.addItem(new Model_Menu("9","Salir",Model_Menu.MenuTipo.MENU));
        listaMenu1.addItem(new Model_Menu("","",Model_Menu.MenuTipo.EMPTY));
    }
    
    
    
    
  
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        listaMenu1 = new CapaPresentacion.PaginaPrincipal.swing.ListaMenu<>();
        panelMoving = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();

        setPreferredSize(new java.awt.Dimension(215, 456));

        panelMoving.setOpaque(false);

        jLabel1.setFont(new java.awt.Font("Roboto Black", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/CapaPresentacion/PaginaPrincipal/iconos/logo.png"))); // NOI18N
        jLabel1.setText("SISTEMA EMPRESA");

        javax.swing.GroupLayout panelMovingLayout = new javax.swing.GroupLayout(panelMoving);
        panelMoving.setLayout(panelMovingLayout);
        panelMovingLayout.setHorizontalGroup(
            panelMovingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 250, Short.MAX_VALUE)
        );
        panelMovingLayout.setVerticalGroup(
            panelMovingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelMovingLayout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 110, Short.MAX_VALUE)
                .addGap(1, 1, 1))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelMoving, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(listaMenu1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 250, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(panelMoving, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(498, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addGap(124, 124, 124)
                    .addComponent(listaMenu1, javax.swing.GroupLayout.DEFAULT_SIZE, 479, Short.MAX_VALUE)
                    .addContainerGap()))
        );
    }// </editor-fold>//GEN-END:initComponents


    @Override
    protected void paintChildren (Graphics grphics){
        Graphics2D g2= (Graphics2D) grphics;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        GradientPaint g=new GradientPaint(0, 0, Color.decode("#9a8478"), 0, getHeight(), Color.decode("#1e130c"));
        g2.setPaint(g);
        g2.fillRoundRect(0, 0, getWidth(), getHeight(), 15, 15 );
        g2.fillRect(getWidth()-20, 0, getWidth(), getHeight());
        super.paintChildren(grphics);
    }
    
    
    
    ///esto es para poder mover la ventana (ya que quitamos los botones de cerrar, minimizar y demas)
    private int x;
    private int y;
    public void initMoving(JFrame fram){
        panelMoving.addMouseListener(new MouseAdapter(){
            @Override
            public void mousePressed(MouseEvent e) {
                x= e.getX();
                y=e.getY();
            }
        });
        
        panelMoving.addMouseMotionListener(new MouseMotionAdapter(){
            @Override
            public void mouseDragged(MouseEvent e) {
                fram.setLocation(e.getXOnScreen()-x, e.getYOnScreen()-y);
            }
            
         });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private CapaPresentacion.PaginaPrincipal.swing.ListaMenu<String> listaMenu1;
    private javax.swing.JPanel panelMoving;
    // End of variables declaration//GEN-END:variables
}
