package espol.proyectopoo_g8_p2.backend;

import java.util.List;
import javafx.scene.control.Alert;

public class Peaton implements Movibles{
    private String numCedula;
    private String pinAcceso;
    /**
     * Constructor de la clase peatón
     * @param numCedula
     * @param pinAcceso 
     */
    public Peaton(String numCedula, String pinAcceso){
        this.numCedula=numCedula;
        this.pinAcceso=pinAcceso;
    }
    
    /**
     * getter que retorna el número de cédula del peatón
     * @return numCedula
     */
    public String getNumCedula(){
    return numCedula;
    }
    
    /**
     * getter que retorna el pin de acceso del peatón
     * @return pinAcceso
     */
    public String getPinAcceso(){
    return pinAcceso;
    }
    
    /**
     * Sobreescritura de un método abstracto de la interfaz movible, retorna un boolean que confirma o no el ingreso del peatón a la ciudadela
     * @return comp
     */
    @Override
    public boolean ingreso() {
        List<Residente> residentes = Residente.cargarResidente();
        boolean comp = true;
        for(Residente r: residentes){
            if(r.getCedula().equals(numCedula) && r.getPinAcceso().equals(pinAcceso)){
                Alert alert = new Alert(Alert.AlertType.INFORMATION, "¡EL PEATÓN PUEDE INGRESAR!");
                alert.show();
                comp = false;
                return true;
            }
        }
        
        if(comp){
            Alert alert = new Alert(Alert.AlertType.ERROR, "¡EL RESIDENTE NO HA SIDO ENCONTRADO!");
            alert.show();
        }
        return false;
    }
}

