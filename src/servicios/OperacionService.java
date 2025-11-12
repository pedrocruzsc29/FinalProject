package servicios;


import estructuras.Validaciones.validaciones;
import estructuras.arboles.BinarySearchTree;
import estructuras.pilas.Stack;
import estructuras.colas.Queue;

import java.time.LocalDate;
import java.util.Scanner;

import Modelo.Libro;
import Modelo.Usuario;
import Modelo.Operaciones;

public class OperacionService {

    // OBJETO SCANNER 

    public static Scanner sc = new Scanner(System.in);

    // PRESTAMOS 

    public static void prestarLibro(BinarySearchTree <Usuario> usuarios, BinarySearchTree <Libro> libros, Stack <Operaciones> acciones, Queue <Usuario> pendientes){
        int numeroUsuario = validaciones.validarNumero(sc, "Número de Usuario: ");
        Usuario usuarioTemporal = new Usuario(numeroUsuario,0," ", " ", "" );
        Usuario usuarioEcontrado = usuarios.buscar1(usuarioTemporal);
        if (usuarioEcontrado != null){
            int code = validaciones.validarNumero(sc, "Código del libro: ");
            Libro libroTemporal = new Libro(code, " ", " ", 0.0, true);
            Libro libroEncontrado = libros.buscar1(libroTemporal);
            if (libroEncontrado != null){
                if (libroEncontrado.isDisponible()){
                    libroEncontrado.setDisponible(false);
                    usuarioEcontrado.setLibrosPrestados(usuarioEcontrado.getLibrosPrestados() + 1);
                    Operaciones operacion = new Operaciones("Prestamo", libroEncontrado, usuarioEcontrado, LocalDate.now());
                    acciones.push(operacion);
                    System.out.println("*** Prestamo realizado exitosamente ***");
                }else{
                    pendientes.add(usuarioEcontrado);
                    System.out.println("Libro no disponible. Usuario agregado a PENDIENTES...");
                }
            }else{
                System.out.println("Libro no encontrado...");
            }
        }else{
            System.out.println("Usuario no encontrado...");
            
        }   
    }    

    // DEVOLUCIONES 

    public static void devolverLibro(BinarySearchTree <Usuario> usuarios, BinarySearchTree <Libro> libros, Stack <Operaciones> acciones){
        int numeroUsuario = validaciones.validarNumero(sc, "Número de Usuario a buscar: ");
        Usuario usuarioTemporal = new Usuario(numeroUsuario,0," ", " ", "");
        Usuario usuarioEcontrado = usuarios.buscar1(usuarioTemporal);
        if (usuarioEcontrado != null){

            int code = validaciones.validarNumero(sc, "Código del libro: ");
            Libro libroTemporal = new Libro(code, " ", " ", 0.0, true);
            Libro libroEncontrado = libros.buscar1(libroTemporal);
            if (libroEncontrado != null){
                if (libroEncontrado.isDisponible() == false){
                    libroEncontrado.setDisponible(true);
                    usuarioEcontrado.setLibrosPrestados(usuarioEcontrado.getLibrosPrestados() - 1);
                    Operaciones operacion = new Operaciones("Devolución", libroEncontrado, usuarioEcontrado, LocalDate.now());
                    acciones.push(operacion);
                    System.out.println("*** Devolución realizada exitosamente ***");
                }else{
                    System.out.println("El libro se encuentra disponible...");
                    
                }
            }else{
                System.out.println("Libro no encontrado...");
            }    

        }else{
            System.out.println("Usuario no encontrado...");
        }
    }

    // REVERSIÓN DE OPERACIONES 
    
    public static Libro reversionOperaciones(BinarySearchTree <Usuario> usuarios, BinarySearchTree <Libro> libros, Stack <Operaciones> acciones){
        Libro libroSaliente = null;
        if (!acciones.isEmpty()){
            Operaciones operacionReciente = acciones.pop();
            Usuario usuario = operacionReciente.getUsuario();
            Libro libro = operacionReciente.getLibro();
            libroSaliente = libro;
            if (operacionReciente.getTipo().equalsIgnoreCase("Prestamo")){
                libroSaliente.setDisponible(true); // Se devuelve el libro
                if (usuario.getLibrosPrestados() > 0){
                    usuario.setLibrosPrestados(usuario.getLibrosPrestados() - 1);
                    System.out.println("Prestamo revertido. El libro fue devuelto...");

                }else{
                    System.out.println("El usuario no posee libros...");
                }
                
            }else{ // Tipo de operación -> Devolución
                if (libro.isDisponible()){
                    libro.setDisponible(false);
                    usuario.setLibrosPrestados(usuario.getLibrosPrestados() + 1);
                    System.out.println("Devolución revertida. El libro fue prestado nuevamente...");
                }else{
                    System.out.println("Libro prestado. No se pudo devolver...");
                }
            }
        }else{
            System.out.println("No hay operaciones para revertir...");
        }
        return libroSaliente;
    }

