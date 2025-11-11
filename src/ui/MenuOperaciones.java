package ui;

import servicios.ServicioPrincipal;
import estructuras.Validaciones.validaciones;


public class MenuOperaciones {
    private final ServicioPrincipal bibliotecaService;

    public MenuOperaciones(ServicioPrincipal bibliotecaService) {
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
            System.out.println("4. Atender pendientes");
            System.out.println("0. Volver");
            opcion = validaciones.readInt("Seleccione una opción: ");

            switch (opcion) {
                case 1 -> bibliotecaService.registrarPrestamo();
                case 2 -> bibliotecaService.registrarDevolucion();
                case 3 -> bibliotecaService.deshacerUltimaOperacion();
                case 4 -> bibliotecaService.atenderPendientes();
                case 0 -> System.out.println("Volviendo al menu principal...");
                default -> System.out.println("Opcion invalida");
            }
            validaciones.pause();
        } while (opcion != 0);
    }

}