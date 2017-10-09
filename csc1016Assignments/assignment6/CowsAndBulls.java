/*********************************************************
*  Game Class that uses NumberUtils class                *
*  Name: Tiro Modibedi                                   *
*  Student Number: MDBTIR001                             *
*  Date: 04-10-2017                                      *
*********************************************************/
public class CowsAndBulls{
  // instance variables
  private NumberPicker numberPicker;
  private int mysteryValue;
  private int guesses;
  private int lastGuess;
  // constants
  public final static int NUM_DIGITS = 4;
  public final static int MAX_VALUE = 9876;
  public final static int MIN_VALUE = 1234;
  public final static int MAX_GUESSES = 10;

  // contructor
  public CowsAndBulls(int seed){
    numberPicker = new NumberPicker(seed, 1, 9);
    this.guesses = MAX_GUESSES;
    this.mysteryValue = numberPicker.nextInt();
    if (!(mysteryValue >= MAX_VALUE && mysteryValue <= MIN_VALUE)) {
      for (int i = 0; i < NUM_DIGITS - 1; i++) {
         mysteryValue = mysteryValue*10 + numberPicker.nextInt();
      }
    }
    /*
    do {
      for (int i = 0; i < NUM_DIGITS - 1; i++) {
         mysteryValue = mysteryValue*10 + numberPicker.nextInt();
      }
      break;
    } while (!(mysteryValue >= MAX_VALUE && mysteryValue <= MIN_VALUE)); */
  }

  public int guessesRemaining(){
    return guesses;
  }

  public Result guess(int myGuess){
    guesses--;
    int bulls = NumberUtils.countMatches(myGuess, mysteryValue);
    int cows = NumberUtils.countIntersect(myGuess, mysteryValue) - bulls;
    Result result = new Result(cows, bulls);
    lastGuess = myGuess;
    return result;
  }

  public int giveUp(){
    guesses = 0;
    return mysteryValue;
  }

  public boolean gameOver(){
    return (guesses == 0 || (lastGuess == mysteryValue));
  }

}
