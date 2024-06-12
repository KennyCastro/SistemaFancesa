
package CapaPresentacion.PaginaPrincipal.componentes;

import CapaPresentacion.PaginaPrincipal.swing.Rotator;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PiePlot3D;
import org.jfree.data.general.DefaultPieDataset;

import java.awt.Color;
import javax.swing.JPanel;
import org.jfree.chart.title.TextTitle;

public class PieChart3DDemo extends JPanel {

    JFreeChart chart;
    DefaultPieDataset data = new DefaultPieDataset();
    public PieChart3DDemo() {
        initComponents();
        
        

        
    }

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 570, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 440, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    public void addElement(String label, int value){
        data.setValue(label+" = "+value, value);
    }
    
    
    public void crearGrafico(String titulo, String subtitle) {        
 
        chart = ChartFactory.createPieChart3D(
                titulo, // chart title
                data, // data
                true, // include legend
                true,
                false
        );
       if(subtitle!=null){
           chart.addSubtitle(new TextTitle(subtitle));
       }
        
        
        
        chart.setBackgroundPaint(Color.ORANGE);//Color de fonde de la ventana
        chart.getTitle().setPaint(Color.blue); //Dar color al titulo

        PiePlot3D plot = (PiePlot3D) chart.getPlot();
        plot.setLabelBackgroundPaint(Color.ORANGE);//Color de las etiquetas
        plot.setForegroundAlpha(0.60f);//Color de el fondo del grafico
                
        //esto es lo que lo hace rotar
        Rotator rotator = new Rotator(plot);
        rotator.start();
        
        
        ChartPanel panel = new ChartPanel(chart, false);
        panel.setBounds(10, 20, 570, 440);
        add(panel);
        

        setVisible(true);
    }
    
    
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
