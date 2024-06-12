
package CapaLogica.Usuarios_Personal;

import CapaDatos.Usuarios_Personal.datosPersonalCocina;
import CapaLogica.Conexion;

import java.sql.*;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


/**
 *
 * @author KENNY
 */
public class conexionPersonalCocina {
     private Conexion SQL = new Conexion();
    private Connection conect = SQL.conectar();
    public static ArrayList<datosPersonalCocina> persona = new ArrayList<datosPersonalCocina>();
    
     String sql="";
     
     

    public DefaultTableModel mostrarTablaPersonalCocina (String buscar, String tipo){
        DefaultTableModel modelo;
        String[]titulos={"ID","Nombre","Ap. Paterno","Ap. Materno","CI","Sueldo","Cargo","Estado"};
        modelo = new DefaultTableModel(null,titulos);
        
        String[] registro = new String[8];
        
        sql= ("select * from fun_mostrarPersonaRESUMIDA('"+buscar+"','"+tipo+"')");
        
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
                registro[7] = rs.getString(8);
                modelo.addRow(registro);
            }
            
            return modelo;
        
        } catch(Exception e) {
            //JOptionPane.showConfirmDialog(null,e.getMessage());
            JOptionPane.showConfirmDialog(null, e.getMessage(),"HUBO UN ERROR, INTENTE DE NUEVO", JOptionPane.CLOSED_OPTION, JOptionPane.INFORMATION_MESSAGE);
            return null;
        }
        
    }
    
   /* public String[] devolverDatos (String id){
       String [] registroDatos = new String[14];
       sql = ("select * from fun_mostrarPersona('"+id+"')");
       
        try {
            Statement st = conect.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while(rs.next()){
                registroDatos[0] = rs.getString(1);
                registroDatos[1] = rs.getString(2);
                registroDatos[2] = rs.getString(3);
                registroDatos[3] = rs.getString(4);
                registroDatos[4] = rs.getString(5);
                registroDatos[5] = rs.getString(6);
                registroDatos[6] = rs.getString(7);
                registroDatos[7] = rs.getString(8);
                registroDatos[8] = rs.getString(9);
                registroDatos[9] = rs.getString(10);
                registroDatos[10] = rs.getString(11);
                registroDatos[11]= rs.getString(12);
                registroDatos[12] = rs.getString(13);
                registroDatos[13] = rs.getString(14);
                
            }
            
           return registroDatos;
        
        } catch(Exception e) {
            JOptionPane.showConfirmDialog(null,e.getMessage());
            return null;
        }
    }*/
    
    
    public datosPersonalCocina devolverDatos (String id){
       datosPersonalCocina registroDatos = new datosPersonalCocina();
       sql = ("select * from fun_mostrarPersona('"+id+"')");
       
        try {
            Statement st = conect.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while(rs.next()){
                registroDatos.setIdPersona(rs.getString(1));
                registroDatos.setNombre(rs.getString(2));
                registroDatos.setApellidoP(rs.getString(3));
                registroDatos.setApellidoM(rs.getString(4));
                registroDatos.setCi(rs.getString(5));
                registroDatos.setTelefono(rs.getString(6));
                registroDatos.setDireccion(rs.getString(7));
                registroDatos.setEdad(Integer.parseInt(rs.getString(8)));
                registroDatos.setSueldo(Float.parseFloat(rs.getString(9)));
                registroDatos.setCargo(rs.getString(10));
                registroDatos.setEstado(rs.getString(11));
                registroDatos.setFechaContratacion(rs.getString(12));
                registroDatos.setNombreImagen(rs.getString(13));
                registroDatos.setFoto(rs.getBytes(14)); 
                
            }
            
           return registroDatos;
        
        } catch(Exception e) {
            JOptionPane.showConfirmDialog(null, e.getMessage(),"HUBO UN ERROR, INTENTE DE NUEVO", JOptionPane.CLOSED_OPTION, JOptionPane.INFORMATION_MESSAGE);
            return null;
        }
    }
    
    
     public ArrayList<datosPersonalCocina> devolverListaPersonaCocina (){
     
         conexionPersonalCocina fun1 = new conexionPersonalCocina();
         
          sql="select * from personacocina where estado='A' order by idpersona";
          persona.clear();
            try {
            
                Statement st = conect.createStatement();

                ResultSet rs = st.executeQuery(sql);

                while(rs.next()){
                    persona.add(new datosPersonalCocina(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7),Integer.parseInt(rs.getString(8)),Float.parseFloat(rs.getString(9)),rs.getString(10),rs.getString(11),rs.getString(12),rs.getString(13),rs.getBytes(14)));
                   //nombres.add(rs.getString(2)+" "+rs.getString(3)+" "+rs.getString(4));

                }
                 return persona;
            
            } catch(Exception e) {
                JOptionPane.showConfirmDialog(null, e.getMessage(),"HUBO UN ERROR INTENTE DE NUEVO", JOptionPane.CLOSED_OPTION, JOptionPane.INFORMATION_MESSAGE);
                return null;
            }
         
         
     }
    
    
    
    public int generarIdpersonal(){
        String sql = ("select max(idpersona) as id from personacocina");
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
    
    
    
    
    public boolean insertarDatos(datosPersonalCocina datos){
        
         int confirmar=0;
        sql = ("select * from personacocina where CI = '"+datos.getCi()+"'");
        
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
              sql = ("call pa_guardarPersonaCocina(?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
        
                try (PreparedStatement pst = conect.prepareStatement(sql)) {
                    pst.setString(1, datos.getIdPersona());
                    pst.setString(2, datos.getNombre());
                    pst.setString(3, datos.getApellidoP());
                    pst.setString(4, datos.getApellidoM());
                    pst.setString(5, datos.getCi());
                    pst.setString(6, datos.getTelefono());
                    pst.setString(7, datos.getDireccion());
                    pst.setInt(8, datos.getEdad());
                    pst.setFloat(9, datos.getSueldo());
                    pst.setString(10, datos.getCargo());
                    pst.setString(11, datos.getEstado());
                    pst.setString(12, datos.getFechaContratacion());
                    pst.setString(13, datos.getNombreImagen());
                    pst.setBytes(14, datos.getFoto());

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
                
                JOptionPane.showConfirmDialog(null, "El número de carnet Ingresado ya está registrado","VENTANA DE INFORMACIÓN", JOptionPane.CLOSED_OPTION, JOptionPane.INFORMATION_MESSAGE);
                return false;
        }
    }
    
    public boolean editarDatos(datosPersonalCocina datos) {
        sql = ("call pa_editarPersonaCocina(?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
           try (PreparedStatement pst = conect.prepareStatement(sql)) {
            pst.setString(1, datos.getIdPersona());
            pst.setString(2, datos.getNombre());
            pst.setString(3, datos.getApellidoP());
            pst.setString(4, datos.getApellidoM());
            pst.setString(5, datos.getCi());
            pst.setString(6, datos.getTelefono());
            pst.setString(7, datos.getDireccion());
            pst.setInt(8, datos.getEdad());
            pst.setFloat(9, datos.getSueldo());
            pst.setString(10, datos.getCargo());
            pst.setString(11, datos.getEstado());
            pst.setString(12, datos.getFechaContratacion());
            pst.setString(13, datos.getNombreImagen());
            pst.setBytes(14, datos.getFoto());
            
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
    
    
    
    
    
    
    
    public boolean eliminarDatos(datosPersonalCocina     datos){
        sql="call pa_inhabilitarPersonaCocina(?)";
        
        try{
            PreparedStatement pst = conect.prepareStatement(sql);
            
            pst.setString(1,datos.getIdPersona());
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
        sql = ("select fun_existeRegistroPersona(?)");
        
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
    
    public int countPersonalActivo () {
        sql = ("select count(*) from personacocina where Estado='A'");
    
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
    
    
    public int countPersonalInactivo () {
        sql = ("select count(*) from personacocina where Estado='X'");
    
        try {
            Statement st =  conect.createStatement();
            int m=0;
            ResultSet rs = st.executeQuery(sql);
            while(rs.next()){
                m=Integer.parseInt(rs.getString(1));
            }
            return m;
        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, e.getMessage(),"HUBO UN ERROR, INTENTE DE NUEVO", JOptionPane.CLOSED_OPTION, JOptionPane.INFORMATION_MESSAGE);
            return 0;
        }

    }
}
