package ui;

import estructuras.Validaciones.validaciones;
import java.util.Scanner;

import servicios.BibliotecaService;

public class MenuUsuarios {

    private final BibliotecaService bibliotecaService;

    
    Scanner scanner= new Scanner(System.in);

    public MenuUsuarios(BibliotecaService bibliotecaService) {
        this.bibliotecaService = bibliotecaService;
    }

    public void mostrar() {
        int opcion;
        do {
            validaciones.clearScreen();
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
                case 3 -> bibliotecaService.listarUsuariosConMasLibros();
                case 4 -> bibliotecaService.mostrarUsuariosRegistrados();

                default -> System.out.println("Opcion invalida");
            }
            validaciones.pause();
        } while (opcion != 0);
    }

  
}
