package OE6_Cortez;

import java.util.Scanner;

public class Employee {
    private final String name;
    private final String username;
    private final String email;
    private String password;

    public Employee() {
        name = setName();
        username = setUserName(name);
        email = setEmail(username);
        password = setPassword(username);
    }//end constructor

    private int countChars(String s, char c) {
        int count = 0;
        for (int index = 0; index < s.length(); index++) {
            if(s.charAt(index) == c) {
                count++;
            }// end if
        }//end for
        return count;
    }//end method countChars

    public String setName() {
        int count; String EmployeeName;
        Scanner in = new Scanner(System.in);

        do {
            System.out.println("Enter name of employee: ");
            EmployeeName = in.nextLine();

            if (EmployeeName.matches(".+ .+")) {
                count = countChars(EmployeeName, ' ');

                if(count != 1) {
                    System.out.println("Incorrect format: name of employee limited to two words only...");
                    System.out.println();
                }//end if
            } else {
                System.out.println("Inccorrect format for name");
                System.out.println();
                count = 0;
            }
        } while (count != 1); //end do-while

        return EmployeeName;
    }//end method setName
        
    public String setUserName(String name) {
        String lowercase = name.toLowerCase();
        String validUsername = lowercase.replace(' ','.');
        return validUsername;
    }//end method setUserName

    public String setEmail(String username) {
        String validEmail = username.substring(0,1);
        
        for (int i = 0; i < username.length(); i++) {
            if (username.charAt(i) == '.') {
                validEmail += username.substring(i+1);
            }//end if
        }//end for

        validEmail += "@oracleacademy.Test";
        return validEmail;
    }//end method setEmail

    public String setPassword(String username) {
        String validPass = username;
        if(validPass.length() < 8) {
            while(validPass.length() < 8) {
                validPass += "*";
            }//end for
        } else if (validPass.length() > 8) {
            validPass = username.substring(0, 8);
        }//end if

        for (int i = 0; i < validPass.length(); i++) {
            if (validPass.charAt(i) == 'a' || validPass.charAt(i) == 'e' || validPass.charAt(i) == 'i' ||
                validPass.charAt(i) == 'o' || validPass.charAt(i) == 'u') {
                    validPass = validPass.replace(validPass.charAt(i), '*');
            }//end if
        }//end for

        validPass = validPass.substring(0, 1).toUpperCase() + validPass.substring(1);
        return validPass;
    }//end method setPassword

    public void printDetails() {
        System.out.println("Employee Details");
        System.out.println("Name\t\t: " + name);
        System.out.println("Username\t: " + username);
        System.out.println("Email\t\t: " + email);
        System.out.println("Password\t: " + password);
    }//end method printDetails
}