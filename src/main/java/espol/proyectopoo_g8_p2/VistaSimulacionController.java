/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package espol.proyectopoo_g8_p2;

import java.io.IOException;
import java.net.URL;
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
public class VistaSimulacionController implements Initializable {


    @FXML
    private Button botonRegresar;
    @FXML
    private Button botSimRes;
    @FXML
    private Button botSimVis;
    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    @FXML
    private void regresarPrincipal(MouseEvent event) throws IOException {
        App.setRoot("principal");
    }

    @FXML
    private void irSimulacionResidente(MouseEvent event) throws IOException{
        App.setRoot("vistaSimulacionResidente");
    }

    @FXML
    private void irSimulacionVisitante(MouseEvent event) throws IOException{
        App.setRoot("vistaSimulacionVisitante");
    }

}
