package ui;

import servicios.ServicioPrincipal;
import Modelo.Libro;
import estructuras.Validaciones.validaciones;
import estructuras.listaEnlazadas.SimpleLinkedList;




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
                case 4 -> buscarPorAutor();
                case 5 -> calcularMontoTotalPrestados();
                case 0 -> System.out.println("Volviendo al menu principal...");

                default -> System.out.println("Opcion invalida");
            }
            validaciones.pause();
        } while (opcion != 0);
    }
    private void buscarPorAutor() {
        System.out.println("\n=== BUSCAR LIBROS POR AUTOR ===");
        String autor = validaciones.readString("Ingrese nombre del autor: ");
        SimpleLinkedList<Libro> resultados = bibliotecaService.buscarLibrosPorAutor(autor);

        if (resultados.size() > 0) {
            System.out.println("\nLIBROS ENCONTRADOS:");
            for (Libro libro : resultados) {
                System.out.println(libro);
            }
            System.out.println("Total: " + resultados.size() + " libros");
        } else {
            System.out.println("No se encontraron libros de este autor");
        }
    }
    public static void calcularMontoTotalPrestados() {
        // double total = bibliotecaService.totalPrestados();
        
    }
}