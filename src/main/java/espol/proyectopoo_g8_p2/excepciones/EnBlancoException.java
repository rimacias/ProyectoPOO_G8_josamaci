/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package espol.proyectopoo_g8_p2.excepciones;

/**
 *
 * @author JMaci
 */
public class EnBlancoException extends Exception{

    /**
     * Creates a new instance of <code>EnBlancoException</code> without detail
     * message.
     */
    public EnBlancoException() {
        System.out.println("¡No puede dejar cajas de texto en blanco!");
    }

    /**
     * Constructs an instance of <code>EnBlancoException</code> with the
     * specified detail message.
     *
     * @param msg the detail message.
     */
    public EnBlancoException(String msg) {
        super(msg);
    }
}
