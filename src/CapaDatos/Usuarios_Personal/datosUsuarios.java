/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CapaDatos.Usuarios_Personal;

/**
 *
 * @author KENNY
 */
public class datosUsuarios {
    private String IdUsuario;
    private String CiUs;
    private String NomUsuario;
    private String PassUs;
    private String EstadoUs;

    public datosUsuarios() {
    }

    public datosUsuarios(String IdUsuario, String CiUs, String NomUsuario, String PassUs, String EstadoUs) {
        this.IdUsuario = IdUsuario;
        this.CiUs = CiUs;
        this.NomUsuario = NomUsuario;
        this.PassUs = PassUs;
        this.EstadoUs = EstadoUs;
    }

    public String getIdUsuario() {
        return IdUsuario;
    }

    public void setIdUsuario(String IdUsuario) {
        this.IdUsuario = IdUsuario;
    }

    public String getCiUs() {
        return CiUs;
    }

    public void setCiUs(String CiUs) {
        this.CiUs = CiUs;
    }

    public String getNomUsuario() {
        return NomUsuario;
    }

    public void setNomUsuario(String NomUsuario) {
        this.NomUsuario = NomUsuario;
    }

    public String getPassUs() {
        return PassUs;
    }

    public void setPassUs(String PassUs) {
        this.PassUs = PassUs;
    }

    public String getEstadoUs() {
        return EstadoUs;
    }

    public void setEstadoUs(String EstadoUs) {
        this.EstadoUs = EstadoUs;
    }
    
}
