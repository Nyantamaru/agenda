
package com.manuel.controller;

import com.manuel.ejb.UsuarioFacadeLocal;
import com.manuel.model.Persona;
import com.manuel.model.Usuario;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

@Named(value ="usuarioController")
@ViewScoped
public class UsuarioController  implements Serializable{
    
    @EJB
    private UsuarioFacadeLocal usuarioEJB;
    
    @Inject
    private Usuario usuario;
    
    @Inject
    private Persona persona;
    
    //como no defini constructor implicito java lo hace automatico cons el @postconstruct
    @PostConstruct
    public void init() {
        
//variable instanciadas para evitar el null pointer execption
       // usuario = new Usuario();
       // persona = new Persona();
    //las comente por que esotoy usando inyecion de dependencias    
    
    
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }
    
    public void registrar() {
        try{
            this.usuario.setCodigo(persona);
            usuarioEJB.create(usuario);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"Aviso","Se Registro"));
            
            
        }catch(Exception e){
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL,"Aviso","Error en la bd"));
            
        }
    }
}
