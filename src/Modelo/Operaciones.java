package Modelo;

import java.time.LocalDate;

public class Operaciones {
    private String idOperacion;
    private String tipo;        // "PRÉSTAMO" o "DEVOLUCIÓN"
    private Libro libro;
    private Usuario usuario;
    private LocalDate fecha;
    public Operaciones(String idOperacion, String tipo, Libro libro, Usuario usuario, LocalDate fecha) {
        this.idOperacion = idOperacion;
        this.tipo = tipo;
        this.libro = libro;
        this.usuario = usuario;
        this.fecha = fecha;
    }
    public String getIdOperacion() {
        return idOperacion;
    }
    public void setIdOperacion(String idOperacion) {
        this.idOperacion = idOperacion;
    }
    public String getTipo() {
        return tipo;
    }
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    public Libro getLibro() {
        return libro;
    }
    public void setLibro(Libro libro) {
        this.libro = libro;
    }
    public Usuario getUsuario() {
        return usuario;
    }
    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
    public LocalDate getFecha() {
        return fecha;
    }
    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }
    @Override
    public String toString() {
        return "Operacion [idOperacion=" + idOperacion + ", tipo=" + tipo + ", libro=" + libro + ", usuario=" + usuario
                + ", fecha=" + fecha + "]";
    }

    
    
}
