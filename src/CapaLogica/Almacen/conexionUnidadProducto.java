/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CapaLogica.Almacen;

import CapaDatos.Almacen.datosUnidadProducto;
import CapaLogica.Conexion;
import java.sql.Connection;
import java.sql.*;
import javax.swing.JOptionPane;

public class conexionUnidadProducto {
     private Conexion SQL = new Conexion();
    private Connection conect = SQL.conectar();
    
     String sql="";
     
     public boolean registrarDatos(datosUnidadProducto datos){

            sql= ("call pa_guardarUnidadProducto(?,?,?)");
             try (PreparedStatement pst = conect.prepareStatement(sql)) {
            pst.setString(1, datos.getIdUnidad());
            pst.setString(2, datos.getNombreUnidad());
            pst.setInt(3, datos.getCantidadEnUnidades());

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
     
     
     
     public boolean editarDatos(datosUnidadProducto datos){

            sql= ("call pa_editarUnidadProducto(?,?,?)");
             try (PreparedStatement pst = conect.prepareStatement(sql)) {
            pst.setString(1, datos.getIdUnidad());
            pst.setString(2, datos.getNombreUnidad());
            pst.setInt(3, datos.getCantidadEnUnidades());

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
        sql = ("select fun_existeRegistroUnidad(?)");
        
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
     
      
       public boolean eliminarDatos(datosUnidadProducto     datos){
        sql="call pa_eliminarUnidadProducto(?)";
        
        try{
            PreparedStatement pst = conect.prepareStatement(sql);
            
            pst.setString(1,datos.getIdUnidad());
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
       
       
       public int generarIdUnidad(){
        String sql = ("select max(idUnidad) as id from UnidadProducto");
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
       
       
       
       public datosUnidadProducto devolverDatos (String id){
       datosUnidadProducto registroDatos = new datosUnidadProducto();
       sql = ("select * from unidadProducto where idUnidad='"+id+"'");
       
        try {
            Statement st = conect.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while(rs.next()){
                registroDatos.setIdUnidad(rs.getString(1));
                registroDatos.setNombreUnidad(rs.getString(2));
                registroDatos.setCantidadEnUnidades(Integer.parseInt(rs.getString(3)));
            }
            
           return registroDatos;
        
        } catch(Exception e) {
            JOptionPane.showConfirmDialog(null, e.getMessage(),"HUBO UN ERROR, INTENTE DE NUEVO", JOptionPane.CLOSED_OPTION, JOptionPane.INFORMATION_MESSAGE);
            return null;
        }
     }
}

