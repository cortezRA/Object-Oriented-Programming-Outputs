package Midterms_Cortez;

import java.util.Scanner;

public class CurrencyApp {

    static void promptMessage(){
        System.out.println("\n[DTP] - Dollar to Peso (1 dollar -> 56.30 peso/s )");
        System.out.println("[PTD] - Peso to Dollar (1 peso -> 0.018 dollar/s)");
        System.out.println("[ETP] - Euro to Peso (1 euro -> 56.61 peso/s)");
        System.out.println("[PTE] - Peso to Euro (1 peso -> 0.018 euro/s)");
        System.out.println();
        System.out.println("Enter the amount and keyword divided by a space: (Ex -> 123.45 etp)");
        System.out.print("> ");
    }// end void promptMessage

    public static void main(String[] args) {
        String yesno = ""; // Y|y for make another conversion and N|n to end program
        int count = 0; double amount = 0;
        System.out.println("| Welcome to the Currency App |");

        while (yesno.matches("[Nn]") == false) {
            Scanner in = new Scanner(System.in);
            promptMessage();
            String choice = in.nextLine(); String choice2[] = choice.split(" ");

            if (choice2[0].matches("^\\d*\\.?\\d+")) {
                amount = Double.valueOf(choice2[0]);
            } else {
                yesno = "Y";
            }

            if (choice.matches("^\\d*\\.?\\d+\s(DTP|dtp)")) {
                Dollar2Peso ex1 = new Dollar2Peso(amount);
            } 
            else if (choice.matches("^\\d*\\.?\\d+\s(PTD|ptd)")) {
                Peso2Dollar ex2 = new Peso2Dollar(amount);
            }
            else if (choice.matches("^\\d*\\.?\\d+\s(ETP|etp)")) {
                Euro2Peso ex3 = new Euro2Peso(amount);
            }
            else if (choice.matches("^\\d*\\.?\\d+\s(PTE|pte)")) {
                Peso2Euro ex4 = new Peso2Euro(amount);
            }
            else System.out.println("Error! Returning to main menu..."); // end if
            
            for (String ele : choice2) count = count + 1; // end for-each loop
            if (count == 2 && choice2[1] != null) {
                switch (choice2[1]) {
                    case "DTP": case "dtp":
                    case "PTD": case "ptd":
                    case "ETP": case "etp":
                    case "PTE": case "pte":
                        do {
                            System.out.println("Would you like to convert another currency amount? ");
                            System.out.println("\n[Y] - Yes");
                            System.out.println("[N] - No\n");
                            System.out.print("> ");
                            yesno = in.next();
    
                            if (yesno.matches("[Nn]")) 
                                System.out.println("Closing the Currency App...");
                            else if (yesno.matches("[Yy]|[Nn]") == false) 
                                System.out.println("Error! Invalid input...\n");
                        } while (yesno.matches("[Yy]|[Nn]") == false); // end do-while
                        break;
                }// end switch
            }//end if
            count = 0;
        }// end while
    }// end method main
}// end class CurrencyApp
