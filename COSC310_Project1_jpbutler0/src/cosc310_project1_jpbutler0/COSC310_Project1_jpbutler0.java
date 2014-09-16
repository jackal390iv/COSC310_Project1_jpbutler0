package cosc310_project1_jpbutler0;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Reaper
 */
public class COSC310_Project1_jpbutler0 {

    public static void main(String[] args) {

        Boolean pass = true;
        String paper;
        String input;
        ArrayList<String> inputFile = new ArrayList<String>();
        int theSize = 0;
        Scanner scanint = new Scanner(System.in);
        Scanner scanstr = new Scanner(System.in);

        System.out
                .println("Greetings, please enter a valid size for your sequence array: ");
        theSize = scanint.nextInt();

        System.out
                .println("Thank you. Now please enter a valid path to your input file: ");

        do {

            input = scanstr.nextLine().trim();

            try {
                FileReader FR = new FileReader(input);
                BufferedReader BR = new BufferedReader(FR);

                while ((paper = BR.readLine()) != null) {
                    paper = paper.toUpperCase().trim();

                    if (!(paper.isEmpty())) {
                        inputFile.add(paper);
                    }

                }
                pass = true;
            } catch (Exception e) {
                System.out
                        .println("Error: "
                                + e.getMessage()
                                + "\n"
                                + "I'm sorry, the path you have given is invalid. Please try again: ");
                pass = false;
            }
        } while (pass == false);

        SequenceArray.test(theSize, inputFile);
    }
}
