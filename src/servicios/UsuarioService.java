package servicios;
import estructuras.arboles.*;
import estructuras.colas.*;
import Modelo.Libro;
import Modelo.Usuario;
import estructuras.Validaciones.validaciones;

public class UsuarioService {  
    private Usuario[] arregloUsuarios;
    private BinarySearchTree<Usuario> arbolUsuarios;
    private Queue<Usuario> colaPendientes;
    private int cantidadUsuarios;
    private BinarySearchTree<Libro> arbolLibros;
 


     public UsuarioService(int capacidadUsuarios) {
        arregloUsuarios = new Usuario[capacidadUsuarios];
        arbolUsuarios = new BinarySearchTree<>();
        colaPendientes = new Queue<>();
        cantidadUsuarios = 0;
        arbolLibros = new BinarySearchTree<>();
    }

    public UsuarioService(int capacidadUsuarios, Queue<Usuario> colaPendientes) {
        arregloUsuarios = new Usuario[capacidadUsuarios];
        cantidadUsuarios = 0;
        this.colaPendientes = (colaPendientes != null) ? colaPendientes : new Queue<>();
        arbolLibros = new BinarySearchTree<>();
    }
    
    public  void registrarUsuario() {
        System.out.println("\n=== REGISTRAR NUEVO USUARIO ===");
        int numeroUsuario = generarCodigoUnico();// Generar un codigo aleatorio
        String dni = validaciones.readString("DNI: ");
        String nombre = validaciones.readString("Nombre completo: ");
        String direccion = validaciones.readString("Dirección: ");
        String telefono = validaciones.readString("Teléfono: ");


        if (registrarUsuario(numeroUsuario, dni, nombre, direccion, telefono)) {
            System.out.println("Usuario registrado exitosamente!");
            System.out.println("Codigo generado: " + numeroUsuario);
        } else {
            System.out.println("Error: El número de usuario ya existe o capacidad máxima alcanzada");
        }
    }

    public boolean registrarUsuario(int numeroUsuario, String dni, String nombre, String direccion, String telefono) {
        if (cantidadUsuarios >= arregloUsuarios.length) {
            return false; // Arreglo lleno
        }
        
        if (buscarPorNumero(numeroUsuario) != null) {
            return false; // Número de usuario ya existe
        }

        Usuario nuevoUsuario = new Usuario(numeroUsuario, dni, nombre, direccion, telefono);
        arregloUsuarios[cantidadUsuarios++] = nuevoUsuario;
        arbolUsuarios.add(nuevoUsuario);
        return true;
    }

    
    
    // Busca usuario por número (búsqueda lineal)
    public Usuario buscarPorNumero(int numeroUsuario) {
        for (int i = 0; i < cantidadUsuarios; i++) {
            if (arregloUsuarios[i].getNumeroUsuario() == numeroUsuario) {
                return arregloUsuarios[i];
            }
        }
        return null;
    }
    public  int generarCodigoUnico() {
        int codigo;
        do {
            codigo = (int) (Math.random() * 1000);
        } while (buscarPorNumero(codigo) != null);
        return codigo;
    }

}
