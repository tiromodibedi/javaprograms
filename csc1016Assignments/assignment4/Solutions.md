## Exercise Two
* Fynbos Flower Company Employee Specification

#### Employee Class
```java
public class Employee{
  // Instance Variables
  private String name;
  private String id;

  // constructor
  public Employee(String name, String id){
    //
  }
  // Methods
  public void signIn(DateTime time){
    // record the sign in time of an employee
    // pass in the DateTime object
  }
  public void signOut(DateTime time){
    // record sign out time of an employee
  }
  public boolean isPresent(){
    // Checks if an employee is peresent
  }
  public int weeklyHours(){
    // Logic for getting total weeklyHours of an employee
  }
  public Shift (){
    // Logic for returning a weekly collection of shifts for an employee
  }
}
```

#### DateTime Class
* The Employee class as well as the Shift class depend on the DateTime Class.

```java
public class DateTime{
  // Instance Variables
  private String time;
  private int day;
  private int month;
  private int year;

  // Constructor
  public DateTime(String time, int day, int month, int year){
    // set values of a DateTime object
  }
  public setTime(String time){
    // implement logic to set the time
  }
  public String getTime(){
    // get the value of the time
  }
  public int getDay(){
    // get the day
  }
  public int getMonth(){
    // get the day
  }
  public int getYear(){
    // get the day
  }
}
```


#### Shift Class
* This class is a dependency for the Employee class

```java
public class Shift{
  // Instance Variables
  private DateTime timeIn;
  private DateTime timeOut;
  private int shiftDuration;

  // Constructor
  public Shift(DateTime timeIn, DateTime timeOut, duration){
    // record a shift
  }
  // Methods
  public setStartTime(DateTime time){
    // Mutator method for setting the Start of a Shift
  }
  public setStartTime(DateTime time){
    // Mutator method for setting the End of a Shift
  }
  public DateTime getStartTime(){
    // Accessor method for the start timeIn
  }
  public DateTime getEndTime(){
    // Accessor method for the End time of a shift
  }
  public int getShiftDuration(){
    // implement logic for retrieving the duration of a shift
  }
}

```
#### Shift collection Class
* A shift collection to store shifts for a particular employee for the whole week.
* Use a JSON Object to store each shift as a json Object e.g {day:3, startShift: "09:30", endShift:"11:30", duration: }

```java
import org.json.JSONObject;

public class ShiftCollection{
  // instance variable Json array object to store the shift information
  private JSONArray array;
  // constructor
  public ShiftCollection(){
    // set an empty json array
    JSONArray array = new JSONArray();
  }
  // Methods
  public addShift(Shift shift){
    // Implement Logic for adding a shift to the shift collection array
  }
  public JSONArray ShiftCollection(){
    // get an array of Json objects about the shifts for a week
  }
}

```
