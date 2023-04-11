/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package libreria;

import java.util.Scanner;
import libreria.Services.AutorService;
import libreria.Services.LibroService;

/**
 * @author Kidver
 */
public class Libreria {

    public static Scanner scan = new Scanner(System.in).useDelimiter("\n");

    public static void main(String[] args) {

        AutorService autSer = new AutorService();
        LibroService libSer = new LibroService();
        String opc;
        try {
            do {
                System.out.println("\n      Bienvenido a S.A.L\n"
                        + "     Sistema Administracion de Libreria\n"
                        + "---Menu principal---\n"
                        + "1) Libros\n"
                        + "2) Autores\n"
                        + "3) Editoriales\n"
                        + "4) Salir\n");
                opc = scan.next().toLowerCase();

                switch (opc) {
                    case "1":
                    case "libros":
                        break;
                    case "2":
                    case "autores":
                        autSer.menuAutores();
                        break;
                    case "3":
                    case "editoriales":
                        break;

                    case "4":
                    case "salir":
                        System.out.println("Cerrando S.A.L..."
                                + "\nHasta luego\n");
                        break;

                    default:
                        System.err.println("Opcion no valida");
                        break;
                }
                System.out.println();
            } while (!opc.equals("4") && !opc.equals("salir"));
        } catch (Exception e) {
            System.out.println(e);
            System.err.println("Error en el sistema");
            scan.close();
        }
        
    }

}//The end
