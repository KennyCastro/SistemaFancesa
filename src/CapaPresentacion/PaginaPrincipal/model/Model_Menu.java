
package CapaPresentacion.PaginaPrincipal.model;
// @author KENNY

import javax.swing.Icon;
import javax.swing.ImageIcon;

 
//clase que recibe datos para poner al menu


public class Model_Menu {
    String icono; 
    String nombre;
    MenuTipo type;

    public String getIcono() {
        return icono;
    }

    public void setIcono(String icono) {
        this.icono = icono;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public MenuTipo getType() {
        return type;
    }

    public void setType(MenuTipo type) {
        this.type = type;
    }

    public Model_Menu(String icono, String nombre, MenuTipo type) {
        this.icono = icono;
        this.nombre = nombre;
        this.type = type;
    }
    
    public Model_Menu(){
        
    }
    
    
    public Icon toIcon(){
        return new ImageIcon(getClass().getResource("/CapaPresentacion/PaginaPrincipal/iconos/"+icono+".png"));
    }
    
    public static enum MenuTipo{
        TITLE, MENU, EMPTY
    }
}
