module espol.proyectopoo_g8_p2{
    requires javafx.controls;
    requires javafx.fxml;
    requires java.base;
    requires java.mail;

    opens espol.proyectopoo_g8_p2 to javafx.fxml;
    exports espol.proyectopoo_g8_p2;
    
}
