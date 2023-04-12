/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package libreria.Persistencia;

import Libreria.Entities.Libro;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Kidver
 */
public class LibroDAO extends DAO<Libro> {

    @Override
    public void guardar(Libro libro) {
        super.guardar(libro);
    }

    @Override
    public void editar(Libro libro) {
        super.editar(libro);
    }

    @Override
    protected void eliminar(Libro libro) {
        super.eliminar(libro);
    }

    public Libro buscarISBN(Long id) {
        conectar();
        Libro libro
                = em.find(Libro.class, id);
        desconectar();
        return libro;
    }

    public List<Libro> buscarNombre(String nombre) {
        List<Libro> lista;
        try {
            conectar();
            lista = em.createQuery("SELECT a FROM Autor a WHERE a.nombre LIKE :nombre")
                    .setParameter("nombre", "%" + nombre + "%")
                    .getResultList();
            desconectar();
            return lista;
        } catch (Exception e) {
            throw e;
        }
    }

    public List<Libro> listarLibros() {
        List<Libro> lista;
        conectar();
        lista = em.createQuery("SELECT l FROM Libro l")
                .getResultList();
        desconectar();        
        return lista;
    }
}//The end
