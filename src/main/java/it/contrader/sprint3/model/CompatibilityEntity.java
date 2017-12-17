package it.contrader.sprint3.model;


import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "compatibility")
public class CompatibilityEntity implements Serializable
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id")
    private long id;

    @Column
    private int id_vehicle;

    @Column
    private int id_gomme;

    public CompatibilityEntity(){}

    public CompatibilityEntity(int id_vehicle, int id_gomme)
    {
        this.id_vehicle = id_vehicle;
        this.id_gomme = id_gomme;
    }

    public long getId() {
        return id;
    }

    public int getId_vehicle() {
        return id_vehicle;
    }

    public void setId_vehicle(int id_vehicle) {
        this.id_vehicle = id_vehicle;
    }

    public int getId_gomme() {
        return id_gomme;
    }

    public void setId_gomme(int id_gomme) {
        this.id_gomme = id_gomme;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CompatibilityEntity)) return false;
        CompatibilityEntity that = (CompatibilityEntity) o;
        return Objects.equals(id_vehicle, that.id_vehicle) &&
                Objects.equals(id_gomme, that.id_gomme);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id_vehicle, id_gomme);
    }

    @Override
    public String toString() {
        return "CompatibilityEntity{" +
                "id_vehicle='" + id_vehicle + '\'' +
                ", id_gomme='" + id_gomme + '\'' +
                '}';
    }
}
