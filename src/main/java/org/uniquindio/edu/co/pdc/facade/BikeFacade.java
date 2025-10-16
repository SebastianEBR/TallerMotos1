package org.uniquindio.edu.co.pdc.facade;

import org.uniquindio.edu.co.pdc.database.GarageDataBase;
import org.uniquindio.edu.co.pdc.model.FactoryBike;
import org.uniquindio.edu.co.pdc.model.IBike;

import java.lang.reflect.Array;
import java.time.LocalDate;
import java.time.Year;
import java.util.ArrayList;
import java.util.List;

public class BikeFacade {
    private GarageDataBase instance;

    public BikeFacade() {
        this.instance = GarageDataBase.getInstance();
    }

    public void registrarMoto(String type, String plate, Year model, String brand) {
        IBike bike = FactoryBike.createBike(type, model, plate, brand);
        instance.addBike(bike);
    }

    public List<IBike> mostrarMotos() {
        return instance.getListBikes();
    }
}

