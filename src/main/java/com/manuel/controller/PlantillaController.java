
package com.manuel.controller;

import com.manuel.model.Usuario;
import java.io.Serializable;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.faces.view.ViewScoped;


@Named(value = "plantillaController")
@ViewScoped
public class PlantillaController implements Serializable {

   
    
        
        public void verificarSesion(){
        
        try{
           FacesContext context = FacesContext.getCurrentInstance();
           Usuario us = (Usuario) context.getExternalContext().getSessionMap().get("usuario");         
           
           if(us == null) {
               context.getExternalContext().redirect("./../permisos.xhtml");
           
           }
        }catch(Exception e){
        //
            System.out.println("hubo un error en la plantilla Controller");
        }
        
       }
   }
    