    // BUSCAR USUARIO EN QUEUE

    public static Usuario buscarUsuarios(int numeroUsuario, Queue <Usuario> pendientes){
        Queue <Usuario> usuarios_aux = new Queue<Usuario>();
        Usuario usuarioSaliente = null;
        while (!pendientes.isEmpty()){
            Usuario usuarioTemporal = pendientes.remove();
            if (usuarioTemporal.getNumeroUsuario() == numeroUsuario){
                usuarioSaliente = usuarioTemporal;
            }
            usuarios_aux.add(usuarioTemporal);
        }
        while (!usuarios_aux.isEmpty()){
            pendientes.add(usuarios_aux.remove()); 
        }
        return usuarioSaliente;
    }

    // REMOVER USUARIO PENDIENTE

    public static void eliminarUsuarioPendiente(Usuario usuarioActual, Queue <Usuario> pendientes){
        Queue <Usuario> usuarios_aux = new Queue<Usuario>();
        while (!pendientes.isEmpty()){
            Usuario usuarioTemporal = pendientes.remove();
            if (!(usuarioTemporal.getNumeroUsuario() == usuarioActual.getNumeroUsuario())){
                usuarios_aux.add(usuarioTemporal);
            }
        }
        while (!usuarios_aux.isEmpty()){
            pendientes.add(usuarios_aux.remove()); 
        }
    }

    // MOSTRAR USUARIOS PENDIENTES 

    public static void mostrarPendientes(Queue <Usuario> pendientes){

        Queue<Usuario> usuarios_aux = new Queue<Usuario>();

        System.out.println("========== USUARIOS PENDIENTES ==========");

        while (!pendientes.isEmpty()) {
            Usuario usuario = pendientes.remove();
            System.out.println("----------------------------------------");
            System.out.println("Número de Usuario: " + usuario.getNumeroUsuario());
            System.out.println("DNI: " + usuario.getDni());
            System.out.println("Nombre: " + usuario.getNombre());
            System.out.println("Dirección: " + usuario.getDireccion());
            System.out.println("Teléfono: " + usuario.getTelefono());
            System.out.println("Libros prestados: " + usuario.getLibrosPrestados());
            System.out.println("----------------------------------------");
            usuarios_aux.add(usuario); 
        }

        System.out.println("========================================");

        while (!usuarios_aux.isEmpty()) {
            pendientes.add(usuarios_aux.remove());
        }
    }

    // MOSTRAR ACCIONES 

    public static void mostrarAccionesRealizadas(Stack <Operaciones> acciones){
        System.out.println("========== ACCIONES REALIZADAS ==========");
        if (acciones.isEmpty()){
            System.out.println("No hay acciones para mostrar...");
        }else{
            Stack <Operaciones> acciones_aux = new Stack<Operaciones>();
            while (!acciones.isEmpty()){
                Operaciones operacion = acciones.pop();
                System.out.println(operacion);
                acciones_aux.push(operacion);
            }
            while(!acciones_aux.isEmpty()){
                acciones.push(acciones_aux.pop());
            }

        }
        
    }

    // ATENCIÓN DE PENDIENTES 

    public static void atenderPendientes(Queue <Usuario> pendientes){
        if (!pendientes.isEmpty()){
            int numeroUsuario = validaciones.validarNumero(sc, "Número de usuario a atender: ");
            Usuario usuarioTemporal = buscarUsuarios(numeroUsuario, pendientes);
            if (usuarioTemporal != null){
                eliminarUsuarioPendiente(usuarioTemporal,pendientes);
                System.out.println("Datos de Usuario atendido:  ");
                System.out.println(usuarioTemporal);
                mostrarPendientes(pendientes);
            }else{
                System.out.println("No se encontro el usuario...");
            }
        }else{
            System.out.println("No hay usuarios en espera...");
        }
    }
}