package ui;

import estructuras.Validaciones.validaciones;
import java.util.Scanner;
import estructuras.listaEnlazadas.SimpleLinkedList;
import servicios.ServicioPrincipal;
import Modelo.Usuario;

public class MenuUsuarios {

    private final ServicioPrincipal bibliotecaService;

    
    Scanner scanner= new Scanner(System.in);

    public MenuUsuarios(ServicioPrincipal bibliotecaService) {
        this.bibliotecaService = bibliotecaService;
    }

    public void mostrar() {
        int opcion;
        do {
            validaciones.limpiarPantalla(); 
            System.out.println("=== GESTION DE USUARIOS ===");
            System.out.println("1. Registrar nuevo usuario");
            System.out.println("2. Buscar usuario");
            System.out.println("3. Listar usuarios con mas X libros");
            System.out.println("4. Usuarios registrados");
            System.out.println("0. Volver");
            opcion = validaciones.readInt("Seleccione una opcion: ");

            switch (opcion) {
                case 1 -> bibliotecaService.registrarUsuario();
                case 2 -> bibliotecaService.buscarUsuario();
                case 3 -> listarUsuariosConMasLibros();
                case 4 -> bibliotecaService.mostrarUsuariosRegistrados();
                case 0 -> System.out.println("Volviendo al menu principal...");
                default -> System.out.println("Opcion invalida");
            }
            validaciones.pause();
        } while (opcion != 0);
    }


    private  void listarUsuariosConMasLibros(){
        System.out.println("\n╔════════════════════════════════════════════════════╗");
        System.out.println("║     USUARIOS CON MÁS DE X LIBROS PRESTADOS         ║");
        System.out.println("╚════════════════════════════════════════════════════╝");
        
        int cantidadMinima = validaciones.readInt("Ingrese cantidad mínima de libros: ");
        SimpleLinkedList<Usuario> usuarios = bibliotecaService.listarUsuariosConMasDeXLibros(cantidadMinima);

        if (usuarios.size() > 0) {
            System.out.println("│   Nº USUARIO │ NOMBRE                  │");
            
            // Recorrer la lista enlazada usando el API de SimpleLinkedList
            for (int i = 0; i < usuarios.size(); i++) {
                Usuario u = usuarios.obtenerPosicion(i);
                System.out.printf("│ %-12s │ %-23s │%n", u.getNumeroUsuario(), u.getNombre());
            }
            
            System.out.println("\nTotal encontrado: " + usuarios.size() + " usuario");
        } else {
            System.out.println("\nNo se encontraron usuarios con " + cantidadMinima + " o más libros prestados");
        }

    }

  
}
