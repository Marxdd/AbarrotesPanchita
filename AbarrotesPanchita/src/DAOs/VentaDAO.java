/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAOs;

import Entidades.Venta;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.ERROR_MESSAGE;
import static javax.swing.JOptionPane.INFORMATION_MESSAGE;

/**
 *
 * @author Abarrotes Panchita
 */
public class VentaDAO extends BaseDAO<Venta> {

    @Override
    public void agregar(Venta entidad) {
        try {
            EntityManager entityManager = this.getEntityManager();
            entityManager.getTransaction().begin();
            entityManager.persist(entidad);
            entityManager.getTransaction().commit();

            // JOptionPane.showMessageDialog(null, "Se agrego nuevo producto", "Aviso", INFORMATION_MESSAGE);
            System.out.println("Se agrego");
        } catch (Exception e) {
            //   JOptionPane.showMessageDialog(null, "No se pudo agregar el producto", "Aviso", ERROR_MESSAGE);
            System.out.println("No se agrego");
            e.printStackTrace();
        }
    }

    @Override
    public void eliminar(Venta entidad) {
        try {
            EntityManager entityManager = this.getEntityManager();
            entityManager.getTransaction().begin();
            Venta ventaEliminada = entityManager.find(Venta.class, entidad.getId());
            if (ventaEliminada != null) {
                entityManager.remove(ventaEliminada);
                System.out.println("Se ha eliminado con exito");
            } else {
                System.out.println("No se pudo eliminar");
                //   JOptionPane.showMessageDialog(null, "No se pudo eliminar el producto", "Aviso", INFORMATION_MESSAGE);
            }
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            //    JOptionPane.showMessageDialog(null, "Huvo un error", "Aviso", ERROR_MESSAGE);
            System.out.println("No se pudo eliminar");
        }
    }

    @Override
    public void actualizar(Venta entidad) {
       try {
             EntityManager entityManager = this.getEntityManager();
             entityManager.getTransaction().begin();
            Venta ventaActualizada = entityManager.find(Venta.class, entidad.getId());
            if (ventaActualizada != null) {
                ventaActualizada.setMontoTotal(entidad.getMontoTotal());
                ventaActualizada.setFecha(entidad.getFecha());
                entityManager.merge(ventaActualizada);
                System.out.println("Se ha actualizado con exito");
            } else {
                // JOptionPane.showMessageDialog(null, "No se encontro la venta", "Aviso", INFORMATION_MESSAGE);
                System.out.println("No se pudo actualizar: Venta no encontrada");
            }
            em.getTransaction().commit();
        } catch (Exception e) {
            System.out.println("No se pudo actualizar");
          //  JOptionPane.showMessageDialog(null, "Huvo un error", "Aviso", ERROR_MESSAGE);
        }
    }

    @Override
    public Venta buscarPorId(Integer entidad) {
       String jpq = "SELECT u FROM Venta u WHERE u.id = :id";
            EntityManager entityManager = this.getEntityManager();
        TypedQuery<Venta> query = entityManager.createQuery(jpq, Venta.class);
        query.setParameter("id", entidad);
        List<Venta> ventas = query.getResultList();
        Venta venta = ventas.get(0);
        if (ventas.isEmpty()) {
            System.out.println("No se pudo encontrar la venta");
            return null;
        } else {
            return venta;
        }
    }

    @Override
    public List<Venta> mostrarTodas() {
        String jpq = "SELECT u FROM Venta u";
            EntityManager entityManager = this.getEntityManager();
        TypedQuery<Venta> query = entityManager.createQuery(jpq, Venta.class);
        List<Venta> ventas = query.getResultList();
        if (ventas.isEmpty()) {
         //   System.out.println("No hay ventas");
            return null;
        } else {
            System.out.println("Mostrando todas las ventas");
            for (Venta venta : ventas) {
                System.out.println(venta);
            }
            return ventas;
        }
    }

}
