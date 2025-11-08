package ui;

import servicios.BibliotecaService;
import estructuras.Validaciones.validaciones;

public class MenuPrincipal {
    
    private final BibliotecaService bibliotecaService;

    // constructos 
    public MenuPrincipal(BibliotecaService bibliotecaService) {
        this.bibliotecaService = bibliotecaService;
    }

    public void mostrar() {
        int opcion;
        do {
            validaciones.clearScreen();
            System.out.println("=== BIBLIOTECA SYSTEM ===");
            System.out.println("1. Gestion de Libros");
            System.out.println("2. Gestion de Usuarios");
            System.out.println("3. Operaciones de Prestamo/Devolucion");
            System.out.println("0. Salir");
            opcion = validaciones.readInt("Seleccione una opcion: ");

            switch (opcion) {
                //  se creo una intancia del menu  donde puedo acceder a las funciones de la bibiliotecaService
                case 1 -> new MenuLibros(bibliotecaService).mostrar();
                case 2 -> new MenuUsuarios(bibliotecaService).mostrar();
                case 3 -> new MenuOperaciones(bibliotecaService).mostrar();
                case 0 -> System.out.println("Saliendo del sistema...");
                default -> System.out.println("Opcion invalida");
            }
        } while (opcion != 0);
    }


}