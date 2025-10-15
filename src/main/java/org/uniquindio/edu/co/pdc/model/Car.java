package org.uniquindio.edu.co.pdc.model;

import java.time.LocalDate;

/**
 * clase abstract que representa los productos del taller
 */
public class Car {

    /**
     * atributos de la clase
     */
    private LocalDate model;
    private String brand;
    private String plate;


    protected Car(Builder builder) {
        this.model = builder.model;
        this.brand = builder.brand;
        this.plate = builder.plate;
    }

    /**
     * metodos getter y setter
     */
    public LocalDate getModel() {
        return model;
    }

    public void setModel(LocalDate model) {
        this.model = model;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getPlate() {
        return plate;
    }

    public void setPlate(String plate) {
        this.plate = plate;
    }

    /**
     * metodo toString
     */
    @Override
    public String toString() {
        return "Car{" +
                "model=" + model +
                ", brand='" + brand + '\'' +
                ", plate='" + plate + '\'' +
                '}';
    }

    public static class Builder{

        private LocalDate model;
        private String brand;
        private String plate;


        public Builder model(LocalDate model){
            this.model = model;
            return this;
        }

        public Builder brand(String brand){
            this.brand = brand;
            return this;
        }

        public Builder plate(String plate){
            this.plate = plate;
            return this;
        }

        public Car build(){
            return new Car(this);
        }

    }
}
