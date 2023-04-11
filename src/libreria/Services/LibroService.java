/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package libreria.Services;

import Libreria.Entities.Autor;
import Libreria.Entities.Libro;
import libreria.Libreria;
import libreria.Persistencia.LibroDAO;

/**
 * @author Kidver
 */
public class LibroService {

    LibroDAO dao = new LibroDAO();
    AutorService autorService = new AutorService();

    public void menuLibros() {
        String aux;
        try {
            do {
                System.out.println("\n      °°°°° Menu Libros °°°°"
                        + "\n       1) Ver lista complea de libros."
                        + "\n       2) Buscar libro."
                        + "\n       3) Cargar un nuevo libro en la base de datos."
                        + "\n       4) Modificar Titulo del libro"
                        + "'n       10) Volver al menu principal");
                aux = Libreria.scan.next();

                switch (aux) {
                    case "1":
                    case "2":
                    case "3":
                        this.creacion();
                        break;
                    case "4":
                    case "10":
                        System.out.println("Volviendo al menu principal...");
                        break;
                    default:
                        
                }

            } while (!aux.equals("10"));
        } catch (Exception e) {
        }
    }

    public void menuBusqueda(){
        String aux;
        System.out.println("            Elige el Metodo de busqueda"
                + "             1) Busqueda por ISBN."
                + "             2) Busqueda Por Titulo."
                + "             3) Busqueda por Autor."
                + "             4) Busqueda pot editorial."
                + "             5) Regresar al menu anterior.");
        aux=Libreria.scan.next();
        switch (aux) {
            case "1":
                
                break;
            default:
                throw new AssertionError();
        }
        
    }
    public void creacion() {

        try {
            Libro libro = new Libro();
            System.out.println("ingrese codigo ISBN");
            long isbn = Libreria.scan.nextLong();
            libro.setIsbn(isbn);
            System.out.println("ingrese titulo");
            String titulo = Libreria.scan.next();
            libro.setTitulo(titulo);
            System.out.println("ingrese año");
            Integer anio = Libreria.scan.nextInt();
            libro.setAnio(anio);
            System.out.println("lista de Autores existentes en la base de datos");
            autorService.listarAutores();
            Autor autor = autorService.buscarPorID();
            if (autor != null) {
                libro.setAutor(autor);
            } else {
                System.out.println("\nNo se ha encontrado el ID ingresado"
                        + "\nCreando Nuevo Autor");
                autor = autorService.creacion();
                libro.setAutor(autor);
            }
            dao.guardar(libro);
        } catch (Exception e) {
            System.out.println(e);
        }

    }

    public void modificacion() {

    }

    public void eliminacion() {

    }

    public Libro buscarPorISBN() {
        try{
        System.out.println("indique el ISBN para la busqueda");
        Long id = Libreria.scan.nextLong();
        Libro autor = dao.buscarISBN(id);
        return autor;
        }catch(Exception e){
            System.out.println("No se ha encontrado un Libro con ese ISBN");
            return null;
        }
    }

}//The end
