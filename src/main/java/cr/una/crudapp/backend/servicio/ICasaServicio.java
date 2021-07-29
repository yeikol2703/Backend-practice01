package cr.una.crudapp.backend.servicio;

import cr.una.crudapp.backend.excepcion.CasaNotFoundException;
import cr.una.crudapp.backend.modelo.Casa;

public interface ICasaServicio {
       /**
     * Metodo que encuentra la entidad por el id (no numero de identificacion de la persona)
     * @param id the id of the entity to find
     * @return the corresponding task
     * @throws cr.una.crudapp.backend.excepcion.CasaNotFoundException
     */
    public Casa encuentraPorId (final long id) throws CasaNotFoundException;


    /**
     * Metodo que sirve para crear una nueva entidad
     * @param casa
     * @return La casa creada con su correspondiente id
     */
    public Casa crear (final Casa casa);

    /**
     * Metodo que actualiza la entidad en la base de datos
     * @param casa
     * @return la casa actualizada
     */
    public Casa actualizar (final Casa casa);

    /**
     * Metodo que sirve para eliminar una entidad en la base de datos
     * @param casa
     */
    public void eliminar(final Casa casa);
    /**
     * Metodo que elimina una entidad en la base de datos por el id
     * @param id the id of the entity to delete
     * @throws cr.una.crudapp.backend.excepcion.CasaNotFoundException
     */
    public void eliminarPorId (final long id) throws CasaNotFoundException;
}
