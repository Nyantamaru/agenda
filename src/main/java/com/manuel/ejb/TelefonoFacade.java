/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.manuel.ejb;

import com.manuel.model.Telefono;
import com.manuel.model.Usuario;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author manuel
 */
@Stateless
public class TelefonoFacade extends AbstractFacade<Telefono> implements TelefonoFacadeLocal {

    @PersistenceContext(unitName = "com.manuel_AgendaCursoPrimeAvanzado_war_1.0PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public TelefonoFacade() {
        super(Telefono.class);
    }

    @Override
    public List<Telefono> buscarTelefono(int codigoPersona) throws Exception {
        List<Telefono> lista = null;
        
        String consulta;
                
        try{
             consulta = "FROM Telefono t WHERE t.codigoPersona.codigo = ?1 ";
            Query query = em.createQuery(consulta);
            query.setParameter(1, codigoPersona);
          
            
            lista = query.getResultList();
           
         
        
        }
        catch(Exception e){
        
        throw  e;
        }
        
        return lista;

    }
    
}
