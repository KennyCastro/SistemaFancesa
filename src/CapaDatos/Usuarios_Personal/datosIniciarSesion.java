/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CapaDatos.Usuarios_Personal;

/**
 *
 * @author KENNY
 */

public class datosIniciarSesion {
    private String NameUser;
    private String PassUser;

    public datosIniciarSesion() {
    }

    public datosIniciarSesion(String NameUser, String PassUser) {
        this.NameUser = NameUser;
        this.PassUser = PassUser;
    }

    public String getNameUser() {
        return NameUser;
    }

    public void setNameUser(String NameUser) {
        this.NameUser = NameUser;
    }

    public String getPassUser() {
        return PassUser;
    }

    public void setPassUser(String PassUser) {
        this.PassUser = PassUser;
    }
    
}

