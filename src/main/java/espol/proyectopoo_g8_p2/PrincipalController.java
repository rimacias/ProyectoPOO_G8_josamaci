/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package espol.proyectopoo_g8_p2;

import espol.proyectopoo_g8_p2.backend.Casa;
import espol.proyectopoo_g8_p2.App;
import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
/**
 * FXML Controller class
 *
 * @author JMaci
 */
public class PrincipalController implements Initializable {


    @FXML
    private Button botonInicioSesion;
    @FXML
    private Button botonSimulacion;
    private static List<Casa> casas;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       casas = Casa.listaCasa();
               }    
    
    @FXML
    private void switchToInicioSesion() throws IOException {
        App.setRoot("inicioSesion");
    }

    @FXML
    private void irSimulacion(MouseEvent event) throws IOException {
        App.setRoot("vistaSimulacion");
    }
    
    
    public static List<Casa> getCasas(){
        return casas;
    }
    
    
}