package model;

public class Animal {
    
    private int id;
    private String name;
    private String type;
    private String color;
    private double size;
    private double weight;

    public Animal() {
    }

    public Animal(int id, String name, String type, String color, 
            double size, double weight) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.color = color;
        this.size = size;
        this.weight = weight;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public double getSize() {
        return size;
    }

    public void setSize(double size) {
        this.size = size;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }
                    
}
