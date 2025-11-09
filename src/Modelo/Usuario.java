package Modelo;

public class Usuario implements Comparable<Usuario> {
    private int numeroUsuario;  // Único
    private String dni;
    private String nombre;
    private String direccion;
    private String telefono;
    private int librosPrestados; // Inicia en 0

    public Usuario(int numeroUsuario, String dni, String nombre, String direccion, String telefono  ) {
        this.numeroUsuario = numeroUsuario;
        this.dni = dni;
        this.nombre = nombre;
        this.direccion = direccion;
        this.telefono = telefono;
        this.librosPrestados = 0;
    }

    public int getNumeroUsuario() {
        return numeroUsuario;
    }

    public void setNumeroUsuario(int numeroUsuario) {
        this.numeroUsuario = numeroUsuario;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public int getLibrosPrestados() {
        return librosPrestados;
    }

    public void setLibrosPrestados(int librosPrestados) {
        this.librosPrestados = librosPrestados;
    }

    @Override
    public String toString() {
        return "Operacion [numeroUsuario=" + numeroUsuario + ", dni=" + dni + ", nombre=" + nombre + ", direccion="
                + direccion + ", telefono=" + telefono + ", librosPrestados=" + librosPrestados + "]";
    }

    @Override
    public int compareTo(Usuario o) {
        return this.nombre.compareToIgnoreCase(o.nombre);
    }
    
}
