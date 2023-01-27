/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import java.util.List;
import modelo.Dignidad;
import servicio.DignidadServiceImpl;

/**
 *
 * @author Juan Diego Roman
 */
public class DignidadControl {

    private DignidadServiceImpl dignidadServiceImpl = new DignidadServiceImpl();

    public DignidadControl() {

    }

    public void crear(String[] dat) {

        //try {
            var publicidad = dat[0];
            var campaña = dat[1];
            var propuestas = dat[2];
            var codigo = Integer.valueOf(dat[3]).intValue();
            var dignidad = new Dignidad(publicidad, campaña, propuestas, codigo);

            this.dignidadServiceImpl.crear(dignidad);
        /*} catch (NumberFormatException e1) {
            throw new RuntimeException("Error en los parametros");
        } catch (RuntimeException e1) {
            throw new RuntimeException("Nro lista existe");
        }*/
    }

    public String modificar(String[] dat) {

        //try {
            var retorno = "No se pudo crear";
            var publicidad = dat[0];
            var campaña = dat[1];
            var propuestas = dat[2];
            var codigo = Integer.valueOf(dat[3]).intValue();
            var dignidad = new Dignidad(publicidad, campaña, propuestas, codigo);

            this.dignidadServiceImpl.modificar(dignidad, codigo);
            retorno = "Dignidad" + dignidad.getCodigo() + "Modificado";
            return retorno;
        /*} catch (NumberFormatException e1) {
            throw new RuntimeException("Error en los parametros");
        } catch (RuntimeException e1) {
            throw new RuntimeException("Nro lista existe");
        }*/
    }

    public List<Dignidad> listar() {
        return this.dignidadServiceImpl.listar();

    }

    public void eliminar(String codigos) {

        //try {
            var codigo = Integer.valueOf(codigos).intValue();
            this.dignidadServiceImpl.eliminar(codigo);
        /*} catch (NumberFormatException e1) {
            throw new RuntimeException("Error en los parametros");
        } catch (RuntimeException e1) {
            throw new RuntimeException("Nro lista existe");
        }*/
    }
}
