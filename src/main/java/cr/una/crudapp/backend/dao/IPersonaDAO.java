package cr.una.crudapp.backend.dao;

import cr.una.crudapp.backend.excepcion.PersonaNotFoundException;
import cr.una.crudapp.backend.modelo.Persona;

public interface IPersonaDAO {
    public Persona encuentraPorId (final long id) throws PersonaNotFoundException;
    public Persona crearPersona (final Persona persona);
    public Persona actualizarPersona (final Persona persona);
    public void eliminarPersona (final Persona persona);
    public void eliminarPersonaPorId (final long id) throws PersonaNotFoundException;
}
