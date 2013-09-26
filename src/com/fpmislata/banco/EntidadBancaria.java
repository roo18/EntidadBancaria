/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fpmislata.banco;

/**
 *
 * @author alumno
 */
public class EntidadBancaria {
    
    private int idEntidad;
    private String codigoEntidad;
    private String nombre;
    private String cif;
    private TipoEntidadBancaria entidad;

    public EntidadBancaria() {
    }

    public EntidadBancaria(int idEntidad, String codigoEntidad, String nombre, String cif, TipoEntidadBancaria entidad) {
        this.idEntidad = idEntidad;
        this.codigoEntidad = codigoEntidad;
        this.cif = cif;
        this.nombre = nombre;
        this.entidad = entidad;
        
    }

    public int getIdEntidad() {
        return idEntidad;
    }

    public void setIdEntidad(int idEntidad) {
        this.idEntidad = idEntidad;
    }

    public String getCodigoEntidad() {
        return codigoEntidad;
    }

    public void setCodigoEntidad(String codigoEntidad) {
        this.codigoEntidad = codigoEntidad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCif() {
        return cif;
    }

    public void setCif(String cif) {
        this.cif = cif;
    }

    public TipoEntidadBancaria getEntidad() {
        return entidad;
    }

    public void setEntidad(TipoEntidadBancaria entidad) {
        this.entidad = entidad;
    }
    
    
    
}
