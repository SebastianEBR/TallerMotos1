package org.uniquindio.edu.co.pdc.controlador;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class DashboardController {

    private Stage stage;

    public void setStage(Stage stage) {
        this.stage = stage;
    }

    @FXML
    void onOpenFormulario(ActionEvent event) {
        cambiarVista("FormularioMoto.fxml", "Agregar Moto", event);
    }

    @FXML
    void onOpenLista(ActionEvent event) {
        cambiarVista("TablaVehicles.fxml", "Lista de Motos", event);
    }

    private void cambiarVista(String fxml, String titulo, ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/org/uniquindio/edu/co/pdc/vista/" + fxml));
            Parent root = loader.load();

            Stage stage = (Stage) ((javafx.scene.Node) event.getSource()).getScene().getWindow();

            stage.setScene(new Scene(root, 900, 600));
            stage.setTitle(titulo);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
