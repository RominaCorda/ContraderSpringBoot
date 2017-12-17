package it.contrader.sprint3.model;

import java.util.Objects;

public class GommaSize
{
    double width;
    double height;
    double diameter;
    double weight;
    String speed;
    String season;
    String typeVehicle;

    public GommaSize(){}
    public GommaSize(double width, double height, double diameter, double weight, String speed, String season, String typeVehicle)
    {
        this.width = width;
        this.height = height;
        this.diameter = diameter;
        this.weight = weight;
        this.speed = speed;
        this.season = season;
        this.typeVehicle = typeVehicle;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof GommaSize)) return false;
        GommaSize gommaSize = (GommaSize) o;
        return Double.compare(gommaSize.width, width) == 0 &&
                Double.compare(gommaSize.height, height) == 0 &&
                Double.compare(gommaSize.diameter, diameter) == 0 &&
                Double.compare(gommaSize.weight, weight) == 0 &&
                Objects.equals(speed, gommaSize.speed) &&
                Objects.equals(season, gommaSize.season) &&
                Objects.equals(typeVehicle, gommaSize.typeVehicle);
    }

    @Override
    public int hashCode() {

        return Objects.hash(width, height, diameter, weight, speed, season, typeVehicle);
    }

    @Override
    public String toString() {
        return "GommaSize{" +
                "width=" + width +
                ", height=" + height +
                ", diameter=" + diameter +
                ", weight=" + weight +
                ", speed='" + speed + '\'' +
                ", season='" + season + '\'' +
                ", typeVehicle='" + typeVehicle + '\'' +
                '}';
    }
}
