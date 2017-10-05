/*********************************************************
*  Car = Child Class for the Vehicle Class               *
*  Name: Tiro Modibedi                                   *
*  Student Number: MDBTIR001                             *
*  Date: 20-09-2017                                      *
*********************************************************/
public class Car extends Vehicle{
  // instance variables
  private int numDoors;

  // constructor
  public Car(String colour, int passengers, int doors){
    super(passengers, colour);
    this.numDoors = doors;
  }
  // methods
  public String toString(){
    return super.toString() + " " + numDoors +
    " doors";
  }
}
