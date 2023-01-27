/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package servicio;

import java.util.List;
import modelo.Eleccion;

/**
 *
 * @author Juan Diego Roman
 */
public interface EleccionService {

    public void crear(Eleccion eleccion);

    public Eleccion buscarPorNroEleccion(int nroeleccion);

    public void modificar(Eleccion eleccion, int nroeleccion);

    public void eliminar(int nroeleccion);

    public List<Eleccion> listar();

    public void almacenarArchivo(Eleccion eleccion, String ruta);

    public List<Eleccion> recuperarArchivo(String ruta);

}
