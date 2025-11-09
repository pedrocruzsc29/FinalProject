package servicios;

import estructuras.arboles.BinarySearchTree;
import estructuras.pilas.Stack;
import estructuras.colas.Queue;
import Modelo.Libro;
import Modelo.Usuario;
import Modelo.Operaciones;
public class BibliotecaService {
    // private LibroService libroService;
    // private UsuarioService usuarioService;
    // almacenes centrales
    public final BinarySearchTree<Usuario> usuarios;
    public final BinarySearchTree<Libro> libros;
    public final Stack<Operaciones> acciones;
    public final Queue<String> pendientes;

    public BibliotecaService() {
        this.usuarios = new BinarySearchTree<>();
        this.libros = new BinarySearchTree<>();
        this.acciones = new Stack<>();
        this.pendientes = new Queue<>();

    }

    // para invocar la lógica de operación
    public void registrarPrestamo() {
        OperacionService.prestarLibro(this.usuarios, this.libros, this.acciones, this.pendientes);
    }

    public void registrarUsuario(){
        // capadicidad de 100
        UsuarioService usuarioService = new UsuarioService(100);
        usuarioService.registrarUsuario();
    }

    


}
