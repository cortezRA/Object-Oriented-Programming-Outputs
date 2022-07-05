package OE5_Cortez.accountgenerator;

public class ReverseString {
    public static String reverse(String str) { 
        String strRev = "";
        for(int i = str.length()-1; i >= 0; i--) {
            strRev+=str.charAt(i);
        }//endfor
        return strRev;
    }//end method reverse
    
    public static String reverse2(String str) { 
        StringBuilder strRev = new StringBuilder();
        strRev.append(str);
        strRev.reverse();
        return strRev.toString();
    }//end method reverse2

    public static void main(String[] args) {
        String str = "Object-Oriented Programming";
        System.out.println(str);
        System.out.println(reverse(str));
        System.out.println(reverse(reverse(str)));

        String str2 = "Peanut Butter and Jelly Sandwich";
        System.out.println();
        System.out.println(str2);
        System.out.println(reverse2(str2));
        System.out.println(reverse2(reverse2(str2)));
    }
}
