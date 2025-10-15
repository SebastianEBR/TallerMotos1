package org.uniquindio.edu.co.pdc.model;

import java.util.ArrayList;
import java.util.List;

/**
 * clase hija de usuario
 */
public class Client extends Person {
    // atributos heredados

    /**
     * conexion con otras clases
     */
    private List<Bike> listBikes;


    private Client(Builder builder) {
        super(builder);
        this.listBikes = new ArrayList<>();
    }

    /**
     * getter y setter
     * @return el valor de los atributos
     */
    public List<Bike> getListBikes() {
        return listBikes;
    }

    public void setListBikes(List<Bike> listBikes) {
        this.listBikes = listBikes;
    }

    /**
     * metodo toString
     * @return el valor de los atributos base + los especificos en formato texto
     */
    @Override
    public String toString() {
        return "Cliente: "            +
                super.toString()      +
                "\n Lista de motos: " + listBikes;
    }


    public static class Builder extends Person.Builder<Builder>{

        @Override
        public Builder self(){
            return this;
        }

        @Override
        public Client build(){
            return new Client(this);
        }
    }
}
