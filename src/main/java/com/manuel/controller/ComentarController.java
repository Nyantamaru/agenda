
package com.manuel.controller;

import com.manuel.ejb.NotaFacadeLocal;
import com.manuel.model.Nota;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;


@Named(value = "comentarController")
@RequestScoped
public class ComentarController implements Serializable {

    
   
    @EJB
    private NotaFacadeLocal notaEJB;
    private List<Nota> notas;
    private Nota nota;

    public Nota getNota() {
        return nota;
    }

    public void setNota(Nota nota) {
        this.nota = nota;
    }
    
    

    public List<Nota> getNotas() {
        return notas;
    }

    public void setNotas(List<Nota> notas) {
        this.notas = notas;
    }
    
    
    
    @PostConstruct
    public void init(){
    
        notas = notaEJB.findAll();
    
    }
    
  public  void asignar(Nota nota){
     this.nota = nota;
    }
    
    
}
