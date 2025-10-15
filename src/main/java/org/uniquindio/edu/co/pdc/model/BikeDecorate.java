package org.uniquindio.edu.co.pdc.model;

public class BikeDecorate implements IBike{

    protected final IBike bike;

    public  BikeDecorate(IBike bike) {
        this.bike = bike;
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
