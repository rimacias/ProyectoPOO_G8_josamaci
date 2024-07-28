/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package espol.proyectopoo_g8_p2;

import espol.proyectopoo_g8_p2.backend.Residente;
import espol.proyectopoo_g8_p2.backend.Ubicacion;
import espol.proyectopoo_g8_p2.backend.Vehiculo;
import espol.proyectopoo_g8_p2.backend.Visitante;
import espol.proyectopoo_g8_p2.excepciones.EnBlancoException;
import espol.proyectopoo_g8_p2.excepciones.FechaException;
import espol.proyectopoo_g8_p2.excepciones.PinException;
import espol.proyectopoo_g8_p2.excepciones.VehiculoException;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.Set;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;

import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumn.CellDataFeatures;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.util.Callback;
/**
 * FXML Controller class
 *
 * @author JMaci
 */
public class VistaResidenteController implements Initializable {


    @FXML
    private Button botonCerrar;
    @FXML
    private Label lblNombre;
    @FXML
    private Label lblCorreo;
    @FXML
    private Label lblVilla;
    @FXML
    private Label lblManzana;
    @FXML
    private Label lblCedula;
    @FXML
    private Label lblPin;
    @FXML
    private TextField txtPin;
    @FXML
    private Button botonPin;
    @FXML
    private GridPane gridVehiculo;
    @FXML
    private TextField txtVehiculo;
    @FXML
    private Button botonVehiculo;
    @FXML
    private TextField txtNombreVisitante;
    @FXML
    private TextField txtCedulaVisitante;
    @FXML
    private TextField txtCorreoVisitante;
    @FXML
    private ComboBox<Integer> ComboMesVisita;
    @FXML
    private ComboBox<Integer> ComboHoraVisita;
    @FXML
    private ComboBox<Integer> ComboMinutoVisita;
    @FXML
    private TableView<Visitante> tableVisitante;
    @FXML
    private ComboBox<Integer> ComboAnioVisita;
    private ComboBox<Integer> ComboDiaVisita;
    @FXML
    private TextField txtDiaVisitante;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        Residente r = (Residente)App.getUsuario();
        lblNombre.setText(r.getNombre());
        lblCorreo.setText(r.getCorreo());
        lblVilla.setText(r.getCasa().getVilla());
        lblManzana.setText(r.getCasa().getManzana());
        lblCedula.setText(r.getCedula());
        lblPin.setText(r.getPinAcceso());
        
        List<Vehiculo> vehiculos = Vehiculo.cargarVehiculos();
        
        int x=0;
        int y=0;
        for(Vehiculo v:vehiculos){
            if(v.getNombrePropietario().equals(lblNombre.getText())){
                Label lbl= new Label();
                lbl.setText(v.getNumMatricula());
                gridVehiculo.add(lbl,y,x);
                x++;
            }
        }
        
        for(int i=0; i<5; i++){
        ComboAnioVisita.getItems().add(LocalDateTime.now().getYear()+i);}
        ComboAnioVisita.getSelectionModel().selectFirst();
        
        for(int i=1; i<=12; i++){
        ComboMesVisita.getItems().add(i);}
        ComboMesVisita.getSelectionModel().select(LocalDateTime.now().getMonth().getValue()-1);
        
        for(int i=0; i<=23; i++){
        ComboHoraVisita.getItems().add(i);
        ComboHoraVisita.getSelectionModel().select(LocalDateTime.now().getHour());
        }
        
        for(int i=0; i<=59; i++){
        ComboMinutoVisita.getItems().add(i);}
        ComboMinutoVisita.getSelectionModel().select(LocalDateTime.now().getMinute());
              
        
        ObservableList<Visitante> visitantes = FXCollections.observableArrayList(r.listaVisitantes());
        TableView tableVisitantes = new TableView<Visitante>();
        tableVisitantes.setItems(visitantes);
        TableColumn<Visitante,String> colCod = new TableColumn<>("Código");
        TableColumn<Visitante,String> colNom = new TableColumn<>("Nombre");
        TableColumn<Visitante,String> colCed = new TableColumn<>("Cédula");
        TableColumn<Visitante,String> colCor = new TableColumn<>("Correo");
        TableColumn<Visitante,String> colMz = new TableColumn<>("Manzana");
        TableColumn<Visitante,String> colVil = new TableColumn<>("Villa");
        TableColumn<Visitante,LocalDateTime> colFec = new TableColumn<>("Fecha");
        
