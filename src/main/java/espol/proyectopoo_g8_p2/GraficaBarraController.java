/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package espol.proyectopoo_g8_p2;

import espol.proyectopoo_g8_p2.backend.Visitante;
import java.io.IOException;
import java.net.URL;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;

/**
 * FXML Controller class
 *
 * @author andre
 */
public class GraficaBarraController implements Initializable {

    @FXML
    private BarChart<?, ?> barChart;

    private List<Visitante> visitantes = Visitante.cargarVisitante();
    
    private List<LocalTime> residentes;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        XYChart.Series series1 = new XYChart.Series();
        series1.setName("Visitantes");
        
        int visita0 = 0;
        int visita1 = 0;
        int visita2 = 0;
        int visita3 = 0;
        int visita4 = 0;
        int visita5 = 0;
        int visita6 = 0;
        int visita7 = 0;
        int visita8 = 0;
        int visita9 = 0;
        int visita10 = 0;
        int visita11 = 0;
        int visita12 = 0;
        int visita13 = 0;
        int visita14 = 0;
        int visita15 = 0;
        int visita16 = 0;
        int visita17 = 0;
        int visita18 = 0;
        int visita19= 0;
        int visita20 = 0;
        int visita21 = 0;
        int visita22 = 0;
        int visita23 = 0;
        
        try{
        for(Visitante v:visitantes){
            switch(v.getFechaIngreso().getHour()){
                case 0 :
                    visita0 += 1;
                case 1 :
                    visita1 += 1;
                case 2 :
                    visita2 += 1;
                case 3 :
                    visita3 += 1;
                case 4 :
                    visita4 += 1;
                case 5 : 
                    visita5 += 1;
                case 6 :
                    visita6 += 1;
                case 7 : 
                    visita7 += 1;
                case 8 :
                    visita8 += 1;
                case 9 : 
                    visita9 += 1;
                case 10 : 
                    visita10 += 1;
                case 11 : 
                    visita11 += 1;
                case 12 :
                    visita12 += 1;
                case 13 :
                    visita13 += 1;
                case 14 :
                    visita14 += 1;
                case 15 : 
                    visita15 += 1;
                case 16 :
                    visita16 += 1;
                case 17 : 
                    visita17 += 1;
                case 18 :
                    visita18 += 1;
                case 19 : 
                    visita19 += 1;
                case 20 : 
                    visita20 += 1;
                case 21 : 
                    visita21 += 1;
                case 22 :
                    visita22 += 1;
                case 23 :
                    visita23 += 1;
                
            } 
            
        }
        }catch(Exception ex){
            System.out.println("Lista vacia");
                }
        
        series1.getData().add(new XYChart.Data("0", visita0));
        series1.getData().add(new XYChart.Data("1", visita1));
        series1.getData().add(new XYChart.Data("2", visita2));
        series1.getData().add(new XYChart.Data("3", visita3));
        series1.getData().add(new XYChart.Data("4", visita4));
        series1.getData().add(new XYChart.Data("5", visita5));
        series1.getData().add(new XYChart.Data("6", visita6));
        series1.getData().add(new XYChart.Data("7", visita7));
        series1.getData().add(new XYChart.Data("8", visita8));
        series1.getData().add(new XYChart.Data("9", visita9));
        series1.getData().add(new XYChart.Data("10", visita10));
        series1.getData().add(new XYChart.Data("11", visita11));
        series1.getData().add(new XYChart.Data("12", visita12));
        series1.getData().add(new XYChart.Data("13", visita13));
        series1.getData().add(new XYChart.Data("14", visita14));
        series1.getData().add(new XYChart.Data("15", visita15));
        series1.getData().add(new XYChart.Data("16", visita16));
        series1.getData().add(new XYChart.Data("17", visita17));
        series1.getData().add(new XYChart.Data("18", visita18));
        series1.getData().add(new XYChart.Data("19", visita19));
        series1.getData().add(new XYChart.Data("20", visita20));
        series1.getData().add(new XYChart.Data("21", visita21));
        series1.getData().add(new XYChart.Data("22", visita22));
        series1.getData().add(new XYChart.Data("23", visita23));
        
        XYChart.Series series2 = new XYChart.Series();
        series2.setName("Residente");
        
