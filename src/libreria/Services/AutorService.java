/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package libreria.Services;

import Libreria.Entities.Autor;
import java.util.List;
import javax.persistence.NoResultException;
import javax.persistence.NonUniqueResultException;
import libreria.Libreria;
import libreria.Persistencia.AutorDAO;

/**
 * @author Kidver
 */
public class AutorService {

    AutorDAO dao = new AutorDAO();

    public void menuAutores() {
        int aux;
        try {
            do {
                System.out.println("\n        Menu Autores    \n"
                        + "\n"
                        + "     1) Ver lista completa\n"
                        + "     2) Buscar un Autor\n"
                        + "     3) Ingresar un nuevo Autor\n"
                        + "     4) Modificar el nombre de un Autor\n"
                        + "     5) Eliminar un Autor de la base de datos\n"
                        + "     6) Ir al menu principal\n"
                        + "\n"
                        + " Selecciona un numero del menu");
                aux = Libreria.scan.nextInt();

                switch (aux) {
                    case 1:
                        List<Autor> lista = dao.listarAutores();
                        for (Autor a : lista) {
                            System.out.println(a);
                        }
                        break;
                    case 2:
                        Autor a = menuBuscar();
                        if (a != null) {
                            System.out.println(a);
                        }
                        break;
                    case 3:
                        creacion();
                        break;
                    case 4:
                        modificarNombre();
                        break;
                    case 5:
                        eliminar();
                        break;
                    case 6:
                        System.out.println("Saliendo de menu Autores...\n");
                        break;
                    default:
                        System.err.println("Opcion incorrecta\n"
                                + "Seleccione un numero de la lista opciones del menu");
                        break;
                }

            } while (aux != 6);
        } catch (Exception e) {
            e.toString();
            Libreria.scan.close();
        }

    }

    private Autor menuBuscar() {
        try {
            String opc;

            System.out.println("\nComo desea buscar al autor?\n"
                    + "a) por nombre\n"
                    + "b) por ID\n");
            opc = Libreria.scan.next().toLowerCase();
            switch (opc) {
                case "a":
                case "1":
                case "nombre":
                    return buscarPorNombre();
                case "b":
                case "2":
                case "id":
                    return buscarPorID();
                default:
                    System.out.println("Opcion no valida\n");
                    return null;
            }

        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }

    public void listarAutores() {
        dao.listarAutores();
    }

    public Autor creacion() {
        try {
            Integer id;
            String nombre;
            System.out.println("indique el ID");
            id = Libreria.scan.nextInt();
            System.out.println("indique el nombre");
            nombre = Libreria.scan.next();
            Autor autor = new Autor(id, nombre);
            autor.toString();
            System.out.println("creacion exitosa!!\n"
                    + "agregando en la base de datos...");
            dao.guardar(autor);
            System.out.println("Agregado con exito!!!");
            return autor;
        } catch (Exception e) {
            System.out.println(e);
            System.out.println("No se ha podido crear el Autor");
            return null;
        }
    }

    public void modificarNombre() {
        try {
            System.out.println("Editor de nombre Autor");
            Autor autor = menuBuscar();
            System.out.println("Ingrese el nuevo nombre");
            String nombre = Libreria.scan.next();
            autor.setNombre(nombre);
            dao.editar(autor);
            System.out.println("Modificacion exitosa!!");
            autor.toString();
        } catch (Exception e) {
            e.toString();
        }
    }

    public void eliminar() {
        try {
            Autor autor = menuBuscar();
            dao.eliminar(autor);
            System.out.println("Autor Eliminado \n"
                    + "no volvera a escribir");
        } catch (Exception e) {
            System.out.println(e);
            System.out.println("No se ha podido eliminar");
        }

    }

    public Autor buscarPorNombre() {
        try {
            System.out.println("indique el nombre para la busqueda");
            String nombre = Libreria.scan.next();
            Autor autor = dao.buscarNombre(nombre);
            return autor;
        } catch (NoResultException e) {
            System.err.println("No se ha encontrado ningun autor por ese nombre");
            return null;
        } catch (NonUniqueResultException e) {
            System.err.println("hay mas de un autor por este nombre\n"
                    + "Intenta la busqueda por ID");
            return null;
        } catch (Exception e) {
            System.err.println(e);
            return null;
        }
    }

    public Autor buscarPorID() {
        try {
            System.out.println("indique el ID");
            Integer id = Libreria.scan.nextInt();
            Autor autor = dao.buscarID(id);
            if (autor != null) {
                return autor;
            } else {
                System.out.println("No se encontro un autor con el ID proporcionado");
                return null;
            }
        } catch (Exception e) {
            System.err.println(e);
            return null;
        }
    }
}//The end
