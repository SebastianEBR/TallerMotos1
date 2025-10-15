package org.uniquindio.edu.co.pdc.model;

public class QuadBikeDecorate extends BikeDecorate {

    public QuadBikeDecorate(IBike bike) {
        super(bike);
    }


    @Override
    public void start() {
        bike.start();
        System.out.println("lista para montañas");
    }

    @Override
    public void run(){
        bike.run();
        System.out.println("andando en la montaña");
    }
}