        colCod.setCellValueFactory(new Callback<CellDataFeatures<Visitante, String>, ObservableValue<String>>(){
            @Override
            public ObservableValue<String> call(CellDataFeatures<Visitante, String> p) {
         return ObservableValue.class.cast(p.getValue().getCodigoAcceso());
        }});
        
        colNom.setCellValueFactory(new Callback<CellDataFeatures<Visitante, String>, ObservableValue<String>>(){
            @Override
            public ObservableValue<String> call(CellDataFeatures<Visitante, String> p) {
         return ObservableValue.class.cast(p.getValue().getNombreVisitante());
        }});
        
        colCed.setCellValueFactory(new Callback<CellDataFeatures<Visitante, String>, ObservableValue<String>>(){
            @Override
            public ObservableValue<String> call(CellDataFeatures<Visitante, String> p) {
         return ObservableValue.class.cast(p.getValue().getNumCedula());
        }});

        colCor.setCellValueFactory(new Callback<CellDataFeatures<Visitante, String>, ObservableValue<String>>(){
            @Override
            public ObservableValue<String> call(CellDataFeatures<Visitante, String> p) {
         return ObservableValue.class.cast(p.getValue().getCorreo());
        }});
        
        colMz.setCellValueFactory(new Callback<CellDataFeatures<Visitante, String>, ObservableValue<String>>(){
            @Override
            public ObservableValue<String> call(CellDataFeatures<Visitante, String> p) {
         return ObservableValue.class.cast(p.getValue().getMzResidente());
        }});
        
        colVil.setCellValueFactory(new Callback<CellDataFeatures<Visitante, String>, ObservableValue<String>>(){
            @Override
            public ObservableValue<String> call(CellDataFeatures<Visitante, String> p) {
         return ObservableValue.class.cast(p.getValue().getVillaResidente());
        }});
        
