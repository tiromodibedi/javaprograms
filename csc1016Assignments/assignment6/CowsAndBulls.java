/*********************************************************
*  Game Class that uses NumberUtils class                *
*  Name: Tiro Modibedi                                   *
*  Student Number: MDBTIR001                             *
*  Date: 04-10-2017                                      *
*********************************************************/
public class CowsAndBulls{
  // instance variables
  private NumberPicker numberPicker;
  private int guessValue;
  private int guesses;

  // constants
  public final static int NUM_DIGITS = 4;
  public final static int MAX_VALUE = 9876;
  public final static int MIN_VALUE = 1234;
  public final static int MAX_GUESSES = 10;

  // contructors
  public CowsAndBulls(int seed){
    numberPicker = new NumberPicker(seed, MIN_VALUE, MAX_VALUE);
    this.guessValue = numberPicker.nextInt();
    this.guesses = MAX_GUESSES;
  }

  public int guessesRemaining(){
    return guesses;
  }

  public Result guess(int guessNumber){
    int value = numberPicker.nextInt();
    int bulls = NumberUtils.countMatches(guessNumber, value);
    int cows = NumberUtils.countIntersect(guessNumber, value);
    Result result = new Result(cows, bulls);
    guesses--;
    return result;
  }

  public int giveUp(){
    return guessValue;
  }

  public boolean gameOver(){
    return guesses == 0;
  }

}
