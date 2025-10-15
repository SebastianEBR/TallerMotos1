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


    // Metodos CRUD relacionados a Usuarios

    /**
     * metodo para registrar un usuario
     *
     * @param person llega un usuario con todos los datos
     * @return true/false en caso de lograr su función
     */
    public boolean registerUser(Person person) {
        Optional<Person> userOptional = searchUser(person.getId()); // buscar el usuario en la lista de usuarios

        if (userOptional.isPresent()) { // no pueden haber usuarios duplicados
            return false;
        }

        listPeople.add(person); // agregar a la lista
        return true; //  correcto
    }


    public boolean registerUser(Client client, Bike bike){
        Optional<Person> userOptional = searchUser(client.getId()); // buscar el usuario en la lista de usuarios
        Optional<Bike> bikeOptional = buscarMoto(bike.getPlate());

        if (userOptional.isPresent() || bikeOptional.isPresent()) { // no pueden haber usuarios ni motos duplicados
            return false;
        }

        listPeople.add(client); // agregar cliente a la lista
        listBikes.add(bike); // agregar moto a la lista
        assignBikeClient(client, bike); // asignamos un cliente a la moto, y agregamos la moto a la lista de motos del cliente
        return true; //  correcto
    }

    /**
     * metodo para ver la información de un usuario
     *
     * @param id para poder buscar el usuario
     * @return los datos de ese Usuario en forma de texto
     */
    public String viewUserInfo(String id) {
        String message = "";
        Optional<Person> userOptional = searchUser(id); // buscar si existe ese usario para ver

        if (userOptional.isPresent()) { // verificar si existe
            Person personAux = userOptional.get();
            if (personAux instanceof Client) { // si es tipo CLiente o ayudante, cambia el mensaje
                message = "Info de Cliente: " + personAux.toString();
            } else {
                message = "Info Ayudante: " + personAux.toString();
            }
            return message;
        }
        return "No existe un usuario con el id: " + id; // en caso de no existir
    }


    /**
     * metodo para actualizar la info de un usuario
     *
     * @param newUsuario llega un usuario que tiene toda la info nueva
     * @return true/false dependiendo del caso
     */
    public boolean updateUser(Person newUsuario) {
        Optional<Person> userOptional = searchUser(newUsuario.getId()); // buscar el usuario en la lista

        if (userOptional.isPresent()) { // si esta presente, actaulizamos sus atributos base
            Person personAux = userOptional.get();
            personAux.setName(newUsuario.getName());

            if (personAux instanceof Client clienteAux) { // si es de tipo CLiente acutalizamos su lista de mtoos

                Client clientBikeList = (Client) newUsuario;
                clienteAux.setListBikes(clientBikeList.getListBikes());
            }
            return true;
        }
        return false;
    }


    /**
     * metodo para eliminar un usuario
     *
     * @param id para buscar dicho usuario
     * @return true/false dependiendo del caso
     */
    public boolean deleteUser(String id) {
        Optional<Person> userOptional = searchUser(id);
        if (userOptional.isPresent()) {
            Person person = userOptional.get();
            listPeople.remove(person);
            return true;
        }
        return false;
    }

    /**
     * metodo para buscar un usuaio
     *
     * @param id para buscar el ususario en la lista
     * @return el primer usuario que encuentre que cumpla la condicion
     */
    private Optional<Person> searchUser(String id) {
        return listPeople.stream().filter(u -> u.getId().equals(id)).findFirst();
    }

    /**
     * metodo para registrar una moto
     *
     * @param bike objeto bike
     * @return true/false
     */
    public boolean registrarMoto(Bike bike) {
        Optional<Bike> bikeOptional = buscarMoto(bike.getPlate());

        if (bikeOptional.isPresent()) {
            return false;
        }
        listBikes.add(bike);
        return true;
    }


    /**
     * metodo para ver la información de una moto
     *
     * @param plate contiene como valor la placa del vehiculo
     * @return la info de la moto en formato texto
     */
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

    /**
     * metodo para actualizar la info de una moto
     *
     * @param newBike nuevo objeto Moto
     * @return true/false
     */
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

    /**
     * metodo para eliminar una moto
     *
     * @param plate contiene como valor la placa del vehiculo
     * @return true/false
     */
    public boolean deleteBike(String plate) {
        Optional<Bike> bikeOptional = buscarMoto(plate);
        if (bikeOptional.isPresent()) {
            listBikes.remove(bikeOptional.get());
            return true;
        }
        return false;
    }

    /**
     * metodo para buscar una moto en la lista de motos
     *
     * @param plate contiene como valor la placa del vehiculo
     * @return un objeto de tipo Optional
     */
    private Optional<Bike> buscarMoto(String plate) {
        return listBikes.stream().filter(m -> m.getPlate().equals(plate)).findFirst();
    }

    /**
     * metodo para registar un producto
     *
     * @param car objeto de tipo Product
     * @return true/false
     */
    public boolean registerProduct(Car car) {
        Optional<Car> pOptional = searchProduct(car.getCode());
        if (pOptional.isPresent()) {
            return false;
        }
        listCars.add(car);
        car.setSellingPrice(calculateSellingPrice(car));

        return true;
    }

    /**
     * metodo para ver la información de un producto
     *
     * @param code contiene como valor el codigo de producto, es de tipo String
     * @return retorna un mensaje dependiendo del caso
     */
    public String viewProductInfo(String code) {
        Optional<Car> pOptional = searchProduct(code);
        if (pOptional.isPresent()) {
            Car car = pOptional.get();
            return "Info de Producto: " + car.toString();
        }
        return "No existe un producto con el codigo: " + code;
    }

    /**
     * metodo para actualizar un producto
     * @param newCar recibe un objeto de tipo Product
     * @return true/false
     */
    public boolean actualizarProducto(Car newCar) {
        Optional<Car> pOptional = searchProduct(newCar.getCode());
        if (pOptional.isPresent()) {
            Car carAux = pOptional.get();
            carAux.setName(newCar.getName());
            carAux.setCostPrice(newCar.getCostPrice());

            if (carAux instanceof LightBulb && newCar instanceof LightBulb) {
                LightBulb light = (LightBulb) newCar;
                carAux.setSellingPrice(light.calculateSellingPrice());
            }
            return true;
        }
        return false;
    }


    /**
     * metodo para eliminar un producto de la lista de prodcutos
     * @param code recibe la variable con un string que representa el codigo dl prodcuto
     * @return true/false
     */
    public boolean deleteProduct(String code) {
        Optional<Car> pOptional = searchProduct(code);
        if (pOptional.isPresent()) {
            listCars.remove(pOptional.get());
            return true;
        }
        return false;
    }


    /**
     * metodo para buscar un producto en la lista de prodcutos
     * @param code recibe la variable con un string que representa el codigo dl prodcuto
     * @return objeto de tipo optional (el primero que encuentre)
     */
    private Optional<Car> searchProduct(String code){
        return listCars.stream().filter(p -> p.getCode().equals(code)).findFirst();
    }

    /**
     * metodo para asignar una moto a un cliente
     * @param client recibe el objeto de tipo Client
     * @param bike recibe el objeto de tipo Bike
     * @return true/false
     */
    public boolean assignBikeClient(Client client, Bike bike){
        Optional<Person> userOptional = searchUser(client.getId()); // buscar el usuario en la lista de usuarios
        Optional<Bike> bikeOptional = buscarMoto(bike.getPlate());

        if (userOptional.isPresent() && bikeOptional.isPresent()) { // no pueden haber usuarios ni bikes duplicados
            client.getListBikes().add(bike);
            bike.setClient(client);
            return true;
        }
        return false;
    }


    public double calculateSellingPrice(Car car) {
        Optional<Car> pOptional = searchProduct(car.getCode()); // buscar el usuario en la lista de usuarios

        if (pOptional.isPresent()) {
            if (car instanceof LightBulb) {
                LightBulb light = (LightBulb) car;
                return light.calculateSellingPrice();
            } else if (car instanceof Helmet) {
                Helmet helmet = (Helmet) car;
                return helmet.calculateSellingPrice();
            }
        }
        return 0;
    }

}
