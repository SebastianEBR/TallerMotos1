package org.uniquindio.edu.co.pdc.database;

import org.uniquindio.edu.co.pdc.database.GarageDataBase;
import org.uniquindio.edu.co.pdc.model.Bike;
import org.uniquindio.edu.co.pdc.model.IBike;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class GarageDataBase {

    private static GarageDataBase dbInstance;
    private ObservableList<IBike> listBikes = FXCollections.observableArrayList();

    public static GarageDataBase getInstance() {
        if (dbInstance == null) {
            dbInstance = new GarageDataBase();
        }
        return dbInstance;
    }

    public ObservableList<IBike> getListBikes() {
        return listBikes;
    }

    public void addBike(IBike bike) {
        listBikes.add(bike);
    }
}

