// Thomas You
// CSE 143
// 5/6/17
// Guitar37

public class Guitar37 implements Guitar {
   public static final String KEYBOARD =
            "q2we4r5ty7u8i9op-[=zxdcfvgbnjmk,.;/' ";
   private GuitarString[] notes;

    // creates an array of guitarStrings ranging from 0 to 880hz.
   public Guitar37() {
      notes = new GuitarString[37];
      for(int i = 0; i < 37; i++) {
         notes[i] = new GuitarString(440.0 * Math.pow(2, ((i - 24) / 12.0)));
      }  
   }

   // converts the pitch to the given note.
   public void playNote(int pitch) {
      if(pitch > 12 && pitch < 25) {
         notes[pitch + 12].pluck();
      }
   }

   // checks if whether the string contains the character or not.
   public boolean hasString(char string) {
      return(KEYBOARD.indexOf(string) != -1);
   }
   
   // if the character is in our given keyboard string, then play that character.
   // if not, throw an illegalArgumentException
   public void pluck(char string) {
      if(hasString(string)) {
         notes[KEYBOARD.indexOf(string)].pluck();
      } 
      else {
         throw new IllegalArgumentException();
      }
   }

   // adds up all the samples in the simulation and returns the value.
   public double sample() {
      double sampleSum = 0.0;
      for (GuitarString x : notes) {
         sampleSum += x.sample();
      }
      return sampleSum;
   }

   // moves the simulation along one tic per turn.
   public void tic() {
      for(GuitarString x: notes) {
         x.tic();
      }
   }
   
   // idk
   public int time() {
      return -1;  
   }
}