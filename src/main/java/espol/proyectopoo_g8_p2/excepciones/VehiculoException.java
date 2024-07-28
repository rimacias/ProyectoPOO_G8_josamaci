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
public class VehiculoException extends Exception{

    /**
     * Creates a new instance of <code>PinLargoException</code> without detail
     * message.
     */
    public VehiculoException() {
        System.out.println("Error al ingresar el vehículo.");
    }

    /**
     * Constructs an instance of <code>PinLargoException</code> with the
     * specified detail message.
     *
     * @param msg the detail message.
     */
    public VehiculoException(String msg) {
        super(msg);
    }
}
