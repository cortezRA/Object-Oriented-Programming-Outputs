package OE1_Cortez;

public class dog extends animal{
    private String name;
    private double weight;
    
    public dog(String name, String breed, double weight, String color){
        super(breed, color);
        this.name = name;
        this.weight = weight;
    }

    public void setDog(String name, String breed, double weight, String color){
        this.name = name;
        this.weight = weight;
    }

    public void getDog(){
        System.out.println("Dog Name: " + name);
        System.out.println("Breed: " + getBreed());
        System.out.println("Weight: " + weight);
        System.out.println("Color: " + getColor());
    }
}
