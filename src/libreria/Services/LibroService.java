/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package libreria.Services;

import Libreria.Entities.Autor;
import Libreria.Entities.Editorial;
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
    EditorialService ediSer = new EditorialService();

    public void menuLibros() {
        String aux;
        try {
            do {
                System.out.println("\n      °°°°° Menu Libros °°°°"
                        + "\n       1) Ver lista complea de libros."
                        + "\n       2) Buscar libro."
                        + "\n       3) Cargar un nuevo libro en la base de datos."
                        + "\n       4) Modificar Titulo del libro"
                        + "\n       5) Volver al menu principal");
                aux = Libreria.scan.next();

                switch (aux) {
                    case "1":
                        this.mostrarTodos();
                        break;
                    case "2":
                        this.menuBusqueda();
                        break;
                    case "3":
                        this.creacion();
                        break;
                    case "4":
                        break;
                    case "5":
                        System.out.println("Volviendo al menu principal...");
                        break;
                    default:
                        System.out.println("Opcion incorrecta.");

                }

            } while (!aux.equals("5"));
        } catch (Exception e) {
        }
    }

    private void menuBusqueda() {
        String aux;
        System.out.println("            Elige el Metodo de busqueda"
                + "\n             1) Busqueda por ISBN."
                + "\n             2) Busqueda Por Titulo."
                + "\n             3) Busqueda por Autor."
                + "\n             4) Busqueda por editorial."
                + "\n             5) Editar informacion."
                + "\n             6) Eliminar un libro de la base de datos."
                + "\n             7) Regresar al menu anterior.");
        aux = Libreria.scan.next();
        switch (aux) {
            case "1":
                System.out.println(
                        this.buscarPorISBN());
                break;
            case "2":
                this.buscarPorTitulo();
                break;
            case "3":
                this.BuscarLibrosAutor();
                break;
            case "4":
                this.BuscarLibrosEditorial();
                break;
            case "5":
                break;
            case "6":
                this.eliminarLibro();
                break;
            case "7":
                System.out.println("Volviendo al menu de Libros...");
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

            System.out.println("lista de Editoriales existentes en la base de datos");
            ediSer.mostrarTodos();
            Editorial editorial = ediSer.buscarPorID();
            if (editorial!=null) {
                libro.setEditorial(editorial);
            } else {
                System.out.println("Editorial no encontrada"
                        + "\nCreando nueva editorial.");
                editorial=ediSer.creacion();
                libro.setEditorial(editorial);
                
            }
            
            
            dao.guardar(libro);
        } catch (Exception e) {
            System.out.println(e);
        }

    }

    public void modificacion() {

    }

    public void eliminarLibro() {
        Libro libro;
        libro = this.buscarPorISBN();
        dao.eliminar(libro);
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
        List<Libro> lista;
        try {
            System.out.println("Digite el Titulo del libro que desea buscar.");
            titulo = Libreria.scan.next();
            lista = dao.buscarTitulo(titulo);

            if (lista.isEmpty()) {
                System.out.println("No se han encontrado coincidencias");

            } else {
                System.out.println("Se han encontrado " + lista.size() + " coincidencias");
                for (Libro libro : lista) {
                    System.out.println(libro);
                }
            }
        } catch (Exception e) {
            throw e;
        }
    }

    private void BuscarLibrosAutor() {
        String nombre;
        List<Libro> lista;
        try {
            System.out.println("Digite El nombre del Autor.");
            nombre = Libreria.scan.next();
            lista = dao.buscarPorAutor(nombre);
            if (lista.isEmpty()) {
                System.out.println("No se han encontrado libros de éste autor");
            } else {
                System.out.println("Se han encontrado " + lista.size() + "Libros de este autor");
                for (Libro libro : lista) {
                    System.out.println(libro);
                }
            }

        } catch (Exception e) {

        }
    }

    private void BuscarLibrosEditorial() {
        String nombre;
        List<Libro> lista;
        try {
            System.out.println("Digite El nombre de la Editorial.");
            nombre = Libreria.scan.next();
            lista = dao.buscarPorEditorial(nombre);
            if (lista.isEmpty()) {
                System.out.println("No se han encontrado libros de ésta Editorial");
            } else {
                System.out.println("Se han encontrado " + lista.size() + "Libros de este autor");
                for (Libro libro : lista) {
                    System.out.println(libro);
                }
            }

        } catch (Exception e) {

        }
    }

    private void mostrarTodos() {
        try {
            List<Libro> list = dao.listarLibros();
            for (Libro libro : list) {
                System.out.println(libro);
            }
        } catch (Exception e) {
            throw e;
        }
    }

}//The end
