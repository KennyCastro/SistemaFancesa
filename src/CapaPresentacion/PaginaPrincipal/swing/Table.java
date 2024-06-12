
package CapaPresentacion.PaginaPrincipal.swing;

import CapaPresentacion.PaginaPrincipal.model.EstadoTipo;
import java.awt.Color;
import java.awt.Component;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;


public class Table extends JTable{
    
    public Table(){
        setShowHorizontalLines(true);
        setGridColor(new Color (230,230,230));
        setRowHeight(40);//establecer alto de cada fila
        getTableHeader().setReorderingAllowed(false);
        getTableHeader().setDefaultRenderer(new DefaultTableCellRenderer(){
            //para renderizar que tabla queremos mostrar
            @Override
            public Component getTableCellRendererComponent(JTable table, Object ob, boolean isSelected, boolean hasFocus, int row, int column) {
                TableHeader header = new TableHeader(ob+"");
                if (column == 10) {
                    header.setHorizontalAlignment(JLabel.CENTER);
                }
                return header;
            }

        });
        
        
        setDefaultRenderer(Object.class, new DefaultTableCellRenderer(){
            @Override
            public Component getTableCellRendererComponent(JTable table, Object ob, boolean isSelected, boolean hasFocus, int row, int column) {
                if (column !=20) {
                    Component com = super.getTableCellRendererComponent(table, ob, isSelected, hasFocus, row, column);
                    com.setBackground(Color.WHITE);
                    //aqui cambiamos el color a la celda que hacemos clic en la tabla
                    setBorder(noFocusBorder);
                    
                    if (isSelected) {
                        com.setForeground(new Color(93,36,23));
                        com.setBackground(Color.PINK);
                    } else {
                        com.setForeground(new Color(0,0,0));
                        com.setBackground(Color.WHITE);
                    }
 
                    return com;
                }else{
                     EstadoTipo type = (EstadoTipo) ob;
                    CeldaEstado cell = new CeldaEstado(type);
                    return cell;
                   // return new JLabel ("Algo esta mal");
                }
                
            } 
            
         });
    }

    public Table(Object[][] object, String[] titulos) {
        DefaultTableModel model = (DefaultTableModel)getModel();
        model.setDataVector(object, titulos);
    }
    
    public void addRow(Object[] filas){
        DefaultTableModel model = (DefaultTableModel)getModel();
        model.addRow(filas);
    }

   
}
