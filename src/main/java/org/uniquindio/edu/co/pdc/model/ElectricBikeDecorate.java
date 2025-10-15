package org.uniquindio.edu.co.pdc.model;

public class ElectricBikeDecorate extends BikeDecorate {

    public ElectricBikeDecorate(IBike bike) {
        super(bike);
    }

    @Override
    public void start() {
        bike.start();
        System.out.println("Moto encendida ahorradora");
    }

    @Override
    public void run(){
        bike.run();
        System.out.println("andando en modo optimo");
    }
}
