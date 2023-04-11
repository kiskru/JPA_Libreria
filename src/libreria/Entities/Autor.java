/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Libreria.Entities;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * @author Kidver
 */
@Entity
public class Autor {

    @Id
    private Integer id;
    private String nombre;
    private Boolean alta;

    public Autor() {
    }

    public Autor(Integer id, String nombre) {
        this.id = id;
        this.nombre = nombre;
        this.alta = true;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Boolean getAlta() {
        return alta;
    }

    public void setAlta(Boolean alta) {
        this.alta = alta;
    }

    @Override
    public String toString() {
        return "ID= " + id + " nombre= " + nombre;
    }

    
}//The end
