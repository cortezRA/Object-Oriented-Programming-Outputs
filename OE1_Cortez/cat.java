package OE1_Cortez;

public class cat extends animal{
    private String name;
    private double weight;
    
    public cat(String name, String breed, double weight, String color){
        super(breed, color);
        this.name = name;
        this.weight = weight;
    }

    public void setCat(String name, String breed, double weight, String color){
        this.name = name;
        this.weight = weight;
    }

    public void getCat(){
        System.out.println("Cat Name: " + name);
        System.out.println("Breed: " + getBreed());
        System.out.println("Weight: " + weight);
        System.out.println("Color: " + getColor());
    }
}
