/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package espol.proyectopoo_g8_p2.backend;

/**
 *
 * @author andre
 */
public class Pin {
    /**
     * Método que crea el pin del residente
     * @param n
     * @return 
     */
    public static String crearPin(int n){
        String numeros = "0123456789";
        
        StringBuilder sb = new StringBuilder(n);
        
        for(int i = 0; i < n; i++){
            int index = (int)(numeros.length()*Math.random());
            
            sb.append(numeros.charAt(index));
            
        }
        return sb.toString();
        
    }
    /**
     * Método estático que ejecuta el método que crea el pin del residente
     * @param args 
     */
    public static void main(String[] args)
    {
  
        // Get the size n
        int n = 4;
  
        // Get and display the alphanumeric string
        System.out.println(Pin.crearPin(n));
    }
    
}
