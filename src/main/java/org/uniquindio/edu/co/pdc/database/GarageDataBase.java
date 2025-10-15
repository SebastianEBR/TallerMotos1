package org.uniquindio.edu.co.pdc.database;

import org.uniquindio.edu.co.pdc.database.GarageDataBase;
import org.uniquindio.edu.co.pdc.model.Bike;
import org.uniquindio.edu.co.pdc.model.IBike;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class GarageDataBase {

    private static GarageDataBase dbInstance;

    private List<IBike> listBikes = new ArrayList<>();


    public static GarageDataBase getInstance(){
        if(dbInstance == null){
            dbInstance = new GarageDataBase();
        }
        return dbInstance;
    }

    public List<IBike> getListBikes() {
        return listBikes;
    }

    public void setListBikes(List<IBike> listBikes) {
        this.listBikes = listBikes;
    }

//    public Optional<IBike> findBikeByPlate(String plate){
//        return this.getListBikes()
//                .stream()
//                .filter(b -> b.getPlate().equals(plate))
//                .findFirst();
//    }

    public void addBike(IBike bike) {
        listBikes.add(bike);
    }

}
