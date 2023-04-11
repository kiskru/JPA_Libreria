/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package libreria.Persistencia;

import Libreria.Entities.Libro;

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
    
    public Libro buscarISBN(Long id){        
        conectar();
        Libro libro =
        em.find(Libro.class, id);
        desconectar();
        return libro;
    }
}//The end
