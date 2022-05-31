package OE2_Cortez;

public class Drink implements Item{
    public String drinkType;
    private double price;

    public Drink(String type, double price){
        drinkType = type;
        this.price = price;
    }// end constructor

    public String getItemName(){
        return "Drink/s:";
    }

    public double getPrice(){
        return price;
    }

    public void setPrice(double price){
        this.price = price;
    }

    public String getDepartment(){
        return "|| Welcome to Abe's Donut Shop ||";
    }

    public String getType(){
        return drinkType;
    }
}
