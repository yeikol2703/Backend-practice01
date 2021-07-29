package cr.una.crudapp.backend.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Clase Abstracta base
 */

public class AbstractHibernateDao {
    /**
     * La SessionFactory de hibernate.
     * Esto sirve para crear una sesion de objeto la cual es usada para operaciones de
     * crud
     */
    @Autowired
    protected SessionFactory sessionFactory;

    /**
     * La sesion de Hibernate que esta conectada a la base de datos
     * @return
     */
    protected Session getCurrentSession() {
        return sessionFactory.getCurrentSession();
    }
}
