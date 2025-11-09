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
        Usuario usuarioTemp = new Usuario(0," ",nombre, " ", " ");
        Usuario usuarioEcontrado = usuarios.buscar1(usuarioTemp);
        if (usuarioEcontrado != null){
            int code = validaciones.validarNumero(sc, "Código del libro: ");
            Libro libroTemporal = new Libro(code, " ", " ", 0.0, true);
            Libro libroEncontrado = libros.buscar1(libroTemporal);
            if (libroEncontrado != null){
                if (libroEncontrado.isDisponible()){
                    libroEncontrado.setDisponible(false);
                    usuarioEcontrado.setLibrosPrestados(usuarioEcontrado.getLibrosPrestados() + 1);
                    Operaciones operacion = new Operaciones("1", "Prestamo", libroEncontrado, usuarioEcontrado, LocalDate.now());
                    acciones.push(operacion);
                    System.out.println("*** Prestamo realizado exitosamente ***");
                }else{
                    pendientes.add(usuarioEcontrado.getNombre());
                    System.out.println("Libro no disponible. Usuario agregado a PENDIENTES...");
                }
            }else{
                System.out.println("Libro no encontrado...");
            }
        }else{
            System.out.println("Usuario no encontrado...");
            
        }   
    }    

    // DEVOLUCIONES 

    public static void devolverLibro(BinarySearchTree <Usuario> usuarios, BinarySearchTree <Libro> libros, Stack <Operaciones> acciones, Queue <String> pendientes){
        Scanner sc = new Scanner(System.in);
        String nombre = validaciones.validarTextoIngresado(sc, "Usuario a buscar: ");
        Usuario usuarioTemp = new Usuario(0," ",nombre, " ", " ");
        Usuario usuarioEcontrado = usuarios.buscar1(usuarioTemp);
        if (usuarioEcontrado != null){

            int code = validaciones.validarNumero(sc, "Código del libro: ");
            Libro libroTemporal = new Libro(code, " ", " ", 0.0, true);
            Libro libroEncontrado = libros.buscar1(libroTemporal);
            if (libroEncontrado != null){
                if (libroEncontrado.isDisponible() == false){
                    libroEncontrado.setDisponible(true);
                    usuarioEcontrado.setLibrosPrestados(usuarioEcontrado.getLibrosPrestados() - 1);
                    Operaciones operacion = new Operaciones("1", "Devolución", libroEncontrado, usuarioEcontrado, LocalDate.now());
                    acciones.push(operacion);
                    System.out.println("*** Devolución realizada exitosamente ***");
                }else{
                    System.out.println("El libro se encuentra disponible...");
                    
                }
            }else{
                System.out.println("Libro no encontrado...");
            }    

        }else{
            System.out.println("Usuario no encontrado...");
        }
    }
        


    
}