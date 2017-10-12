/*********************************************************
*  Cat Class to implement the MakeSound Interface        *
*  Name: Tiro Modibedi                                   *
*  Student Number: MDBTIR001                             *
*  Date: 12-10-2017                                      *
*********************************************************/
public class Cat implements MakesSound{
  private String sound;

  public Cat(){
    this.sound = "Meeow";
  }

  public String makeNoise(){
    return sound;
  }
}
