/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package espol.proyectopoo_g8_p2;

import espol.proyectopoo_g8_p2.backend.Residente;
import espol.proyectopoo_g8_p2.backend.Usuario;
import espol.proyectopoo_g8_p2.excepciones.EnBlancoException;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Alert;

import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
/**
 * FXML Controller class
 *
 * @author JMaci
 */
public class InicioSesionController implements Initializable {


    @FXML
    private Button botonRegresar;
    @FXML
    private TextField textNombre;
    @FXML
    private TextField textContra;
    @FXML
    private Button botonInicioSesion;
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
    private void iniciarSesion(MouseEvent event) throws IOException, EnBlancoException{
        String usuario="";
        String contrasenia="";   
        
        try{
            
        usuario = textNombre.getText();
        if(usuario.isBlank()){
        throw new EnBlancoException();}

        contrasenia = textContra.getText();
        if(contrasenia.isBlank()){
        throw new EnBlancoException();}
        
        boolean c1 = false;
        boolean c2 = false;
        
        for(Usuario u: Usuario.getListaUsuarios()){
            
            if(u.getNombreUsuario().equals(usuario)){
                c1= true;

                if(u.getContrasenia().equals(contrasenia)){
                    c2 = true;
                    App.setUsuario(u);
                    }
            }}
        if(App.getUsuario() instanceof Residente){
            comprobarResidente(c1,c2);
        }else{comprobarAdmin(c1,c2);}
        
        
        }catch(EnBlancoException e){
        Alert alert = new Alert(Alert.AlertType.ERROR, "¡NO PUEDE DEJAR NINGUNO DE LOS CAMPOS EN BLANCO!");
        alert.show();
            
        }
    }

    @FXML
    private void regresarPrincipal(MouseEvent event) throws IOException {
        App.setRoot("principal");
    }
    
    private void comprobarResidente(boolean c1, boolean c2) throws IOException{
    if(c1){
                if(c2){
                    App.setRoot("vistaResidente");
                }else{
                Alert alert = new Alert(Alert.AlertType.ERROR, "CONTRASEÑA INCORRECTA");
                alert.show();
                textContra.clear();
                }
            }else{
            Alert alert = new Alert(Alert.AlertType.ERROR, "USUARIO NO ENCONTRADO");
                alert.show();
                textNombre.clear();
                textContra.clear();
            }
    }
    
    private void comprobarAdmin(boolean c1, boolean c2) throws IOException{
    if(c1){
        if(c2){
            App.setRoot("vistaAdmin");
                }else{
                Alert alert = new Alert(Alert.AlertType.ERROR, "CONTRASEÑA INCORRECTA");
                alert.show();
                textContra.clear();
                }
            }else{
            Alert alert = new Alert(Alert.AlertType.ERROR, "USUARIO NO ENCONTRADO");
                alert.show();
                textNombre.clear();
                textContra.clear();
            }
    }
}
