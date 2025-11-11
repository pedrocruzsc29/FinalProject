package servicios;

import estructuras.Validaciones.validaciones;
import estructuras.arboles.BinarySearchTree;
import estructuras.pilas.Stack;
import estructuras.colas.Queue;
import estructuras.listaEnlazadas.SimpleLinkedList;
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
    private Libro[] arreglolLibro;
    private final SimpleLinkedList<Libro> listaLibros = new SimpleLinkedList<>();

    private final UsuarioService usuarioService; // reutilizar instancia

    public ServicioPrincipal() {
        this.usuarios = new BinarySearchTree<>();
        this.libros = new BinarySearchTree<>();
        this.acciones = new Stack<>();
        this.pendientes = new Queue<>();
        this.colaPendientes = new Queue<>();
        this.arreglolLibro = new Libro[100];// arreglo para almacenar libros de forma secuencial
        this.usuarioService = new UsuarioService(100, this.usuarios,  this.libros);

    }

    //LOGICA DE USUARIO
    public void registrarUsuario(){
        usuarioService.registrarUsuario();
    }

    public void buscarUsuario(){
        usuarioService.buscarUsuario();
    }
    
    public SimpleLinkedList<Usuario> listarUsuariosConMasDeXLibros(int cantidadMinima) {
        SimpleLinkedList<Usuario> usuariosConMasLibros = usuarioService.listarUsuariosConMasDeXLibrosEnLista(cantidadMinima);
        return usuariosConMasLibros;
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
        LibroService.insertarLibro(this.libros, this.arreglolLibro);
    }
    public void buscarLibro(){
        LibroService.buscaLibro(this.libros);
    }
    public void mostrarCatalogo(){
        LibroService.mostrarInOrder(this.libros);
    }

    public SimpleLinkedList<Libro> buscarLibrosPorAutor(String autor){ 
        SimpleLinkedList<Libro> resultados = new SimpleLinkedList<>();
        resultados = LibroService.buscarLibrosPorAutor(autor, this.arreglolLibro);
        return resultados;
        
    }


}
