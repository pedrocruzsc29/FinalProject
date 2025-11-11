package servicios;

import Modelo.Libro;
import estructuras.Validaciones.validaciones;
import estructuras.arboles.BinarySearchTree;
import estructuras.listaEnlazadas.SimpleLinkedList;

import java.util.Scanner;


public class LibroService {
    public static Scanner input = new Scanner(System.in);

    // Inserta un nuevo libro en el árbol y en el arreglo
    public static void insertarLibro(BinarySearchTree<Libro> librosArbol, Libro[] librosArreglo){
        System.out.println("\n=== REGISTRAR NUEVO LIBRO ===");
        int codigo = generarCodigoUnico(librosArbol);
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
            double precio = validaciones.readDouble("ingrese el precio de libro " + titulo);
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
    // Busca un libro por código e imprime su información
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
    // ----------------------------------------------------------------------------------------------------------

    // Muestra el catálogo completo de libros (inOrder)
    public static void mostrarInOrder(BinarySearchTree<Libro> libros){
        System.out.println("\n=== CATÁLOGO COMPLETO ===");
        System.out.println("estos son los libros mostrados en orden ");
        libros.inOrder();
    }
    // ----------------------------------------------------------------------------------------------------------

    // Busca un libro por código (usando el árbol binario)
    public static Libro buscarPorCodigo(int codigo, BinarySearchTree<Libro> arbolLibros) {
        Libro libroTemp = new Libro(codigo, "", "", 0.0, true);
        return arbolLibros.get(libroTemp);
    }

     public static int generarCodigoUnico(BinarySearchTree<Libro> librosArbol) {
        int codigo;
        do {
            codigo = (int) (Math.random() * 1000);
        } while (buscarPorCodigo(codigo, librosArbol) != null);
        return codigo;
    }
    // ----------------------------------------------------------------------------------------------------------


     public static SimpleLinkedList<Libro> buscarLibrosPorAutor(String autor, Libro[] arrgloLibro) {
        SimpleLinkedList<Libro> resultados = new SimpleLinkedList<>();
        if (autor == null || autor.trim().isEmpty()) return resultados;
        for (Libro libro : arrgloLibro) {
            if (libro != null && autor.equalsIgnoreCase(libro.getAutor())) {
                resultados.addFirst(libro);
            }
        }
        return resultados;
    }


    public static double calcularMontoTotalPrestados(Libro[] arregloLibro) {
        double total = 0.0;
        for (Libro libro : arregloLibro) {
            if (libro != null && libro.isDisponible() == false) {
                total += libro.getPrecio();
            }
        }
        return total;
    }

     
    
    
}