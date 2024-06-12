/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CapaLogica.TraspasoAlmacenTienda;

import CapaLogica.Conexion;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;


public class conexionDetalleTraspasoAlmacenTienda {
      private Conexion SQL = new Conexion();
    private Connection conect = SQL.conectar();
    
    String sql="";
    
    
     public int generarIdTienda(){
            String sql = ("select max(IdDetalleTraspaso) as id from DetalleTraspaso");
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
}
