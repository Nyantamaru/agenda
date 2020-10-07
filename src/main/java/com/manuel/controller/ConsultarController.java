
package com.manuel.controller;

import com.manuel.ejb.PersonaFacadeLocal;
import com.manuel.ejb.TelefonoFacadeLocal;
import com.manuel.model.Persona;
import com.manuel.model.Telefono;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.faces.view.ViewScoped;


@Named(value = "consultarController")
@ViewScoped
public class ConsultarController implements Serializable {

    @EJB
    private PersonaFacadeLocal personaEJB;
    @EJB
    private TelefonoFacadeLocal telefonoEJB;
    
    private List<Persona> personas;
    private List<Telefono> telefonos;
    private int codigoPersona;

    
    
    public List<Telefono> getTelefonos() {
        return telefonos;
    }

    public void setTelefonos(List<Telefono> telefonos) {
        this.telefonos = telefonos;
    }
 
    public int getCodigoPersona() {
        return codigoPersona;
    }

    public void setCodigoPersona(int codigoPersona) {
        this.codigoPersona = codigoPersona;
    }
    
    public List<Persona> getPersonas() {
        return personas;
    }

    public void setPersonas(List<Persona> personas) {
        this.personas = personas;
    }

    @PostConstruct
    public void  init(){
    
       personas =  personaEJB.findAll();
        
    }
    
    public void buscarTelefonos() throws Exception {
        try {

            telefonos = telefonoEJB.buscarTelefono(codigoPersona);

        } catch (Exception e) {

            throw e;
        }

    }
   
}
