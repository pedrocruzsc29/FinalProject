package servicios;
import estructuras.arboles.*;
import Modelo.Libro;
import Modelo.Usuario;
import estructuras.Validaciones.validaciones;
import estructuras.listaEnlazadas.SimpleLinkedList;

public class UsuarioService {  
    private Usuario[] arregloUsuarios;
    private BinarySearchTree<Usuario> arbolUsuarios;
    private int cantidadUsuarios;
 


     public UsuarioService(int capacidadUsuarios) {
        arregloUsuarios = new Usuario[capacidadUsuarios];
        arbolUsuarios = new BinarySearchTree<>();
        cantidadUsuarios = 0;
    }

    // Contructor para reutilizar almacenes centrales (árboles/colas) de BibliotecaService
    public UsuarioService(int capacidadUsuarios, BinarySearchTree<Usuario> arbolUsuarios, BinarySearchTree<Libro> arbolLibros) {
        arregloUsuarios = new Usuario[capacidadUsuarios];// donde se almacenan los usuarios registrados de forma secuencial. 
        this.arbolUsuarios = (arbolUsuarios != null) ? arbolUsuarios : new BinarySearchTree<>();// si arbolUsuarios es null, se crea uno nuevo y si no se usa el que se pasa como parámetro
        this.cantidadUsuarios = 0;
    }
    // Método para registrar un nuevo usuario
    public void registrarUsuario() {
        System.out.println("\n=== REGISTRAR NUEVO USUARIO ===");
        if (cantidadUsuarios >= arregloUsuarios.length) {
            System.out.println("Error: Capacidad máxima alcanzada");
            return;
        }
        int numeroUsuario = generarCodigoUnico(); // Generar un codigo aleatorio (ahora solo si hay espacio)
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
        if (arbolUsuarios != null) {// 
            arbolUsuarios.add(nuevoUsuario);
        }
        return true;
    }

    // ----------------------------------------------------------------------------------------------------------
    
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
    // ----------------------------------------------------------------------------------------------------------
    public void buscarUsuario() {
        System.out.println("\n\033[0;32m=== BUSCAR USUARIO ===");
        int numeroUsuario = validaciones.readInt("Ingrese número de usuario: ");
        Usuario usuario = buscarPorNumero(numeroUsuario);
        if (usuario != null) {
            imprimirUsuario(usuario);
        } else {
            System.out.println("Usuario no encontrado");
        }
    }
    private void imprimirUsuario(Usuario usuario) {
        System.out.println("\nUSUARIO ENCONTRADO:");
        System.out.println("Número: " + usuario.getNumeroUsuario());
        System.out.println("Nombre: " + usuario.getNombre());
        System.out.println("DNI: " + usuario.getDni());
        System.out.println("Dirección: " + usuario.getDireccion());
        System.out.println("Teléfono: " + usuario.getTelefono());
        System.out.println("Libros prestados: " + usuario.getLibrosPrestados());
    } 
    // ----------------------------------------------------------------------------------------------------------

    // Lista usuarios con más de X libros prestados
    public SimpleLinkedList<Usuario> listarUsuariosConMasDeXLibrosEnLista(int cantidadMinima) {
        SimpleLinkedList<Usuario> resultado = new SimpleLinkedList<>();
        
        // Recorrer el arreglo de usuarios
        for (int i = 0; i < this.cantidadUsuarios; i++) {
            Usuario u = this.arregloUsuarios[i];
            if (u != null && u.getLibrosPrestados() >= cantidadMinima) {
                resultado.addLast(u);
            }
        }
        
        return resultado;
    }

    // Lista usuarios con X o más libros prestados
    public Usuario[] listarUsuariosConMasDeXLibros(int cantidadMinima) {
        int contador = 0;
        for (int i = 0; i < cantidadUsuarios; i++) {
            if (arregloUsuarios[i].getLibrosPrestados() >= cantidadMinima) {
                contador++;
            }
        }

        Usuario[] resultado = new Usuario[contador];
        int index = 0;
        for (int i = 0; i < cantidadUsuarios; i++) {
            if (arregloUsuarios[i].getLibrosPrestados() >= cantidadMinima) {
                resultado[index++] = arregloUsuarios[i];
            }
        }
        return resultado;
    }
    // ----------------------------------------------------------------------------------------------------------
    // Mostrar todos los usuarios registrados
    public void mostrarUsuariosRegistrados(){
        System.out.println("\n === USUARIOS REGISTRADOS === ");
        Usuario[] usuarios = getTodosLosUsuarios();
        if(usuarios.length == 0){
            System.out.println("No hay usuarios registrados");
        }else{
            for (Usuario usuario : usuarios) {
                System.out.println("Número: " + usuario.getNumeroUsuario() +
                                   " | Nombre: " + usuario.getNombre() +
                                   " | DNI: " + usuario.getDni() +
                                   " | Dirección: " + usuario.getDireccion() +
                                   " | Teléfono: " + usuario.getTelefono() +
                                   " | Libros prestados: " + usuario.getLibrosPrestados());
            }
            System.out.println("Total: " + usuarios.length + " usuarios");
        }
    }

    // Devuelve un arreglo con todos los usuarios registrados (usa System.arraycopy para velocidad)
    public Usuario[] getTodosLosUsuarios() {
        if (cantidadUsuarios == 0) return new Usuario[0];
        Usuario[] usuarios = new Usuario[cantidadUsuarios];
        System.arraycopy(arregloUsuarios, 0, usuarios, 0, cantidadUsuarios);// copia los usuarios registrados al nuevo arreglo
        return usuarios;
    }
}
