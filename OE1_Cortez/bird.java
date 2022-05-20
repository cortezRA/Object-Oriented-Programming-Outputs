package OE1_Cortez;

public class bird extends animal{
    private String name;
    private double weight;
    
    public bird(String name, String breed, double weight, String color){
        super(breed, color);
        this.name = name;
        this.weight = weight;
    }

    public void setBird(String name, String breed, double weight, String color){
        this.name = name;
        this.weight = weight;
    }

    public void getBird(){
        System.out.println("Bird Name: " + name);
        System.out.println("Breed: " + getBreed());
        System.out.println("Weight: " + weight);
        System.out.println("Color: " + getColor());
    }
}
