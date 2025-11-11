package ui;

import servicios.BibliotecaService;
import estructuras.Validaciones.validaciones;


public class MenuOperaciones {
    private final BibliotecaService bibliotecaService;

    public MenuOperaciones(BibliotecaService bibliotecaService) {
        this.bibliotecaService = bibliotecaService;
    }

    public void mostrar() {
        int opcion;
        do {

            validaciones.limpiarPantalla();
            System.out.println("=== OPERACIONES ===");
            System.out.println("1. Registrar préstamo");
            System.out.println("2. Registrar devolución");
            System.out.println("3. Deshacer última operación");
            System.out.println("0. Volver");
            opcion = validaciones.readInt("Seleccione una opción: ");

            switch (opcion) {
                case 1 -> bibliotecaService.registrarPrestamo();
                case 2 -> bibliotecaService.registrarDevolucion();
                case 3 -> bibliotecaService.deshacerUltimaOperacion();
                case 0 -> System.out.println("Volviendo al menú principal...");
                default -> System.out.println("Opcion invalida");
            }
            validaciones.pause();
        } while (opcion != 0);
    }

}