package servicios;

import Modelo.Libro;
import estructuras.Validaciones.validaciones;
import estructuras.arboles.BinarySearchTree;
import java.util.Scanner;


public class LibroService {
    public static Scanner input = new Scanner(System.in);

    public static void insertarLibro(BinarySearchTree<Libro> librosArbol, Libro[] librosArreglo){
        System.out.println("\n=== REGISTRAR NUEVO LIBRO ===");
        int codigo = validaciones.validarNumero(input, "ingrese el codigo ");
        Libro auxiliar = new Libro(codigo, "","",00,false);
        Libro encontrado = librosArbol.buscar1(auxiliar);
        int contador = 0;
        for (Libro libro : librosArreglo) {
            if(libro != null){
                contador++;
            }
        }
        if(encontrado == null && contador < librosArreglo.length ){
            String titulo = validaciones.validarTextoIngresado(input, "ingrese el titulo del libro: ");
            String autor = validaciones.validarTextoIngresado(input, "ingrese el nombre del autor de " + titulo);
            double precio = validaciones.readDouble("ingrese el precio de libro "+ titulo);
            boolean disponible = true;
            Libro libro = new Libro(codigo, titulo,autor,precio,disponible);
            librosArbol.add(libro);
            librosArreglo[contador] = libro;
            System.out.println("se agrego el libro a la biblioteca.");
        }
        else{
            System.out.println("ERROR!!!!!!!");
            System.out.println("el libros ya esta registrado en la biblioteca.");
        }
    }
    public static void buscaLibro(BinarySearchTree<Libro> librosArbol){
        System.out.println("\n=== BUSCAR LIBRO POR CÓDIGO ===");
        int codigo = validaciones.readInt("Ingrese código del libro: ");
        Libro auxiliar = new Libro(codigo, "","",00,false);
        Libro encontrado = librosArbol.buscar1(auxiliar);
        if(encontrado == null){
            System.out.println("no se encontro el libro que se estaba bucando");
        }
        System.out.println("El libro fue encontardo con exito");
        System.out.println(encontrado);
    }
    public static void mostrarInOrder(BinarySearchTree<Libro> libros){
        System.out.println("\n=== CATÁLOGO COMPLETO ===");
        System.out.println("estos son los libros mostrados en orden ");
        libros.inOrder();
    }
    
    
    
}