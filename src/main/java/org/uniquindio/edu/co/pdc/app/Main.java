package org.uniquindio.edu.co.pdc.app;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.uniquindio.edu.co.pdc.controlador.DashboardController;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        FXMLLoader loader = new FXMLLoader(Main.class.getResource("/org/uniquindio/edu/co/pdc/vista/Dashboard.fxml"));
        Parent root = loader.load();

        DashboardController controller = loader.getController();
        controller.setStage(primaryStage);

        Scene scene = new Scene(root, 900, 600);

        primaryStage.setTitle("Sistema de Gestión de Motos");
        primaryStage.setScene(scene);
        primaryStage.setMinWidth(800);
        primaryStage.setMinHeight(500);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

}
