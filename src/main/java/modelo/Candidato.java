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
public class Candidato implements Serializable {

    private String nombreCandidato;
    private int edad;
    private String genero;
    private String lugarDeNacimiento;
    private int nroLista;

    public Candidato(String nombreCandidato, int edad, String genero,
            String lugarDeNacimiento, int nroLista) {

        this.nombreCandidato = nombreCandidato;
        this.edad = edad;
        this.genero = genero;
        this.lugarDeNacimiento = lugarDeNacimiento;

        this.nroLista = nroLista;
    }

    public String getNombreCandidato() {
        return nombreCandidato;
    }

    public void setNombreCandidato(String nombreCandidato) {
        this.nombreCandidato = nombreCandidato;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getLugarDeNacimiento() {
        return lugarDeNacimiento;
    }

    public void setLugarDeNacimiento(String lugarDeNacimiento) {
        this.lugarDeNacimiento = lugarDeNacimiento;
    }

    public int getNroLista() {
        return nroLista;
    }

    public void setNroLista(int nroLista) {
        this.nroLista = nroLista;
    }

    @Override
    public String toString() {
        return "Candidato{" + "nombreCandidato=" + nombreCandidato + ", edad="
                + edad + ", genero=" + genero + ", lugarDeNacimiento="
                + lugarDeNacimiento + ", nroLista=" + nroLista + '}';
    }

}
