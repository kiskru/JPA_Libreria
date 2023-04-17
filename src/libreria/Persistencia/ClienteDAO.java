/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package libreria.Persistencia;

import libreria.Entities.Cliente;

/**
 * @author Kidver
 */
public class ClienteDAO extends DAO<Cliente> {

    @Override
    public void guardar(Cliente edit) {
        super.guardar(edit);
    }
    @Override
    public void editar(Cliente edit) {
        super.editar(edit);
    }
    @Override
    public void eliminar(Cliente edit) {
        super.eliminar(edit);
    }
    public Cliente buscarID(Integer id) {
        conectar();
        Cliente edit
                = em.find(Cliente.class, id);
        desconectar();
        return edit;
    }
    
    
}//The end
