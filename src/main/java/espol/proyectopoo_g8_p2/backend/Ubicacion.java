/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package espol.proyectopoo_g8_p2.backend;

/**
 *
 * @author JMaci
 */
public class Ubicacion {
    private double x;
    private double y;
   /**
     * Constructor para la clase ubicacion
     * @param x - Define la coordenada en x
     * @param y - Define la coordenada en y
     
     */   
    public Ubicacion(double x, double y){
        this.x = x;
        this.y = y;
    }
    /**
     * getter que retorna la coordenada x 
     * @return x
     */
    public double getX() {
        return x;
    }
      /**
     * setter que retorna la coordenada x
     * @param x 
     */
    public void setX(double x) {
        this.x = x;
    }
    /**
     * getter que retorna la coordenada y
     * @return y
     */
    public double getY() {
        return y;
    }
      /**
     * setter que retorna la coordenada y
     * @param y 
     */
    public void setY(double y) {
        this.y = y;
    }
    /**
     * calcula la distancia cartesiana entre la ubicacion pasada 
     * como parametro y el objeto que llama a la funcion
     * d =  ( (x2 - x1)^2 + (y2 - y1)^2 )^1/2
     * */
    public double calcularDistancia(Ubicacion u){
        return Math.sqrt(Math.pow(u.x-x,2) + Math.pow(u.y - y,2));
    }

    @Override
    /**
     * Metodo retorna el objeto formato string
     * 
     * 
     * */
    public String toString() {
        return "Ubicacion{" + "x=" + x + ", y=" + y + '}';
    }
      /**
     * Metodo retorna el objeto en csv
     * 
     * 
     * */
    public String toCSV() {
        return getX()+":"+getY();
    }
}