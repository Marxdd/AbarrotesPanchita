/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAOs;

import Entidades.Categoria;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

/**
 *
 * @author carls
 */
public class CategoriaDAO extends BaseDAO<Categoria> {

    @Override
    public void agregar(Categoria entidad) {
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
    public void eliminar(Categoria entidad) {
        try {
            EntityManager entityManager = this.getEntityManager();
            entityManager.getTransaction().begin();
            Categoria categoria = entityManager.find(Categoria.class, entidad.getId());
            if (categoria != null) {
                entityManager.remove(categoria);

            } 
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            //    JOptionPane.showMessageDialog(null, "Huvo un error", "Aviso", ERROR_MESSAGE);
            System.out.println("No se pudo eliminar");
        }
    }


    @Override
    public void actualizar(Categoria entidad) {
        try {
            EntityManager entityManager = this.getEntityManager();
            entityManager.getTransaction().begin();

            Categoria categoria = buscarPorId(entidad.getId());
            if (categoria != null) {
                entityManager.merge(entidad);
            } 
            entityManager.getTransaction().commit();
        } catch (Exception e) {

        }
    }

    @Override
    public Categoria buscarPorId(Integer id) {
        String jpq = "SELECT u FROM Categoria u WHERE u.idcategoria = :id";
        EntityManager entityManager = this.getEntityManager();
        TypedQuery<Categoria> query = entityManager.createQuery(jpq, Categoria.class);
        query.setParameter("id", id);
        List<Categoria> categorias = query.getResultList();
        Categoria categoria = categorias.get(0);
        if (categorias.isEmpty()) {
            return null;
        } else {
            return categoria;
        }
    }

    @Override
    public List<Categoria> mostrarTodas() {
        String jpq = "SELECT u FROM Categoria u";
        EntityManager entityManager = this.getEntityManager();
        TypedQuery<Categoria> query = entityManager.createQuery(jpq, Categoria.class);
        List<Categoria> categorias = query.getResultList();
        if (categorias.isEmpty()) {
            return null;
        } else {
            return categorias;
        }
    }

    public List<Categoria> buscarPorNombre(String nombre) {
        String jpq = "SELECT u FROM Categoria u WHERE u.nombre LIKE :nombre";
        TypedQuery<Categoria> query = em.createQuery(jpq, Categoria.class);
        query.setParameter("nombre", "%" + nombre + "%");
        List<Categoria> categorias = query.getResultList();
        if (categorias.isEmpty()) {
            return categorias;
        } else {
            return categorias;
        }
    }

}
