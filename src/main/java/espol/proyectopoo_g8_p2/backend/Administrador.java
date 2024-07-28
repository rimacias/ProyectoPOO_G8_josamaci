package espol.proyectopoo_g8_p2.backend;

import espol.proyectopoo_g8_p2.App;
import espol.proyectopoo_g8_p2.backend.Usuario;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Administrador extends Usuario{
    /**
     * Constructor Administrador
     * @param nombreUsuario
     * @param contrasenia 
     */
    public Administrador(String nombreUsuario, String contrasenia){
        super(nombreUsuario, contrasenia);
    }
    
    public void registroResidente(){    
    }
    public void generarReporte(){
        
    }
    /**
     * Método que retorna una lista de los administradores que se encuentran en admin.txt
     * @return List<Administrador>
     */
    public static List<Administrador> cargarAdmin(){
        
            String ruta = "admin.txt";
            List<Administrador> administradores = new ArrayList<>();
            
            try(InputStream input = App.class.getResource(ruta).openStream();
                BufferedReader bf = new BufferedReader(
                                    new InputStreamReader(input,"UTF-8"))){
                
                String linea;
                
                while((linea=bf.readLine())!=null){
                    
                    String[] p = linea.split(",");
                    
                    Administrador administrador = new Administrador(p[0],p[1]);
                    administradores.add(administrador);
                }
                
            } catch (IOException ex){
                System.out.println("ERROR: No se pudo cargar la información de los residentes");
            }
        return administradores;
    }
}
