
// Thomas You
// 4/19/17
// CSE 142
// Assignment 6

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.Scanner;

public class Personality {
    public static final int NUM = 4;

    public static void main(String[] args) throws FileNotFoundException {
        Scanner console = new Scanner(System.in);
        intro();
        System.out.print("input file name? ");
        String inputFile = console.nextLine();
        Scanner input = new Scanner(new File(inputFile));
        System.out.print("output file name? ");
        String outputFile = console.nextLine();
        PrintStream out = new PrintStream(new File(outputFile));
        translateString(input, out);
    }

    // reads a file and translates the string into a personality type.
    public static void translateString(Scanner input, PrintStream out) {
        while (input.hasNextLine()) {
            String line = input.nextLine();
            out.print(line + ": ");
            String line2 = input.nextLine().toUpperCase();
            int[] countA = countString(line2, 'A');
            int[] countB = countString(line2, 'B');
            int[] percentageOfB = findPercentage(countA, countB);
            String personality = personalityType(percentageOfB);
            out.print(Arrays.toString(percentageOfB));
            out.println(" = " + personality);
        }
    }

    // takes the percentage of Bs found in the String and convert it into the
    // standard personality type.
    public static String personalityType(int[] b) {
        String s = "";
        String[] a1 = { "E", "S", "T", "J" };
        String[] a2 = { "I", "N", "F", "P" };
        for (int i = 0; i < NUM; i++) {
            if (b[i] == 50) {
                s += "X";
            }
            if (b[i] > 50) {
                s += a2[i];
            }
            if (b[i] < 50) {
                s += a1[i];
            }
        }
        return s;
    }

    // returns the percentage of A and B letters in the string
    public static int[] findPercentage(int[] a, int[] b) {
        int[] percentageB = new int[NUM];
        for (int i = 0; i < NUM; i++) {
            int percentage = (int) Math.round(100.0 * b[i] / (a[i] + b[i]));
            percentageB[i] = percentage;
        }
        return percentageB;
    }

    // returns the number of A and B letters in the string
    public static int[] countString(String line, char letter) {
        int[] trackCount = new int[NUM];
        for (int i = 0; i < line.length(); i++) {
            if (line.charAt(i) == letter) {
                if (i % 7 == 0) {
                    trackCount[0]++;
                } else if (i % 7 == 1 || i % 7 == 2) {
                    trackCount[1]++;
                } else if (i % 7 == 3 || i % 7 == 4) {
                    trackCount[2]++;
                } else if (i % 7 == 5 || i % 7 == 6) {
                    trackCount[3]++;
                }
            }
        }
        return trackCount;
    }

    // small introduction to the program
    public static void intro() {
        System.out.println("This program processes a file of answers to the");
        System.out.println("Keirsey Temperament Sorter.  It converts the");
        System.out.println("various A and B answers for each person into");
        System.out.println("a sequence of B-percentages and then into a");
        System.out.println("four-letter personality type.");
    }
}