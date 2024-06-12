/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CapaLogica.TraspasoAlmacenTienda;

import CapaDatos.Almacen.datosTienda;
import CapaDatos.TraspasoAlmacenTienda.datosTraspasoAlmacenTienda;
import CapaLogica.Conexion;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.sql.*;
import java.util.ArrayList;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;

public class conexionTraspasoAlmacenTienda {
    
      private Conexion SQL = new Conexion();
    private Connection conect = SQL.conectar();
    String sql="";
    
    
     public int generarIdTraspaso(){
            String sql = ("select max(idTraspaso) as id from TraspasoAlmacenTienda");
            int siguienteID = 0;
            try{
                Statement st= conect.createStatement();
                ResultSet rs= st.executeQuery(sql);
                if(rs.next()){
                    siguienteID=rs.getInt("id")+1;
                }

            } catch(SQLException e){
                JOptionPane.showMessageDialog(null,"CONSULTE CON EL ADMINISTRADOR: Error SQL: "+e.getMessage());
            }
            return siguienteID;
    }
     
     
     public DefaultTableModel mostrarTablaTraspasoTienda (String buscar){
            DefaultTableModel modelo;
            String[]titulos={"ID","Tienda","Fecha Traspaso","Nombre Entregante","Apellido Entregante","Nombre Recepcionante","Apellido Recepcionante "};
            modelo = new DefaultTableModel(null,titulos);

            String[] registro = new String[7];

             sql= ("select * from fun_mostrarTraspasoAlmacenTienda('"+buscar+"')");

            try {

                Statement st = conect.createStatement();

                ResultSet rs = st.executeQuery(sql);

                while(rs.next()){
                    registro[0] = rs.getString(1);
                    registro[1] = rs.getString(2);
                    registro[2] = rs.getString(3);
                    registro[3] = rs.getString(4);
                    registro[4] = rs.getString(5);
                    registro[5] = rs.getString(6);
                    registro[6] = rs.getString(7);
                    modelo.addRow(registro);
                }

                return modelo;

            } catch(Exception e) {
                JOptionPane.showConfirmDialog(null, e.getMessage(),"HUBO UN ERROR INTENTE DE NUEVO", JOptionPane.CLOSED_OPTION, JOptionPane.INFORMATION_MESSAGE);
                return null;
            }
      }
    
    
     public boolean registrarDatos(datosTraspasoAlmacenTienda datos){

                sql= ("call pa_guardarTraspasoAlmacenTienda(?,?,?,?,?)");
                 try (PreparedStatement pst = conect.prepareStatement(sql)) {
                        pst.setString(1, datos.getIdTraspaso());
                        pst.setString(2, datos.getIdTienda());
                        pst.setDate(3, (Date)datos.getFechaTraspaso());
                       pst.setString(4, datos.getIdPersonaEntrega());
                       pst.setString(2, datos.getIdPersonaRecibe());


                        int n=-1;
                        n = pst.executeUpdate();
                        if(n!=-1)
                            return true;
                        else
                            return false;

            } catch(Exception e){
                JOptionPane.showConfirmDialog(null, e.getMessage(),"HUBO UN ERROR, INTENTE DE NUEVO", JOptionPane.CLOSED_OPTION, JOptionPane.INFORMATION_MESSAGE);
                return false;
            }
       }
     
     
     public boolean editarDatos(datosTraspasoAlmacenTienda datos){

                sql= ("call pa_editarTraspasoAlmacenTienda(?,?,?,?,?)");
                 try (PreparedStatement pst = conect.prepareStatement(sql)) {
                        pst.setString(1, datos.getIdTraspaso());
                        pst.setString(2, datos.getIdTienda());
                        pst.setDate(3, (Date)datos.getFechaTraspaso());
                       pst.setString(4, datos.getIdPersonaEntrega());
                       pst.setString(2, datos.getIdPersonaRecibe());


                        int n=-1;
                        n = pst.executeUpdate();
                        if(n!=-1)
                            return true;
                        else
                            return false;

            } catch(Exception e){
                JOptionPane.showConfirmDialog(null, e.getMessage(),"HUBO UN ERROR, INTENTE DE NUEVO", JOptionPane.CLOSED_OPTION, JOptionPane.INFORMATION_MESSAGE);
                return false;
            }
       }
    
      public boolean eliminarDatos(datosTraspasoAlmacenTienda datos){
            sql="call pa_eliminarTraspasoAlmacenTienda(?)";

            try{
                PreparedStatement pst = conect.prepareStatement(sql);

                pst.setString(1,datos.getIdTienda());
                int n = pst.executeUpdate();
                if(n!=0)
                    return true;
                else
                    return false;
            }
            catch(Exception e){
                JOptionPane.showConfirmDialog(null, e.getMessage(),"HUBO UN ERROR, INTENTE DE NUEVO", JOptionPane.CLOSED_OPTION, JOptionPane.INFORMATION_MESSAGE);
                return false;
            }
        }
      
      
      
    
}
