/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package libreria.Persistencia;

import Libreria.Entities.Autor;
import java.util.List;

/**
 * @author Kidver
 */
public class AutorDAO extends DAO<Autor> {

    @Override
    public void guardar(Autor autor) {
        super.guardar(autor);
    }

    @Override
    public void editar(Autor autor) {
        super.editar(autor);
    }

    @Override
    public void eliminar(Autor autor) {

        super.eliminar(autor);
    }

    public Autor buscarNombre(String nombre)  {
        try{
        conectar();
        Autor autor
                = (Autor) em.createQuery("SELECT a FROM Autor a WHERE a.nombre LIKE :nombre")
                        .setParameter("nombre", "%" + nombre + "%")
                        .getSingleResult();
        
        return autor;
        }catch(Exception e){
            throw e;
        }finally{
            desconectar();
        }        
    }

    public Autor buscarID(Integer id) {
        try{
        conectar();
        Autor autor
                = em.find(Autor.class, id);
        return autor;
        }catch(Exception e){
            System.out.println(e);
            return null;
        }finally{
            desconectar();
        } 
    }

    public List<Autor> listarAutores() {
        conectar();
        List<Autor> lista
                = em.createQuery("SELECT a FROM Autor a")
                        .getResultList();
        desconectar();
        return lista;
    }
}//The end
