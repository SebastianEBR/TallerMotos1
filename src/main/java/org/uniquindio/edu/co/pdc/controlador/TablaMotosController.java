package org.uniquindio.edu.co.pdc.controlador;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import org.uniquindio.edu.co.pdc.database.GarageDataBase;
import org.uniquindio.edu.co.pdc.model.FactoryBike;
import org.uniquindio.edu.co.pdc.model.IBike;

import java.time.LocalDate;
import java.time.Year;

public class TablaMotosController {

    @FXML
    private TableView<IBike> tablaMotos;

    @FXML
    private TableColumn<IBike, String> colPlate;

    @FXML
    private TableColumn<IBike, Year> colModel;

    @FXML
    private TableColumn<IBike, String> colBrand;

    @FXML
    public void initialize() {
        colPlate.setCellValueFactory(new PropertyValueFactory<>("plate"));
        colModel.setCellValueFactory(new PropertyValueFactory<>("model"));
        colBrand.setCellValueFactory(new PropertyValueFactory<>("brand"));

        // Obtener la lista compartida
        var motos = GarageDataBase.getInstance().getListBikes();

        // Solo agregar motos de prueba si no hay ninguna
        if (motos.isEmpty()) {
            motos.add(FactoryBike.createBike("BIKE", Year.of(2001), "lcs", "Honda"));
            motos.add(FactoryBike.createBike("QUADBIKE", Year.of(2002), "lcs", "akt"));
            motos.add(FactoryBike.createBike("ELECTRICBIKE", Year.of(2003), "lcd", "zusuki"));
        }

        // Asignar la lista al TableView
        tablaMotos.setItems(motos);
    }


    @FXML
    void onVolver() {
        try {
            javafx.fxml.FXMLLoader loader = new javafx.fxml.FXMLLoader(getClass().getResource("/org/uniquindio/edu/co/pdc/vista/Dashboard.fxml"));
            javafx.scene.Parent root = loader.load();
            javafx.stage.Stage stage = (javafx.stage.Stage) tablaMotos.getScene().getWindow();
            stage.setScene(new javafx.scene.Scene(root));
            stage.setTitle("Dashboard");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
