// Thomas You
// CSE142
// 4/11/17
// Draw a rocket ship of any size

public class DrawRocket {
    public static final int SIZE = 3;
    
    public static void main(String[] args) {
        tail();
        combineTop();
        combineBot();
        tail();
    }
    
    // combine various shapes to create top of rocket
    public static void combineTop() {
        line();
        top();
        bot();
        line();
    }
    
    // combines various shapes to create bottom of rocket
    public static void combineBot() {
        bot();
        top();
        line();
    }
    
    // creates the line shape of the rocket
    public static void line() {
        System.out.print("+");
        for (int i = 1; i <= SIZE * 2; i++) {
            System.out.print("=*");
        }
        System.out.println("+");
    }
    
    // creates the rocket tail shape
    public static void tail() {
        for (int line = 1; line <= SIZE * 2 - 1; line++) {
            for (int i = SIZE * 2 - 1; i >= line; i--) {
                System.out.print(" ");
            }
            for (int j = 1; j <= line; j++) {
                System.out.print("/");
            }
            System.out.print("**");
            for (int a = 1; a <= line; a++) {
                System.out.print("\\");
            }
            for (int i = 5; i >= line; i--) {
                System.out.print(" ");
            }
            System.out.println();
        }
    }
    
    // creates the top pattern of the rocket body
    public static void top() {
        for (int line = 1; line <= SIZE; line++) {
            System.out.print("|");
            for (int loop = 1; loop <= 2; loop++) {
                for (int i = SIZE - 1; i >= line; i--) {
                    System.out.print(".");
                }
                for (int j = 1; j <= line; j++) {
                    System.out.print("/\\");
                }
                for (int k = SIZE - 1; k >= line; k--) {
                    System.out.print(".");
                }
            }
            System.out.println("|");
        }
    }
    
    // creates the bottom pattern of the rocket body
    public static void bot() {
        for (int line = 1; line <= SIZE; line++) {
            System.out.print("|");
            for (int loop = 1; loop <= 2; loop++) {
                for (int i = 1; i < line; i++) {
                    System.out.print(".");
                }
                for (int j = SIZE; j >= line; j--) {
                    System.out.print("\\/");
                }
                for (int k = 1; k < line; k++) {
                    System.out.print(".");
                }
            }
            System.out.println("|");
        }
    }
}
