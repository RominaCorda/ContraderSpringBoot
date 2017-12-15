package it.contrader.sprint3.model;

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

    public double getHeight() {
        return height;
    }

    public double getDiameter() {
        return diameter;
    }

    public double getWeight() {
        return weight;
    }

    public String getSpeed() {
        return speed;
    }

    public String getSeason() {
        return season;
    }

    public String getTypeVehicle() {
        return typeVehicle;
    }
}
