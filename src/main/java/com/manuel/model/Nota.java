/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.manuel.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author manuel
 */
@Entity
@Table(name = "nota")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Nota.findAll", query = "SELECT n FROM Nota n")
    , @NamedQuery(name = "Nota.findByCodigo", query = "SELECT n FROM Nota n WHERE n.codigo = :codigo")
    , @NamedQuery(name = "Nota.findByEncabezado", query = "SELECT n FROM Nota n WHERE n.encabezado = :encabezado")
    , @NamedQuery(name = "Nota.findByCuerpo", query = "SELECT n FROM Nota n WHERE n.cuerpo = :cuerpo")
    , @NamedQuery(name = "Nota.findByFecha", query = "SELECT n FROM Nota n WHERE n.fecha = :fecha")
    , @NamedQuery(name = "Nota.findByComentarioadmin", query = "SELECT n FROM Nota n WHERE n.comentarioadmin = :comentarioadmin")
    , @NamedQuery(name = "Nota.findByValorizacion", query = "SELECT n FROM Nota n WHERE n.valorizacion = :valorizacion")})
public class Nota implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "codigo")
    private int codigo;
    
    
    @Size(max = 2147483647)
    @Column(name = "encabezado")
    private String encabezado;
    @Size(max = 2147483647)
    @Column(name = "cuerpo")
    private String cuerpo;
    
    
    @Column(name = "fecha",insertable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecha;
    
    
    @Size(max = 2147483647)
    @Column(name = "comentarioadmin")
    private String comentarioadmin;
    
    
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "valorizacion")
    private Integer valorizacion;
    
    
    @JoinColumn(name = "codigo_categoria", referencedColumnName = "codigo")
    @ManyToOne(optional = false)
    private Categoria codigoCategoria;
    
    
    @JoinColumn(name = "codigo_persona", referencedColumnName = "codigo")
    @ManyToOne(optional = false)
    private Persona codigoPersona;

    public Nota() {
    }

    public Nota(int codigo) {
        this.codigo = codigo;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getEncabezado() {
        return encabezado;
    }

    public void setEncabezado(String encabezado) {
        this.encabezado = encabezado;
    }

    public String getCuerpo() {
        return cuerpo;
    }

    public void setCuerpo(String cuerpo) {
        this.cuerpo = cuerpo;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getComentarioadmin() {
        return comentarioadmin;
    }

    public void setComentarioadmin(String comentarioadmin) {
        this.comentarioadmin = comentarioadmin;
    }

    public Integer getValorizacion() {
        return valorizacion;
    }

    public void setValorizacion(Integer valorizacion) {
        this.valorizacion = valorizacion;
    }

    public Categoria getCodigoCategoria() {
        return codigoCategoria;
    }

    public void setCodigoCategoria(Categoria codigoCategoria) {
        this.codigoCategoria = codigoCategoria;
    }

    public Persona getCodigoPersona() {
        return codigoPersona;
    }

    public void setCodigoPersona(Persona codigoPersona) {
        this.codigoPersona = codigoPersona;
    }

 

  

    @Override
    public String toString() {
        return "com.manuel.model.Nota[ codigo=" + codigo + " ]";
    }
    
}
