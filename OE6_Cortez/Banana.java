package OE6_Cortez;

import java.util.regex.*;

public class Banana {
    public static void main(String[] args) {
        String str = "anana";  
        if (str.matches(".?anana")) System.out.println("True");
        else System.out.println("False");
        str = "banana";
        if (str.matches(".?anana")) System.out.println("True");
        else System.out.println("False");
        str = "gabanana";
        if (str.matches(".?anana")) System.out.println("True");
        else System.out.println("False");
        System.out.println();

        String str2 = "banana";
        if (str2.matches("[Bb]anana")) System.out.println("True");
        else System.out.println("False");
        str2 = "anana";
        if (str2.matches("[Bb]anana")) System.out.println("True");
        else System.out.println("False");
        str2 = "shanana";
        if (str2.matches("[Bb]anana")) System.out.println("True");
        else System.out.println("False");
        System.out.println();

        String str3 = "montanana";
        if (str3.matches(".*anana")) System.out.println("True");
        else System.out.println("False");
        str3 = "anana";
        if (str3.matches(".*anana")) System.out.println("True");
        else System.out.println("False");
        str3 = "_anana";
        if (str3.matches(".*anana")) System.out.println("True");
        else System.out.println("False");

    }//end main method
}//end class Banana
