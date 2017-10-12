/*********************************************************
*  Dog Class to implement the MakeSound Interface        *
*  Name: Tiro Modibedi                                   *
*  Student Number: MDBTIR001                             *
*  Date: 12-10-2017                                      *
*********************************************************/
public class Dog implements MakesSound{
  private String sound;

  public Dog(){
    this.sound = "Woof!";
  }

  public String makeNoise(){
    return sound;
  }
}
