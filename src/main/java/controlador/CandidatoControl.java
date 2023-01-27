/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import java.io.Serializable;
import java.util.List;
import modelo.Candidato;
import servicio.CandidatoServiceImpl;

/**
 *
 * @author Juan Diego Roman
 */
public class CandidatoControl  {

    private CandidatoServiceImpl candidatoServiceImpl = new CandidatoServiceImpl();
    //private static CandidatoControl instance;

    /*public static CandidatoControl getInstance() {
        if (instance == null) {
            instance = new CandidatoControl();
        }
        return instance;
    }
    public CandidatoControl() {

    }*/

    public Candidato crear(String[] data) throws Exception {

        //try {
            var retorno = "No se puede crear";
            var nombreCandidato = data[0];
            var edad = Integer.valueOf(data[1]);
            var genero = data[2];
            var lugarDeNacimiento = data[3];
            var nrolista = Integer.valueOf(data[4]);
            var candidato = new Candidato(nombreCandidato, edad, genero, lugarDeNacimiento, nrolista);

            this.candidatoServiceImpl.crear(candidato);
        /*} catch (NumberFormatException e1) {
            throw new RuntimeException("Error al ingresar los datos");
        } catch (RuntimeException e1) {
            throw new RuntimeException("Nro lista existe");
        }*/
        return candidato;

    }

    public boolean NroLista(int NroLista) {
        var retorno = false;
        for (var candidato : this.candidatoServiceImpl.listar()) {
            if (candidato.getNroLista() == NroLista) {
                retorno = true;

            }
        }

        return retorno;
    }

    public String modifcar(String[] data) {

        //try {

            var retorno = "No se pudo crear el candidato";
            var nombreCandidato = data[0];
            var edad = Integer.valueOf(data[1]).intValue();
            var genero = data[2];
            var lugarDeNacimiento = data[3];
            var nrolista = Integer.valueOf(data[4]).intValue();
            var candidato = new Candidato(nombreCandidato, edad, genero, lugarDeNacimiento, nrolista);

            this.candidatoServiceImpl.modificar(candidato, nrolista);
            retorno = "Candidato " + candidato.getNombreCandidato() + " Modificado";
            return retorno;
            

        /*} catch (NumberFormatException e1) {
            throw new RuntimeException("Error en los parametros");
        } catch (RuntimeException e1) {
            throw new RuntimeException("Nro lista existe");
        }*/

    }

    public List<Candidato> listar() {
        return this.candidatoServiceImpl.listar();

    }

    public void eliminar(String listas) {

        //try {

            var lista = Integer.valueOf(listas).intValue();
            this.candidatoServiceImpl.eliminar(lista);

        /*} catch (NumberFormatException e1) {
            throw new RuntimeException("Error en los parametros");
        } catch (RuntimeException e1) {
            throw new RuntimeException("Nro lista existe");
        }*/
    }

    public Candidato buscarPorNombre(String nombreCandidato) {
        return this.candidatoServiceImpl.buscarPorNombre(nombreCandidato);

    }

    /* public boolean NrolistaExiste(int Nrolista) {
        var retorno = false;
        for (var candidato : this.candidatoServiceImpl.listar()) {
            if (candidato.getNroLista() == Nrolista) {
                retorno = true;

            }

        }
        return retorno;
    }*/
    public boolean validarNroLista(int nrolista) {
        String numCadena = String.valueOf(nrolista);
        String cadena = numCadena;

        char[] cadenaDiv = cadena.toCharArray();
        String n = "";

        for (int i = 0; i < cadenaDiv.length; i++) {
            if (Character.isDigit(cadenaDiv[i])) {
                n += cadenaDiv[i];
            } else {
                return false;
            }
        }
        if (nrolista > 0) {

            return true;
        } else {
            return false;
        }
    }

    public boolean validarTexto(String texto) {
        var retorno = true;
        String cadena = texto;
        char[] cadena_div = cadena.toCharArray();
        String n = "";
        for (int i = 0; i < cadena_div.length; i++) {
            if (Character.isDigit(cadena_div[i])) {
                n += cadena_div[i];
                retorno = false;

            }
        }

        return retorno;
    }
}
