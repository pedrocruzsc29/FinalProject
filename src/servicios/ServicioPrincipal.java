package servicios;

import estructuras.arboles.BinarySearchTree;
import estructuras.pilas.Stack;
import estructuras.colas.Queue;
// Modelos
import Modelo.Libro;
import Modelo.Usuario;
import Modelo.Operaciones;
public class ServicioPrincipal {
    public final BinarySearchTree<Usuario> usuarios;
    public final BinarySearchTree<Libro> libros;
    public final Stack<Operaciones> acciones;
    public final Queue<String> colaPendientes;
    public final Queue<Usuario> pendientes;
    private Libro[] arbolLibro;

    private final UsuarioService usuarioService; // reutilizar instancia

    public ServicioPrincipal() {
        this.usuarios = new BinarySearchTree<>();
        this.libros = new BinarySearchTree<>();
        this.acciones = new Stack<>();
        this.pendientes = new Queue<>();
        this.colaPendientes = new Queue<>();
        this.arbolLibro = new Libro[100];
        this.usuarioService = new UsuarioService(100, this.usuarios,  this.libros);

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
        OperacionService.devolverLibro(this.usuarios, this.libros, this.acciones);
    }
    public void deshacerUltimaOperacion() {
        OperacionService.reversionOperaciones(this.usuarios, this.libros, this.acciones);
    }
    public void atenderPendientes() {
        OperacionService.atenderPendientes(this.pendientes);
    }
    // ----------------------------------------------------------------------------------------------------------
    // LOGICA DE LIBROS
    public void registrarLibro(){
        LibroService.insertarLibro(this.libros, this.arbolLibro);
    }
    public void buscarLibro(){
        LibroService.buscaLibro(this.libros);
    }
    public void mostrarCatalogo(){
        LibroService.mostrarInOrder(this.libros);
    }


}
