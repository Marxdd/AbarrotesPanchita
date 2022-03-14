/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAOs;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Abarrotes
 */
public abstract class BaseDAO<T> {
       protected EntityManagerFactory managerFactory = Persistence.createEntityManagerFactory("AbarrotesPanchitaPU");
    protected EntityManager em = managerFactory.createEntityManager();

    public abstract void agregar(T entidad);

    public abstract void eliminar(T entidad);

    public abstract void actualizar(T entidad);

    public abstract T buscarPorId(Integer entidad);

    public abstract List<T> mostrarTodas();

    public EntityManager getEntityManager() {
        return em;
    }
}
