/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CapaLogica.Usuarios_Personal;

import CapaDatos.Usuarios_Personal.datosIniciarSesion;
import CapaDatos.Usuarios_Personal.datosUsuarios;
import CapaLogica.Conexion;
import CapaPresentacion.PaginaPrincipal.main.Principal;
import java.sql.*;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author KENNY
 */
public class conexionUsuarios {
    private Conexion SQL = new Conexion();
    private Connection conect = SQL.conectar();
    
    
    String sql="";
    
    public boolean IniciarSesionLogin(datosIniciarSesion datos){
        //sql=("select IniciarSesion('"+datos.getNameUser()+"', '"+datos.getPassUser()+"')");
        sql = ("select IniciarSesion (?,?)");
        try {
          
            PreparedStatement pst = conect.prepareStatement(sql);
            pst.setString (1,datos.getNameUser());
            pst.setString (2,datos.getPassUser());
            ResultSet rs = pst.executeQuery();
            String existeUsuario="";
            while(rs.next()){
                existeUsuario=rs.getString(1);
                //System.out.println("===========");
            }
            //System.out.print(existeUsuario);
            if(Integer.parseInt(existeUsuario)==1){
                return true;
            }
            else {
                JOptionPane.showConfirmDialog(null, "No existe Usuario","VENTANA DE INFORMACION", JOptionPane.CLOSED_OPTION, JOptionPane.INFORMATION_MESSAGE);
                return false; 
            }
            
        } catch(Exception e){
            JOptionPane.showConfirmDialog(null, e.getMessage(),"HUBO UN ERROR INTENTE DE NUEVO", JOptionPane.CLOSED_OPTION, JOptionPane.INFORMATION_MESSAGE);
            return false;
        }
    }
    
    
    public DefaultTableModel mostrarTablaPersona (String buscar){
        DefaultTableModel modelo;
        String[]titulos={"ID","Nombre","Ap. Paterno","Ap. Materno","CI"};
        modelo = new DefaultTableModel(null,titulos);
        
        String[] registro = new String[5];
        
         sql= ("select * from fun_mostrarPersonaRESUMIDA('"+buscar+"')");
        
        try {
            
            Statement st = conect.createStatement();
   
            ResultSet rs = st.executeQuery(sql);
            
            while(rs.next()){
                registro[0] = rs.getString(1);
                registro[1] = rs.getString(2);
                registro[2] = rs.getString(3);
                registro[3] = rs.getString(4);
                registro[4] = rs.getString(5);
                modelo.addRow(registro);
            }
            
            return modelo;
        
        } catch(Exception e) {
            JOptionPane.showConfirmDialog(null, e.getMessage(),"HUBO UN ERROR INTENTE DE NUEVO", JOptionPane.CLOSED_OPTION, JOptionPane.INFORMATION_MESSAGE);
            return null;
        }
    }
    
    
    public DefaultTableModel mostrarTablaUsuario(String buscar){
        DefaultTableModel modelo;
        String[]titulos={"IdUser","Nombre","Ap. Paterno","CI"};
        modelo = new DefaultTableModel(null,titulos);
        
        String[] registro = new String[4];
        
        sql= ("select * from fun_MostrarUsuarioCompleto('"+buscar+"')");
         try {
            
            Statement st = conect.createStatement();
            ResultSet rs = st.executeQuery(sql);
            
            while(rs.next()){
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
    
    
    public int generarIdUsuario(){
        sql = ("select max(idusuario) as id from usuario");
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
    
    
    public boolean insertarUsuario(datosUsuarios datos){
        int usuarioInhabilitado=0;
        sql=("select * from fun_verificarusuariohabilitado(?)");
        
         try {
          
            PreparedStatement pst = conect.prepareStatement(sql);
            pst.setString (1,datos.getCiUs());
            ResultSet rs = pst.executeQuery();
            String Habilitado="";
            while(rs.next()){
                Habilitado=rs.getString(1);
                //System.out.println("===========");
            }
            //System.out.print(existeUsuario);
            if(Integer.parseInt(Habilitado)==1){
                usuarioInhabilitado=1;
            }

        } catch(Exception e){
            JOptionPane.showConfirmDialog(null, e.getMessage(),"HUBO UN ERROR INTENTE DE NUEVO", JOptionPane.CLOSED_OPTION, JOptionPane.INFORMATION_MESSAGE);
            return false;
        }
        
        
        if(usuarioInhabilitado==1){
              int confirmar=0;
                sql = ("select * from usuario where CiP ='"+datos.getCiUs()+"'"); //verificamos que ese usuario exista

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



                if(confirmar==0){


                        sql = ("call pa_guardarUsuario(?,?,?,?,?)");

                        try{
                            PreparedStatement pst = conect.prepareStatement(sql);
                            pst.setString(1, datos.getIdUsuario());
                            pst.setString(2, datos.getCiUs());
                            pst.setString(3, datos.getNomUsuario());
                            pst.setString(4, datos.getPassUs());
                            pst.setString(5, datos.getEstadoUs());

                            int n=-1;
                            n = pst.executeUpdate();


                            if(n!=-1)
                                return true;
                            else
                                return false;



                        } catch(Exception e) {
                            JOptionPane.showConfirmDialog(null, e.getMessage(),"HUBO UN ERROR INTENTE DE NUEVO", JOptionPane.CLOSED_OPTION, JOptionPane.INFORMATION_MESSAGE);
                            return false;

                        }
                }else {

                    JOptionPane.showConfirmDialog(null, "Ya existe ese usuario","VENTANA DE INFORMACIÓN", JOptionPane.CLOSED_OPTION, JOptionPane.INFORMATION_MESSAGE);
                    return false;
                }

        }
        else {
            JOptionPane.showConfirmDialog(null, "Ese carnet de identidad no existe","VENTANA DE INFORMACIÓN", JOptionPane.CLOSED_OPTION, JOptionPane.INFORMATION_MESSAGE);
            return false;
        }
    }
    
    
    public boolean eliminarDatos(datosUsuarios datos){
        sql="call pa_eliminarUsuario(?)";
        
        try{
            PreparedStatement pst = conect.prepareStatement(sql);
            
            pst.setString(1,datos.getIdUsuario());
            int n = pst.executeUpdate();
            if(n!=0)
                return true;
            else
                return false;
        }
        catch(Exception e){
            JOptionPane.showConfirmDialog(null, e.getMessage(),"HUBO UN ERROR INTENTE DE NUEVO", JOptionPane.CLOSED_OPTION, JOptionPane.INFORMATION_MESSAGE);
            return false;
        }
        
    }
    
   
    
    
}
