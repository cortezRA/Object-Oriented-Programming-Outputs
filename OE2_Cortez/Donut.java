package OE2_Cortez;

public class Donut implements Item{
    public String donutType;
    private double price;

    public Donut(String type, double price){
        donutType = type;
        this.price = price;
    }// end constructor

    public String getItemName(){
        return "Donut/s:";
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
        return donutType;
    }
}
