
package CapaPresentacion.PaginaPrincipal.model;

//@author KENNY

import javax.swing.Icon;


public class Model_Card {

    private Icon icono ;
    private String titulo;
    private String valor;
    private String descripcion;

    public Icon getIcono() {
        return icono;
    }

    public void setIcono(Icon icono) {
        this.icono = icono;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripción(String descripcion) {
        this.descripcion = descripcion;
    }

    public Model_Card(Icon icono, String titulo, String valor, String descripción) {
        this.icono = icono;
        this.titulo = titulo;
        this.valor = valor;
        this.descripcion = descripción;
    }
    
    
    
    
    public Model_Card() {
    }
    
    
}
