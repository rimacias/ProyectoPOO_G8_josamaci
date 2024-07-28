/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package espol.proyectopoo_g8_p2;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;

/**
 * FXML Controller class
 *
 * @author andre
 */
public class SeleccionarGráficaController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    @FXML
    private void Linea(ActionEvent event){
        try{
            FXMLLoader loader = new FXMLLoader(App.class.getResource("graficaLinea.fxml"));
            Parent viewInicio = loader.load();
            App.setRoot("graficaLinea");
        }catch(IOException e){
            System.out.println("Error cargando graficaLinea.fxml");
        }
    }
    
    @FXML
    private void Barra(ActionEvent event){
        try{
            FXMLLoader loader = new FXMLLoader(App.class.getResource("graficaBarra.fxml"));
            Parent viewInicio = loader.load();
            App.setRoot("graficaBarra");
        }catch(IOException e){
            System.out.println("Error cargando graficaBarra.fxml");
        }
    }
    
    
    @FXML
    private void Regresar(ActionEvent event){
        try{
            FXMLLoader loader = new FXMLLoader(App.class.getResource("vistaAdmin.fxml"));
            Parent viewInicio = loader.load();
            App.setRoot("vistaAdmin");
        }catch(IOException e){
            System.out.println("Error cargando vistaAdmin.fxml");
        }
    }   
}
