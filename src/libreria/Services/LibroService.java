/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package libreria.Services;

import Libreria.Entities.Autor;
import Libreria.Entities.Libro;
import java.util.List;
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
                        this.mostarTodos();
                        break;
                    case "2":
                        this.menuBusqueda();
                        break;
                    case "3":
                        this.creacion();
                        break;
                    case "4":
                        break;
                    case "10":
                        System.out.println("Volviendo al menu principal...");
                        break;
                    default: 
                        System.out.println("Opcion incorrecta.");

                }

            } while (!aux.equals("10"));
        } catch (Exception e) {
        }
    }

    private void menuBusqueda() {
        String aux;
        System.out.println("            Elige el Metodo de busqueda"
                + "\n             1) Busqueda por ISBN."
                + "\n             2) Busqueda Por Titulo."
                + "\n             3) Busqueda por Autor."
                + "\n             4) Busqueda pot editorial."
                + "\n             5) Regresar al menu anterior.");
        aux = Libreria.scan.next();
        switch (aux) {
            case "1":
                System.out.println(
                        this.buscarPorISBN());
                break;
            case "2":
                this.buscarPorTitulo();
                break;
            default:
                System.out.println("Opcion incorrecta.");
        }

    }

    private void creacion() {

        try {
            Libro libro = new Libro();
           
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

    private Libro buscarPorISBN() {
        try {
            System.out.println("indique el ISBN para la busqueda.");
            Long ISBN = Libreria.scan.nextLong();
            Libro autor = dao.buscarISBN(ISBN);
            return autor;
        } catch (Exception e) {
            System.out.println("No se ha encontrado un Libro con ese ISBN.");
            throw e;
        }
    }

    private void buscarPorTitulo() {
            String titulo;
            List lista;
        try {
            System.out.println("Digite el Titulo del libro que desea buscar.");
            titulo = Libreria.scan.next();
            lista = dao.buscarNombre(titulo);
            if (lista.isEmpty()) {
                System.out.println("No se han encontrado coincidencias");
                
            } else {
                System.out.println("Se han encontrado "+ lista.size()+" coincidencias");
                for (Object object : lista) {
                    object.toString();
                }
            }
            
        } catch (Exception e) {
            throw e;
        }
    }
    
    private void mostarTodos(){
        try{
        List<Libro> list = dao.listarLibros();
        for (Libro libro : list) {
            System.out.println(libro);
        }
        }catch(Exception e){
            throw e;
        }
    }
    
}//The end
