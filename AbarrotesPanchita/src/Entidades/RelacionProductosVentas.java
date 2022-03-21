/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author Abarrotes
 */
@Entity
@Table(name = "rel_productos_ventas")
public class RelacionProductosVentas implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "idrel_producto_venta")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "cantidad", nullable = false, length = 11)
    private Integer cantidad;

    @Column(name = "precio", nullable = false)
    private float precio;

    @Column(name = "cantidad_granel", nullable = true)
    private float cantidadGranel;

    @ManyToOne
    @JoinColumn(name = "id_producto", nullable = false)
    private Producto producto;

    @ManyToOne
    @JoinColumn(name = "id_venta", nullable = false)
    private Venta venta;

    public RelacionProductosVentas(Integer id, Integer cantidad, float precio, float cantidadGranel, Producto producto, Venta venta) {
        this.id = id;
        this.cantidad = cantidad;
        this.precio = precio;
        this.cantidadGranel = cantidadGranel;
        this.producto = producto;
        this.venta = venta;
    }

    public RelacionProductosVentas(Integer cantidad, float precio, float cantidadGranel, Producto producto, Venta venta) {
        this.cantidad = cantidad;
        this.precio = precio;
        this.cantidadGranel = cantidadGranel;
        this.producto = producto;
        this.venta = venta;
    }

    public RelacionProductosVentas(Integer cantidad, float precio, Producto producto, Venta venta) {
        this.cantidad = cantidad;
        this.precio = precio;
        this.producto = producto;
        this.venta = venta;
    }

    public RelacionProductosVentas() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    public float getCantidadGranel() {
        return cantidadGranel;
    }

    public void setCantidadGranel(float cantidadGranel) {
        this.cantidadGranel = cantidadGranel;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public Venta getVenta() {
        return venta;
    }

    public void setVenta(Venta venta) {
        this.venta = venta;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 13 * hash + Objects.hashCode(this.id);
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
        final RelacionProductosVentas other = (RelacionProductosVentas) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

  
    @Override
    public String toString() {
        return "RelacionProductosVentas{" + "id=" + id + ", cantidad=" + cantidad + ", precio=" + precio + ", cantidadGranel=" + cantidadGranel + ", producto=" + producto + ", venta=" + venta + '}';
    }

}
