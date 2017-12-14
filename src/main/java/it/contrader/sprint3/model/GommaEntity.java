package it.contrader.sprint3.model;

import it.contrader.sprint3.service.GommaService;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "gomme")
public class GommaEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id_gomme")
    private long id;

    @Column
    private String model;

    @Column
    private String manufacturer;

    @Column
    private double price;

    @Column
    private double width;

    @Column
    private double height;

    @Column
    private double diameter;

    @Column
    private double weight;

    @Column
    private String speed;

    @Column
    private String season;

    @Column
    private String typeVehicle;

    @Column
    private double quantity;

    public GommaEntity () {}

    public GommaEntity(Integer idGomme, String model, String manufacturer, double price, double width, double height, double diameter, double weight, String speed, String season,String typeVehicle,int quantity)
    {
        this.id = idGomme;
        this.model = model;
        this.manufacturer = manufacturer;
        this.price = price;
        this.width = width;
        this.height = height;
        this.diameter = diameter;
        this.weight = weight;
        this.speed = speed;
        this.typeVehicle = typeVehicle;
        this.season = season;
        this.quantity=quantity;
    }

    public long getId() {
        return id;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getDiameter() {
        return diameter;
    }

    public void setDiameter(double diameter) {
        this.diameter = diameter;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public String getSpeed() {
        return speed;
    }

    public void setSpeed(String speed) {
        this.speed = speed;
    }

    public String getSeason() {
        return season;
    }

    public void setSeason(String season) {
        this.season = season;
    }

    public String getTypeVehicle() {
        return typeVehicle;
    }

    public void setTypeVehicle(String typeVehicle) {
        this.typeVehicle = typeVehicle;
    }

    public double getQuantity() {
        return quantity;
    }

    public void setQuantity(double quantity) {
        this.quantity = quantity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof GommaEntity)) return false;
        GommaEntity that = (GommaEntity) o;
        return Double.compare(that.price, price) == 0 &&
                Double.compare(that.width, width) == 0 &&
                Double.compare(that.height, height) == 0 &&
                Double.compare(that.diameter, diameter) == 0 &&
                Double.compare(that.weight, weight) == 0 &&
                Double.compare(that.quantity, quantity) == 0 &&
                Objects.equals(model, that.model) &&
                Objects.equals(manufacturer, that.manufacturer) &&
                Objects.equals(speed, that.speed) &&
                Objects.equals(season, that.season) &&
                Objects.equals(typeVehicle, that.typeVehicle);
    }

    @Override
    public int hashCode() {

        return Objects.hash(model, manufacturer, price, width, height, diameter, weight, speed, season, typeVehicle, quantity);
    }

    @Override
    public String toString() {
        return "GommaEntity{" +
                "model='" + model + '\'' +
                ", manufacturer='" + manufacturer + '\'' +
                ", price=" + price +
                ", width=" + width +
                ", height=" + height +
                ", diameter=" + diameter +
                ", weight=" + weight +
                ", speed='" + speed + '\'' +
                ", season='" + season + '\'' +
                ", typeVehicle='" + typeVehicle + '\'' +
                ", quantity=" + quantity +
                '}';
    }
}
