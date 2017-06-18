package application.control;

import javax.persistence.*;
import java.util.List;


/***
 *  @author Magjan Amangeldi
 *  CRUD operation for all object in Database
 *  {@param Entity class}
 */
public abstract class Control<T> {

    public Class<T> entityClass;

    public EntityManager em = Persistence.createEntityManagerFactory("UNIT").createEntityManager();

    /**
     * @param entityClass
     */
    public Control(Class<T> entityClass) {
        this.entityClass = entityClass;
    }
    protected EntityManager getEntityManager(){
        return em;
    }

    /**
     * Abstract method.
     * @return List<T>
     */
    public abstract List<T> getAll();

    /**
     * Add entity in Database
     * @param t
     * t = entityClass
     * @return entityClass
     */
    public T add(T t){
        em.getTransaction().begin();
        T added = em.merge(t);
        em.getTransaction().commit();
        return added;
    }

    /**
     * Update the entity is in database
     * @param t
     * @return entityClass
     */
    public T update(T t){
        em.getTransaction().begin();
        T updated = em.merge(t);
        em.getTransaction().commit();
        return updated;
    }

    /**
     * Delete entity in database by ID
     * @param id
     */
    public void delete(Long id){
        em.getTransaction().begin();
        em.remove(get(id));
        em.getTransaction().commit();
    }

    /**
     * Get entity in database by ID
     * @param id
     * @return entityClass
     */
    public T get(long id){
        return em.find(entityClass, id);
    }
}
