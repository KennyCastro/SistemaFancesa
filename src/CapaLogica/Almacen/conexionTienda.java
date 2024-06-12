/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CapaLogica.Almacen;

import CapaDatos.Almacen.datosTienda;
import CapaLogica.Conexion;
import java.sql.Connection;
import java.sql.*;
import java.util.ArrayList;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class conexionTienda {
     private Conexion SQL = new Conexion();
    private Connection conect = SQL.conectar();
    private ArrayList<datosTienda> tienda = new ArrayList<datosTienda>();
    String sql="";
    
    
     public int generarIdTienda(){
            String sql = ("select max(idTienda) as id from Tienda");
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
     
     
      public DefaultTableModel mostrarTablaTienda (String buscar){
            DefaultTableModel modelo;
            String[]titulos={"ID","Nombre"};
            modelo = new DefaultTableModel(null,titulos);

            String[] registro = new String[2];

             sql= ("select * from fun_mostrarTienda('"+buscar+"')");

            try {

                Statement st = conect.createStatement();

                ResultSet rs = st.executeQuery(sql);

                while(rs.next()){
                    registro[0] = rs.getString(1);
                    registro[1] = rs.getString(2);
                    modelo.addRow(registro);
                }

                return modelo;

            } catch(Exception e) {
                JOptionPane.showConfirmDialog(null, e.getMessage(),"HUBO UN ERROR INTENTE DE NUEVO", JOptionPane.CLOSED_OPTION, JOptionPane.INFORMATION_MESSAGE);
                return null;
            }
      }
     
     
     
     
       public boolean registrarDatos(datosTienda datos){

                sql= ("call pa_guardarTienda(?,?)");
                 try (PreparedStatement pst = conect.prepareStatement(sql)) {
                pst.setString(1, datos.getIdTienda());
                pst.setString(2, datos.getNombreTienda());

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
       
       
        public boolean editarDatos(datosTienda datos){

                sql= ("call pa_editarTienda(?,?)");
                 try (PreparedStatement pst = conect.prepareStatement(sql)) {
                    pst.setString(1, datos.getIdTienda());
                    pst.setString(2, datos.getNombreTienda());

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
        
        
        
        public boolean eliminarDatos(datosTienda datos){
            sql="call pa_eliminarTienda(?)";

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
        
        public int verificarRegistroExistente (String id){
        sql = ("select fun_existeRegistroTienda(?)");
        
      try {
          
            PreparedStatement pst = conect.prepareStatement(sql);
            pst.setString (1,id);
            ResultSet rs = pst.executeQuery();
            String existe="";
            while(rs.next()){
                existe=rs.getString(1);
            }
            return Integer.valueOf(existe);
      }
           catch(Exception e){
            JOptionPane.showConfirmDialog(null, e.getMessage(),"HUBO UN ERROR, INTENTE DE NUEVO", JOptionPane.CLOSED_OPTION, JOptionPane.INFORMATION_MESSAGE);
            return 0;
        }
    }
        
        
         public ComboBoxModel mostrarTienda() {
         DefaultComboBoxModel<String> model = new DefaultComboBoxModel<String>();
         
         

         ArrayList<datosTienda> tien = devolverListaTienda();


         try {
            
                
                for (datosTienda nombre : tien) {
                    model.addElement(nombre.getNombreTienda());
                }  

                return model;
            
            } catch(Exception e) {
                JOptionPane.showConfirmDialog(null, e.getMessage(),"HUBO UN ERROR INTENTE DE NUEVO", JOptionPane.CLOSED_OPTION, JOptionPane.INFORMATION_MESSAGE);
                return null;
            }
        }
       
       
       public ArrayList<datosTienda> devolverListaTienda (){

          sql="select * from tienda order by idtienda";
          tienda.clear();
            try {
            
                Statement st = conect.createStatement();

                ResultSet rs = st.executeQuery(sql);

                while(rs.next()){
                    tienda.add(new datosTienda(rs.getString(1),rs.getString(2)));

                }
                 return tienda;
            
            } catch(Exception e) {
                JOptionPane.showConfirmDialog(null, e.getMessage(),"HUBO UN ERROR INTENTE DE NUEVO", JOptionPane.CLOSED_OPTION, JOptionPane.INFORMATION_MESSAGE);
                return null;
            }

     }
       
       
        public String darIdTienda(String nombreTienda){
         sql="select * from tienda";
         try{
            Statement st = conect.createStatement();
            ResultSet rs = st.executeQuery(sql);
             while(rs.next()){
                 String tiendas = rs.getString(2);
                 if(tiendas.equals(nombreTienda)){
                     return rs.getString(1);
                 }
             }
             return "";
         
         } catch(Exception e){
            JOptionPane.showConfirmDialog(null, e.getMessage(),"HUBO UN ERROR, INTENTE DE NUEVO", JOptionPane.CLOSED_OPTION, JOptionPane.INFORMATION_MESSAGE);
            return "";
        }
     
     }
}
