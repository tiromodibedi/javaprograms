/*********************************************************
*  SoftDrink class for soft drinks objects               *
*  Name: Tiro Modibedi                                   *
*  Student Number: MDBTIR001                             *
*  Date: 12-10-2017                                      *
*********************************************************/
import java.util.*;
import java.lang.*;

public class SoftDrink implements Comparable<SoftDrink>{
  /*  Instance Variables  */
  private String name;
  private String colour;
  private int volume;

  /*  Constructor   */
  public SoftDrink (String name, String colour, int volume){
    this.name = name;
    this.colour = colour;
    this.volume = volume;
  }

  /*  Accessor Methods  */
  public String getName(){  return name;  }
  public String getColour(){ return colour;  }
  public int getVolume(){  return volume;   }

  public int compareTo(SoftDrink other){
    if ((this.name).equals(other.name)) {
      if ((this.colour).equals(other.colour)) {
        if ((this.volume) == other.volume) {
          return 0;
        } else if ((this.volume) > other.volume){
          return 1;
        } else {
          return -1;
        }
      } else {
        return (this.colour).compareTo(other.colour);
      }
    } else {
      return (this.name).compareTo(other.name);
    }
    /*
    return Comparator.comparing(SoftDrink::getName)
              .thenComparing(SoftDrink::getColour)
              .thenComparingInt(SoftDrink::getVolume)
              .compare(this, other);
    //return (this.name).compareTo(other.name);*/
  }

  public String toString(){
    return this.name + " " + this. colour + " " + this.volume;
  }
}
