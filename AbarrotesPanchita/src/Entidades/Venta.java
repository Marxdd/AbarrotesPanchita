/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Objects;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Abarrotes
 */
@Entity
@Table(name = "ventas")
public class Venta implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "idventa")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "fecha", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Calendar fecha;

    @Column(name = "monto", nullable = false)
    private float montoTotal;

    @OneToMany(mappedBy = "venta", cascade = CascadeType.ALL)
    private List<RelacionProductosVentas> productos;

    public Venta(Integer id, Calendar fecha, float montoTotal) {
        this.id = id;
        this.fecha = fecha;
        this.montoTotal = montoTotal;
        productos = new ArrayList<RelacionProductosVentas>();
    }

    public Venta(Calendar fecha, float montoTotal) {
        this.fecha = fecha;
        this.montoTotal = montoTotal;
        productos = new ArrayList<RelacionProductosVentas>();
    }

    public Venta() {
        productos = new ArrayList<RelacionProductosVentas>();
    }

    public void agregarProductos(RelacionProductosVentas producto) {
        productos.add(producto);
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Calendar getFecha() {
        return fecha;
    }

    public void setFecha(Calendar fecha) {
        this.fecha = fecha;
    }

    public float getMontoTotal() {
        return montoTotal;
    }

    public void setMontoTotal(float montoTotal) {
        this.montoTotal = montoTotal;
    }

    public List<RelacionProductosVentas> getProductos() {
        return productos;
    }

    public void setProductos(List<RelacionProductosVentas> productos) {
        this.productos = productos;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 29 * hash + Objects.hashCode(this.id);
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
        final Venta other = (Venta) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Venta{" + "id=" + id + ", fecha=" + fecha + ", montoTotal=" + montoTotal + ", productos=" + productos + '}';
    }

}
