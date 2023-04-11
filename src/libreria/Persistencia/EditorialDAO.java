/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package libreria.Persistencia;

import Libreria.Entities.Editorial;


/**
 * @author Kidver
 */

public class EditorialDAO extends DAO<Editorial>{

@Override
    public void guardar(Editorial edit){
        super.guardar(edit);
    }

    @Override
    public void editar(Editorial edit){
        super.editar(edit);
    }
    
    @Override
    protected void eliminar(Editorial edit) {
        super.eliminar(edit);
    }
     public Editorial buscarID(Integer id){        
        conectar();
        Editorial edit =
        em.find(Editorial.class, id);
        desconectar();
        return edit;
    }
}//The end
