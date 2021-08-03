/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cr.una.crudapp.backend.dao;

import com.google.common.base.Preconditions;
import cr.una.crudapp.backend.excepcion.CasaNotFoundException;
import cr.una.crudapp.backend.modelo.Casa;
import org.springframework.stereotype.Repository;

/**
 *
 * Estudiar mas a fondo para entender la abstraccion que realiza hibernate
 */
@Repository
public class CasaDAO extends AbstractHibernateDao implements ICasaDAO {

    @Override
    public Casa encuentraPorId(long id) throws CasaNotFoundException {
        Casa casa = (Casa) getCurrentSession().get(Casa.class, id);
        
        if(casa == null){
            throw new CasaNotFoundException("Casa no fue encontrada");
        }else{
            return casa;
        }
    }

    @Override
    public Casa crearCasa(Casa casa) {
        Preconditions.checkNotNull(casa);
        getCurrentSession().saveOrUpdate(casa);
        
        return casa;
    }

    @Override
    public Casa actualizarCasa(Casa casa) {
        Preconditions.checkNotNull(casa);
        return (Casa) getCurrentSession().merge(casa);
    }

    @Override
    public void eliminarCasa(Casa casa) {
         Preconditions.checkNotNull(casa);
        getCurrentSession().delete(casa);
    }

    @Override
    public void eliminarCasaPorId(long id) throws CasaNotFoundException {
        final Casa casa = encuentraPorId(id);
        Preconditions.checkState(casa != null);
        eliminarCasa(casa);    }
    
}
