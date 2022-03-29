/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author Abarrotes
 */
@Entity
@Table(name ="productos")
public class Producto implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idproducto")
    private Integer id;
    
    @Column(name = "nombre",length = 100,nullable = false)
    private String nombre;
    
    @Column(name = "precio",nullable = false)
    private float precio;
    
    @Column(name = "codigo",length = 100,nullable = false)
    private String codigo;
    
    @Column(name = "a_granel",nullable = false)
    private boolean aGranel;
    
       @OneToMany(mappedBy = "producto",cascade = CascadeType.ALL)
    private List<RelacionProductosVentas> ventas;

    public Producto(Integer id, String nombre, float precio, String codigo, boolean aGranel) {
        this.id = id;
        this.nombre = nombre;
        this.precio = precio;
        this.codigo = codigo;
        this.aGranel = aGranel;
        this.ventas = new ArrayList<RelacionProductosVentas>();
    }

    public Producto(String nombre, float precio, String codigo,boolean aGranel) {
        this.nombre = nombre;
        this.precio = precio;
        this.codigo = codigo;
        this.aGranel = aGranel;
        ventas = new ArrayList<RelacionProductosVentas>();
    }

   

    public Producto() {
        ventas = new ArrayList<RelacionProductosVentas>();
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

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public List<RelacionProductosVentas> getVentas() {
        return ventas;
    }

    public void setVentas(List<RelacionProductosVentas> ventas) {
        this.ventas = ventas;
    }

    public boolean isaGranel() {
        return aGranel;
    }

    public void setaGranel(boolean aGranel) {
        this.aGranel = aGranel;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 73 * hash + Objects.hashCode(this.id);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Producto other = (Producto) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

 

    @Override
    public String toString() {
        return "Producto{" + "id=" + id + ", nombre=" + nombre + ", precio=" + precio + ", codigo=" + codigo + ", ventas=" + ventas + ", aGranel"+aGranel+'}';
    }
    
    
    
    

  
    
}

