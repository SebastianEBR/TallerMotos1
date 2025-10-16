package org.uniquindio.edu.co.pdc.model;

import java.time.Year;

public class BikeDecorate implements IBike{

    protected final IBike bike;

    public  BikeDecorate(IBike bike) {
        this.bike = bike;
    }

    @Override
    public String getPlate(){
        return bike.getPlate();
    }

    @Override
    public String getBrand(){
        return bike.getBrand();
    }

    @Override
    public Year getModel(){
        return bike.getModel();
    }

    @Override
    public void run() {
        bike.run();
    }

    @Override
    public void start() {
        bike.start();
    }
}
