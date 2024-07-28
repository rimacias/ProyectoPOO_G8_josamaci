/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package espol.proyectopoo_g8_p2;

import espol.proyectopoo_g8_p2.App;
import espol.proyectopoo_g8_p2.App;
import espol.proyectopoo_g8_p2.App;
import espol.proyectopoo_g8_p2.App;
import espol.proyectopoo_g8_p2.backend.Peaton;
import espol.proyectopoo_g8_p2.backend.Residente;
import espol.proyectopoo_g8_p2.backend.Vehiculo;
import espol.proyectopoo_g8_p2.excepciones.EnBlancoException;
import java.io.IOException;
import java.net.URL;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;

import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
/**
 * FXML Controller class
 *
 * @author JMaci
 */
public class VistaSimulacionResidenteController implements Initializable {
    
    private ArrayList<LocalTime> horas = new ArrayList();
    int contador = 0;
    @FXML
    private Button botRegresar;
    @FXML
    private TextField txtVehiculo;
    @FXML
    private Button comprobarVehiculo;
    @FXML
    private TextField txtCedula;
    @FXML
    private TextField txtCodigo;
    @FXML
    private Button comprobarPeaton;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    @FXML
    private void volver(MouseEvent event) throws IOException {
        App.setRoot("vistaSimulacion");
    }

    @FXML
    private void comprobarVehiculo(MouseEvent event) {
        try{
        String mat = txtVehiculo.getText();
        if(mat.isBlank()){
        throw new EnBlancoException();
        }
        Vehiculo v = new Vehiculo(mat);
        boolean i = v.ingreso();
        
        txtVehiculo.clear();
        if(i){
        contador++;
        horas.add(LocalTime.now());
        }
        }catch(EnBlancoException e){
        Alert alert = new Alert(Alert.AlertType.ERROR, "¡NO PUEDE DEJAR EL CAMPO EN BLANCO!");
        alert.show();  
        }
    }

    @FXML
    private void comprobarPeaton(MouseEvent event) {
        try{
        String ced = txtCedula.getText();
        String cod = txtCodigo.getText();
        if(ced.isBlank() || cod.isBlank()){
        throw new EnBlancoException();
        }    
        Peaton p = new Peaton(ced, cod);
        boolean i = p.ingreso();
 
        txtCedula.clear();
        txtCodigo.clear();
        if(i){
        contador++;
        horas.add(LocalTime.now());
            try{
                FXMLLoader loader = new FXMLLoader(getClass().getResource("graficaBarra.fxml"));
                GraficaBarraController reporte = loader.getController();
                reporte.setHoras(horas);
                
            }catch(Exception e){
                System.out.println("Error cargando la lista al controlador");
            }
            try{
                FXMLLoader loader = new FXMLLoader(getClass().getResource("graficaLinea.fxml"));
                GraficaBarraController reporte = loader.getController();
                reporte.setHoras(horas);
                
            }catch(Exception e){
                System.out.println("Error cargando la lista al controlador");
            }
            
        }

        }catch(EnBlancoException e){
        Alert alert = new Alert(Alert.AlertType.ERROR, "¡NO PUEDE DEJAR EL CAMPO EN BLANCO!");
        alert.show();  
        }
    }
    
    
    public int getContadorResidente(){
        return contador;
    }
    
    public ArrayList<LocalTime> getHoras(){
        return horas;
    }
}