        colFec.setCellValueFactory(new Callback<CellDataFeatures<Visitante, LocalDateTime>, ObservableValue<LocalDateTime>>(){
            @Override
            public ObservableValue<LocalDateTime> call(CellDataFeatures<Visitante, LocalDateTime> p) {
         return ObservableValue.class.cast(p.getValue().getFechaIngreso());
        }});
        tableVisitantes.getColumns().addAll(colCod,colNom,colCed,colCor,colMz,colVil,colFec);
        tableVisitante = tableVisitantes;
        
    }    

    @FXML
    private void cerrarSesion(MouseEvent event) throws IOException{
        App.setRoot("principal");
    }

    @FXML
    private void cambiarPin(MouseEvent event) throws PinException, EnBlancoException, IOException{
        String pin;
        pin = txtPin.getText();
        try{
            
            int com = Integer.parseInt(pin);
            
            if(pin.length()==0){
            throw new EnBlancoException();}
            
            if(pin.length()!=4 || pin.equals(lblPin.getText())){
                txtPin.clear();
            throw new PinException();
            }
            
            Residente r = Residente.CambiarPinResidente(pin, App.getUsuario().getNombreUsuario());
            lblPin.setText(r.getPinAcceso());
            App.enviarCorreo(r.getCorreo(), "SU PIN HA SIDO CAMBIADO, EL NUEVO ES: "+pin);
            Alert alert = new Alert(Alert.AlertType.INFORMATION, "Se ha cambiado su pin de acceso.");
            alert.show();
            
        }catch(PinException e){
            if (pin.equals(lblPin.getText())){
            Alert alert = new Alert(Alert.AlertType.ERROR, "¡El pin no debe ser igual al anterior!");
            alert.show();
            }
            else{
            Alert alert = new Alert(Alert.AlertType.ERROR, "¡El pin ingresado no es válido, debe tener 4 dígitos!");
            alert.show();}
        
        }catch(EnBlancoException e){
        Alert alert = new Alert(Alert.AlertType.ERROR, "¡NO PUEDE DEJAR RL CAMPO EN BLANCO!");
        alert.show(); 
        
        }catch(NumberFormatException e){
            txtPin.clear();
        Alert alert = new Alert(Alert.AlertType.ERROR, "¡DEBE INGRESAR NÚMEROS!");
        alert.show(); 
        
        }
        
    }

    @FXML
    private void registrarVehiculo(MouseEvent event) throws VehiculoException, EnBlancoException, IOException{
        try{
        String mat = txtVehiculo.getText();
        if(mat.isBlank()){
        throw new EnBlancoException();
        }
        
        Vehiculo veh = new Vehiculo(mat,lblNombre.getText());
        List<Vehiculo> vehiculos;
        vehiculos = Vehiculo.cargarVehiculos();
        int x=gridVehiculo.getRowCount();
        int y=0;
        for(Vehiculo v: vehiculos){
            if(v.getNumMatricula().equals(mat)){
                throw new VehiculoException();
            }   
        }    
        Label lbl= new Label();
        lbl.setText(veh.getNumMatricula());
        gridVehiculo.add(lbl,y,x);
        
        Vehiculo.AgregarVehiculo(veh);
        txtVehiculo.clear();
        Alert alert = new Alert(Alert.AlertType.INFORMATION, "Se ha agredado el vehículo.");
            alert.show();
        
        }catch(EnBlancoException e){
        Alert alert = new Alert(Alert.AlertType.ERROR, "¡NO PUEDE DEJAR NINGÚN CAMPO EN BLANCO!");
        alert.show();  
        }catch(VehiculoException e){
            txtVehiculo.clear();
        Alert alert = new Alert(Alert.AlertType.ERROR, "¡LA MATRÍCULA YA ESTÁ REGISTRADA!");
        alert.show();  
        }catch (IOException ex){
                System.out.println("ERROR IO");
        }
        
        
    }

    @FXML
    private void ingresarVisita(MouseEvent event) {
        List<Visitante> visitante = Visitante.cargarVisitante();
        String nombreVisitante;
        String numCedula;
        String correoVisitante;
        LocalDateTime fecha;
        
        
        try{
        nombreVisitante = txtNombreVisitante.getText();
        if(nombreVisitante.isBlank()){
        throw new EnBlancoException();
        }
        numCedula = txtCedulaVisitante.getText();
        if(numCedula.isBlank()){
        throw new EnBlancoException();
        }
        correoVisitante = txtCorreoVisitante.getText();
        if(correoVisitante.isBlank()){
        throw new EnBlancoException();
        }
        
        int anio = ComboAnioVisita.getValue();
        int mes = ComboMesVisita.getValue();
        
        if(txtDiaVisitante.getText().isBlank()){
        throw new EnBlancoException();
        }
        
        int dia = Integer.parseInt(txtDiaVisitante.getText());
        if(mes==1 || mes==3 || mes==5 || mes==7 || mes==8 || mes==10 || mes==12){
            if (dia>31){
                throw new FechaException();
            }
        }
        
        if(mes==4 || mes==6 || mes==9 || mes==11){
            if (dia>30){
                throw new FechaException();
            }
        }
        
        if(mes==2){
            if (dia>28){
                throw new FechaException();
            }
        }
        
        int hora = ComboHoraVisita.getValue();
        int minuto = ComboMinutoVisita.getValue();
        
        fecha = LocalDateTime.of(anio,mes,dia,hora,minuto);
        if (fecha.isBefore(LocalDateTime.now())){
            throw new FechaException();
        }
        
        Visitante vi = Residente.registrarVisitante(nombreVisitante, numCedula, correoVisitante, lblManzana.getText(), lblVilla.getText(), fecha);
        Alert alert = new Alert(Alert.AlertType.INFORMATION, "SE HA REGISTRADO UNA NUEVA VISITA");
        alert.show(); 
        App.enviarCorreo(correoVisitante, "LA CLAVE PARA SU VISITA PROGRAMADA EL "+vi.getFechaIngreso()+" ES: "+vi.getCodigoAcceso());
        txtNombreVisitante.clear();
        txtCedulaVisitante.clear();
        txtCorreoVisitante.clear();
        txtDiaVisitante.clear();
                
        }catch(EnBlancoException e){
        Alert alert = new Alert(Alert.AlertType.ERROR, "¡NO PUEDE DEJAR NINGÚN CAMPO EN BLANCO!");
        alert.show();  
        
        }catch(NumberFormatException e){
            txtDiaVisitante.clear();
        Alert alert = new Alert(Alert.AlertType.ERROR, "¡DEBE INGRESAR NÚMEROS EL DIA!");
        alert.show(); 
        
        }catch(FechaException e){
            txtDiaVisitante.clear();
        Alert alert = new Alert(Alert.AlertType.ERROR, "¡LA FECHA INGRESADA NO ES CORRECTA O ANTERIOR A LA FECHA ACTUAL!");
        alert.show(); 
        
        
        
        }
        
        
    }
    
    
}
