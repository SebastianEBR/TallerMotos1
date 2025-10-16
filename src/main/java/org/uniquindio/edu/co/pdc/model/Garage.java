package org.uniquindio.edu.co.pdc.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * clase que representa el taller MotoNASSS
 */
public class Garage {
    /**
     * atributos de la clase
     */
    private String name;
    private String nit;
    private String location;

    /**
     * conexion con otras clases
     */
    private List<Car> listCars;
    private List<Person> listPeople;
    private List<Bike> listBikes;

    /**
     * metodo contructor
     *
     * @param name a
     * @param nit a
     * @param location a
     */
    public Garage(String name, String nit, String location) {
        this.name = name;
        this.nit = nit;
        this.location = location;
        listCars = new ArrayList<>();
        listPeople = new ArrayList<>();
        listBikes = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNit() {
        return nit;
    }

    public void setNit(String nit) {
        this.nit = nit;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public List<Car> getListProducts() {
        return listCars;
    }

    public void setListProducts(List<Car> listCars) {
        this.listCars = listCars;
    }

    public List<Person> getListUsers() {
        return listPeople;
    }

    public void setListUsers(List<Person> listPeople) {
        this.listPeople = listPeople;
    }

    public List<Bike> getListBikes() {
        return listBikes;
    }

    public void setListBikes(List<Bike> listBikes) {
        this.listBikes = listBikes;
    }

    /**
     * metodo toString
     *
     * @return los valores que tenga cada atributo en forma de String
     */
    @Override
    public String toString() {
        return "Taller: " +
                "\n Nombre: " + name + '\'' +
                "\n Nit: " + nit + '\'' +
                "\n Ubicación: " + location + '\'' +
                "\n Lista de productos: " + listCars +
                "\n Lista de Usuarios: " + listPeople +
                "\n Lista de motos: " + listBikes;
    }


    public boolean registrarMoto(Bike bike) {
        Optional<Bike> bikeOptional = buscarMoto(bike.getPlate());

        if (bikeOptional.isPresent()) {
            return false;
        }
        listBikes.add(bike);
        return true;
    }



    public String viewBikeInfo(String plate) {
        String message = "";
        Optional<Bike> bikeOptional = buscarMoto(plate);
        if (bikeOptional.isPresent()) {
            Bike moto = bikeOptional.get();
            message = "Info de Moto: " + moto.toString();
            return message;
        }
        return "No existe un moto con el placa: " + plate;
    }


    public boolean updateBike(Bike newBike) {
        Optional<Bike> bikeOptional = buscarMoto(newBike.getPlate());
        if (bikeOptional.isPresent()) {
            Bike moto = bikeOptional.get();
            moto.setModel(newBike.getModel());
            moto.setBrand(newBike.getBrand());
            moto.setClient(newBike.getClient());
            return true;
        }
        return false;
    }


    public boolean deleteBike(String plate) {
        Optional<Bike> bikeOptional = buscarMoto(plate);
        if (bikeOptional.isPresent()) {
            listBikes.remove(bikeOptional.get());
            return true;
        }
        return false;
    }


    private Optional<Bike> buscarMoto(String plate) {
        return listBikes.stream().filter(m -> m.getPlate().equals(plate)).findFirst();
    }


    public boolean registerCar(Car car) {
        Optional<Car> carOptionalOptional = searchCar(car.getPlate());
        if (carOptionalOptional.isPresent()) {
            return false;
        }
        listCars.add(car);
        return true;
    }

    /**
     * metodo para eliminar un producto de la lista de prodcutos
     * @param plate recibe la variable con un string que representa el codigo dl prodcuto
     * @return true/false
     */
    public boolean deleteProduct(String plate) {
        Optional<Car> pOptional = searchCar(plate);
        if (pOptional.isPresent()) {
            listCars.remove(pOptional.get());
            return true;
        }
        return false;
    }



    private Optional<Car> searchCar(String code){
        return listCars.stream().filter(c -> c.getPlate().equals(code)).findFirst();
    }

}
