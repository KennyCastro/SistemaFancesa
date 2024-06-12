


package CapaLogica.Usuarios_Personal;

import CapaDatos.Usuarios_Personal.datosPagoPersonal;
import CapaLogica.Conexion;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.sql.*;
import java.util.ArrayList;


public class conexionPagoPersonal {
    private Conexion SQL = new Conexion();
    private Connection conect = SQL.conectar();
    
    String sql="";
    
    
    public int generarIdPago(){
        sql = ("select max(idpago) as id from pagopersona");
        int siguienteID = 0;
        try{
            Statement st= conect.createStatement();
            ResultSet rs= st.executeQuery(sql);
            if(rs.next()){
                siguienteID=rs.getInt("id")+1;
            }
            
        } catch(SQLException e){
            
            JOptionPane.showConfirmDialog(null, e.getMessage(),"HUBO UN ERROR INTENTE DE NUEVO", JOptionPane.CLOSED_OPTION, JOptionPane.INFORMATION_MESSAGE);
            
        }
        
        return siguienteID;
    }
    
    
    
    
     public DefaultTableModel mostrarTablaPagoPersona(String buscar, String tipo){
        DefaultTableModel modelo;
        String[]titulos={"Mes","Año","Pago","Descuento","Detalle","Total","Estado"};
        modelo = new DefaultTableModel(null,titulos);
        
        String[] registro = new String[8];
        
        
        
        sql= ("select * from fun_mostrarPagoPersona('"+buscar+"','"+tipo+"')");
        
        try {
            Statement st = conect.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while(rs.next()){
               
                registro[0] = rs.getString(5);
                registro[1] = rs.getString(6);
                registro[2] = rs.getString(7);
                registro[3] = rs.getString(8);
                registro[4] = rs.getString(9);
                registro[5] = rs.getString(10);
                registro[6] = rs.getString(11);

                
                modelo.addRow(registro);
            }
            
            return modelo;
        
        } catch(Exception e) {
            //JOptionPane.showConfirmDialog(null,e.getMessage());
            JOptionPane.showConfirmDialog(null, e.getMessage(),"HUBO UN ERROR, INTENTE DE NUEVO", JOptionPane.CLOSED_OPTION, JOptionPane.INFORMATION_MESSAGE);
            return null;
        }
        
    }
     
     public ArrayList<String> SumarCantidades(String IdPersona, String tipo){
         ArrayList<String> ListaSumas=new ArrayList<String>();
         sql=("select sum(Pago) as TOTALMES, sum (DescuentoMES) as DESCUENTOTOTAL, sum(TOTALPAGAR)as TOTALPAGAR from pagopersona where IdPersona = '"+IdPersona+"' and Estado = '"+tipo+"'");
         try{
            Statement st = conect.createStatement();
            ResultSet rs= st.executeQuery(sql);
            if(rs.next()){
                ListaSumas.add(rs.getString(1));
                ListaSumas.add(rs.getString(2));
                ListaSumas.add(rs.getString(3));
            }
            return ListaSumas;
            
        }catch(Exception e){
            JOptionPane.showConfirmDialog(null, e.getMessage(),"HUBO UN ERROR INTENTE DE NUEVO", JOptionPane.CLOSED_OPTION, JOptionPane.INFORMATION_MESSAGE);
            
        }
         return ListaSumas;
     }
     
     
     
     
     
     public String DevolverId(String IdPersona, String Mes, String Anio){
         //System.out.println(IdPersona+"  ---- MES: "+Mes+" ------AÑO: "+Anio);
         sql=("select * from pagopersona where MesPago = '"+Mes+"' and Anio = "+Anio+" and IdPersona = '"+IdPersona+"'");
         try{
            Statement st = conect.createStatement();
            ResultSet rs= st.executeQuery(sql);
            if(rs.next()){
                System.out.println(rs.getString(1));
                return rs.getString(1);
            }
        
        }catch(Exception e){
            JOptionPane.showConfirmDialog(null, e.getMessage(),"HUBO UN ERROR INTENTE DE NUEVO", JOptionPane.CLOSED_OPTION, JOptionPane.INFORMATION_MESSAGE);
            
        }
         return "";
     }
     
     
     
