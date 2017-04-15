
// Thomas You
// CSE 142
// 4/13/17
// searches for a baby name and gender and if it exists, graphs the popularity of the name throughout the decades.

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Name {
    public static final int DECADES = 10;
    public static final int START_YEAR = 1920;
    public static final int WIDTH = 90;

    public static void main(String[] args) throws FileNotFoundException {
        Scanner input = new Scanner(new File("names2.txt"));
        intro();
        String name = inputName();
        String line = findName(input, name);
        if (line != "") {
            DrawingPanel panel = new DrawingPanel(DECADES * WIDTH, 550);
            Graphics g = panel.getGraphics();
            g.setFont(new Font("Arial", Font.PLAIN, 12));
            createGraph(g);
            plotGraph(g, line);
        } else {
            System.out.println("name/gender combination not found");
        }
    }

    // introduction
    public static void intro() {
        System.out.println("This program allows you to search through the");
        System.out.println("data from the Social Security Administration");
        System.out.println("to see how popular a particular name has been");
        System.out.println("since " + START_YEAR + ".");
    }

    // asks user for baby name and gender
    public static String inputName() {
        Scanner console = new Scanner(System.in);
        System.out.print("name? ");
        String name = console.next().toLowerCase();
        System.out.print("gender (M or F)? ");
        String gender = console.next().toLowerCase();
        String nameGender = "" + name + " " + gender;
        return nameGender;
    }

    // draws the graph with the baby name and rank in red
    public static void plotGraph(Graphics g, String line) {
        Scanner lineScan = new Scanner(line);
        String name = lineScan.next();
        String gender = lineScan.next();
        String combo = "" + name + " " + gender + " ";
        int number = 0;
        int x2 = 0;
        int y2 = 0;
        g.setColor(Color.RED);
        for (int i = 0; i < DECADES; i++) {
            if (lineScan.hasNextInt()) {
                number = lineScan.nextInt();
            }
            int coordinate = 0;
            if (number == 0) {
                coordinate = 525;
            } else if (number % 2 == 0) {
                coordinate = 25 + number / 2 - 1;
            } else {
                coordinate = 25 + number / 2;
            }
            g.drawString(combo + number, WIDTH * i, coordinate);
            if (i > 0) {
                g.drawLine(WIDTH * i, coordinate, x2, y2);
            }
            x2 = WIDTH * i;
            y2 = coordinate;
        }
    }

    // draws the grid-like background
    public static void createGraph(Graphics g) {
        int xSize = DECADES * WIDTH;
        int year = START_YEAR;
        g.drawLine(0, 25, xSize, 25);
        g.drawLine(0, 525, xSize, 525);
        g.drawString("" + year, 0, 550);
        for (int i = 0; i < DECADES; i++) {
            year += 10;
            String decades = "" + year;
            g.drawLine(WIDTH * i, 0, WIDTH * i, 550);
            if (i > 0) {
                g.drawString(decades, WIDTH * i, 550);
            }
        }
    }

    // takes the user input of the baby name and gender they are looking for and
    // compare it to the text file
    // and returns the baby name and ranking.
    public static String findName(Scanner input, String name) {
        while (input.hasNextLine()) {
            String line = input.nextLine();
            Scanner lineScan = new Scanner(line);
            String fileName = lineScan.next().toLowerCase();
            String fileGender = lineScan.next().toLowerCase();
            String fileFound = "" + fileName + " " + fileGender;
            while (lineScan.hasNextInt()) {
                int number = lineScan.nextInt();
            }
            if (name.equals(fileFound)) {
                return line;
            }
        }
        return "";
    }
}
