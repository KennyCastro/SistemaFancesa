/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CapaLogica.Almacen;

import CapaDatos.Almacen.datosTipoProducto;
import CapaLogica.Conexion;
import java.sql.Connection;
import java.sql.*;
import javax.swing.JOptionPane;

public class conexionTipoProducto {
     private Conexion SQL = new Conexion();
    private Connection conect = SQL.conectar();
    
    String sql="";
    
    public boolean registrarDatos(datosTipoProducto datos){

            sql= ("call pa_guardarTipoProducto(?,?)");
             try (PreparedStatement pst = conect.prepareStatement(sql)) {
            pst.setString(1, datos.getIdTipo());
            pst.setString(2, datos.getNombreTipo());

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
    
    
    public boolean editarDatos(datosTipoProducto datos){

            sql= ("call pa_editarTipoProducto(?,?)");
             try (PreparedStatement pst = conect.prepareStatement(sql)) {
                pst.setString(1, datos.getIdTipo());
                pst.setString(2, datos.getNombreTipo());

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
    
    
     public int verificarRegistroExistente (String id){
        sql = ("select fun_existeRegistroTipo(?)");
        
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
     
     
      public boolean eliminarDatos(datosTipoProducto datos){
        sql="call pa_eliminarTipoProducto(?)";
        
        try{
            PreparedStatement pst = conect.prepareStatement(sql);
            
            pst.setString(1,datos.getIdTipo());
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
      
      public int generarIdTipo(){
        String sql = ("select max(idTipo) as id from TipoProducto");
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
      
      
       public datosTipoProducto devolverDatos (String id){
       datosTipoProducto registroDatos = new datosTipoProducto();
       sql = ("select * from tipoproducto where idTipo='"+id+"'");
       
        try {
            Statement st = conect.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while(rs.next()){
                registroDatos.setIdTipo(rs.getString(1));
                registroDatos.setNombreTipo(rs.getString(2));
            }
            
           return registroDatos;
        
        } catch(Exception e) {
            JOptionPane.showConfirmDialog(null, e.getMessage(),"HUBO UN ERROR, INTENTE DE NUEVO", JOptionPane.CLOSED_OPTION, JOptionPane.INFORMATION_MESSAGE);
            return null;
        }
     }
    
}
