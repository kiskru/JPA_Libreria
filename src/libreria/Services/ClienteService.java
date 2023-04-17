/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package libreria.Services;

import java.util.List;
import libreria.Entities.Cliente;
import libreria.Libreria;
import libreria.Persistencia.ClienteDAO;

/**
 * @author Kidver
 */
public class ClienteService {

    public void menuClientes() {
        
        ClienteDAO dao = new ClienteDAO();
        
        String aux;
        do {
            System.out.println("\n"
                    + "       °  Menu Clientes  °        \n"
                    + "\n"
                    + "1) Ver todos los clientes.\n"
                    + "2) Buscar Cliente.\n"
                    + "3) Crear cliente.\n"
                    + "4) Eliminar Cliente.\n"
                    + "0) Volver al menu principal.\n");

            aux = Libreria.scan.next();
            switch (aux) {
                case "1":
                    this.listarClientes();
                    break;
                case "2":
                    this.menuBuscar();
                    break;
                case "3":
                    System.out.println(
                            this.crearCliente());
                    break;
                case "4":
                    this.eliminarCliente();
                    break;
                case "0":
                    System.out.println("Saliendo menu clientes...\n");
                    break;
                default:
                    throw new AssertionError();
            }
        } while (!aux.equals("0"));

    }//fin menu
    
    private void listarClientes(){
        List<Cliente> lista;
        lista = dao.
    }

}//The end
