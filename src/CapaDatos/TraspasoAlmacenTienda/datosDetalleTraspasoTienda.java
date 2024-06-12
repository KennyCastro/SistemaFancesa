
package CapaDatos.TraspasoAlmacenTienda;


public class datosDetalleTraspasoTienda {
       private String IdDetalleTraspasoTienda;
       private String IdTraspaso;
       private String IdProducto;
       private int CantidadTraspaso;
       private String UnidadTraspaso;

    public datosDetalleTraspasoTienda() {
    }

    public datosDetalleTraspasoTienda(String IdDetalleTraspasoTienda, String IdTraspaso, String IdProducto, int CantidadTraspaso, String UnidadTraspaso) {
        this.IdDetalleTraspasoTienda = IdDetalleTraspasoTienda;
        this.IdTraspaso = IdTraspaso;
        this.IdProducto = IdProducto;
        this.CantidadTraspaso = CantidadTraspaso;
        this.UnidadTraspaso = UnidadTraspaso;
    }

    public String getIdDetalleTraspasoTienda() {
        return IdDetalleTraspasoTienda;
    }

    public void setIdDetalleTraspasoTienda(String IdDetalleTraspasoTienda) {
        this.IdDetalleTraspasoTienda = IdDetalleTraspasoTienda;
    }

    public String getIdTraspaso() {
        return IdTraspaso;
    }

    public void setIdTraspaso(String IdTraspaso) {
        this.IdTraspaso = IdTraspaso;
    }

    public String getIdProducto() {
        return IdProducto;
    }

    public void setIdProducto(String IdProducto) {
        this.IdProducto = IdProducto;
    }

    public int getCantidadTraspaso() {
        return CantidadTraspaso;
    }

    public void setCantidadTraspaso(int CantidadTraspaso) {
        this.CantidadTraspaso = CantidadTraspaso;
    }

    public String getUnidadTraspaso() {
        return UnidadTraspaso;
    }

    public void setUnidadTraspaso(String UnidadTraspaso) {
        this.UnidadTraspaso = UnidadTraspaso;
    }
       
    
    
}
