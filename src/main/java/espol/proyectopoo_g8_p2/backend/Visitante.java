package espol.proyectopoo_g8_p2.backend;
import espol.proyectopoo_g8_p2.App;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.time.LocalDateTime;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

    public class Visitante{
    private String codigoAcceso;
    private String nombreVisitante;
    private String numCedula;
    private String mzResidente;
    private String villaResidente;
    private LocalDateTime fechaIngreso;
    private String correo;
    private boolean usoCodigo;
    
    /**
     * Constructor que crea un Visitante 
     * @param codigoAcceso
     * @param nombreVisitante
     * @param numCedula
     * @param correo
     * @param mzResidente
     * @param villaResidente
     * @param fechaIngreso 
     */
    public Visitante(String codigoAcceso,String nombreVisitante,String numCedula,String correo, String mzResidente,String villaResidente,LocalDateTime fechaIngreso){
    this.codigoAcceso=codigoAcceso;
    this.nombreVisitante=nombreVisitante;
    this.numCedula=numCedula;
    this.mzResidente=mzResidente;
    this.villaResidente=villaResidente;
    this.fechaIngreso = fechaIngreso;
    this.correo = correo;
    this.usoCodigo = true;
    }
    /**
     * Constructor que crea un Visitante sin correo
     * @param codigoAcceso
     * @param nombreVisitante
     * @param numCedula
     * @param mzResidente
     * @param villaResidente
     * @param fechaIngreso 
     */
    public Visitante(String codigoAcceso,String nombreVisitante,String numCedula, String mzResidente,String villaResidente,LocalDateTime fechaIngreso){
    this.codigoAcceso=codigoAcceso;
    this.nombreVisitante=nombreVisitante;
    this.numCedula=numCedula;
    this.mzResidente=mzResidente;
    this.villaResidente=villaResidente;
    this.fechaIngreso = fechaIngreso;
    this.correo = null;
    this.usoCodigo = true;
    }
    
    /**
     * Constructor vacío de visitante
     */
    public Visitante(){
    
    }
    
    /**
     * Método estático que devuelve la lista de los visitantes que se encuentran en visitantes.txt
     * @return visitantes
     */
    public static List<Visitante> cargarVisitante(){
        
            //String ruta = "src/main/resources/espol/proyectopoo_g8_p2/visitantes.txt";
            String ruta = "visitantes.txt";
            List<Visitante> visitantes = new ArrayList<>();           
            try(InputStream input = App.class.getResource(ruta).openStream();
                BufferedReader bf = new BufferedReader(
                                    new InputStreamReader(input,"UTF-8"))){
                
                String linea;
                
                while((linea=bf.readLine())!=null){
                    String[] p = linea.split(",");
                    String[] fecha = p[6].split("-");
                    LocalDateTime lc = LocalDateTime.of(Integer.parseInt(fecha[0]), Integer.parseInt(fecha[1]), Integer.parseInt(fecha[2]), Integer.parseInt(fecha[3]), Integer.parseInt(fecha[4]));
                    Visitante v = new Visitante(p[0],p[1],p[2],p[3],p[4],p[5], lc);
                    visitantes.add(v);
                }
            } catch (IOException ex){
                System.out.println("ERROR: No se pudo cargar la información de los visitantes");
            }
        System.out.println(visitantes);    
        return visitantes;
    } 
    
    /**
     * getter que devuelve el código de acceso del visitante
     * @return codigoAcceso
     */
    public String getCodigoAcceso(){
    return codigoAcceso;
    }
    /**
     * getter que devuelve el nombre del visitante
     * @return nombreVisitante
     */
        public String getNombreVisitante(){
    return nombreVisitante;
    } 
    /**
     * getter que devuelve el número de cédula del visitante
     * @return numCedula
     */
        public String getNumCedula(){
    return numCedula;
    } 
    /**
     * getter que devuelve la manzana de la casa del residente
     * @return mzResidente
     */
        public String getMzResidente(){
    return mzResidente;
    } 
    /**
     * getter que devuelve la villa de la casa del residente
     * @return villaResidente
     */
        public String getVillaResidente(){
    return villaResidente;
    } 
    /**
     * getter que devuelve la fecha de ingreso a la casa del residente
     * @return fechaIngreso
     */
        public LocalDateTime getFechaIngreso(){
    return fechaIngreso;
    }
        /**
     * getter que devuelve un boolean si se usó el código
     * @return usoCodigo
     */
        public boolean getUsoCodigo(){
    return usoCodigo;
    }
        /**
     * getter que devuelve el correo 
     * @return correo
     */
        public String getCorreo(){
    return correo;
    }
        /**
         * setter que cambia el codigo de acceso del visitante
         * @param codigoAcceso 
         */
    public void setCodigoAcceso(String codigoAcceso){
    this.codigoAcceso = codigoAcceso;
    }
    /**
         * setter que cambia el nombre del visitante
         * @param nombreVisitante 
         */
        public void setNombreVisitante(String nombreVisitante){
    this.nombreVisitante=nombreVisitante;
    }
        /**
         * setter que cambia el número de cédula del visitante
         * @param numCedula 
         */
         public void setNumCedula(String numCedula){
    this.numCedula=numCedula;
    }
         /**
          * setter que cambia la manzana del residente a la irá el visitante.
          * @param mzResidente 
          */
        public void setMzResidente(String mzResidente){
    this.mzResidente=mzResidente;
    } 
        /**
          * setter que cambia la villa del residente a la irá el visitante.
          * @param villaResidente 
          */
        public void setVillaResidente(String villaResidente){
    this.villaResidente=villaResidente;
    } 
        /**
         * setter que cambia el estaodo del código (si se usó o no)
         * @param bool 
         */
        public void setUsoCodigo(boolean bool){
    usoCodigo = bool;
    }
        /**
         * Método que verifica si la fecha de ingreso está entre 5 minutos antes o después de la establecida
         * @return 
         */
    public boolean comprobarFechaIngreso(){
        if(fechaIngreso.minusMinutes(5).isBefore(LocalDateTime.now()) && fechaIngreso.minusMinutes(-5).isAfter(LocalDateTime.now())){
            return true;}
            
        return false;
        }
}

