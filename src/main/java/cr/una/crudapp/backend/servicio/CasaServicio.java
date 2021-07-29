/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cr.una.crudapp.backend.servicio;

import cr.una.crudapp.backend.dao.ICasaDAO;
import cr.una.crudapp.backend.excepcion.CasaNotFoundException;
import cr.una.crudapp.backend.modelo.Casa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class CasaServicio implements ICasaServicio{
    @Autowired
    private ICasaDAO dao;


    @Override
    public Casa encuentraPorId(long id) throws CasaNotFoundException {
        return dao.encuentraPorId(id);
    }

    @Override
    public Casa crear(Casa casa) {

        return dao.crearCasa(casa);
    }

    @Override
    public Casa actualizar( Casa casa) {
        return dao.actualizarCasa(casa);
    }

    @Override
    public void eliminar(Casa casa) {
        dao.eliminarCasa(casa);
    }
    
    @Override
    public void eliminarPorId(long id) throws CasaNotFoundException {
        dao.eliminarCasaPorId(id);
    }

}
