
package com.manuel.controller;

import com.manuel.ejb.MenuFacadeLocal;
import com.manuel.model.Menu;
import com.manuel.model.Usuario;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import org.primefaces.model.menu.DefaultMenuItem;
import org.primefaces.model.menu.DefaultMenuModel;
import org.primefaces.model.menu.DefaultSubMenu;
import org.primefaces.model.menu.MenuModel;
import javax.faces.context.FacesContext;

@Named(value = "menuController")
@SessionScoped


public class MenuController  implements Serializable {

  
    @EJB
    private MenuFacadeLocal EJBMenu;
    private List<Menu> lista;
    private MenuModel model;

  
    
    // se usa por que se han llamado beans y no se han inizializado y con el @postconstruct los beann ya han sido inicializados
    @PostConstruct
    public void init(){
        this.listarMenus();
        model = new DefaultMenuModel();
        this.establecerPermisos();
    }
    
    
     public void listarMenus(){
     
         try{
             lista = EJBMenu.findAll();
             
         }catch(Exception exc){
             exc.printStackTrace();
             System.out.println("error en menuController");
         
         } 
     }
     
       public MenuModel getModel() {
        return model;
    }

    public void setModel(MenuModel model) {
        this.model = model;
    }
    
    
     public void establecerPermisos(){
         Usuario us = (Usuario) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("usuario");
         
         for(Menu m : lista){
             if(m.getTipo().equals("S") && m.getTipousuario().equals(us.getTipo()) ) {
                  DefaultSubMenu firstSubmenu = new DefaultSubMenu(m.getNombre());
                  for(Menu i: lista){
                     Menu submenu = i.getCodigoSubmenu();
                        if(submenu != null){
                            if(Objects.equals(submenu.getCodigo(), m.getCodigo())) {
                                DefaultMenuItem item = new DefaultMenuItem(i.getNombre());
                                item.setUrl(i.getUrl());
                                firstSubmenu.addElement(item);
                       }
                  }
               }
                      model.addElement(firstSubmenu);
             } else {
                 if(m.getCodigoSubmenu() == null &&  m.getTipousuario().equals(us.getTipo())  ){
                  DefaultMenuItem item = new DefaultMenuItem(m.getNombre());
                  item.setUrl(m.getUrl());
                  model.addElement(item);
                 }
                
             }
         }
     
     }
     
  public void cerrarSession(){
      FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
  }
  
  public String  mostrarUsuarioLogeado(){
           
      
      Usuario us = (Usuario) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("usuario");

  return us.getUsuario();
  }
     
}
