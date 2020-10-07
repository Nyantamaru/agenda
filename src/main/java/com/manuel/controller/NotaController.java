
package com.manuel.controller;

import com.manuel.ejb.CategoriaFacadeLocal;
import com.manuel.ejb.NotaFacadeLocal;
import com.manuel.model.Categoria;
import com.manuel.model.Nota;
import com.manuel.model.Persona;
import com.manuel.model.Usuario;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;


@Named(value = "notaController")
@ViewScoped
public class NotaController  implements Serializable{

   
    @EJB
    private NotaFacadeLocal notaEJB;
    @EJB
    private CategoriaFacadeLocal categoriaEJB;
    @Inject
    private Nota nota;
    @Inject
    private Categoria categoria;
    
    
    private List<Categoria> categorias;

    public Nota getNota() {
        return nota;
    }

    public void setNota(Nota nota) {
        this.nota = nota;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    
    
    public List<Categoria> getCategorias() {
        return categorias;
    }

    public void setCategorias(List<Categoria> categorias) {
        this.categorias = categorias;
    }
    
    
    @PostConstruct
    public void init(){
        categorias  = categoriaEJB.findAll();
    
    }
    
    
    public void registrar(){
        
        try{
            Usuario us = (Usuario) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("usuario");
            nota.setCodigoCategoria(categoria);
            nota.setCodigoPersona(us.getCodigo());
            notaEJB.create(nota);
           
       FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"Aviso","Se Registro"));

        
        }catch(Exception e){
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL,"Aviso","Error en notaCtroller"));
            System.out.println("algo salio mal en notaController");
        
        }
         
        
    
    
    }
    
    
      
            
            
       
    
    
    
}
