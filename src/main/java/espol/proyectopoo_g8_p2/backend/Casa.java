package espol.proyectopoo_g8_p2.backend;

import espol.proyectopoo_g8_p2.App;
import espol.proyectopoo_g8_p2.backend.Residente;
import espol.proyectopoo_g8_p2.backend.Ubicacion;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;


public class Casa {
    private String manzana;
    private Ubicacion coordenadas;
    private String villa;
    private String residente;
     /**
     * Constructor para la clase Casa
     * @param manzana - Define la manzana 
     * @param villa - Define la villa donde se encuentra
     * @param coordenadas - Define la ubicacion en coordenadas de la casa
     * @param residente - Define el residente de la casa
     
     */
    
    public Casa(String manzana,Ubicacion coordenadas,String villa,String residente){
        this.manzana=manzana;
        this.coordenadas=coordenadas;
        this.villa=villa;
        this.residente=residente;
        
    }
    /**
     * Constructor de la clase Casa sin RESIDENTE
     * @param manzana
     * @param coordenadas
     * @param villa 
     */
    public Casa(String manzana,Ubicacion coordenadas,String villa){
        this.manzana=manzana;
        this.coordenadas=coordenadas;
        this.villa=villa;
        residente="";
    }
    
    /**
     * Constructor de la clase Casa vacío
     */
    public Casa(){
    }
 
    /**
     * Método que retorna una lista de casas que se encuentran registradas en casas.txt
     * @return List<Casa>
     */   
    public static List<Casa> cargarCasa(){
        
        String ruta = "casas2.txt";
        List<Casa> casas = new ArrayList<>();
            
        try(InputStream input = App.class.getResource(ruta).openStream();
            BufferedReader bf = new BufferedReader(
                                    new InputStreamReader(input,"UTF-8"))){
                
            String linea;
                
            while((linea=bf.readLine())!=null){
                    
                String[] p = linea.split(",");
                String[] u = p[1].split(":");
                    
                Ubicacion ubicacion = new Ubicacion(Double.valueOf(u[0]),Double.valueOf(u[1]));
                Casa casa = new Casa(p[0],ubicacion,p[2],p[3]);
                casas.add(casa);
            }
            } catch (IOException ex){
                System.out.println("ERROR: No se pudo cargar la información de las casas");

            }
        return casas;
        }
    
    /**
     * getter que retorna la manzana de la casa
     * @return manzana
     */
    public String getManzana(){
    return manzana;
    }
    /**
     * getter que retorna la ubicación de la casa
     * @return coordenadas
     */
     public Ubicacion getCoordenadas(){
    return coordenadas;
    }
     /**
     * getter que retorna la villa de la casa
     * @return villa
     */
      public String getVilla(){
    return villa;
    }
      /**
     * getter que retorna al residente de la casa
     * @return residente
     */
       public String getResidente(){
    return residente;
    }
       /**
     * setter que cambia la manzana de la casa
     * @param manzana 
     */
       public void setManzana(String manzana){
    this.manzana=manzana;
    }
       /**
     * setter que cambia la ubicación de la casa
     * @param u 
     */
     public void setCoordenadas(Ubicacion u){
   coordenadas=u;
    }
     /**
     * setter que cambia la villa de la casa
     * @param villa 
     */
     public void setVilla(String villa){
    this.villa=villa;
    }
    /**
     * setter que cambia el residente de la casa
     * @param residente
     */
    public void setResidente(String res){
        residente=res;
    }
    
    /**
     * Método que devuelve una copia de lista de casas
     * @return List<Casa> 
     */
    public static List<Casa> listaCasa(){
        List<Casa> casas = Casa.cargarCasa();
        return casas;
    }
    
    /**
     * Método que asigna un residente a una casa vacía.
     * @param c
     * @param res
     */
    public void nuevoResidente(Casa c, String res){
        c.setResidente(res);
        
    }
}
    
    


