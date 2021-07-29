package cr.una.crudapp.backend.servicio;

import cr.una.crudapp.backend.excepcion.PersonaNotFoundException;
import cr.una.crudapp.backend.modelo.Persona;


/**
 * IPersonaServicio
 *
 * Es el servicio para la Persona
 * Para este ejemplo, el id no es la identificacion de la persona, es el autoincrementable que se le ha asignado
 */

public interface IPersonaServicio {

    /**
     * Metodo que encuentra la entidad por el id (no numero de identificacion de la persona)
     * @param id the id of the entity to find
     * @return the corresponding task
     * @throws PersonaNotFoundException Si no hay una persona encontrada
     */
    public Persona encuentraPorId (final long id) throws PersonaNotFoundException;


    /**
     * Metodo que sirve para crear una nueva entidad
     * @param persona La entidad que va a ser creada en la base de datos
     * @return La persona creada con su correspondiente id
     */
    public Persona crear (final Persona persona);

    /**
     * Metodo que actualiza la entidad en la base de datos
     * @param persona la entidad con la nueva informacion actualizada
     * @return la persona actualizada
     */
    public Persona actualizar (final Persona persona);

    /**
     * Metodo que sirve para eliminar una entidad en la base de datos
     * @param persona la entidad que va a ser eliminada
     */
    public void eliminar(final Persona persona);
    /**
     * Metodo que elimina una entidad en la base de datos por el id
     * @param id the id of the entity to delete
     * @throws PersonaNotFoundException Si no hay una persona encontrada
     */
    public void eliminarPorId (final long id) throws PersonaNotFoundException;
}
