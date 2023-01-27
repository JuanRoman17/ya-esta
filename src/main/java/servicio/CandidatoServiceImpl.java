/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package servicio;

import java.io.DataInput;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.Candidato;

/**
 *
 * @author Juan Diego Roman
 */
public class CandidatoServiceImpl implements CandidatoService {

    private static List<Candidato> candidatoList = new ArrayList<>();

    /*public CandidatoServiceImpl() {       
        System.out.println("this.candidatoList");
        System.out.println(this.candidatoList);
    }*/
    @Override
    public void crear(Candidato candidato) {
        
       this.candidatoList.add(candidato);
       this.almacenarArchivo(candidato, "C:/TProgra/Candidato.txt");
        

    }

    @Override
    public List<Candidato> listar() {
        return this.candidatoList;
    }

    @Override
    public Candidato buscarPorLista(int lista) {
        Candidato retorno = null;
        for (var candidato : this.candidatoList) {
            if (lista == candidato.getNroLista()) {
                retorno = candidato;
                break;
            }
        }
        return retorno;
    }

    @Override
    public Candidato buscarPorNombre(String nombre) {
        Candidato retorno = null;

        for (var candidato : this.candidatoList) {
            if (nombre.equals(candidato.getNombreCandidato())) {
                retorno = candidato;
                break;
            }
        }

        return retorno;
    }

    @Override
    public void modificar(Candidato candidato, int lista) {
        var indice = -1;
        for (var candidatos : this.candidatoList) {
            indice++;
            if (lista == candidatos.getNroLista()) {
                this.candidatoList.set(indice, candidato);
            }
        }
    }

    @Override
    public void eliminar(int lista) {
        var indice = -1;
        for (var candidatos : this.candidatoList) {
            indice++;
            if (lista == candidatos.getNroLista()) {
                this.candidatoList.remove(indice);

            }

        }

    }

    @Override
    public Candidato busacarPorNombre(String nombre) {
        Candidato retorno = null;

        for (var candidato : this.candidatoList) {
            if (nombre.equals(candidato.getNombreCandidato())) {
                retorno = candidato;
                break;
            }
        }

        return retorno;
    }

    /* @Override
    public void crearArchivo(Candidato candidato) {
       //this.candidatoList.add(candidato);
        //this.almacenarArchivo(candidato, "C:/Users/Juan Diego Roman/OneDrive/Escritorio/TProgra");
    }*/
    @Override
    public void almacenarArchivo(Candidato candidato, String ruta) {

        DataOutputStream salida = null;

        try {
            salida = new DataOutputStream(new FileOutputStream(ruta, true));

            salida.writeUTF(candidato.getNombreCandidato());
            salida.writeInt(candidato.getEdad());
            salida.writeUTF(candidato.getGenero());
            salida.writeUTF(candidato.getLugarDeNacimiento());
            salida.writeInt(candidato.getNroLista());

        } catch (IOException e) {
            try {
                salida.close();
            } catch (IOException ex) {
            Logger.getLogger(CandidatoServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }        

    }

    @Override
    public List<Candidato> recuperarArchivo(String ruta)  {

        var candidatoList = new ArrayList<Candidato>();
        DataInputStream entrada = null;
    
        try {
            entrada = new DataInputStream(new FileInputStream(ruta));
            while (true) {

                var nombreCandidato = entrada.readUTF();
                var edad = entrada.readInt();
                var genero = entrada.readUTF();
                var lugarDeNacimiento = entrada.readUTF();
                var nroLista = entrada.readInt();
                var candidato = new Candidato(nombreCandidato, edad, genero, lugarDeNacimiento, nroLista);
                candidatoList.add(candidato);
            }

        } catch (IOException e) {
            try {
                entrada.close();
            } catch (IOException ex) {
                Logger.getLogger(CandidatoServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
        return candidatoList;
    }

    public List<Candidato> getCandidatoList() {
        return candidatoList;
    }

    public void setCandidatoList(List<Candidato> candidatoList) {
        CandidatoServiceImpl.candidatoList = candidatoList;
    }

}
