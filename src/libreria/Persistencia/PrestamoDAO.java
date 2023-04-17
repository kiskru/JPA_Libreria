/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package libreria.Persistencia;

import libreria.Entities.Prestamo;


/**
 * @author Kidver
 */

public class PrestamoDAO extends DAO<Prestamo>{

    @Override
    public void guardar(Prestamo edit) {
        super.guardar(edit);
    }

    @Override
    public void editar(Prestamo edit) {
        super.editar(edit);
    }

    @Override
    public void eliminar(Prestamo edit) {
        super.eliminar(edit);
    }

    public Prestamo buscarID(Integer id) {
        conectar();
        Prestamo edit
                = em.find(Prestamo.class, id);
        desconectar();
        return edit;
    }
    
    
    
}//The end
