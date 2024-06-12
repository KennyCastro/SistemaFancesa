

package CapaDatos.Almacen;
import java.math.BigDecimal;
/**
 *
 * @author KENNY
 */
public class datosProductoAlmacen {
    
    private String IdProducto;
    private String NombreProducto;
    private int Cantidad;
    private String IdTipo;
    private String IdUnidad;
    private String FechaRegistro;
    private String FechaVencimiento;
    private String IdPersonaRegistro;
    private BigDecimal PrecioCompra;
    private BigDecimal PrecioVenta;
     private byte [] fotoProducto;
     
      public datosProductoAlmacen() {
    }

    public datosProductoAlmacen(String IdProducto, String NombreProducto, int Cantidad, String IdTipo, String IdUnidad, String FechaRegistro, String FechaVencimiento, String IdPersonaRegistro, BigDecimal PrecioCompra, BigDecimal PrecioVenta, byte[] fotoProducto) {
        this.IdProducto = IdProducto;
        this.NombreProducto = NombreProducto;
        this.Cantidad = Cantidad;
        this.IdTipo = IdTipo;
        this.IdUnidad = IdUnidad;
        this.FechaRegistro = FechaRegistro;
        this.FechaVencimiento = FechaVencimiento;
        this.IdPersonaRegistro = IdPersonaRegistro;
        this.PrecioCompra = PrecioCompra;
        this.PrecioVenta = PrecioVenta;
        this.fotoProducto = fotoProducto;
    }

    public String getIdProducto() {
        return IdProducto;
    }

    public void setIdProducto(String IdProducto) {
        this.IdProducto = IdProducto;
    }

    public String getNombreProducto() {
        return NombreProducto;
    }

    public void setNombreProducto(String NombreProducto) {
        this.NombreProducto = NombreProducto;
    }

    public int getCantidad() {
        return Cantidad;
    }

    public void setCantidad(int Cantidad) {
        this.Cantidad = Cantidad;
    }

    public String getIdTipo() {
        return IdTipo;
    }

    public void setIdTipo(String IdTipo) {
        this.IdTipo = IdTipo;
    }

    public String getIdUnidad() {
        return IdUnidad;
    }

    public void setIdUnidad(String IdUnidad) {
        this.IdUnidad = IdUnidad;
    }

    public String getFechaRegistro() {
        return FechaRegistro;
    }

    public void setFechaRegistro(String FechaRegistro) {
        this.FechaRegistro = FechaRegistro;
    }

    public String getFechaVencimiento() {
        return FechaVencimiento;
    }

    public void setFechaVencimiento(String FechaVencimiento) {
        this.FechaVencimiento = FechaVencimiento;
    }

    public String getIdPersonaRegistro() {
        return IdPersonaRegistro;
    }

    public void setIdPersonaRegistro(String IdPersonaRegistro) {
        this.IdPersonaRegistro = IdPersonaRegistro;
    }

    public BigDecimal getPrecioCompra() {
        return PrecioCompra;
    }

    public void setPrecioCompra(BigDecimal PrecioCompra) {
        this.PrecioCompra = PrecioCompra;
    }

    public BigDecimal getPrecioVenta() {
        return PrecioVenta;
    }

    public void setPrecioVenta(BigDecimal PrecioVenta) {
        this.PrecioVenta = PrecioVenta;
    }

    public byte[] getFotoProducto() {
        return fotoProducto;
    }

    public void setFotoProducto(byte[] fotoProducto) {
        this.fotoProducto = fotoProducto;
    }
      
      
      
    
}
