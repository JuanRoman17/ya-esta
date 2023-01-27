/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package servicio;

import java.util.List;
import modelo.Candidato;

/**
 *
 * @author Juan Diego Roman
 */
public interface CandidatoService {
    
    public void crear(Candidato candidato);

    //public void crearArchivo(Candidato candidato);

    public List<Candidato> listar();

    public Candidato buscarPorLista(int lista);

    public Candidato buscarPorNombre(String nombreCandidato);

    public void modificar(Candidato candidato, int lista);

    public void eliminar(int lista);
    
    public Candidato busacarPorNombre(String nombre);
    
    public void almacenarArchivo(Candidato candidato, String ruta);
    
    public List<Candidato> recuperarArchivo(String ruta);

}
