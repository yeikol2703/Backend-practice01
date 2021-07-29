package cr.una.crudapp.backend.dao;
import com.google.common.base.Preconditions;
import org.springframework.stereotype.Repository;
import cr.una.crudapp.backend.excepcion.PersonaNotFoundException;
import cr.una.crudapp.backend.modelo.Persona;

/**
 * Clase PersonaDAO
 *
 * Con la ayuda de la clase AbstractHibernateDao, se encarga de insertar a la base de datos los objetos recibidos
 *
 */

@Repository
public class PersonaDAO extends AbstractHibernateDao   implements IPersonaDAO {
    @Override
    public Persona encuentraPorId(final long id) throws PersonaNotFoundException {
        Persona persona = (Persona) getCurrentSession().get(Persona.class, id);
        if (persona == null) {
            throw new PersonaNotFoundException("Persona no fue encontrada");
        } else {
            return persona;
        }
    }

    @Override
    public Persona crearPersona(Persona persona) {
        Preconditions.checkNotNull(persona);
        getCurrentSession().saveOrUpdate(persona);

        return persona;
    }

    @Override
    public Persona actualizarPersona(Persona persona) {
        Preconditions.checkNotNull(persona);
        return (Persona) getCurrentSession().merge(persona);
    }

    @Override
    public void eliminarPersona(Persona persona) {
        Preconditions.checkNotNull(persona);
        getCurrentSession().delete(persona);
    }
    @Override
    public void eliminarPersonaPorId(long id) throws PersonaNotFoundException {
        final Persona persona = encuentraPorId(id);
        Preconditions.checkState(persona != null);
        eliminarPersona(persona);
    }
}
