/*********************************************************
*  Cow Class to implement the MakeSound Interface        *
*  Name: Tiro Modibedi                                   *
*  Student Number: MDBTIR001                             *
*  Date: 12-10-2017                                      *
*********************************************************/
public class Cow implements MakesSound{
  private String sound;

  public Cow(){
    this.sound = "Moo!";
  }

  public String makeNoise(){
    return sound;
  }
}
