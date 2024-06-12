/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package sistemainventarios;

import CapaPresentacion.Login;
import CapaPresentacion.PaginaPrincipal.Ventanas.VentanasProductos.Ventana_Productos_Registro;
import java.awt.EventQueue;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

/**
 *
 * @author KENNY
 */
public class SistemaInventarios {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
         try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
            Logger.getLogger(Ventana_Productos_Registro.class.getName()).log(Level.SEVERE, null, ex);
        }
        Login login = new Login();
        EventQueue.invokeLater(()->{
                login.setVisible(true);
    
        });
    }
    
}
