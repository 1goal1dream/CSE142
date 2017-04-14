// Thomas You
// CSE142
// 4/11/17
// Creates a program to calculate which applicant is better via using weighted SAT/GPA/ACT scores

import java.util.Scanner;

public class Admit {
    
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        introduction();
        double scoreA = applicants(console, 1);
        double scoreB = applicants(console, 2);
        compareStudents(scoreA, scoreB);
    }
    
    // brief introduction of this program.
    public static void introduction() {
        System.out.println("This program compares two applicants to");
        System.out.println("determine which one seems like the stronger");
        System.out.println("applicant.  For each candidate I will need");
        System.out.println("either SAT or ACT scores plus a weighted GPA.");
        System.out.println();
    }
    
    // returns the adjusted SAT/ACT score and the weighted score of the student.
    public static double applicants(Scanner console, int applicant) {
        System.out.println("Information for applicant #" + applicant + ":");
            System.out.print("do you have 1) SAT scores or 2) ACT scores? ");
        int test = console.nextInt();
        double examScore = 0.0;
        double GPAScore = 0.0;
        double finalScore = 0.0;
        if (test == 1) {
            examScore = takeSAT(console);
        } else {
            examScore = takeACT(console);
        }
        System.out.println("exam score = " + round(examScore));
        GPAScore = findGPA(console);
        System.out.println("GPA score = " + round(GPAScore) + "\n");
        finalScore = round(examScore + GPAScore);
        return finalScore;
    }
    
    // calculates the SAT score of the given student.
    public static double takeSAT(Scanner console) {
        System.out.print("SAT math? ");
        int math = console.nextInt();
        System.out.print("SAT critical reading? ");
        int reading = console.nextInt();
        System.out.print("SAT writing? ");
        int writing = console.nextInt();
        double total = (2 * math + reading + writing) / 32.0;
        return total;
    }
    
    // finds the ACT sscore of the given student.
    public static double takeACT(Scanner console) {
        System.out.print("ACT english? ");
        int english = console.nextInt();
        System.out.print("ACT math? ");
        int math = console.nextInt();
        System.out.print("ACT reading? ");
        int reading = console.nextInt();
        System.out.print("ACT writing? ");
        int writing = console.nextInt();
        double total = (english + 2 * math + reading + writing) / 1.8;
        return total;
    }
    
    // finds the weighted GPA of the student.
    public static double findGPA(Scanner console) {
        System.out.print("overall GPA? ");
        double GPA = console.nextDouble();
        System.out.print("max GPA? ");
        double maxGPA = console.nextDouble();
        System.out.print("Transcript Multiplier? ");
        double weight = console.nextDouble();
        double weightedGPA = (GPA / maxGPA) * 100 * weight;
        return weightedGPA;
    }
    
    // compares the two student overall score and prints out which applicant is
    // better.
    public static void compareStudents(double student1, double student2) {
        System.out.println("First applicant overall score  = " + student1);
        System.out.println("Second applicant overall score = " + student2);
        if (student1 < student2) {
            System.out.println("The second applicant seems to be better");
        } else if (student1 > student2) {
            System.out.println("The first applicant seems to be better");
        } else {
            System.out.println("The two applicants seem to be equal");
        }
    }
    
    // round number to 1 decimal point.
    public static double round(double num) {
        return Math.round(num * 10.0) / 10.0;
    }
}
