/*********************************************************
*  Jump Record Program = record athlete's jumps          *
*  Name: Tiro Modibedi                                   *
*  Student Number: MDBTIR001                             *
*  Date: 03-09-2017                                      *
*********************************************************/
public class JumpRecord{
  private int maxNumOfJumps;
  private int numOfJumps;
  private int numOfFoulJumps;
  private boolean checkFinished;
  private double distance;
  private Double jump1;
  private Double jump2;
  private Double jump3;

  // constructor method
  public JumpRecord(){
    distance = 0;
    maxNumOfJumps = 3;
    numOfJumps = 0;
    jump1 = -1.0;
    jump2 = -1.0;
    jump3 = -1.0;
    checkFinished = false;
  }

  public void recordJump(double distance){
    do {
      if (jump1 == -1.0) {
        jump1 = distance;
        numOfJumps++;
        break;
      } else if (jump2 == -1.0) {
        jump2 = distance;
        numOfJumps++;
        break;
      } else if (jump3 == -1.0){
        jump3 = distance;
        numOfJumps++;
        break;
      } else;
    } while (numOfJumps <= 3);
  }

  public void recordFoulJump(){
    do {
      if (jump1 == -1.0) {
        jump1 = 0.0;
        numOfJumps++;
        numOfFoulJumps++;
        break;
      } else if (jump2 == -1.0) {
        jump2 = 0.0;
        numOfJumps++;
        numOfFoulJumps++;
        break;
      } else if (jump3 == -1.0){
        jump3 = 0.0;
        numOfJumps++;
        numOfFoulJumps++;
        break;
      } else;
    } while (numOfJumps <= 3);
  }

  public int jumps(){
    return numOfJumps;
  }

  public boolean finished(){
    return numOfJumps == maxNumOfJumps;
  }

  public int maxJumps(){
    return maxNumOfJumps;
  }

  public int foulJumps(){
    return numOfFoulJumps;
  }

  public boolean isFoulJump(int n){
    switch (n) {
      case 1: return (jump1 == 0.0);
      case 2: return (jump2 == 0.0);
      case 3: return (jump3 == 0.0);
      default: break;
    }
    return false;
  }
  public double getJumpDistance(int n){
    switch (n) {
      case 1: return jump1;
      case 2: return jump2;
      case 3: return jump3;
      default: break;
    }
    return -1;
  }
  public int getLongest(){
    double longest = Math.max(Math.max(jump1, jump2),jump3);
    if (numOfJumps > 0 && numOfFoulJumps < numOfJumps) {
      if (Math.abs(longest-jump1) <= 0.000001) {
        return 1;
      } else if (Math.abs(longest-jump2) <= 0.000001) {
        return 2;
      } else if (Math.abs(longest-jump3) <= 0.000001) {
        return 3;
      } else;
    }
    return -1;
  }




}

/*
public class JumpRecord{
  private double distance;
  private int maxNumOfJumps;
  private double distanceJumped;
  private boolean checkFinished;
  private int numOfJumps;
  private int numOfFoulJumps;

  // class constructor
  public JumpRecord(){
    // stuff
  }
  public void recordJump(double distance){
    this.distance = distance;
    numOfJumps++;
  }
  public void recordFoulJump(){
    // code here
  }
  public int jumps(){
    // code
    return -1;
  }
  public boolean finished(){
    // code and stuff
    return false;
  }
  public int maxJumps(){
    // code
    return -1;
  }
  public int foulJumps(){
    // your code here
    return -1;
  }
  public boolean isFoulJump(int n){
    // code
    return false;
  }
  public double getJumpDistance(int n){
    // code goes here
    return -1.0;
  }
  public int getLongest(){
    // code goes here
    return -1;
  }
}
*/
