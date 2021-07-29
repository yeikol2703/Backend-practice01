/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cr.una.crudapp.backend.dao;
import cr.una.crudapp.backend.excepcion.CasaNotFoundException;
import cr.una.crudapp.backend.modelo.Casa;

public interface ICasaDAO {
    public Casa encuentraPorId (final long id) throws CasaNotFoundException;
    public Casa crearCasa (final Casa casa);
    public Casa actualizarCasa (final Casa casa);
    public void eliminarCasa (final Casa casa);
    public void eliminarCasaPorId (final long id) throws CasaNotFoundException;

}
