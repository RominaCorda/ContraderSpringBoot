package it.contrader.sprint3.model;

import javax.annotation.Generated;
import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;


@Entity
@Table(name = "vehicle")
public class VehicleEntity  implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long idVehicle;

    @Column
    private String brand ;

    @Column
    private String model ;

    @Column
    private String fuel ;

    @Column
    private String version ;

    @Column
    private String capacity ;


    public VehicleEntity() { }

    public VehicleEntity(String brand, String model, String fuel, String version, String capacity)
    {
        this.brand = brand;
        this.model = model;
        this.fuel = fuel;
        this.version = version;
        this.capacity =  capacity;
    }

    public long getIdVehicle() {
        return idVehicle;
    }

    public void setIdVehicle(long idVehicle) {
        this.idVehicle = idVehicle;
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

    public String getFuel() {
        return fuel;
    }

    public void setFuel(String fuel) {
        this.fuel = fuel;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getCapacity() {
        return capacity;
    }

    public void setCapacity(String capacity) {
        this.capacity = capacity;
    }



    //brand, model, fuel, version, capacity


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof VehicleEntity)) return false;
        VehicleEntity that = (VehicleEntity) o;
        return Objects.equals(brand, that.brand) &&
                Objects.equals(model, that.model) &&
                Objects.equals(fuel, that.fuel) &&
                Objects.equals(version, that.version) &&
                Objects.equals(capacity, that.capacity);
    }

    @Override
    public int hashCode() {

        return Objects.hash(brand, model, fuel, version, capacity);
    }

    @Override
    public String toString() {
        return "VehicleEntity{" +
                "brand='" + brand + '\'' +
                ", model='" + model + '\'' +
                ", fuel='" + fuel + '\'' +
                ", version='" + version + '\'' +
                ", capacity='" + capacity + '\'' +
                '}';
    }
}

