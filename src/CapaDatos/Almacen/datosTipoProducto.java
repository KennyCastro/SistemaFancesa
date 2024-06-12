
package CapaDatos.Almacen;

/**
 *
 * @author KENNY
 */
public class datosTipoProducto {
    private String IdTipo;
    private String NombreTipo;

    public datosTipoProducto() {
    }

    public datosTipoProducto(String IdTipo, String NombreTipo) {
        this.IdTipo = IdTipo;
        this.NombreTipo = NombreTipo;
    }

    public String getIdTipo() {
        return IdTipo;
    }

    public void setIdTipo(String IdTipo) {
        this.IdTipo = IdTipo;
    }

    public String getNombreTipo() {
        return NombreTipo;
    }

    public void setNombreTipo(String NombreTipo) {
        this.NombreTipo = NombreTipo;
    }
    
    
    
}
