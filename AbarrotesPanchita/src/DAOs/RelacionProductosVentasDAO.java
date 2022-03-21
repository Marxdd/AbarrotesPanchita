/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAOs;

import Entidades.RelacionProductosVentas;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

/**
 *
 * @author Abarrotes
 */
public class RelacionProductosVentasDAO extends BaseDAO<RelacionProductosVentas> {

    @Override
    public void agregar(RelacionProductosVentas entidad) {
        try {
            EntityManager entityManager = this.getEntityManager();
            entityManager.getTransaction().begin();
            entityManager.persist(entidad);
            entityManager.getTransaction().commit();

            System.out.println("Se creo relacion");
        } catch (Exception e) {
            System.out.println("No se creo la relacion");
            e.printStackTrace();
        }
    }

    @Override
    public void eliminar(RelacionProductosVentas entidad) {
        try {
            EntityManager entityManager = this.getEntityManager();
            entityManager.getTransaction().begin();
            RelacionProductosVentas relacionEliminada = entityManager.find(RelacionProductosVentas.class, entidad.getId());
            if (relacionEliminada != null) {
                entityManager.remove(relacionEliminada);
                System.out.println("Se ha eliminado con exito");
            } else {
                System.out.println("No se pudo eliminar");
            }
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            System.out.println("No se pudo eliminar");
        }
    }

    @Override
    public void actualizar(RelacionProductosVentas entidad) {
        try{
         EntityManager entityManager = this.getEntityManager();
             entityManager.getTransaction().begin();
            RelacionProductosVentas relacionActualizada = entityManager.find(RelacionProductosVentas.class, entidad.getId());
            if (relacionActualizada != null) {
                relacionActualizada.setCantidad(entidad.getCantidad());
                relacionActualizada.setCantidadGranel(entidad.getCantidadGranel());
                relacionActualizada.setPrecio(entidad.getPrecio());
                relacionActualizada.setProducto(entidad.getProducto());
                relacionActualizada.setVenta(entidad.getVenta());
              
                entityManager.merge(relacionActualizada);
                System.out.println("Se ha actualizado la relacion con exito");
            } else {
                System.out.println("No se pudo actualizar: No se encontro");
            }
            em.getTransaction().commit();
        } catch (Exception e) {
            System.out.println("No se pudo actualizar");
        }
    }

    @Override
    public RelacionProductosVentas buscarPorId(Integer entidad) {
        String jpq = "SELECT u FROM RelacionProductosVentas u WHERE u.id = :id";
            EntityManager entityManager = this.getEntityManager();
        TypedQuery<RelacionProductosVentas> query = entityManager.createQuery(jpq, RelacionProductosVentas.class);
        query.setParameter("id", entidad);
        List<RelacionProductosVentas> relacionesPV = query.getResultList();
        RelacionProductosVentas relacion = relacionesPV.get(0);
        if (relacionesPV.isEmpty()) {
            System.out.println("No se pudo encontrar la relacion");
            return null;
        } else {
            return relacion;
        }
    }

    @Override
    public List<RelacionProductosVentas> mostrarTodas() {
        String jpq = "SELECT u FROM RelacionProductosVentas u";
            EntityManager entityManager = this.getEntityManager();
        TypedQuery<RelacionProductosVentas> query = entityManager.createQuery(jpq, RelacionProductosVentas.class);
        List<RelacionProductosVentas> relacionesPV = query.getResultList();
        if (relacionesPV.isEmpty()) {
            System.out.println("No hay relaciones");
            return null;
        } else {
            System.out.println("Mostrando todas las relaciones");
            for (RelacionProductosVentas relacion : relacionesPV) {
                System.out.println(relacion);
            }
            return relacionesPV;
        }
    }

}
