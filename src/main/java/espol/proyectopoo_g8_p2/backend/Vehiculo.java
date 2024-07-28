/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package espol.proyectopoo_g8_p2.backend;

import espol.proyectopoo_g8_p2.App;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import javafx.scene.control.Alert;

/**
 *
 * @author andre
 */
public class Vehiculo implements Movibles{
    private String numMatricula;
    private String nombrePropietario;
    /**
     * Constructor para la clase vehiculo
     * @param num - Define el numero de matricula
     * @param nombre - Define el nombre del vehiculo
     
     */ 
    public Vehiculo(String num, String nombre){
        numMatricula = num;
        nombrePropietario = nombre;
    }
    /**
     * Constructor para la clase Vehiculo
     * @param x - Define el numero de matricula
     
     */ 
    public Vehiculo(String num){
        numMatricula = num;
        nombrePropietario = null;
    }
 /**
     * metodo para cargar los datos de los vehiculos del fichero
     * vehiculos.txt
     * */
    
    public static List<Vehiculo> cargarVehiculos(){
        
            String ruta = "vehiculos.txt";
            List<Vehiculo> vehiculos = new ArrayList<>();
            
            try(InputStream input = App.class.getResource(ruta).openStream();
                BufferedReader bf = new BufferedReader(
                                    new InputStreamReader(input,"UTF-8"))){
                
                String linea;
                
                while((linea=bf.readLine())!=null){
                    
                    String[] p = linea.split(",");
                    
                    Vehiculo vehiculo = new Vehiculo(p[0],p[1]);
                    vehiculos.add(vehiculo);
                }
                
            } catch (IOException ex){
                System.out.println("ERROR: No se pudo cargar la información de los residentes");
                ex.printStackTrace();
            }
        return vehiculos;
    }
    /**
     * getter que retorna el numero de matricula 
     * @return numMatricula
     */
    public String getNumMatricula(){
        return numMatricula;
    }
    /**
     * getter que retorna el nombre del propietario
     * @return nombrePropietario
     */
    public String getNombrePropietario(){
        return nombrePropietario;
    }
     /**
     * setter que retorna el numero de matricula
     * @param numero
     */
     public void setNumMatricula(String numero){
         
        numMatricula=numero;
    }
      /**
     * setter que retorna el nombre del propietario
     * @param nombre
     */
    public void setNombrePropietario(String nombre){
        nombrePropietario=nombre;
    }
    /**
     * metodo para agregar un nuevo vehiculo al fichero
     * */
    
    public static void AgregarVehiculo(Vehiculo veh) throws IOException{
            List <Vehiculo> vehiculos = cargarVehiculos();
            String ruta = "vehiculos.txt";
            vehiculos.add(veh);
            
            try(BufferedWriter bf = new BufferedWriter(new FileWriter(ruta))){
            for(Vehiculo v: vehiculos){
                    String line = v.getNumMatricula()+","+v.getNombrePropietario();
                    bf.write(line);
                    bf.newLine();
                }
                                
            }catch (FileNotFoundException ex){
                System.out.println("ERROR File");
            } catch (IOException ex){
                System.out.println("ERROR IO");
            }
            
        }
/**
     * Método que devuelve un boolean si el vehiculo puede ingresar
     * @return boolean 
     */
    @Override
    public boolean ingreso() {
        List<Vehiculo> vehiculos = Vehiculo.cargarVehiculos();
        boolean comp = true;
        
        for(Vehiculo v: vehiculos){
            if(v.getNumMatricula().equals(numMatricula)){
                Alert alert = new Alert(Alert.AlertType.INFORMATION, "¡EL VEHÍCULO PUEDE INGRESAR!");
                alert.show();
                comp = false;
                return true;
            }
        }
        
        if(comp){
            Alert alert = new Alert(Alert.AlertType.ERROR, "¡EL VEHÍCULO NO HA SIDO ENCONTRADO!");
            alert.show();
        }
    return false;
    }
}
