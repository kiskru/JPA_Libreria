/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package libreria.Persistencia;

import Libreria.Entities.Libro;
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
    public void eliminar(Libro libro) {
        super.eliminar(libro);
    }

    public Libro buscarISBN(Long id) {
        conectar();
        Libro libro
                = em.find(Libro.class, id);
        desconectar();
        return libro;
    }

    public List<Libro> buscarTitulo(String titulo) {
        List<Libro> lista;
        try {
            conectar();
            lista = em.createQuery("SELECT l FROM Libro l WHERE l.titulo LIKE :titulo")
                    .setParameter("titulo", "%" + titulo + "%")
                    .getResultList();
            desconectar();
            return lista;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        } finally {
            desconectar();
        }
    }

    public List<Libro> buscarPorAutor(String nombre) {
        List<Libro> lista;
        try {
            conectar();

            lista = em.createQuery("SELECT l FROM Libro l WHERE l.autor.nombre LIKE :nombre")
                    .setParameter("nombre", "%" + nombre + "%")
                    .getResultList();
            return lista;
        } catch (Exception e) {
            System.out.println(e);
            return null;
        } finally {
            desconectar();
        }

    }
    
    public List<Libro> buscarPorEditorial(String nombre) {
        List<Libro> lista;
        try {
            conectar();

            lista = em.createQuery("SELECT l FROM Libro l WHERE l.editorial.nombre LIKE :nombre")
                    .setParameter("nombre", "%" + nombre + "%")
                    .getResultList();
            return lista;
        } catch (Exception e) {
            System.out.println(e);
            return null;
        } finally {
            desconectar();
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
