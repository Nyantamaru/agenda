
package com.manuel.controller;

import com.manuel.ejb.CategoriaFacadeLocal;
import com.manuel.model.Categoria;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

//value agregado por mi por que el ide lo agregar por defecto
@Named(value ="categoriaController") 
@ViewScoped
public class CategoriaController implements Serializable {
    
    
    @EJB
    private CategoriaFacadeLocal categoriaEJB; 
    
    //esto es inyecion de dependencias
    @Inject 
    private Categoria  categoria;

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }
    
    
    @PostConstruct
    public void init() {
        //categoria = new Categoria();   //esto es sin inyecion de depnedencias
    
    }
    
    public void registrar() {
            
        try   {
                categoriaEJB.create(categoria);
        } catch (Exception e) {
                    //mensaje prime grwol 
        }
    }  
}
