package org.uniquindio.edu.co.pdc.controlador;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import org.uniquindio.edu.co.pdc.database.GarageDataBase;
import org.uniquindio.edu.co.pdc.model.FactoryBike;
import org.uniquindio.edu.co.pdc.model.IBike;

import java.time.Year;

public class FormularioMotoController {

    @FXML
    public TextField typeField;
    @FXML
    private TextField plateField;

    @FXML
    private TextField modelField;

    @FXML
    private TextField marcaField;

    @FXML
    void onGuardar() {
        String type = typeField.getText();
        String plate = plateField.getText();
        Year model = Year.parse(modelField.getText());
        String marca = marcaField.getText();

        IBike b = FactoryBike.createBike(type, model, plate, marca);

        // Agregar a la base de datos
        GarageDataBase.getInstance().addBike(b);

        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Moto Guardada");
        alert.setHeaderText(null);
        alert.setContentText("Moto agregada: " );
        alert.showAndWait();
    }

    @FXML
    void onVolver() {
        try {
            javafx.fxml.FXMLLoader loader = new javafx.fxml.FXMLLoader(getClass().getResource("/org/uniquindio/edu/co/pdc/vista/Dashboard.fxml"));
            javafx.scene.Parent root = loader.load();
            javafx.stage.Stage stage = (javafx.stage.Stage) plateField.getScene().getWindow();
            stage.setScene(new javafx.scene.Scene(root));
            stage.setTitle("Dashboard");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
