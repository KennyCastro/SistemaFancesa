
package CapaPresentacion.PaginaPrincipal.swing;

import CapaPresentacion.PaginaPrincipal.model.EstadoTipo;


public class CeldaEstado extends javax.swing.JPanel {

    public CeldaEstado(EstadoTipo tipo) {
        initComponents();
        estadoCelda.setTipo(tipo);
    }

  
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        estadoCelda = new CapaPresentacion.PaginaPrincipal.swing.TableEstado();

        setBackground(new java.awt.Color(255, 255, 255));

        estadoCelda.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        estadoCelda.setText("tableEstado1");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(estadoCelda, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(10, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addComponent(estadoCelda, javax.swing.GroupLayout.DEFAULT_SIZE, 24, Short.MAX_VALUE)
                .addGap(8, 8, 8))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private CapaPresentacion.PaginaPrincipal.swing.TableEstado estadoCelda;
    // End of variables declaration//GEN-END:variables
}
