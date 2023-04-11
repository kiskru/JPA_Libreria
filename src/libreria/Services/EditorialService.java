/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package libreria.Services;

import Libreria.Entities.Editorial;
import libreria.Libreria;
import libreria.Persistencia.EditorialDAO;

/**
 * @author Kidver
 */
public class EditorialService {
    
    EditorialDAO dao = new EditorialDAO();

    public void consulta() {

    }

    public void creacion() {

    }

    public void modificacion() {

    }

    public void eliminacion() {

    }
    
    public Editorial buscarPorID() {
        System.out.println("indique el ID para la busqueda");
        Integer id = Libreria.scan.nextInt();
        Editorial autor = dao.buscarID(id);
        return autor;
    }
    
}//The end
