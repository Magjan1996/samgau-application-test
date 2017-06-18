package application.control;

import application.entity.Student;

import javax.ejb.Stateless;
import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/***
 *  @author Magjan Amangeldi
 *  implementation for {@link Control}
 */
@Stateless
public class ControlImpl extends Control<Student> implements Serializable{

    /**
     * Overloaded constructor
     * @param entityClass
     */
    public ControlImpl(Class<Student> entityClass) {
        super(entityClass);
    }

    /**
     * Default constructor
     */
    public ControlImpl(){
        super(Student.class);
    }


    /***
     * Redefinition and import abstract abstract method
     * and write an implementation for Entity {@link Student}
     * @return List<Student>
     */
    @Override
    public List<Student> getAll() {
        em.getTransaction().begin();
        TypedQuery<Student> namedQuery;
        namedQuery = em.createNamedQuery("Student.getAll", Student.class);
        namedQuery.getResultList();
        em.getTransaction().commit();
        return namedQuery.getResultList();
    }

}
