package OE3_Cortez;

import java.util.Scanner;

public class OE3_Cortez {
    static void bubbleSort(int[] numbers) {
        System.out.println("Applying Bubblesort...");
        System.out.println();
        for(int i=0; i<numbers.length; i++) { 
            boolean flag = false;
            for(int j=0; j<numbers.length-1; j++) {
                if(numbers[j]>numbers[j+1]) {
                    flag = true;
                    int temp = numbers[j+1];
                    numbers[j+1] = numbers[j];
                    numbers[j] = temp;
                }//end if
            }//end for
            
            if(!flag) {//No Swapping happened, array is sorted. Exit.
                System.out.println("Bubblesort Completed...");
                return; 
            }//end if
        }//end for
    }//end bubbleSort method

    static public void binarySearch(int[] numbers, int value) { 
        int low = 0; 
        int high = numbers.length - 1; 
        while(high >= low) { 
            int middle = (low + high)/2; // Middle index 
            if(numbers[middle] == value) { 
                System.out.println("The number "+ value + " is at position "
                                    + middle + " on the list...");
                System.out.println();
                return; //Target value was found 
            }//end if

            if(numbers[middle] < value) { 
                low = middle + 1; 
            }//end if

            if(numbers[middle] > value) { 
                high = middle - 1; 
            }//end if
        }//end while //The value was not found
        
        System.out.println("The number "+ value + " is not on the list...");
        System.out.println(); 
    }//end binarySearch method

    static public void displayNumbers(int[] numbers) {
        for(int i = 0; i < numbers.length; i++){
            if (i == numbers.length-1) {
                System.out.print(numbers[i] + ")");
            } else {
                System.out.print(numbers[i] + ", ");
            }
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.println("Enter size of array: ");
        int size = in.nextInt();
        int array[] = new int[size];

        for(int i = 0; i < size; i++) {
            System.out.println("Enter element No. #" + (i+1) + ": ");
            array[i] = in.nextInt();
        }

        System.out.println();
        System.out.print("Array Elements before BubbleSort: (");
        displayNumbers(array);
        bubbleSort(array);
        
        int choice = 0;
        do {
            System.out.println("What would you like to do?");
            System.out.println("[1] - Search for an Array Element");
            System.out.println("[2] - Display all Array Elements");
            System.out.println("[3] - Exit");
            System.out.println();
            choice = in.nextInt();
            System.out.println();

            if(choice == 1) {
                System.out.println("Enter number to be searched in the array: ");
                int value = in.nextInt();
                System.out.println();
                binarySearch(array, value);
            } else if (choice == 2) {
                System.out.print("Array Elements after BubbleSort: (");
                displayNumbers(array);
                System.out.println();
            } else if (choice == 3) {
                System.out.println("Thank you for using the program...");
            } else {
                System.out.println("Input error! \nReturning to Main Menu...");
                System.out.println();
            }
        } while (choice != 3);
    }
}