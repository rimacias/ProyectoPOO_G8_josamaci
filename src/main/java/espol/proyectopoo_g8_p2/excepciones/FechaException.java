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
public class FechaException extends Exception{

    /**
     * Creates a new instance of <code>PinLargoException</code> without detail
     * message.
     */
    public FechaException() {
        System.out.println("Error al leer la fecha.");
    }

    /**
     * Constructs an instance of <code>PinLargoException</code> with the
     * specified detail message.
     *
     * @param msg the detail message.
     */
    public FechaException(String msg) {
        super(msg);
    }
}
