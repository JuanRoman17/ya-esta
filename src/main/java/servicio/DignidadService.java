/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package servicio;

import java.util.List;
import modelo.Dignidad;

/**
 *
 * @author Juan Diego Roman
 */
public interface DignidadService {

    public void crear(Dignidad dignidad);

    public List<Dignidad> listar();

    public Dignidad buscarPorCodigo(int codigo);

    public void modificar(Dignidad dignidad, int codigo);

    public void eliminar(int codigo);
    
    public Dignidad buscarPorPublicidad(String nombre);
    
    public void almacenarArchivo(Dignidad dignidad, String ruta);
    
    public List<Dignidad> recuperarArchivo(String ruta);

}
