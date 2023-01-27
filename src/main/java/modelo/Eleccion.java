/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;
import java.io.Serializable;
import modelo.Candidato;
/**
 *
 * @author Juan Diego Roman
 */
public class Eleccion implements Serializable{

    private String canton;
    private  Candidato candidato;
    private int numeroVotos;
    private Dignidad dignidad;
    private int nroEleccion;

    public Eleccion(String canton, Candidato candidato, int numeroVotos, Dignidad dignidad, int nroEleccion) {
        this.canton = canton;
        this.candidato = candidato;
        this.numeroVotos = numeroVotos;
        this.dignidad = dignidad;
        this.nroEleccion = nroEleccion;
    }

    public String getCanton() {
        return canton;
    }

    public void setCanton(String canton) {
        this.canton = canton;
    }

    public Candidato getCandidato() {
        return candidato;
    }

    public void setCandidato(Candidato candidato) {
        this.candidato = candidato;
    }

    public int getNumeroVotos() {
        return numeroVotos;
    }

    public void setNumeroVotos(int numeroVotos) {
        this.numeroVotos = numeroVotos;
    }

    public Dignidad getDignidad() {
        return dignidad;
    }

    public void setDignidad(Dignidad dignidad) {
        this.dignidad = dignidad;
    }

    public int getNroEleccion() {
        return nroEleccion;
    }

    public void setNroEleccion(int nroEleccion) {
        this.nroEleccion = nroEleccion;
    }

    @Override
    public String toString() {
        return "Eleccion{" + "canton=" + canton + ", candidato=" + candidato 
                + ", numeroVotos=" + numeroVotos + ", dignidad=" + dignidad + ", nroelecion=" + nroEleccion + '}';
    }

    
    
}
