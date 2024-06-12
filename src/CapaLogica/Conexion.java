/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CapaLogica;

/**
 *
 * @author KENNY
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {
    public static Connection conn = null; 
    
    public static Connection conectar(){
        String url = "jdbc:postgresql://localhost:5432/db_SistemaInventarios";
        String user ="postgres";
        String password= "admin";
        try {
            Class.forName("org.postgresql.Driver");  //esto es para inicializar el drive (actualmente no es necesario coloocarlo porque desde JDVC 4 ya se hace automaticamente en la linea DriverManager.getconnection();)
        } catch(ClassNotFoundException e){
            System.out.println("Error de SQL "+ e.getMessage());
        }
        
        try{
            conn = DriverManager.getConnection(url,user,password); //Nos conectamos a nuestra base de datos
            
        }catch(SQLException e){
            System.out.println("Error de conexion del driver"+e.getMessage());
        }
        return conn;
    } 
}
