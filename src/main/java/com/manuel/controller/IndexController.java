
package com.manuel.controller;

import com.manuel.ejb.UsuarioFacadeLocal;
import com.manuel.model.Usuario;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Named;



@Named(value ="indexController")
@ViewScoped
public class IndexController implements Serializable {
    
    @EJB
    private UsuarioFacadeLocal EJBUsuario;
    private Usuario usuario;
    
    
    @PostConstruct
    public void init(){
        usuario = new Usuario();
    
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
    
    public String iniciarSesion(){
     
        Usuario us;
        String redirecion = null;
     
        try{
         us = EJBUsuario.iniciarSesion(usuario);
         if(us !=  null) {
             //almacenar en la sesion del Jsf   apodo=usuario and  valor=us
             FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("usuario", us);
             
          redirecion = "/protegido/principal?faces-redirect=true";
         }else{
  FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN,"Aviso","Credenciales incorrectas"));

         }
         
       } catch(Exception e) {
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL ,"Aviso","ERROR algo salio mal"));
        
        }
        return  redirecion;     
    }
    
}
