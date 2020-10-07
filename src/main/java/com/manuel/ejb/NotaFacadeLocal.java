
package com.manuel.ejb;

import com.manuel.model.Nota;
import java.util.Date;
import java.util.List;
import javax.ejb.Local;

//para mencionar que es una interfaz de tipo local
@Local
public interface NotaFacadeLocal {

    void create(Nota nota);

    void edit(Nota nota);

    void remove(Nota nota);

    Nota find(Object id);

    List<Nota> findAll();

    List<Nota> findRange(int[] range);

    int count();
    
    List<Nota> buscar(int CodigoPersona, int codigoCategoria, Date fechaConsulta) throws Exception;
    
}
