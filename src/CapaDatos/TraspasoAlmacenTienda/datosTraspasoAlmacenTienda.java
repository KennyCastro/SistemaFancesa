
package CapaDatos.TraspasoAlmacenTienda;

import java.util.Date;


public class datosTraspasoAlmacenTienda {
    private String IdTraspaso;
    private String IdTienda;
    private Date FechaTraspaso;
    private String IdPersonaEntrega;
    private String IdPersonaRecibe;

    public datosTraspasoAlmacenTienda() {
    }

    
    public datosTraspasoAlmacenTienda(String IdTraspaso, String IdTienda, Date FechaTraspaso, String IdPersonaEntrega, String IdPersonaRecibe) {
        this.IdTraspaso = IdTraspaso;
        this.IdTienda = IdTienda;
        this.FechaTraspaso = FechaTraspaso;
        this.IdPersonaEntrega = IdPersonaEntrega;
        this.IdPersonaRecibe = IdPersonaRecibe;
    }

    public String getIdTraspaso() {
        return IdTraspaso;
    }

    public void setIdTraspaso(String IdTraspaso) {
        this.IdTraspaso = IdTraspaso;
    }

    public String getIdTienda() {
        return IdTienda;
    }

    public void setIdTienda(String IdTienda) {
        this.IdTienda = IdTienda;
    }

    public Date getFechaTraspaso() {
        return FechaTraspaso;
    }

    public void setFechaTraspaso(Date FechaTraspaso) {
        this.FechaTraspaso = FechaTraspaso;
    }

    public String getIdPersonaEntrega() {
        return IdPersonaEntrega;
    }

    public void setIdPersonaEntrega(String IdPersonaEntrega) {
        this.IdPersonaEntrega = IdPersonaEntrega;
    }

    public String getIdPersonaRecibe() {
        return IdPersonaRecibe;
    }

    public void setIdPersonaRecibe(String IdPersonaRecibe) {
        this.IdPersonaRecibe = IdPersonaRecibe;
    }
    
    
}
