package OE1_Cortez;

public class fish extends animal{
    private String name;
    private double weight;
    
    public fish(String name, String breed, double weight, String color){
        super(breed, color);
        this.name = name;
        this.weight = weight;
    }

    public void setFish(String name, String breed, double weight, String color){
        this.name = name;
        this.weight = weight;
    }

    public void getFish(){
        System.out.println("Fish Name: " + name);
        System.out.println("Breed: " + getBreed());
        System.out.println("Weight: " + weight);
        System.out.println("Color: " + getColor());
    }
}
