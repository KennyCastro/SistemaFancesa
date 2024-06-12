
package CapaDatos.Usuarios_Personal;
//@author KENNY

import java.math.BigDecimal;

public class datosPagoPersonal {
    private String IDPago;
    private String IdPersona;
    private String MesPago;
    private int Anio;
    private BigDecimal Pago;
    private BigDecimal Descuento;
    private String DetalleDecuento;
    private BigDecimal Total;
    private String Activo;

    public datosPagoPersonal() {
    }

    public datosPagoPersonal(String IDPago, String IdPersona, String MesPago, int Anio, BigDecimal Pago, BigDecimal Descuento, String DetalleDecuento, BigDecimal Total, String Activo) {
        this.IDPago = IDPago;
        this.IdPersona = IdPersona;
        this.MesPago = MesPago;
        this.Anio = Anio;
        this.Pago = Pago;
        this.Descuento = Descuento;
        this.DetalleDecuento = DetalleDecuento;
        this.Total = Total;
        this.Activo = Activo;
    }

    public String getIDPago() {
        return IDPago;
    }

    public void setIDPago(String IDPago) {
        this.IDPago = IDPago;
    }

    public String getIdPersona() {
        return IdPersona;
    }

    public void setIdPersona(String IdPersona) {
        this.IdPersona = IdPersona;
    }

    public String getMesPago() {
        return MesPago;
    }

    public void setMesPago(String MesPago) {
        this.MesPago = MesPago;
    }

    public int getAnio() {
        return Anio;
    }

    public void setAnio(int Anio) {
        this.Anio = Anio;
    }

    public BigDecimal getPago() {
        return Pago;
    }

    public void setPago(BigDecimal Pago) {
        this.Pago = Pago;
    }

    public BigDecimal getDescuento() {
        return Descuento;
    }

    public void setDescuento(BigDecimal Descuento) {
        this.Descuento = Descuento;
    }

    public String getDetalleDecuento() {
        return DetalleDecuento;
    }

    public void setDetalleDecuento(String DetalleDecuento) {
        this.DetalleDecuento = DetalleDecuento;
    }

    public BigDecimal getTotal() {
        return Total;
    }

    public void setTotal(BigDecimal Total) {
        this.Total = Total;
    }

    public String getActivo() {
        return Activo;
    }

    public void setActivo(String Activo) {
        this.Activo = Activo;
    }
    
    
}
