
package com.manuel.controller;

import com.manuel.ejb.NotaFacadeLocal;
import com.manuel.model.Nota;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;


@Named(value = "valorarController")
@ViewScoped
public class ValorarController implements Serializable  {

    @EJB
    private NotaFacadeLocal notaEJB;
    @Inject
    private ComentarController comentarController;
    private Nota nota;
    
    
    @PostConstruct
    public void init(){
            this.nota = comentarController.getNota();
    }

    public Nota getNota() {
        return nota;
    }

    public void setNota(Nota nota) {
        this.nota = nota;
    }
    
    public void registrar(){
    
        try{
       
            notaEJB.edit(nota);
FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"Aviso","Se Comento Perfectamente"));

        }
        catch(Exception e){
        
FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Aviso","Error en #valorarController"));
          
        
        }
        finally{
        
            FacesContext.getCurrentInstance().getExternalContext().getFlash().setKeepMessages(true);
        }
        
        
        
    }
    
    
}
