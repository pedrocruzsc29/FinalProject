package servicios;

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
    private Libro[] arregloLibro;
   
    

    private final UsuarioService usuarioService; // reutilizar instancia

    public ServicioPrincipal() {
        this.usuarios = new BinarySearchTree<>();
        this.libros = new BinarySearchTree<>();
        this.acciones = new Stack<>();
        this.pendientes = new Queue<>();
        this.colaPendientes = new Queue<>();
        this.arregloLibro = new Libro[100];// arreglo para almacenar libros de forma secuencial
        this.usuarioService = new UsuarioService(100, this.usuarios,  this.libros);

        precargarDatos();

    }
    private void precargarDatos() {

        // USUARIOS -> ARREGLO USUARIOS -> ÁRBOL BINARIO DE BÚSQUEDA 
                
        usuarioService.registrarUsuario(1, 30123456, "Ana López", "Av. Mitre 123", "1134567890");
        usuarioService.registrarUsuario(2, 28456789, "Carlos Pérez", "Calle Belgrano 456", "1145678901");
        usuarioService.registrarUsuario(3, 31234567, "Lucía Fernández", "Av. Rivadavia 789", "1156789012");
        usuarioService.registrarUsuario(4, 29345678, "Martín Gómez", "Calle San Martín 321", "1167890123");
        usuarioService.registrarUsuario(5, 30111222, "Sofía Díaz", "Av. Corrientes 987", "1178901234");

        // LIBROS -> OBJETOS
        Libro l1 = new Libro(1001, "Cien años de soledad", "Gabriel García Márquez", 2500.00, true);
        Libro l2 = new Libro(1002, "La Divina Comedia", "Dante Alighieri", 2300.50, true);
        Libro l3 = new Libro(1003, "El viejo y el mar", "Ernest Hemingway", 1900.00, true);
        Libro l4 = new Libro(1004, "Fervor de Buenos Aires", "Jorge Luis Borges", 2100.75, false);
        Libro l5 = new Libro(1005, "Laberinto", "Jorge Luis Borges", 3200.00, true);
        Libro l6 = new Libro(1006, "1984", "George Orwell", 2800.00, false);
        Libro l7 = new Libro(1007, "La metamorfosis", "Franz Kafka", 1500.50, true);
        Libro l8 = new Libro(1008, "Hamlet", "William Shakespeare", 2400.00, true);
        Libro l9 = new Libro(1009, "El Principe", "Nicolás Maquiavelo", 1700.00, true);
        Libro l10 = new Libro(1010, "Los miserables", "Victor Hugo", 3500.00, true);

        // LIBROS -> ÁRBOL BINARIO DE BÚSQUEDA 
        libros.add(l1);
        libros.add(l2);
        libros.add(l3);
        libros.add(l4);
        libros.add(l5);
        libros.add(l6);
        libros.add(l7);
        libros.add(l8);
        libros.add(l9);
        libros.add(l10);

        // LIBROS EN EL ARREGLO
        arregloLibro[0] = l1;
        arregloLibro[1] = l2;
        arregloLibro[2] = l3;
        arregloLibro[3] = l4;
        arregloLibro[4] = l5;
        arregloLibro[5] = l6;
        arregloLibro[6] = l7;
        arregloLibro[7] = l8;
        arregloLibro[8] = l9;
        arregloLibro[9] = l10;
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

    public void mostrarAcciones(){
        OperacionService.mostrarAccionesRealizadas(this.acciones);
    }

    public void atenderPendientes() {
        OperacionService.atenderPendientes(this.pendientes);
    }
    // ----------------------------------------------------------------------------------------------------------
    // LOGICA DE LIBROS
    public void registrarLibro(){
        LibroService.insertarLibro(this.libros, this.arregloLibro);
    }
    public void buscarLibro(){
        LibroService.buscaLibro(this.libros);
    }
    public void mostrarCatalogo(){
        LibroService.mostrarInOrder(this.libros);
    }

    public SimpleLinkedList<Libro> buscarLibrosPorAutor(String autor){ 
        SimpleLinkedList<Libro> resultados = new SimpleLinkedList<>();
        resultados = LibroService.buscarLibrosPorAutor(autor, this.arregloLibro);
        return resultados;
        
    }
    public double totalPrestados(){
        double total = LibroService.calcularMontoTotalPrestados(this.arregloLibro);
        return total;
    }


}
