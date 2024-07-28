/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package espol.proyectopoo_g8_p2;
import espol.proyectopoo_g8_p2.backend.Casa;
import espol.proyectopoo_g8_p2.backend.Pin;
import espol.proyectopoo_g8_p2.backend.Residente;
import espol.proyectopoo_g8_p2.backend.Ubicacion;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;

import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
/**
 * FXML Controller class
 *
 * @author andre
 */
public class RegistrarResidenteController implements Initializable {

    @FXML
    private TextField txtNombre;
    @FXML
    private TextField txtCorreo;
    @FXML
    private ComboBox<String> cbGenero;
    @FXML
    private TextField txtCedula;
    
    private Casa casaSeleccionada;
    
    private List<Casa> casas = Casa.listaCasa();
    @FXML
    private Button btnAceptar;
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
        ArrayList<String> opciones = new ArrayList<>();
        opciones.add("MASCULINO");
        opciones.add("FEMENINO");
        opciones.add("LGBTI");
        
        cbGenero.getItems().addAll(opciones);
        // TODO
    }    
    
    public void setCasa(Casa c){
        casaSeleccionada = c;     
    }
    
    @FXML
    private void Aceptar(ActionEvent event){
        registrarResidente();
    }
    
    @FXML
    private void Cancelar(ActionEvent event){
        try{
            FXMLLoader loader = new FXMLLoader(App.class.getResource("vistaAdmin.fxml"));
            Parent viewInicio = loader.load();
            App.setRoot("vistaAdmin");
        }catch(IOException e){
            System.out.println("Error cargando vistaAdmin.fxml");
        }
    }
    
    private void registrarResidente(){
        String nombre = txtNombre.getText();
        String correo = txtCorreo.getText();
        String genero = cbGenero.getValue();
        String cedula = txtCedula.getText();
        
        if(!nombre.isBlank()){
            if(!correo.isBlank() & correo.contains("@")){
                if(!genero.isBlank()){
                    if(!cedula.isBlank() & cedula.length()==10){
                        try{    
                            String nombreUsuario = nombre.substring(0,1).toUpperCase() + nombre.substring(1);
                            String contrasena = cedula;
                            String pin = Pin.crearPin(4);
                                                   
                            try{
                                Residente nuevoResidente = new Residente(nombreUsuario, contrasena, correo, casaSeleccionada, genero, nombre, null, cedula, pin);                            
                                
                                try{
                                    App.getUsuario().nuevoUsuario(nuevoResidente);

                                }catch(Exception ex){
                                    System.out.println("Error añadiendo residente");
                                }
                                
                                try{
                                    for(Casa c: App.getCiudadela().getListaCasas()){
                                        if(c.getManzana().equals(casaSeleccionada.getManzana())){
                                            if(c.getVilla().equals(casaSeleccionada.getVilla())){
                                                App.getCiudadela().getCasa(c).setResidente(nuevoResidente.getNombre());
                                                App.enviarCorreo(nuevoResidente.getCorreo(), "EL PIN GENERADO PARA SU INGRESO EN LA CIUDADELA ES: "+pin);
                                            }
                                        }                                    
                                    }
                                }catch(Exception ex){
                                        System.out.println("Error añadiendo casa");
                                    }

                            }catch(Exception ex){
                                System.out.println("Error creando residente");
                            }
                                                       
                            try{                    
                                FXMLLoader loader = new FXMLLoader(App.class.getResource("vistaAdmin.fxml"));
                                Parent viewAdmin = loader.load();
                                App.setRoot(viewAdmin);
                        
                            }catch(IOException ex){

                                System.out.println("No se ha podido cargar la vista");
                                System.out.println("VistaPrincipal.fxml");
                            }
                        }
                        catch(Exception e){
                            System.out.println("Error cargando información del residente");
                        }
                    }
                    else{
                        Alert alert = new Alert(Alert.AlertType.WARNING, "¡LA CÉDULA INGRESADA NO ES VÁLIDA!");
                        alert.show();
                    }
                }
                else{
                    Alert alert = new Alert(Alert.AlertType.WARNING, "¡POR FAVOR, SELECCIONE UN GÉNERO ANTES DE CONTINUAR!");
                    alert.show();
                }
            }
            else{
                Alert alert = new Alert(Alert.AlertType.WARNING, "¡EL CORREO INGRESADO NO ES VÁLIDO!");
                alert.show();
            }
        }
        else{
            Alert alert = new Alert(Alert.AlertType.WARNING, "¡NO PUEDE DEJAR EL NOMBRE EN BLANCO!");
            alert.show();
        }
    }
}    