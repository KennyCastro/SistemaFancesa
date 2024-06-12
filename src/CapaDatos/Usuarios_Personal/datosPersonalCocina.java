
package CapaDatos.Usuarios_Personal;

import java.util.Date;

/**
 *
 * @author KENNY
 */
public class datosPersonalCocina {

    public datosPersonalCocina(String IdPersona, String Nombre, String ApellidoP, String ApellidoM, String Ci, String Telefono, String Direccion, int Edad, float Sueldo, String Cargo, String Estado, String FechaContratacion, String NombreImagen, byte [] foto) {
        this.IdPersona = IdPersona;
        this.Nombre = Nombre;
        this.ApellidoP = ApellidoP;
        this.ApellidoM = ApellidoM;
        this.Ci = Ci;
        this.Telefono = Telefono;
        this.Direccion = Direccion;
        this.Edad = Edad;
        this.Sueldo = Sueldo;
        this.Cargo = Cargo;
        this.Estado = Estado;
        this.FechaContratacion = FechaContratacion;
        this.NombreImagen = NombreImagen;
        this.foto = foto;
    }

    public String getIdPersona() {
        return IdPersona;
    }

    public void setIdPersona(String IdPersona) {
        this.IdPersona = IdPersona;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getApellidoP() {
        return ApellidoP;
    }

    public void setApellidoP(String ApellidoP) {
        this.ApellidoP = ApellidoP;
    }

    public String getApellidoM() {
        return ApellidoM;
    }

    public void setApellidoM(String ApellidoM) {
        this.ApellidoM = ApellidoM;
    }

    public String getCi() {
        return Ci;
    }

    public void setCi(String Ci) {
        this.Ci = Ci;
    }

    public String getTelefono() {
        return Telefono;
    }

    public void setTelefono(String Telefono) {
        this.Telefono = Telefono;
    }

    public String getDireccion() {
        return Direccion;
    }

    public void setDireccion(String Direccion) {
        this.Direccion = Direccion;
    }

    public int getEdad() {
        return Edad;
    }

    public void setEdad(int Edad) {
        this.Edad = Edad;
    }

    public float getSueldo() {
        return Sueldo;
    }

    public void setSueldo(float Sueldo) {
        this.Sueldo = Sueldo;
    }

    public String getCargo() {
        return Cargo;
    }

    public void setCargo(String Cargo) {
        this.Cargo = Cargo;
    }

    public String getEstado() {
        return Estado;
    }

    public void setEstado(String Estado) {
        this.Estado = Estado;
    }

    public String getFechaContratacion() {
        return FechaContratacion;
    }

    public void setFechaContratacion(String FechaContratacion) {
        this.FechaContratacion = FechaContratacion;
    }

    public String getNombreImagen() {
        return NombreImagen;
    }

    public void setNombreImagen(String NombreImagen) {
        this.NombreImagen = NombreImagen;
    }

    public byte [] getFoto() {
        return foto;
    }

    public void setFoto(byte [] foto) {
        this.foto = foto;
    }
    private String IdPersona;
    private String Nombre;
    private String ApellidoP;
    private String ApellidoM;
    private String Ci;
    private String Telefono;
    private String Direccion;
    private int Edad;
    private float Sueldo;
    private String Cargo;
    private String Estado;
    private String FechaContratacion;
    private String NombreImagen;
    private byte [] foto;

    
    public datosPersonalCocina() {
    }
    
}
