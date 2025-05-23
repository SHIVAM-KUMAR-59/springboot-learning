package org.shivam;

import jakarta.persistence.*;

import java.util.List;

@Entity
// @Embeddable // Allows us embbed the fields of  laptop into alien class without making a separate table for laptop
public class Laptop {
    @Id
    private int lid;
    private String brand;
    private String model;
    private int ram;
    // @ManyToOne
    // @ManyToMany
    // private List<Alien> aliens;

    // public List<Alien> getAliens() {
       // return aliens;
    // }

    // public void setAliens(List<Alien> aliens) {
       // this.aliens = aliens;
    // }

    public int getRam() {
        return ram;
    }

    public void setRam(int ram) {
        this.ram = ram;
    }

    public int getLid() {
        return lid;
    }

    public void setLid(int lid) {
        this.lid = lid;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    @Override
    public String toString() {
        return "Laptop{" +
                "lid=" + lid +
                ", brand='" + brand + '\'' +
                ", model='" + model + '\'' +
                ", ram=" + ram +
                '}';
    }
}
