package OE2_Cortez;

public class DonutShop {
    public static void main(String[] args) {
        Donut donut1 = new Donut("Bavarian-filled Powdered Donut", 20);
        Donut donut2 = new Donut("Strawberry-filled Powdered Donut", 22);
        Donut donut3 = new Donut("Chocolate Frosted Donut", 18);
        Donut donut4 = new Donut("Sugar-Glazed Donut", 16);

        Drink drink1 = new Drink("Mountain Dew", 15);
        Drink drink2 = new Drink("Blue Lemonade", 30);
        Drink drink3 = new Drink("Apple Juice", 12);
        Drink drink4 = new Drink("Mineral Water", 20);

        System.out.println(donut1.getDepartment());
        System.out.println();
        System.out.println(donut1.getItemName());
        System.out.println(donut1.getType() + " - " + donut1.getPrice());
        System.out.println(donut2.getType() + " - " + donut2.getPrice());
        System.out.println(donut3.getType() + " - " + donut3.getPrice());
        System.out.println(donut4.getType() + " - " + donut4.getPrice());
        System.out.println();
        System.out.println(drink1.getItemName());
        System.out.println(drink1.getType() + " - " + drink1.getPrice());
        System.out.println(drink2.getType() + " - " + drink2.getPrice());
        System.out.println(drink3.getType() + " - " + drink3.getPrice());
        System.out.println(drink4.getType() + " - " + drink4.getPrice());
    }
}