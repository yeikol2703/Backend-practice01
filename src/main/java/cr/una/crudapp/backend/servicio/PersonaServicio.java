package cr.una.crudapp.backend.servicio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import cr.una.crudapp.backend.dao.IPersonaDAO;
import cr.una.crudapp.backend.excepcion.PersonaNotFoundException;
import cr.una.crudapp.backend.modelo.Persona;

/**
 * PersonaServicio
 *
 * El servicio para la Persona
 */

@Service
@Transactional
public class PersonaServicio implements IPersonaServicio{
    @Autowired
    private IPersonaDAO dao;

    /**
     *
     * @param id el id de la entidad que se va a econtrar
     * @return Retorna la persona que fue encontrada por id
     * @throws PersonaNotFoundException Si no hay una persona encontrada
     */
    @Override
    public Persona encuentraPorId(long id) throws PersonaNotFoundException {
        return dao.encuentraPorId(id);
    }




    /**
     *
     * @param persona La entidad que va a ser creada en la base de datos
     * @return la persona que fue creada en la base de datos
     */
    @Override
    public Persona crear(Persona persona) {

        return dao.crearPersona(persona);
    }

    /**
     *
     * @param persona la entidad con la nueva informacion actualizada
     * @return la entidad de la persona que ha sido actualizada
     */
    @Override
    public Persona actualizar(Persona persona) {
        return dao.actualizarPersona(persona);
    }

    /**
     *
     * @param persona la entidad que va a ser eliminada
     */
    @Override
    public void eliminar(Persona persona) {
        dao.eliminarPersona(persona);
    }

    /**
     *
     * @param id the id of the entity to delete
     * @throws PersonaNotFoundException Si la persona no fue encontrada
     */
    @Override
    public void eliminarPorId(long id) throws PersonaNotFoundException {
        dao.eliminarPersonaPorId(id);
    }
}
