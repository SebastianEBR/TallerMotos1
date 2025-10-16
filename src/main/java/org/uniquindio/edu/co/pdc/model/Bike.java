package org.uniquindio.edu.co.pdc.model;

import java.time.LocalDate;
import java.time.Year;

/**
 * clase que representa motos
 */
public class Bike implements IBike{
    /**
     * atributos de la clase
     */
    private Year model;
    private String brand;
    private String plate;

    /**
     * conexion con otras clases
     */
    private Client client;

    public Bike(Year model, String brand, String plate) {
        this.model = model;
        this.brand = brand;
        this.plate = plate;
    }

    @Override
    public Year getModel() {
        return model;
    }

    public void setModel(Year model) {
        this.model = model;
    }

    @Override
    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    @Override
    public String getPlate() {
        return plate;
    }

    public void setPlate(String plate) {
        this.plate = plate;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }


    @Override
    public void run() {
        System.out.println("Moto andando");;
    }

    @Override
    public void start() {
        System.out.println("Moto encendida");;
    }


    /**
     * metodo toString
     * @return los valores de los atributos en forma de texto
     */
    @Override
    public String toString() {
        return "Moto: " +
                "\n Modelo: "  + model + '\'' +
                "\n Marca: "   + brand + '\'' +
                "\n Placa:"    + plate + '\'' +
                "\n Cliente: " + client.getName();
    }
}
