package org.uniquindio.edu.co.pdc.model;

/**
 * clase abstracta que representa los usuarios en general
 */
public abstract class Person {

    /**
     * atributos generales de la clase
     */
    protected String name;
    protected String id;
    protected String phone;


    protected Person(Builder<?> builder){
        this.name = builder.name;
        this.id = builder.id;
        this.phone = builder.phone;
    }

    /**
     * getter y setter
     * @return el valor del atributo
     */
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPhone() {return phone;}

    public void setPhone(String phone) {this.phone = phone;}

    /**
     * metodo toString
     * @return el valor de los atributos en formato texto
     */
    @Override
    public String toString() {
        return  "\n Name: "  + name +
                "\n ID: "    + id   +
                "\n Phone: " + phone;
    }

    public abstract static class Builder<T extends Builder<T>>{
        private String name;
        private String id;
        private String phone;

        public T name(String name){
            this.name = name;
            return self();
        }

        public T id(String id){
            this.id = id;
            return self();
        }

        public T phone(String phone){
            this.phone = phone;
            return self();
        }

        protected abstract T self();

        public abstract Person build();
    }
}
