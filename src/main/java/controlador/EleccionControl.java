/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import java.util.List;
import modelo.Eleccion;
import servicio.CandidatoServiceImpl;
import servicio.DignidadServiceImpl;
import servicio.EleccionServiceImpl;

/**
 *
 * @author Juan Diego Roman
 */
public class EleccionControl {

    private EleccionServiceImpl eleccionServiceImpl = new EleccionServiceImpl();
    private DignidadServiceImpl dignidadServiceImpl = new DignidadServiceImpl();
    private CandidatoServiceImpl candidatoServiceImpl = new CandidatoServiceImpl();

    public EleccionControl() {
        eleccionServiceImpl = new EleccionServiceImpl();
    }

    public void crear(String[] dato) {

        //try {
            var canton = dato[0];
            var numeroVotos = Integer.valueOf(dato[1]).intValue();
            var nroEleccion = Integer.valueOf(dato[2]).intValue();
            var candidato = this.candidatoServiceImpl.busacarPorNombre(dato[3]);
            var dignidad = this.dignidadServiceImpl.buscarPorPublicidad(dato[4]);
            
            var eleccion = new Eleccion(canton, candidato, numeroVotos, dignidad, nroEleccion);
            this.eleccionServiceImpl.crear(eleccion);
        /*} catch (NumberFormatException e1) {
            throw new RuntimeException("Error al ingresar canton");
        } catch (RuntimeException e1) {
            throw new RuntimeException("Nro lista existe");
        }*/
    }

    public String modificar(String[] dato) {

        //try {
            var retorno = "No se pudo modificar";
            var canton = dato[0];
            var candidato = this.candidatoServiceImpl.buscarPorLista(Integer.valueOf(dato[1]).intValue());
            var numeroVotos = Integer.valueOf(dato[2]).intValue();
            var dignidad = this.dignidadServiceImpl.buscarPorCodigo(Integer.valueOf(dato[3]).intValue());
            var nroEleccion = Integer.valueOf(dato[4]).intValue();
            var eleccion = new Eleccion(canton, candidato, numeroVotos, dignidad, nroEleccion);

            this.eleccionServiceImpl.modificar(eleccion, nroEleccion);
            retorno = "Se modifico";
            return retorno;
        /*} catch (NumberFormatException e1) {
            throw new RuntimeException("Error en los parametros");
        } catch (RuntimeException e1) {
            throw new RuntimeException("Nro lista existe");
        }*/

    }

    public List<Eleccion> listar() {

        return this.eleccionServiceImpl.listar();

    }

    public void eliminar(String nroElecciones) {

        //try {
            var nroeleccion = Integer.valueOf(nroElecciones).intValue();
            this.eleccionServiceImpl.eliminar(nroeleccion);
        /*} catch (NumberFormatException e1) {
            throw new RuntimeException("Error en los parametros");
        } catch (RuntimeException e1) {
            throw new RuntimeException("Nro lista existe");
        }*/

    }

}
