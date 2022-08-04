package OE6_Cortez;

import java.util.regex.*;
import java.io.*;

public class AnswerKeyProblem {

    static String finalAnswers(String answers) {
        answers = answers.replaceAll("e", "b");
        answers = answers.replaceAll("E", "A");
        answers = answers.replaceAll("f", "c");
        answers = answers.replaceAll("F", "D");
        answers = answers.toLowerCase();
        return answers;
    }

    public static void main(String[] args) throws IOException{
        //read in the file provided by your teacher
        BufferedReader codedAnswers = new BufferedReader(
                new FileReader("OE6_Cortez/CodedAnswerKey.txt"));
        
        //initialize  String  line  as  the  first  line  of  the  file
        String line = codedAnswers.readLine();
        String answers = "";

        while (line != null) {
            if (line.matches("[a-fA-F]")) {
                answers += line;
                answers += " ";
            }//end if

            //read  the  next  line  of  the  file
            line = codedAnswers.readLine();
        }//endwhile
        codedAnswers.close();

        System.out.println("Initial Answers: " + answers);
        System.out.println("Final Answers:\t " + finalAnswers(answers));
    }//end main method
}//end class AnswerKeyProblem
