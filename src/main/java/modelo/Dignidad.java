/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.io.Serializable;

/**
 *
 * @author Juan Diego Roman
 */
public class Dignidad implements Serializable{

    private String publicidad;
    private String campaña;
    private String propuestas;
    private int codigo;

    public Dignidad(String publicidad, String campaña, String propuestas, int codigo) {
        this.publicidad = publicidad;
        this.campaña = campaña;
        this.propuestas = propuestas;
        this.codigo = codigo;
    }

    public String getPublicidad() {
        return publicidad;
    }

    public void setPublicidad(String publicidad) {
        this.publicidad = publicidad;
    }

    public String getCampaña() {
        return campaña;
    }

    public void setCampaña(String campaña) {
        this.campaña = campaña;
    }

    public String getPropuestas() {
        return propuestas;
    }

    public void setPropuestas(String propuestas) {
        this.propuestas = propuestas;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    @Override
    public String toString() {
        return "Dignidad{" + "publicidad=" + publicidad + ", campa\u00f1a="
                + campaña + ", propuestas=" + propuestas + ", codigo=" + codigo + '}';
    }

}
