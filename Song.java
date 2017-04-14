// Thomas You
// 4/10/17
// CSE 142
// Creates a song

public class Song {
    public static void main(String[] args) {
        fly();
        spider();
        bird();
        cat();
        dog();
        monkey();
        last();
    }
    
    public static void fly() {
        System.out.println("There was an old woman who swallowed a fly.");
        chorus();
    }
    
    public static void chorus() {
        System.out.println("I don't know why she swallowed that fly,");
        System.out.println("Perhaps she'll die.");
        System.out.println();
    }
    
    public static void chorus1() {
        System.out.println("She swallowed the spider to catch the fly,");
        chorus();
    }
    
    public static void spider() {
        System.out.println("There was an old woman who swallowed a spider,");
        System.out.println("That wriggled and iggled and jiggled inside her.");
        chorus1();
    }
    
    public static void chorus2() {
        System.out.println("She swallowed the bird to catch the spider,");
        chorus1();
    }
    
    public static void bird() {
        System.out.println("There was an old woman who swallowed a bird,");
        System.out.println("How absurd to swallow a bird.");
        chorus2();
    }
    
    public static void chorus3() {
        System.out.println("She swallowed the cat to catch the bird,");
        chorus2();
    }
    
    public static void cat() {
        System.out.println("There was an old woman who swallowed a cat,");
        System.out.println("Imagine that to swallow a cat.");
        chorus3();
    }
    
    public static void chorus4() {
        System.out.println("She swallowed the dog to catch the cat,");
        chorus3();
    }
    
    public static void dog() {
        System.out.println("There was an old woman who swallowed a dog,");
        System.out.println("What a hog to swallow a dog.");
        chorus4();
    }
    
    public static void chorus5() {
        System.out.println("She swallowed the monkey to catch the dog,");
        chorus4();
    }
    
    public static void monkey() {
        System.out.println("There was an old woman who swallowed a monkey,");
        System.out.println("He was quite chunky for a monkey.");
            chorus5();
    }
    
    public static void last() {
        System.out.println("There was an old woman who swallowed a horse,");
        System.out.println("She died of course.");
    }
}
