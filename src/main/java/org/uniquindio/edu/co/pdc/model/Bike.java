package org.uniquindio.edu.co.pdc.model;

import java.time.LocalDate;

/**
 * clase que representa motos
 */
public class Bike implements IBike{
    /**
     * atributos de la clase
     */
    private LocalDate model;
    private String brand;
    private String plate;

    /**
     * conexion con otras clases
     */
    private Client client;

    public Bike(LocalDate model, String brand, String plate) {
        this.model = model;
        this.brand = brand;
        this.plate = plate;
    }

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
