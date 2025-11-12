package Modelo;

import java.time.LocalDate;

public class Operaciones {
    private static int contador = 1;
    private int idOperacion;
    private String tipo;        // "PRÉSTAMO" o "DEVOLUCIÓN"
    private Libro libro;
    private Usuario usuario;
    private LocalDate fecha;
    public Operaciones(String tipo, Libro libro, Usuario usuario, LocalDate fecha) {
        this.idOperacion = contador++;
        this.tipo = tipo;
        this.libro = libro;
        this.usuario = usuario;
        this.fecha = fecha;
    }
    public int getIdOperacion() {
        return idOperacion;
    }
    public void setIdOperacion(int idOperacion) {
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
        return "Acción -> [ID]: " + idOperacion + " - Tipo: " + tipo + " - Libro: " + libro + " - Usuario: " + usuario
                + " -Fecha:" + fecha;
    }

    
    
}
