/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package servicio;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.Eleccion;

/**
 *
 * @author Juan Diego Roman
 */
public class EleccionServiceImpl implements EleccionService {

    private static List<Eleccion> eleccionList;

    public EleccionServiceImpl() {
        eleccionList = new ArrayList<>();
    }

    @Override
    public void crear(Eleccion eleccion) {
        this.eleccionList.add(eleccion);
    }

    @Override
    public List<Eleccion> listar() {
        return this.eleccionList;
    }

    @Override
    public Eleccion buscarPorNroEleccion(int nroEleccion) {
        Eleccion retorno = null;
        for (var eleccion : this.eleccionList) {
            if (nroEleccion == eleccion.getNroEleccion()) {
                retorno = eleccion;
                break;
            }
        }
        return null;
    }

    @Override
    public void modificar(Eleccion eleccion, int nroEleccion) {
        var indice = -1;
        for (var eleciones : this.eleccionList) {
            indice++;
            if (nroEleccion == eleciones.getNroEleccion()) {
                this.eleccionList.set(indice, eleccion);
            }
        }
    }

    @Override
    public void eliminar(int nroEleccion) {

        var indice = -1;
        for (var eleciones : this.eleccionList) {
            indice++;
            if (nroEleccion == eleciones.getNroEleccion()) {
                this.eleccionList.remove(indice);

            }

        }

    }

    @Override
    public void almacenarArchivo(Eleccion eleccion, String ruta) {

        ObjectOutputStream salida = null;

        try {
            salida = new ObjectOutputStream(new FileOutputStream(ruta, true));
            salida.writeObject(eleccion);
            salida.close();

        } catch (Exception ex) {
            Logger.getLogger(EleccionServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @Override
    public List<Eleccion> recuperarArchivo(String ruta) {
        List<Eleccion> eleccionList = new ArrayList<Eleccion>();
        try {
            var fis = new FileInputStream(new File(ruta));
            ObjectInputStream entrada = null;

            while (fis.available() > 0) {
                entrada = new ObjectInputStream(fis);
                Eleccion provincia = (Eleccion) entrada.readObject();
                eleccionList.add(provincia);

            }
            entrada.close();
        } catch(Exception ex){
            //entrada.close(); 
        }
        return eleccionList;
    }

    public static List<Eleccion> getEleccionList() {
        return eleccionList;
    }

    public static void setEleccionList(List<Eleccion> eleccionList) {
        EleccionServiceImpl.eleccionList = eleccionList;
    }

}
