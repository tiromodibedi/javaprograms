## Inheritance
* is the practice of passing on property, titles, debts, rights, and obligations of an induvidual to their successor.

## Example of Inheritance
```java
/*
*                               Animals
*                  ________________|________________
*                  |                               |
*             Vertebrates                     Invertebrates
*     _____________|_______________                
*     |       |        |          |
*   Fish    Birds   Mammals   Reptiles
*                   |-> Humans
*                   |-> dogs
*/
```
* In this example the parent `class` is animals and there are two sub-classes (Vertebrates and Invertebrates)
* Vertebrates and Invertebrates are sub-classes of `animals` and they inherit general properties of animals
* However the two sub-classes have their own distinct properties
* Also the two sub-classes also have sub-classes of their own.

## Inheritance in OOP
* Inheritance is one of the main Techniques of **Object Oriented Programming**
* In java Inheritance involves the creation of a `general class (super class)` and then more specialized classes (`sub-classes`) are created which extend the functionality of the `super class`

#### Formal Definition
* Inheritance is the process by which a new class is created from another class.
  * The new class is called the `child class` or derived class.
  * The original class is called the `parent class` or base class.
* The `child class` automatically has all the instance variables and methods of the `parent class` and it can also have it's own additional methods and/or instance variables.

#### Why use Inheritance
* Simply put! To get rid of redundancy.
  * If there are objects that share properties, instead of defining the properties they have in common in classes that define each object a `PARENT CLASS` is created which defines properties shared by child objects. Since child classes have access to all methods and instance variables in the parent class then they have access to the properties.

## Class Hierarchy
* Look at an example below that demonstrates Hierarchy associated with grouping classes.

```java
/*
*                                           Employee
*                         ______________________|____________________
*                         |                                         |
*                   HourlyEmployee                           SalariedEmployee
*             ____________|____________                     ________|________              
*             |                       |                     |               |
*   FullTimeHourlyEmployee     PartTimeEmployee       TechnicalStaff    Executive
*                                                           |
*                                             ______________|________________
*                                             |             |               |
*                                         Engineer     Technician     ClericalStaff
*                  
*/
```
* An `HourlyEmployee` is an `Employee`. It is defined as the derived(child) class of the class Employee (parent).
* This is how to define a child class in Java:

```java
public class HourlyEmployee extends Employee{
  // do stuff
}
```

## Simple Implementation of the Logic Above
* The **Parent Class** => `Employee Class`

```java
public class Employee{
  private String name;
  private Date hireDate;

  // constructors
  public Employee(){
    name = "No Name";
    hireDate = new Date ("Jan", 1, 1000);
  }
  public  Employee(String theName, Date theDate){
    if (theName == null || theDate == null) {
      System.out.println("Fatal ERROR in creating Employee.");
      System.exit(0)
    }
    name = theName;
    hireDate = new Date(theDate);
  }
  // methods
  public String getName(){}
  public Date getHireDate(){}
}
```
* Now this is a simple Implementation of the Employee class and each Employee has a name and a the date in which they were hired.
* Now let's create a child class to extends the Employee (parent) class.

```java
public class HourlyEmployee extends Employee{
  private double wageRate;
  private double Hours; // for the month

  // constructors
  public HourlyEmployee(){
    super();
    wageRate = 0;
    hours = 0;
  }
  public HourlyEmployee(String theName, Date theDate, double theWageRate, double theHours){
    super(theName, theDate);
    if ((theWageRate >= 0) && (theHours >= 0)) {
      wageRate = theWageRate;
      hours = theHours;
    } else {
      System.out.println("Fatal ERROR in creating Employee.");
      System.exit(0);
    }
  }
}
```
* Class Employee defines the instance variables name and hireDate.
* Class HourlyEmployee (child class) has access to the instance variables stated above even though they are not specified in its class definition.
* Class HourlyEmployee has additional Instance variables: wageRate and Hours that are specified in its class definition.
* Class HourlyEmployee also inherits Class Employee's Methods and an object of HourlyEmployee can invoke a call to the methods in the parent class.

## Derived classes

#### Overiding a Method Definition
* Although a child class inherits methods from parent it can change or overide an inherited method if necessary
  * In order to overide a method a new definition of the method is placed in child class just like any other method
* example
```java
public class Parent{
  /* Method to be Overidden */
  public String toSring(){
    return "Hello World";
  }
}

public class Child extends Parent{
  /* Overiding the toString() Method */
  public String toString(){
    return "Hello Word.. I am the child";
  }
}

```

#### Overiding the return Type of an Overidden Method
* Typically the type returned may not be changed when Overiding a method.
* However a method in a subclass may return an object whose type is a subclass of the type returned by the method with the same signature in the superclass.
  * This feature removes the need for excessive type checking and casting.
* Example
  * In this example; in the child class the method `getSomeone()` is Overidden and it's return type is changed.. Note that the return type is changed from `Employee` to `HourlyEmployee`... this is `LEGAL` => the Overidden method is an object whose type(HourlyEmployee) is a subclass of the type(Employee) returned by the original method in the superclass.
```java
/*  PARENT CLASS  */
public class Employee{
  public Employee getSomeone(long id){
    .....
  }
}

/* CHILD CLASS  */
public class HourlyEmployee extends Employee{
  public HourlyEmployee getSomeone(long id){
    ....
  }
}
```
