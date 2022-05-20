package OE1_Cortez;

public class my_animal {
    
    public static void main(String[] args) {
        dog dog1 = new dog("Parkie", "Aspin (Mixed)", 20, "Brown with Black Fur at Top side");
        dog dog2 = new dog("Koomi", "Mixed", 3, "White with Brown Spots");
        cat cat1 = new cat("Nagi", "Norwegian Forest Cat", 6, "Orange/White Bicolor Fur");
        cat cat2 = new cat("Snow", "Ragdoll", 9, "White with Cream and Brown Spots");
        fish fish1 = new fish("Coral", "Goldfish", 1.2, "Orange");
        fish fish2 = new fish("Dory", "Blue Tang", 0.5, "Blue");
        bird bird1 = new bird("Rio", "Blue Macaw", 1, "Blue");
        bird bird2 = new bird("Savannah", "Secretarybird", 3.9, "Whitish-Gray with Black tail feathers");

        dog1.getDog();
        System.out.println();
        dog2.getDog();
        System.out.println();
        cat1.getCat();
        System.out.println();
        cat2.getCat();
        System.out.println();
        fish1.getFish();
        System.out.println();
        fish2.getFish();
        System.out.println();
        bird1.getBird();
        System.out.println();
        bird2.getBird();
    }
}
