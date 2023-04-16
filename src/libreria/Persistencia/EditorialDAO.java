/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package libreria.Persistencia;

import Libreria.Entities.Editorial;
import java.util.List;

/**
 * @author Kidver
 */
public class EditorialDAO extends DAO<Editorial> {

    @Override
    public void guardar(Editorial edit) {
        super.guardar(edit);
    }

    @Override
    public void editar(Editorial edit) {
        super.editar(edit);
    }

    @Override
    protected void eliminar(Editorial edit) {
        super.eliminar(edit);
    }

    public Editorial buscarID(Integer id) {
        conectar();
        Editorial edit
                = em.find(Editorial.class, id);
        desconectar();
        return edit;
    }

    public Editorial buscarNombre(String nombre) {

        try {
            conectar();
            Editorial editorial;
            editorial = (Editorial) em.createQuery("SELECT e FROM Editorial e WHERE e.nombre like :nombre")
                    .setParameter("nombre", "%" + nombre + "%")
                    .getSingleResult();
            return editorial;
        } catch (Exception e) {
            System.err.println(e);
            return null;
        } finally {
            desconectar();
        }
    }

    public List<Editorial> listarTodos() {
        try {
            conectar();
            List<Editorial> lista = em.createQuery("SELECT e FROM Editorial e").getResultList();
            return lista;
        } catch (Exception e) {
            System.out.println(e);
            return null;
        } finally {
            desconectar();
        }
    }

}//The end
