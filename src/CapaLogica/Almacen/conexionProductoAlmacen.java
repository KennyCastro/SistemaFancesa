/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CapaLogica.Almacen;

import CapaDatos.Almacen.datosProductoAlmacen;
import CapaDatos.Almacen.datosTipoProducto;
import CapaDatos.Almacen.datosUnidadProducto;
import CapaDatos.Usuarios_Personal.datosPersonalCocina;
import CapaLogica.Conexion;
import CapaLogica.Usuarios_Personal.conexionPersonalCocina;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.util.ArrayList;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import java.math.BigDecimal;
import javax.swing.table.DefaultTableModel;
import static CapaPresentacion.PaginaPrincipal.Ventanas.VentanasProductos.VentanaTraspasoProductos.ProductosEnEspera;
import CapaDatos.TraspasoAlmacenTienda.datosDetalleTraspasoTienda;
/**
 *
 * @author KENNY
 */
public class conexionProductoAlmacen {
     private Conexion SQL = new Conexion();
    private Connection conect = SQL.conectar();
    
    public static ArrayList<datosTipoProducto> tipoProducto = new ArrayList<datosTipoProducto>();
     public static ArrayList<datosUnidadProducto> unidadProducto = new ArrayList<datosUnidadProducto>();
    
    String sql="";
    
