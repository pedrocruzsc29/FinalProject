package ui;

import servicios.BibliotecaService;
import estructuras.Validaciones.validaciones;



public class MenuLibros {
    private final BibliotecaService bibliotecaService;

    public MenuLibros(BibliotecaService bibliotecaService) {
        this.bibliotecaService = bibliotecaService;
    }

    public void mostrar() {
        int opcion;
        do {
            System.out.println("pepe");
            validaciones.clearScreen();
            System.out.println("=== GESTION DE LIBROS ===");
            System.out.println("1. Registrar nuevo libro");
            System.out.println("2. Buscar libro por codigo");
            System.out.println("3. Mostrar catalogo completo");
            System.out.println("4. Buscar libros por autor");
            System.out.println("5. Calcular monto total de libros Prestados");
            System.out.println("0. Volver al menu principal");
            opcion = validaciones.readInt("Seleccione una opcion: ");

            switch (opcion) {

                case 0 -> {
                }
                default -> System.out.println("Opcion invalida");
            }
            validaciones.pause();
        } while (opcion != 0);
    }
  
}