package ui;

import servicios.ServicioPrincipal;
import estructuras.Validaciones.validaciones;



public class MenuLibros {
    private final ServicioPrincipal bibliotecaService;

    public MenuLibros(ServicioPrincipal bibliotecaService) {
        this.bibliotecaService = bibliotecaService;
    }

    public void mostrar() {
        int opcion;
        do {
            System.out.println("pepe");
            validaciones.limpiarPantalla();
            System.out.println("=== GESTION DE LIBROS ===");
            System.out.println("1. Registrar nuevo libro");
            System.out.println("2. Buscar libro por codigo");
            System.out.println("3. Mostrar catalogo completo");
            System.out.println("4. Buscar libros por autor");
            System.out.println("5. Calcular monto total de libros Prestados");
            System.out.println("0. Volver al menu principal");
            opcion = validaciones.readInt("Seleccione una opcion: ");

            switch (opcion) {
                case 1 -> bibliotecaService.registrarLibro();
                case 2 -> bibliotecaService.buscarLibro();
                case 3 -> bibliotecaService.mostrarCatalogo();
                // case 4 -> bibliotecaService.buscarLibrosPorAutor();
                // case 5 -> bibliotecaService.calcularMontoTotalPrestados();
                case 0 -> System.out.println("Volviendo al menu principal...");

                default -> System.out.println("Opcion invalida");
            }
            validaciones.pause();
        } while (opcion != 0);
    }
  
}