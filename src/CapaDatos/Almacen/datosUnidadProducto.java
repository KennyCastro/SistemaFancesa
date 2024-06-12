
package CapaDatos.Almacen;
/**
 *
 * @author KENNY
 */
public class datosUnidadProducto {
    private String IdUnidad;
    private String NombreUnidad;
    private int CantidadEnUnidades;

    public datosUnidadProducto() {
    }

    public datosUnidadProducto(String IdUnidad, String NombreUnidad, int CantidadEnUnidades) {
        this.IdUnidad = IdUnidad;
        this.NombreUnidad = NombreUnidad;
        this.CantidadEnUnidades = CantidadEnUnidades;
    }

    public String getIdUnidad() {
        return IdUnidad;
    }

    public void setIdUnidad(String IdUnidad) {
        this.IdUnidad = IdUnidad;
    }

    public String getNombreUnidad() {
        return NombreUnidad;
    }

    public void setNombreUnidad(String NombreUnidad) {
        this.NombreUnidad = NombreUnidad;
    }

    public int getCantidadEnUnidades() {
        return CantidadEnUnidades;
    }

    public void setCantidadEnUnidades(int CantidadEnUnidades) {
        this.CantidadEnUnidades = CantidadEnUnidades;
    }
    
    
    
}
