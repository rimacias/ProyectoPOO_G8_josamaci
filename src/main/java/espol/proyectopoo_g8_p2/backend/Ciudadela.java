/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package espol.proyectopoo_g8_p2.backend;

import java.util.List;

/**
 *
 * @author andre
 */
public class Ciudadela {
    List<Casa> casas;
    //List<Usuario> usuarios;
    
    /**
     * Constructor de Ciudadela que carga la lista de casas de casas.txt
     */
    public Ciudadela(){
        casas = Casa.cargarCasa();
    }
    
    /**
     * getter de la lista de casas de la ciudadela
     * @return List<Casa>
     */
    public List<Casa> getListaCasas(){
        return casas;
    }
    
    /**
     * Método que selecciona una casa 
     * @param c 
     * @return Casa
     */
    public Casa getCasa(Casa c){
        return c;
    }
}
