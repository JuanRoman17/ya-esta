/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package servicio;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.Dignidad;

/**
 *
 * @author Juan Diego Roman
 */
public class DignidadServiceImpl implements DignidadService {

    private static List<Dignidad> dignidadList = new ArrayList<>();

    @Override
    public void crear(Dignidad dignidad) {
        this.dignidadList.add(dignidad);
        this.almacenarArchivo(dignidad, "C:/TProgra/Dignidad.txt");
        
    }

    @Override
    public List<Dignidad> listar() {
        return this.dignidadList;
    }

    @Override
    public Dignidad buscarPorCodigo(int codigo) {
        Dignidad retorno = null;
        for (var dignidad : this.dignidadList) {
            if (codigo == dignidad.getCodigo()) {
                retorno = dignidad;
                break;
            }
        }
        return retorno;
    }

    @Override
    public void modificar(Dignidad dignidad, int codigo) {
        var indice = -1;
        for (var candidatos : this.dignidadList) {
            indice++;
            if (codigo == candidatos.getCodigo()) {
                this.dignidadList.set(indice, dignidad);
            }
        }
    }

    @Override
    public void eliminar(int codigo) {
        var indice = -1;
        for (var dignidades : this.dignidadList) {
            indice++;
            if (codigo == dignidades.getCodigo()) {
                this.dignidadList.remove(indice);

            }

        }
    }

    @Override
    public Dignidad buscarPorPublicidad(String nombre) {
        Dignidad retorno = null;

        for (var dignidad : this.dignidadList) {
            if (nombre.equals(dignidad.getPublicidad())) {
                retorno = dignidad;
                break;
            }
        }

        return retorno;
    }

    @Override
    public void almacenarArchivo(Dignidad dignidad, String ruta) {
        DataOutputStream salida = null;

        try {
            salida = new DataOutputStream(new FileOutputStream(ruta, true));
            salida.writeUTF(dignidad.getPublicidad());
            salida.writeUTF(dignidad.getCampaña());
            salida.writeUTF(dignidad.getPropuestas());
            salida.writeInt(dignidad.getCodigo());

        } catch (IOException e) {
            
            try {
                salida.close();
            } catch (IOException ex) {
                Logger.getLogger(DignidadServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    @Override
    public List<Dignidad> recuperarArchivo(String ruta) {
        var dignidadList = new ArrayList<Dignidad>();
        DataInputStream entrada = null;

        try {
            entrada = new DataInputStream(new FileInputStream(ruta));
            while (true) {
                while (true) {
                    var publicidad = entrada.readUTF();
                    var campaña = entrada.readUTF();
                    var propuesta = entrada.readUTF();
                    var codigo = entrada.readInt();
                    var dignidad = new Dignidad(publicidad, campaña, propuesta, codigo);
                    dignidadList.add(dignidad);
                }
            }
        } catch (IOException e) {
            try {
                entrada.close();
            } catch (IOException ex) {
                Logger.getLogger(DignidadServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return dignidadList;

    }

    public static List<Dignidad> getDignidadList() {
        return dignidadList;
    }

    public static void setDignidadList(List<Dignidad> dignidadList) {
        DignidadServiceImpl.dignidadList = dignidadList;
    }
    
}
