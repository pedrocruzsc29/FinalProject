package servicios;

import estructuras.arboles.BinarySearchTree;
import estructuras.pilas.Stack;
import estructuras.colas.Queue;
import Modelo.Libro;
import Modelo.Usuario;
import Modelo.Operaciones;
public class ServicioPrincipal {
    // private LibroService libroService;
    // private UsuarioService usuarioService;
    // almacenes centrales
    public final BinarySearchTree<Usuario> usuarios;
    public final BinarySearchTree<Libro> libros;
    public final Stack<Operaciones> acciones;
    public final Queue<String> pendientes;

    private final UsuarioService usuarioService; // reutilizar instancia

    public ServicioPrincipal() {
        this.usuarios = new BinarySearchTree<>();
        this.libros = new BinarySearchTree<>();
        this.acciones = new Stack<>();
        this.pendientes = new Queue<>();
        this.usuarioService = new UsuarioService(100, this.usuarios, this.pendientes, this.libros); // inicializar con referencias centrales

    }

    //LOGICA DE USUARIO
    public void registrarUsuario(){
        usuarioService.registrarUsuario();
    }

    public void buscarUsuario(){
        usuarioService.buscarUsuario();
    }
    
    public void listarUsuariosConMasLibros(){
        usuarioService.listarUsuariosConMasLibros();
    }

    public void mostrarUsuariosRegistrados(){
        usuarioService.mostrarUsuariosRegistrados();
    }
    // ----------------------------------------------------------------------------------------------------------

    // LOGICA DE OPERACIONES
    public void registrarPrestamo() {
        OperacionService.prestarLibro(this.usuarios, this.libros, this.acciones, this.pendientes);
    }
    public void registrarDevolucion() {
        OperacionService.devolverLibro(this.usuarios, this.libros, this.acciones, this.pendientes);
    }
    public void deshacerUltimaOperacion() {
        OperacionService.reversionOperaciones(this.usuarios, this.libros, this.acciones);
    }


}
