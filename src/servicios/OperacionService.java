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

    // PRESTAMOS 

    public static void prestarLibro(BinarySearchTree <Usuario> usuarios, BinarySearchTree <Libro> libros, Stack <Operaciones> acciones, Queue <String> pendientes){
        Scanner sc = new Scanner(System.in);
        String nombre = validaciones.validarTextoIngresado(sc, "Usuario a buscar: ");
        Usuario usuario = new Usuario(0," ",nombre, " ", " ");
        if (usuarios.buscar1(usuario) != null){
            int code = validaciones.validarNumero(sc, "Código del libro: ");
            Libro libro = new Libro(code, " ", " ", 0.0, true);
            if (libros.buscar1(libro) != null){
                Usuario usuarioEcontrado = usuarios.buscar1(usuario);
                Libro libroEncontrado = libros.buscar1(libro);
                if (libroEncontrado.isDisponible()){
                    libroEncontrado.setDisponible(false);
                    usuarioEcontrado.setLibrosPrestados(usuarioEcontrado.getLibrosPrestados() + 1);
                    Operaciones operacion = new Operaciones("1", "Prestamo", libroEncontrado, usuarioEcontrado, LocalDate.now());
                    acciones.push(operacion);
                }else{
                    pendientes.add(usuarioEcontrado.getNombre());
                }

            }else{
                System.out.println("Libro no encontrado...");
            }
        }else{
            System.out.println("Usuario no encontrado...");
        }
    }

    // DEVOLUCIONES 



    }

    
    
}