     public DefaultTableModel mostrarTablaProductoAlmacen (String buscar){
        DefaultTableModel modelo;
        String[]titulos={/*"Imagen",*/"ID","Producto","Cantidad","Tipo","Unidad","F. Registro","F. Vencimiento","N. Registrante","Ap. Registrante","Pr. Compra","Pr.Venta"};
        modelo = new DefaultTableModel(null,titulos);
        
        String[] registro = new String[12];
        
         sql= ("select * from fun_mostrarProducto('"+buscar+"')");
        
        try {
            
            Statement st = conect.createStatement();
   
            ResultSet rs = st.executeQuery(sql);
            
            while(rs.next()){
                //registro[0] = rs.getString(12);
                registro[0] = rs.getString(1);
                registro[1] = rs.getString(2);
                registro[2] = rs.getString(3);
                registro[3] = rs.getString(4);
                registro[4] = rs.getString(5);
                registro[5] = rs.getString(6);
                registro[6] = rs.getString(7);
                registro[7] = rs.getString(8);
                registro[8] = rs.getString(9);
                registro[9] = rs.getString(10);
                registro[10]=rs.getString(11);
                
                
                
                modelo.addRow(registro);
            }
            
            return modelo;
        
        } catch(Exception e) {
            JOptionPane.showConfirmDialog(null, e.getMessage(),"HUBO UN ERROR INTENTE DE NUEVO", JOptionPane.CLOSED_OPTION, JOptionPane.INFORMATION_MESSAGE);
            return null;
        }
    }
    
     
     public int totalCantidad (){
     sql = ("select sum(Cantidad) from Producto");
    
        try {
            Statement st =  conect.createStatement();
            int n=0;
            ResultSet rs = st.executeQuery(sql);
            while(rs.next()){
                n=Integer.parseInt(rs.getString(1));
            }
            return n;
        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, e.getMessage(),"HUBO UN ERROR, INTENTE DE NUEVO", JOptionPane.CLOSED_OPTION, JOptionPane.INFORMATION_MESSAGE);
            return 0;
        }
     }
     
     
     
     public ComboBoxModel mostrarTipoProducto() {
         DefaultComboBoxModel<String> model = new DefaultComboBoxModel<String>();
        JComboBox<String> comboBox = new JComboBox<String>(model);

         sql="select * from tipoproducto";
         tipoProducto.clear();
         try {
            
            Statement st = conect.createStatement();
   
            ResultSet rs = st.executeQuery(sql);
            
            while(rs.next()){
                tipoProducto.add(new datosTipoProducto(rs.getString(1),rs.getString(2)));

            }
            
             for(datosTipoProducto tipos: tipoProducto){
                    model.addElement(tipos.getNombreTipo());
                }
            
            return model;
            
        } catch(Exception e) {
            JOptionPane.showConfirmDialog(null, e.getMessage(),"HUBO UN ERROR INTENTE DE NUEVO", JOptionPane.CLOSED_OPTION, JOptionPane.INFORMATION_MESSAGE);
            return null;
        }
     
     }
     
     
     
     public ComboBoxModel mostrarUnidadProducto() {
         DefaultComboBoxModel<String> model = new DefaultComboBoxModel<String>();
        JComboBox<String> comboBox = new JComboBox<String>(model);
        
         
         sql="select * from unidadproducto";
         unidadProducto.clear();
         try {
            
            Statement st = conect.createStatement();
   
            ResultSet rs = st.executeQuery(sql);
            
              while(rs.next()){
                unidadProducto.add(new datosUnidadProducto(rs.getString(1),rs.getString(2),rs.getInt(3)));

            }
            
                for(datosUnidadProducto unidad: unidadProducto){
                    model.addElement(unidad.getNombreUnidad());
                }
            return model;
            
        } catch(Exception e) {
            JOptionPane.showConfirmDialog(null, e.getMessage(),"HUBO UN ERROR INTENTE DE NUEVO", JOptionPane.CLOSED_OPTION, JOptionPane.INFORMATION_MESSAGE);
            return null;
        }
     
     }
    
     
      
     
     public ComboBoxModel mostrarRegistrante() {
         DefaultComboBoxModel<String> model = new DefaultComboBoxModel<String>();
        JComboBox<String> comboBox = new JComboBox<String>(model);
         conexionPersonalCocina fun1 = new conexionPersonalCocina();
         

         ArrayList<datosPersonalCocina> persona = fun1.devolverListaPersonaCocina();


         try {
            
                
                for (datosPersonalCocina nombre : persona) {
                    model.addElement(nombre.getNombre()+" "+nombre.getApellidoP()+" "+nombre.getApellidoM());
                }  

                return model;
            
            } catch(Exception e) {
                JOptionPane.showConfirmDialog(null, e.getMessage(),"HUBO UN ERROR INTENTE DE NUEVO", JOptionPane.CLOSED_OPTION, JOptionPane.INFORMATION_MESSAGE);
                return null;
            }
        }
     
     
     
     public datosProductoAlmacen devolverDatos (String id){
       datosProductoAlmacen registroDatos = new datosProductoAlmacen();
       sql = ("select * from producto where idproducto='"+id+"'");
       
        try {
            Statement st = conect.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while(rs.next()){
                registroDatos.setIdProducto(rs.getString(1));
                registroDatos.setNombreProducto(rs.getString(2));
                registroDatos.setCantidad(Integer.parseInt(rs.getString(3)));
                registroDatos.setIdTipo(rs.getString(4));
                registroDatos.setIdUnidad(rs.getString(5));
                registroDatos.setFechaRegistro(rs.getString(6));
                registroDatos.setFechaVencimiento(rs.getString(7));
                registroDatos.setIdPersonaRegistro(rs.getString(8));
                registroDatos.setPrecioCompra(new BigDecimal(rs.getString(9)));
                registroDatos.setPrecioVenta(new BigDecimal(rs.getString(10)));
                registroDatos.setFotoProducto(rs.getBytes(11));
            }
            
           return registroDatos;
        
        } catch(Exception e) {
            JOptionPane.showConfirmDialog(null, e.getMessage(),"HUBO UN ERROR, INTENTE DE NUEVO", JOptionPane.CLOSED_OPTION, JOptionPane.INFORMATION_MESSAGE);
            return null;
        }
     
     
     }

     
      public boolean registrarDatos(datosProductoAlmacen datos){

            sql= ("call pa_guardarProducto(?,?,?,?,?,?,?,?,?,?,?)");
             try (PreparedStatement pst = conect.prepareStatement(sql)) {
            pst.setString(1, datos.getIdProducto());
            pst.setString(2, datos.getNombreProducto());
            pst.setInt(3, datos.getCantidad());
            pst.setString(4, datos.getIdTipo());
            pst.setString(5, datos.getIdUnidad());
            pst.setString(6, String.valueOf(datos.getFechaVencimiento()));
            pst.setString(7, String.valueOf(datos.getFechaVencimiento()));
            pst.setString(8, datos.getIdPersonaRegistro());
            pst.setBigDecimal(9, datos.getPrecioCompra());
            pst.setBigDecimal(10, datos.getPrecioVenta());
            pst.setBytes(11, datos.getFotoProducto());
            
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
     
     
     
     
      public boolean editarDatos(datosProductoAlmacen datos){

            sql= ("call pa_editarProducto(?,?,?,?,?,?,?,?,?,?,?)");
             try (PreparedStatement pst = conect.prepareStatement(sql)) {
            pst.setString(1, datos.getIdProducto());
            pst.setString(2, datos.getNombreProducto());
            pst.setInt(3, datos.getCantidad());
            pst.setString(4, datos.getIdTipo());
            pst.setString(5, datos.getIdUnidad());
            pst.setString(6, String.valueOf(datos.getFechaVencimiento()));
            pst.setString(7, String.valueOf(datos.getFechaVencimiento()));
            pst.setString(8, datos.getIdPersonaRegistro());
            pst.setBigDecimal(9, datos.getPrecioCompra());
            pst.setBigDecimal(10, datos.getPrecioVenta());
            pst.setBytes(11, datos.getFotoProducto());
            
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
     
      
      public boolean eliminarDatos(datosProductoAlmacen     datos){
        sql="call pa_eliminarProducto(?)";
        
        try{
            PreparedStatement pst = conect.prepareStatement(sql);
            
            pst.setString(1,datos.getIdProducto());
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
      
      
      
      
     
     public String darIdTipo(String nombreTipo){
         sql="select * from tipoproducto";
         try{
            Statement st = conect.createStatement();
            ResultSet rs = st.executeQuery(sql);
             while(rs.next()){
                 if(rs.getString(2).equals(nombreTipo)){
                     return rs.getString(1);
                 }
             }
             return "";
         
         } catch(Exception e){
            JOptionPane.showConfirmDialog(null, e.getMessage(),"HUBO UN ERROR, INTENTE DE NUEVO", JOptionPane.CLOSED_OPTION, JOptionPane.INFORMATION_MESSAGE);
            return "";
        }
     
     }
      
      public String darIdUnidad(String nombreUnidad){
         sql="select * from unidadproducto";
         try{
            Statement st = conect.createStatement();
            ResultSet rs = st.executeQuery(sql);
             while(rs.next()){
                // System.out.println(rs.getString(2));
                 if(rs.getString(2).equals(nombreUnidad)){
                     return rs.getString(1);
                 }
             }
             return "";
         
         } catch(Exception e){
            JOptionPane.showConfirmDialog(null, e.getMessage(),"HUBO UN ERROR, INTENTE DE NUEVO", JOptionPane.CLOSED_OPTION, JOptionPane.INFORMATION_MESSAGE);
            return "";
        }
     
     }
      
      
      public String darIdRegistrante(String nombreRegistrante){
         sql="select * from personacocina";
         try{
            Statement st = conect.createStatement();
            ResultSet rs = st.executeQuery(sql);
             while(rs.next()){
                 String registrante = rs.getString(2)+" "+rs.getString(3)+" "+rs.getString(4);
                 if(registrante.equals(nombreRegistrante)){
                     return rs.getString(1);
                 }
             }
             return "";
         
         } catch(Exception e){
            JOptionPane.showConfirmDialog(null, e.getMessage(),"HUBO UN ERROR, INTENTE DE NUEVO", JOptionPane.CLOSED_OPTION, JOptionPane.INFORMATION_MESSAGE);
            return "";
        }
     
     }
      
       public String darNombreProducto(String idProduct){
         sql="select * from producto where idproducto='"+idProduct+"'";
         try{
            Statement st = conect.createStatement();
            ResultSet rs = st.executeQuery(sql);
             while(rs.next()){
                 String producto = rs.getString(2);
                     return producto;
                 
             }
             return "";
         
         } catch(Exception e){
            JOptionPane.showConfirmDialog(null, e.getMessage(),"HUBO UN ERROR, INTENTE DE NUEVO", JOptionPane.CLOSED_OPTION, JOptionPane.INFORMATION_MESSAGE);
            return "";
        }
     
     }
      
     
     
     
      public int generarIdProducto(){
        String sql = ("select max(idProducto) as id from producto");
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
     
      
       public int verificarRegistroExistente (String id){
        sql = ("select fun_existeRegistroProducto(?)");
        
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
      
       
       public ArrayList<datosProductoAlmacen> productosMayorCantidad(){
           sql = "select * from producto order by Cantidad DESC LIMIT 10";
           ArrayList<datosProductoAlmacen> datos = new ArrayList<datosProductoAlmacen>();
           try {
               Statement st= conect.createStatement();
                ResultSet rs= st.executeQuery(sql);
                while(rs.next()){
                datos.add(new datosProductoAlmacen(rs.getString(1),rs.getString(2),rs.getInt(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7),rs.getString(8),rs.getBigDecimal(9),rs.getBigDecimal(10),rs.getBytes(11)));
            }
                return datos;
           } catch (Exception e) {
               JOptionPane.showConfirmDialog(null, e.getMessage(),"HUBO UN ERROR, INTENTE DE NUEVO", JOptionPane.CLOSED_OPTION, JOptionPane.INFORMATION_MESSAGE);
                return null;
           }
       }
      
       
       
       public DefaultTableModel mostrarTablaProductosEscasos (String buscar){
        DefaultTableModel modelo;
        String[]titulos={"Producto","Cantidad"};
        modelo = new DefaultTableModel(null,titulos);
        String[] registro = new String[2];
        
         sql= ("select * from fun_mostrarProducto('"+buscar+"') where cantidad<10");
        
        try {
            
            Statement st = conect.createStatement();
   
            ResultSet rs = st.executeQuery(sql);
            
            while(rs.next()){
                registro[0] = rs.getString(2);//nombre
                registro[1] = rs.getString(3);//cantidad
                modelo.addRow(registro);
            } 
    
            return modelo;
        
        } catch(Exception e) {
            JOptionPane.showConfirmDialog(null, e.getMessage(),"HUBO UN ERROR INTENTE DE NUEVO", JOptionPane.CLOSED_OPTION, JOptionPane.INFORMATION_MESSAGE);
            return null;
        }
    }
       
       
       public DefaultTableModel mostrarTablaUnidades (String buscar){
        DefaultTableModel modelo;
        String[]titulos={"Unidad"};
        modelo = new DefaultTableModel(null,titulos);
        String[] registro = new String[1];
        
         sql= ("select * from fun_mostrarUnidadProducto('"+buscar+"')");
        
        try {
            
            Statement st = conect.createStatement();
   
            ResultSet rs = st.executeQuery(sql);
            
            while(rs.next()){
                registro[0] = rs.getString(2);//nombre
                modelo.addRow(registro);
            } 
            return modelo;
        } catch(Exception e) {
            JOptionPane.showConfirmDialog(null, e.getMessage(),"HUBO UN ERROR INTENTE DE NUEVO", JOptionPane.CLOSED_OPTION, JOptionPane.INFORMATION_MESSAGE);
            return null;
        }
       }
       
       
       public DefaultTableModel mostrarTablaTipos (String buscar){
        DefaultTableModel modelo;
        String[]titulos={"Tipos"};
        modelo = new DefaultTableModel(null,titulos);
        String[] registro = new String[1];
        
         sql= ("select * from fun_mostrarTipoProducto('"+buscar+"')");
        
        try {
            
            Statement st = conect.createStatement();
   
            ResultSet rs = st.executeQuery(sql);
            
            while(rs.next()){
                registro[0] = rs.getString(2);//nombre
                modelo.addRow(registro);
            } 
            return modelo;
        } catch(Exception e) {
            JOptionPane.showConfirmDialog(null, e.getMessage(),"HUBO UN ERROR INTENTE DE NUEVO", JOptionPane.CLOSED_OPTION, JOptionPane.INFORMATION_MESSAGE);
            return null;
        }
       }
      
       
       public String darFechaInicio(){
           sql="SELECT fecharegistro FROM producto WHERE TO_DATE(FECHAREGISTRO, 'YYYY-MM-DD') = ( SELECT MIN(TO_DATE(FECHAREGISTRO, 'YYYY-MM-DD')) FROM producto)";
          String FechaInicio="";
           try {
               Statement st= conect.createStatement();
                ResultSet rs= st.executeQuery(sql);
                while(rs.next()){
                    FechaInicio = rs.getString(1);
            }
                return FechaInicio;
           } catch (Exception e) {
               JOptionPane.showConfirmDialog(null, e.getMessage(),"HUBO UN ERROR, INTENTE DE NUEVO", JOptionPane.CLOSED_OPTION, JOptionPane.INFORMATION_MESSAGE);
                return null;
           }
           
       }
       
       
       public String darFechaFin(){
           sql="SELECT fecharegistro FROM producto WHERE TO_DATE(FECHAREGISTRO, 'YYYY-MM-DD') = ( SELECT MAX(TO_DATE(FECHAREGISTRO, 'YYYY-MM-DD')) FROM producto)";
          String FechaFin="";
           try {
               Statement st= conect.createStatement();
                ResultSet rs= st.executeQuery(sql);
                while(rs.next()){
                    FechaFin = rs.getString(1);
            }
                return FechaFin;
           } catch (Exception e) {
               JOptionPane.showConfirmDialog(null, e.getMessage(),"HUBO UN ERROR, INTENTE DE NUEVO", JOptionPane.CLOSED_OPTION, JOptionPane.INFORMATION_MESSAGE);
                return null;
           }
           
       }
       
       
       
       /////ESTO ES PARA VENTAS MOSTRARTABLEALMACEN
        public DefaultTableModel mostrarTablaAlmacen (String buscar){
        DefaultTableModel modelo;
        String[]titulos={/*"Imagen",*/"ID","Producto","Cantidad","Unidad"};
        modelo = new DefaultTableModel(null,titulos);
        
        String[] registro = new String[4];
        
         sql= ("select * from fun_mostrarProducto('"+buscar+"')");
        
        try {
            
            Statement st = conect.createStatement();
   
            ResultSet rs = st.executeQuery(sql);
            
            while(rs.next()){
                //registro[0] = rs.getString(12);
                registro[0] = rs.getString(1);
                registro[1] = rs.getString(2);
                registro[2] = rs.getString(3);
                registro[3] = rs.getString(5);
                modelo.addRow(registro);
            }
            return modelo;
        } catch(Exception e) {
            JOptionPane.showConfirmDialog(null, e.getMessage(),"HUBO UN ERROR INTENTE DE NUEVO", JOptionPane.CLOSED_OPTION, JOptionPane.INFORMATION_MESSAGE);
            return null;
        }
    }
       
        
        
        public DefaultTableModel mostrarTablaTienda (String buscar){
        DefaultTableModel modelo;
        String[]titulos={"ID","Producto","Cantidad","Unidad"};
        modelo = new DefaultTableModel(null,titulos);
        
        String[] registro = new String[4];
        
         try {
             if(!ProductosEnEspera.isEmpty()){
                for (datosDetalleTraspasoTienda datos : ProductosEnEspera) {
                    registro[0]=datos.getIdProducto();
                    registro[1]=darNombreProducto(datos.getIdProducto());
                    registro[2]=String.valueOf(datos.getCantidadTraspaso());
                    registro[3]=datos.getUnidadTraspaso();
                    modelo.addRow(registro);
                    
                }  
             }
             return modelo;
            } catch(Exception e) {
                JOptionPane.showConfirmDialog(null, e.getMessage(),"HUBO UN ERROR INTENTE DE NUEVO", JOptionPane.CLOSED_OPTION, JOptionPane.INFORMATION_MESSAGE);
                return null;
            }
    }
       
}
