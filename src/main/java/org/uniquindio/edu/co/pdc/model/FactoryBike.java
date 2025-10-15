package org.uniquindio.edu.co.pdc.model;

import java.time.LocalDate;

public class FactoryBike {

    public static IBike createBike(String type, LocalDate model, String plate, String brand){
        switch (type.toUpperCase()){
            case "BIKE":
                return new Bike(model, plate, brand);
            case "QUADBIKE":
                IBike bikeAux = new Bike(model, plate, brand);
                return new QuadBikeDecorate(bikeAux);
            case "ELECTRICBIKE":
                IBike bikeAux1 = new Bike(model, plate, brand);
                return new ElectricBikeDecorate(bikeAux1);
            default:
                throw new IllegalArgumentException("No se encontro el tipo " + model);
        }
    }
}
