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
            validaciones.limpiarPantalla();
            System.out.println("=== BIBLIOTECA SYSTEM ===");
            System.out.println("\n\033[0;33m 1. Gestion de Libros");
            System.out.println("\n\033[0;34m 2. Gestion de Usuarios");
            System.out.println("\n\033[0;35m 3. Operaciones de Prestamo/Devolucion");
            System.out.println("\n\033[0;36m 0. Salir\n\033[0m");
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