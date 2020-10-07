
package com.manuel.controller;

import com.manuel.ejb.CategoriaFacadeLocal;
import com.manuel.ejb.NotaFacadeLocal;
import com.manuel.model.Categoria;
import com.manuel.model.Nota;
import com.manuel.model.Usuario;
import javax.inject.Named;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;


@Named(value = "buscarController")
@ViewScoped
public class BuscarController implements Serializable {
    
    @EJB 
    CategoriaFacadeLocal categoriaEJB;
    
    @EJB 
    NotaFacadeLocal notaEJB;
    
    List<Categoria> listaCategorias;
    List<Nota> listaNotas;
    private int codigoCategoria;
    private Date fechaConsulta;

    public List<Nota> getListaNotas() {
        return listaNotas;
    }

    public void setListaNotas(List<Nota> listaNotas) {
        this.listaNotas = listaNotas;
    }
    
    

    public int getCodigoCategoria() {
        return codigoCategoria;
    }

    public void setCodigoCategoria(int codigoCategoria) {
        this.codigoCategoria = codigoCategoria;
    }

    public Date getFechaConsulta() {
        return fechaConsulta;
    }

    public void setFechaConsulta(Date fechaConsulta) {
        this.fechaConsulta = fechaConsulta;
    }
    
    

    public List<Categoria> getListaCategorias() {
        return listaCategorias;
    }

    public void setListaCategorias(List<Categoria> listaCategorias) {
        this.listaCategorias = listaCategorias;
    }

   

 
    
    
    @PostConstruct 
    public void init(){
        
        listaCategorias = categoriaEJB.findAll();
    }
    
    public void buscar(){
        
        try {
       
         Usuario us = (Usuario) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("usuario");

         listaNotas = notaEJB.buscar( us.getCodigo().getCodigo(), codigoCategoria, fechaConsulta);
     
        } 
        catch(Exception e){
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
        
          }
    
}
