/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package libreria.Services;

import Libreria.Entities.Editorial;
import java.util.List;
import libreria.Libreria;
import libreria.Persistencia.EditorialDAO;

/**
 * @author Kidver
 */
public class EditorialService {

    EditorialDAO dao = new EditorialDAO();

    public void menuEditorial() {
        String aux;
        try {
            do {
                System.out.println("\n      °°°°° Menu Editorial °°°°"
                        + "\n       1) Ver lista complea de Editoriales."
                        + "\n       2) Buscar Editorial por ID."
                        + "\n       3) Buscar Editorial por nombre."
                        + "\n       4) Cargar una nueva Editorial en la base de datos."
                        + "\n       5) Modificar el Nombre de la Editorial"
                        + "\n       6) Eliminar una editorial de la base de datos."
                        + "\n       7) Dar alta o baja a una editorial"
                        + "\n       0) Volver al menu principal");
                aux = Libreria.scan.next();

                switch (aux) {
                    case "1":
                        this.mostrarTodos();
                        break;
                    case "2":
                        System.out.println(
                                this.buscarPorID());
                        break;
                    case "3":
                        System.out.println(
                                this.buscarPorNombre());
                        break;
                    case "4":
                        System.out.println(
                                this.creacion());
                        break;
                    case "5":
                        System.out.println(
                                this.modificarNombre());
                        break;
                    case "6":
                        this.eliminacion();
                        break;
                    case "7":
                        this.darAltaBaja();
                        break;
                    case "0":
                        System.out.println("Volviendo al menu principal...");
                        break;
                    default:
                        System.out.println("Opcion incorrecta.");

                }

            } while (!aux.equals("0"));
        } catch (Exception e) {
        }
    }

    public void mostrarTodos() {
        try {
            List<Editorial> list = dao.listarTodos();
            for (Editorial editorial : list) {
                System.out.println(editorial);
            }
        } catch (Exception e) {
            throw e;
        }
    }

    public Editorial creacion() {
        String nombre;
        Editorial editorial;
        try {
            System.out.println("Ingrese el Nombre de la Editorial");
            nombre = Libreria.scan.next();
            editorial = dao.buscarNombre(nombre);
            if (!editorial.getNombre().equalsIgnoreCase(nombre)) {
                editorial = new Editorial();
                editorial.setNombre(nombre);
                dao.guardar(editorial);
                System.out.println("Creacion exitosa!!!");
                return editorial;
            } else {
                System.out.println("La editorial ya se encuentra en la base de datos.");
                return null;
            }
        } catch (Exception e) {
            System.err.println("Creacion fallida");
            System.out.println(e);
            return null;
        }

    }

    public Editorial modificarNombre() {
        String nombre;
        Editorial editorial;
        editorial = this.menuBuscar();

        try {
            System.out.println("Escriba el nuevo nombre para la editorial.");
            nombre = Libreria.scan.next();
            editorial.setNombre(nombre);
            dao.editar(editorial);
            System.out.println("Nombre actualizado!!!");
            System.out.println(editorial);
            return editorial;

        } catch (Exception e) {
            System.out.println(e);
            return null;
        }

    }

    public void eliminacion() {
        Editorial editorial;
        editorial = this.buscarPorID();
        dao.eliminar(editorial);
        System.out.println("Eliminando...\n");
    }

    private Editorial menuBuscar() {
        Editorial editorial;
        int aux;
        do {
            System.out.println("Elige el metodo de busqueda.\n"
                    + "1) Busqueda por ID.\n"
                    + "2) Busqueda por nombre.\n");
            try {
                aux = Libreria.scan.nextInt();
            } catch (Exception e) {
                aux = 0;
                Libreria.scan.next();
            }
            switch (aux) {
                case 1:
                    editorial = this.buscarPorID();
                    break;
                case 2:
                    editorial = this.buscarPorNombre();
                    break;
                default:
                    System.err.println("Opcion incorrecta.");
                    editorial = null;
                    break;
            }
        } while (aux != 1 && aux != 2);

        return editorial;
    }

    public Editorial buscarPorID() {
        try {
            System.out.println("indique el ID para la busqueda");
            Integer id = Libreria.scan.nextInt();
            Editorial editorial = dao.buscarID(id);
            return editorial;
        } catch (Exception e) {
            System.out.println(e);
            Libreria.scan.next();
            return null;
        }
    }

    public Editorial buscarPorNombre() {
        Editorial editorial;
        String nombre;
        System.out.println("Ingrese el nombre para la busqueda");
        nombre = Libreria.scan.next();
        editorial = dao.buscarNombre(nombre);
        return editorial;
    }

    public void darAltaBaja() {
        Editorial editorial = menuBuscar();
        String aux;
        System.out.println(editorial);
        System.out.println("Estado acual de la editorial: " + editorial.getAlta());
        System.out.println("Desea modificar el estado? Y/N");
        try {

            do {
                aux = Libreria.scan.next().toUpperCase();
                if (!aux.equalsIgnoreCase("Y") && !aux.equalsIgnoreCase("N")) {
                    System.out.println("Debes elegir Y o N");
                } else {
                    if (aux.equals("Y")) {
                        //cambia estdo
                        if (editorial.getAlta() == true) {
                            editorial.setAlta(Boolean.FALSE);
                        } else {
                            editorial.setAlta(true);
                        }

                        dao.editar(editorial);
                        System.out.println("Estado cambiado.");
                    }
                    if (aux.equalsIgnoreCase("N")) {
                        System.out.println("No se ha cambiado el estado de la editorial.");
                    }
                }
            } while (!aux.equals("Y") && !aux.equals("N"));

        } catch (Exception e) {
            System.out.println("Error en cabio alta_Baja");
            System.out.println(e);
        }
    }
}//The end
