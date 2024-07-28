package espol.proyectopoo_g8_p2.backend;
import espol.proyectopoo_g8_p2.App;
import espol.proyectopoo_g8_p2.backend.Usuario;
import espol.proyectopoo_g8_p2.backend.Vehiculo;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.nio.charset.Charset;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Random;

public class Residente extends Usuario{
    private String correo;
    private Casa casa;
    private GENERO genero;
    private String nombre;
    private ArrayList<Vehiculo> vehiculos ;
    private String cedula;
    private String pinAcceso;
    private ArrayList<Visitante> visitantes;
        
    /**
     * Cnstructor que crea un nuevo usuario sin vehículos.
     * @param nombreUsuario
     * @param contrasenia
     * @param correo
     * @param casa
     * @param genero
     * @param nombre
     * @param cedula
     * @param pinAcceso 
     */
        public Residente(String nombreUsuario, String contrasenia, String correo, 
                Casa casa, String genero, String nombre, String cedula, String pinAcceso){
            super(nombreUsuario, contrasenia);
            this.correo = correo;
            this.casa = casa;
            this.genero = GENERO.valueOf(genero.toUpperCase());
            this.nombre = nombre;
            this.cedula = cedula;
            this.pinAcceso = pinAcceso;
            vehiculos = new ArrayList();
            
        }
        /**
         * Cnstructor que crea un nuevo usuario.
         * @param nombreUsuario
         * @param contrasenia
         * @param correo
         * @param casa
         * @param genero
         * @param nombre
         * @param vehiculos
         * @param cedula
         * @param pinAcceso 
         */
        public Residente(String nombreUsuario, String contrasenia, String correo, 
                Casa casa, String genero, String nombre,ArrayList<Vehiculo> vehiculos,String cedula, String pinAcceso){
            super(nombreUsuario, contrasenia);
            this.correo = correo;
            this.casa = casa;
            this.genero = GENERO.valueOf(genero.toUpperCase());
            this.nombre = nombre;
            this.cedula = cedula;
            this.pinAcceso = pinAcceso;
            this.vehiculos = vehiculos;
            
        }
    /**
     * Método estático que registra un visitante y devuelve al mismo.
     * @param nombre
     * @param numcedula
     * @param correo
     * @param mzResidente
     * @param villaResidente
     * @param fecha
     * @return 
     */    
    public static Visitante registrarVisitante(String nombre,String numcedula,String correo,String mzResidente,String villaResidente, LocalDateTime fecha){
    
    List<Visitante> visitantes = Visitante.cargarVisitante();
    char [] chars = "0123456789abcdefghijklmnopqrstuvwxyz".toCharArray();
    int charsLength = chars.length;

    Random random = new Random();
    StringBuffer buffer = new StringBuffer();
    String codigo;
    
    boolean c=false;
    do{
        
        for (int i=0;i<8;i++){
        buffer.append(chars[random.nextInt(charsLength)]);
            }  

        codigo=buffer.toString();

        for(int i=0; i<visitantes.size(); i++){
            if (codigo.equals(visitantes.get(i).getCodigoAcceso())){
                c = true;
        }
    }
    }while(c);

    //String ruta = "src/main/resources/espol/proyectopoo_g8_p2/visitantes.txt";
    String ruta = "visitantes.txt";
    
    try(BufferedWriter bf = new BufferedWriter(new FileWriter(ruta, true))){
            
                    String line = codigo+","+nombre+","+numcedula+","+correo+","+mzResidente+","+villaResidente+","+fecha.getYear()+"-"+fecha.getMonthValue()+"-"+fecha.getDayOfMonth()+"-"+fecha.getHour()+"-"+fecha.getMinute();
                    bf.write(line);
                    bf.newLine();
             
            }catch (FileNotFoundException ex){
                System.out.println("ERROR File");
            } catch (IOException ex){
                System.out.println("ERROR IO");
            }
    return new Visitante(codigo,nombre,numcedula,correo,mzResidente,villaResidente,fecha);
    }
/**
 * Método que registra un vehículo para un residente.
 * @param vehiculo 
 */
    public void registrarVehiculo(Vehiculo vehiculo){
        vehiculos.add(vehiculo);
        }
/**
 * Método devuelve una lista de visistantes que visitarán al residente en cuestión.
 * @return visitantes
 */
    
    
     public List<Visitante> listaVisitantes(){
     Residente r = (Residente)App.getUsuario();    
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
                    if(v.getMzResidente().equals(r.getCasa().getManzana()) && v.getVillaResidente().equals(r.getCasa().getVilla()) && v.getFechaIngreso().isAfter(LocalDateTime.now())){
                    visitantes.add(v);
                    }
                }
                
            } catch (IOException ex){
                System.out.println("ERROR: No se pudo cargar la información de los visitantes");
            }
        return visitantes;

        }
    /**
     * Método que elimina a un visitante
     * @param v 
     */
        public void eliminarVisitante(Visitante v){
 
   //File inputFile = new File("src/main/resources/espol/proyectopoo_g8_p2/visitantes.txt");
   //File outputFile = new File("src/main/resources/espol/proyectopoo_g8_p2/visitantes.txt");
   
   File inputFile = new File("visitantes.txt");
   File outputFile = new File("visitantes.txt");
   
   LocalDateTime fActual=LocalDateTime.now();
    try {
      BufferedReader reader = new BufferedReader(new FileReader(inputFile));
      BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile));

    String linea;
    
    while((linea = reader.readLine()) != null) {
        String[] p = linea.split(",");
        String[] fecha = p[6].split("-");
        LocalDateTime lc = LocalDateTime.of(Integer.parseInt(fecha[0]), Integer.parseInt(fecha[1]), Integer.parseInt(fecha[2]), Integer.parseInt(fecha[3]), Integer.parseInt(fecha[4]));
        ZonedDateTime zdt = fActual.atZone(ZoneId.systemDefault()); 
        Date actual = Date.from(zdt.toInstant());
        ZonedDateTime zdt1 = lc.atZone(ZoneId.systemDefault()); 
        Date fechav = Date.from(zdt1.toInstant());
        Calendar calendar1 = Calendar.getInstance();
        calendar1.setTime(fechav);
        calendar1.add(Calendar.MINUTE, 5);
        if(p[2].equals(v.getNumCedula())&& !calendar1.getTime().after(actual)){ 
            continue;
        }
        writer.write(linea + System.getProperty("line.separator"));
    }       

    writer.close();
    reader.close();

    } catch (IOException e) {
        e.printStackTrace();
    }
        }
  
        /**
         * Método estático que carga en una lista a los residente ingresados en el archivo residentes.txt
         * @return residentes
         */
        public static List<Residente> cargarResidente(){
        
            //String ruta = "src/main/resources/espol/proyectopoo_g8_p2/residentes.txt";
            String ruta = "residentes.txt";
            List<Residente> residentes = new ArrayList<>();
            List<Casa> casas = Casa.cargarCasa();
            List<Vehiculo> vehiculos = Vehiculo.cargarVehiculos();            
            try(InputStream input = App.class.getResource(ruta).openStream();
                BufferedReader bf = new BufferedReader(
                                    new InputStreamReader(input,"UTF-8"))){
                
                String linea;
                Casa casa =new Casa();
                
                while((linea=bf.readLine())!=null){
                    String[] p = linea.split(",");
                    for(Casa ca:casas){
                        if(ca.getResidente().equals(p[4])){
                            casa=ca;
                        }
                    }
                    Residente residente = new Residente(p[0],p[1],p[2],casa,p[3],p[4],p[5],p[6]);
                    
                    for(Vehiculo v:vehiculos){
                        if(v.getNombrePropietario().equals(residente.getNombre())){
                            residente.registrarVehiculo(v);
                        }
                    }
                    residentes.add(residente);
                }
            } catch (IOException ex){
                System.out.println("ERROR: No se pudo cargar la información de los residentes");
            }
        System.out.println(residentes);    
        return residentes;
    }
        /**
         * getter que retorna el correo del residente.
         * @return correo
         */
          public String getCorreo(){
            return correo;
        }
          /**
         * getter que retorna el genero del residente.
         * @return genero
         */
        public GENERO getGenero(){
            return genero;
        }
        /**
         * getter que retorna la casa del residente.
         * @return casa
         */
        public Casa getCasa(){
            return casa;
        }
        /**
         * getter que retorna el nombre del residente.
         * @return nombre
         */
        public String getNombre(){
            return nombre;
        }
        /**
         * getter que retorna la cédula del residente.
         * @return cedula
         */
        public String getCedula(){
            return cedula;
        }
        /**
         * getter que retorna el Pin de Acceso del residente.
         * @return pinAcceso
         */
        public String getPinAcceso(){
            return pinAcceso;
        }
        /**
         * Setter cambia el correo del residente.
         * @param c
         */
         public void setCorreo(String c){
            correo=c;
        }
         /**
         * Setter cambia el genero del residente.
         * @param g
         */
        public void setGenero(GENERO g){
            genero=g;
        }
        /**
         * Setter cambia la casa del residente.
         * @param casa
         */
        public void setCasa(Casa casa){
            this.casa=casa;
        }
        /**
         * Setter cambia el nombre del residente.
         * @param nombre
         */
        public void setNombre(String nombre){
            this.nombre=nombre;
        }
        /**
         * Setter cambia la cédula del residente.
         * @param cedula
         */
       public void setCedula(String cedula){
            this.cedula=cedula;
        }
       /**
         * Setter cambia el pin de acceso del residente.
         * @param pinAcceso
         */
         public void setPinAcceso(String pinAcceso){
            this.pinAcceso=pinAcceso;
        }
       /**
        * Método estático que cambia el pin del residente y retorna al residente con el cambio.
        * @param pin
        * @param usuario
        * @return res
        * @throws IOException 
        */
        public static Residente CambiarPinResidente(String pin, String usuario) throws IOException{
            List <Residente> residentes = cargarResidente();
            //String ruta = "src/main/resources/espol/proyectopoo_g8_p2/residentes.txt";
            String ruta = "residentes.txt";
            
            Residente res=null;
            for(Residente r:residentes){
                if (r.getNombreUsuario().equals(usuario)){
                    r.setPinAcceso(pin);
                    res=r;
                    System.out.println(res.getPinAcceso());
                }
            }
            
            try(BufferedWriter bf = new BufferedWriter(new FileWriter(ruta))){
                for(Residente r:residentes){
                    String line = r.getNombreUsuario()+","+r.getContrasenia()+","+r.getCorreo()+","+r.getGenero()
                    +","+r.getNombre()+","+r.getCedula()+","+r.getPinAcceso();
                    bf.write(line);
                    bf.newLine();
                    
                }
                                
            }catch (FileNotFoundException ex){
                System.out.println("ERROR File");
            } catch (IOException ex){
                System.out.println("ERROR IO");
            } 
          return res;  
        }
    /**
     * Método que registra aun visitante sin código y devuelve al visitante.
     * @param nombre
     * @param numcedula
     * @param fecha
     * @return Visitante
     */    
    public Visitante registrarVisitanteSinCodigo(String nombre,String numcedula, LocalDateTime fecha){
    
    List<Visitante> visitantes = Visitante.cargarVisitante();
    char [] chars = "0123456789abcdefghijklmnopqrstuvwxyz".toCharArray();
    int charsLength = chars.length;

    Random random = new Random();
    StringBuffer buffer = new StringBuffer();
    String codigo;
    
    boolean c=false;
    do{
        
        for (int i=0;i<8;i++){
        buffer.append(chars[random.nextInt(charsLength)]);
            }  

        codigo=buffer.toString();

        for(int i=0; i<visitantes.size(); i++){
            if (codigo.equals(visitantes.get(i).getCodigoAcceso())){
                c = true;
        }
    }
    }while(c);
    //String ruta = "src/main/resources/espol/proyectopoo_g8_p2/visitantes.txt";
    String ruta = "visitantes.txt";
    try(BufferedWriter bf = new BufferedWriter(new FileWriter(ruta, true))){
            
                    String line = codigo+","+nombre+","+numcedula+","+null+","+casa.getManzana()+","+casa.getVilla()+","+fecha.getYear()+"-"+fecha.getMonthValue()+"-"+fecha.getDayOfMonth()+"-"+fecha.getHour()+"-"+fecha.getMinute();
                    bf.write(line);
                    bf.newLine();
                
                                
            }catch (FileNotFoundException ex){
                System.out.println("ERROR File");
            } catch (IOException ex){
                System.out.println("ERROR IO");
            }
    return new Visitante(codigo,nombre,numcedula,casa.getManzana(),casa.getVilla(),fecha);
    }
 }

