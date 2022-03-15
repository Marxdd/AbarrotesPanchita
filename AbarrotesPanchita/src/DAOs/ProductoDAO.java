/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAOs;

import Entidades.Producto;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.ERROR_MESSAGE;
import static javax.swing.JOptionPane.INFORMATION_MESSAGE;

/**
 *
 * @author Abarrotes
 */
public class ProductoDAO extends BaseDAO<Producto>{
      @Override
    public void agregar(Producto entidad) {
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
    public void eliminar(Producto entidad) {
        try {
            EntityManager entityManager = this.getEntityManager();
            entityManager.getTransaction().begin();
            Producto productoEliminado = entityManager.find(Producto.class, entidad.getId());
            if (productoEliminado != null) {
                entityManager.remove(productoEliminado);
                System.out.println("Se ha eliminado con exito");
            } else {
                System.out.println("No se pudo eliminar");
               // JOptionPane.showMessageDialog(null, "No se pudo eliminar el producto", "Aviso", INFORMATION_MESSAGE);
            }
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            //JOptionPane.showMessageDialog(null, "Huvo un error", "Aviso", ERROR_MESSAGE);
           System.out.println("No se pudo eliminar");
        }
    }

    @Override
    public void actualizar(Producto entidad) {
        try {
             EntityManager entityManager = this.getEntityManager();
             entityManager.getTransaction().begin();
            Producto productoActualizado = entityManager.find(Producto.class, entidad.getId());
            if (productoActualizado != null) {
                productoActualizado.setNombre(entidad.getNombre());
                productoActualizado.setPrecio(entidad.getPrecio());
                productoActualizado.setCodigo(entidad.getCodigo());
              
                entityManager.merge(productoActualizado);
                System.out.println("Se ha actualizado con exito");
            } else {
              //  JOptionPane.showMessageDialog(null, "No se encontro el producto", "Aviso", INFORMATION_MESSAGE);
                System.out.println("No se pudo actualizar");
            }
            em.getTransaction().commit();
        } catch (Exception e) {
           //  JOptionPane.showMessageDialog(null, "Huvo un error", "Aviso", ERROR_MESSAGE);
            System.out.println("No se pudo actualizar");
        }
    }

    @Override
    public Producto buscarPorId(Integer entidad) {
        String jpq = "SELECT u FROM Producto u WHERE u.id = :id";
            EntityManager entityManager = this.getEntityManager();
        TypedQuery<Producto> query = entityManager.createQuery(jpq, Producto.class);
        query.setParameter("id", entidad);
        List<Producto> productos = query.getResultList();
        if (productos.isEmpty()) {
            System.out.println("No se pudo encontrar la venta");
            return null;
        } else {
             Producto producto = productos.get(0);
            return producto;
        }
    }

    @Override
    public List<Producto> mostrarTodas() {
         String jpq = "SELECT u FROM Producto u";
            EntityManager entityManager = this.getEntityManager();
        TypedQuery<Producto> query = entityManager.createQuery(jpq, Producto.class);
        List<Producto> productos = query.getResultList();
        if (productos.isEmpty()) {
            System.out.println("No hay ventas");
            return null;
        } else {
            System.out.println("Mostrando todas las ventas");
            for (Producto producto : productos) {
                System.out.println(producto);
            }
            return productos;
        }
    }
    
     public List<Producto> buscarPorNombre(String nombre) {
        String jpq = "SELECT u FROM Producto u WHERE u.nombre LIKE :nombre";
        TypedQuery<Producto> query = em.createQuery(jpq, Producto.class);
        query.setParameter("nombre", "%" + nombre + "%");
        List<Producto> productos = query.getResultList();
        if (productos.isEmpty()) {
              System.out.println("No hay productos");
            return null;
        } else {
            System.out.println("Mostrando todos los productos");
            for (Producto producto : productos) {
                System.out.println(productos);
            }
            return productos;
        }
    }
    
}