        int visita2_0 = 0;
        int visita2_1 = 0;
        int visita2_2 = 0;
        int visita2_3 = 0;
        int visita2_4 = 0;
        int visita2_5 = 0;
        int visita2_6 = 0;
        int visita2_7 = 0;
        int visita2_8 = 0;
        int visita2_9 = 0;
        int visita2_10 = 0;
        int visita2_11 = 0;
        int visita2_12 = 0;
        int visita2_13 = 0;
        int visita2_14 = 0;
        int visita2_15 = 0;
        int visita2_16 = 0;
        int visita2_17 = 0;
        int visita2_18 = 0;
        int visita2_19 = 0;
        int visita2_20 = 0;
        int visita2_21 = 0;
        int visita2_22 = 0;
        int visita2_23 = 0;
        
        try{
        for(LocalTime t: residentes){
            switch(t.getHour()){
                case 0 :
                    visita2_0 += 1;
                case 1 :
                    visita2_1 += 1;
                case 2 :
                    visita2_2 += 1;
                case 3 :
                    visita2_3 += 1;
                case 4 :
                    visita2_4 += 1;
                case 5 : 
                    visita2_5 += 1;
                case 6 :
                    visita2_6 += 1;
                case 7 : 
                    visita2_7 += 1;
                case 8 :
                    visita2_8 += 1;
                case 9 : 
                    visita2_9 += 1;
                case 10 : 
                    visita2_10 += 1;
                case 11 : 
                    visita2_11 += 1;
                case 12 :
                    visita2_12 += 1;
                case 13 :
                    visita2_13 += 1;
                case 14 :
                    visita2_14 += 1;
                case 15 : 
                    visita2_15 += 1;
                case 16 :
                    visita2_16 += 1;
                case 17 : 
                    visita2_17 += 1;
                case 18 :
                    visita2_18 += 1;
                case 19 : 
                    visita2_19 += 1;
                case 20 : 
                    visita2_20 += 1;
                case 21 : 
                    visita2_21 += 1;
                case 22 :
                    visita2_22 += 1;
                case 23 :
                    visita2_23 += 1;
                
            } 
        }
        }catch(Exception ex){
            System.out.println("Lista vacía");
        }
        series2.getData().add(new XYChart.Data("0", visita2_0));
        series2.getData().add(new XYChart.Data("1", visita2_1));
        series2.getData().add(new XYChart.Data("2", visita2_2));
        series2.getData().add(new XYChart.Data("3", visita2_3));
        series2.getData().add(new XYChart.Data("4", visita2_4));
        series2.getData().add(new XYChart.Data("5", visita2_5));
        series2.getData().add(new XYChart.Data("6", visita2_6));
        series2.getData().add(new XYChart.Data("7", visita2_7));
        series2.getData().add(new XYChart.Data("8", visita2_8));
        series2.getData().add(new XYChart.Data("9", visita2_9));
        series2.getData().add(new XYChart.Data("10", visita2_10));
        series2.getData().add(new XYChart.Data("11", visita2_11));
        series2.getData().add(new XYChart.Data("12", visita2_12));
        series2.getData().add(new XYChart.Data("13", visita2_13));
        series2.getData().add(new XYChart.Data("14", visita2_14));
        series2.getData().add(new XYChart.Data("15", visita2_15));
        series2.getData().add(new XYChart.Data("16", visita2_16));
        series2.getData().add(new XYChart.Data("17", visita2_17));
        series2.getData().add(new XYChart.Data("18", visita2_18));
        series2.getData().add(new XYChart.Data("19", visita2_19));
        series2.getData().add(new XYChart.Data("20", visita2_20));
        series2.getData().add(new XYChart.Data("21", visita2_21));
        series2.getData().add(new XYChart.Data("22", visita2_22));
        series2.getData().add(new XYChart.Data("23", visita2_23));
        
        barChart.getData().addAll(series1, series2);
    }    
    
    @FXML
    private void Regresar(ActionEvent event){
        try{
            FXMLLoader loader = new FXMLLoader(App.class.getResource("seleccionarGráfica.fxml"));
            Parent viewInicio = loader.load();
            App.setRoot("seleccionarGráfica");
        }catch(IOException e){
            System.out.println("Error cargando seleccionarGráfica.fxml");
        }
    }
    
    public void setHoras(ArrayList<LocalTime> horas){
        residentes = horas;
    }
    
}