      public boolean insertarDatos(datosPagoPersonal datos){
        
         int confirmar=0;
        sql = ("select * from pagopersona where MesPago = '"+datos.getMesPago()+"' and Anio = "+datos.getAnio()+" and IdPersona = '"+datos.getIdPersona()+"'");
        
        try{
            Statement st = conect.createStatement();
            ResultSet rs= st.executeQuery(sql);
            if(rs.next()){
                confirmar=1;
            }
        
        }catch(Exception e){
            JOptionPane.showConfirmDialog(null, e.getMessage(),"HUBO UN ERROR INTENTE DE NUEVO", JOptionPane.CLOSED_OPTION, JOptionPane.INFORMATION_MESSAGE);
            return false;
        }
        
        
        if(confirmar == 0){
              sql = ("call pa_guardarPagoPersona(?,?,?,?,?,?,?,?,?)");
        
                try (PreparedStatement pst = conect.prepareStatement(sql)) {
                    pst.setString(1, datos.getIDPago());
                    pst.setString(2, datos.getIdPersona());
                    pst.setString(3, datos.getMesPago());
                    pst.setInt(4, datos.getAnio());
                    pst.setBigDecimal(5, datos.getPago());
                    pst.setBigDecimal(6, datos.getDescuento());
                    pst.setString(7, datos.getDetalleDecuento());
                    pst.setBigDecimal(8, datos.getTotal());
                    pst.setString(9, datos.getActivo());
                    int n=-1;
                    //System.out.println(n);
                    n = pst.executeUpdate();//esto para extraer lo que me sale de la consulta
                    //System.out.println(n+"  ------------------------------asdasdasdasd");
                    if(n!=-1)
                        return true;
                    else
                        return false;

                } catch(Exception e){
                    JOptionPane.showConfirmDialog(null, e.getMessage(),"HUBO UN ERROR INTENTE DE NUEVO", JOptionPane.CLOSED_OPTION, JOptionPane.INFORMATION_MESSAGE);
                    return false;
                }
        
        }
        else {
                
                JOptionPane.showConfirmDialog(null, "El pago en ese mes y año ya está registrado","VENTANA DE INFORMACIÓN", JOptionPane.CLOSED_OPTION, JOptionPane.INFORMATION_MESSAGE);
                return false;
        }
    }
    
      
      
      public boolean editarDatos(datosPagoPersonal datos){
        sql="call pa_editarPagoPersona(?,?,?,?,?,?,?,?,?)";
        
        try{
            PreparedStatement pst = conect.prepareStatement(sql);
                    pst.setString(1, datos.getIDPago());
                    pst.setString(2, datos.getIdPersona());
                    pst.setString(3, datos.getMesPago());
                    pst.setInt(4, datos.getAnio());
                    pst.setBigDecimal(5, datos.getPago());
                    pst.setBigDecimal(6, datos.getDescuento());
                    pst.setString(7, datos.getDetalleDecuento());
                    pst.setBigDecimal(8, datos.getTotal());
                    pst.setString(9, datos.getActivo());
                    int n=-1;
                    //System.out.println(n);
                    n = pst.executeUpdate();//esto para extraer lo que me sale de la consulta
                    //System.out.println(n+"  ------------------------------asdasdasdasd");
                    if(n!=-1)
                        return true;
                    else
                        return false;

        }
        catch(Exception e){
            JOptionPane.showConfirmDialog(null, e.getMessage(),"HUBO UN ERROR, INTENTE DE NUEVO", JOptionPane.CLOSED_OPTION, JOptionPane.INFORMATION_MESSAGE);
            return false;
        }
        
    }
      
      
      public boolean eliminarDatos(datosPagoPersonal datos){
        sql="call pa_eliminarPagoPersona(?)";
        
        try{
            PreparedStatement pst = conect.prepareStatement(sql);
            
            pst.setString(1,datos.getIDPago());
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
