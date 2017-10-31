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

#### Changing the Access Permission of an Overidden Method
* This is allowed (private ==> public)
  * PARENT CLASS:    `private void doStuff()`
  * CHILD CLASS:     'public void doStuff()'
* This is not allowed (public ==> private)
  * PARENT CLASS:    `public void doStuff()`
  * CHILD CLASS:     'private void doStuff()'

#### Overiding Vs Overloading
* Overiding
  * The new method in child class has exact same number and type of parameters as in parent class
  * PARENT: `public Int getNumber()`
  * CHILD:  `public Int getNumber()`
* Overloading
  * The new method in child class has different signature from method in parent class.
  * PARENT: `public Int getNumber()`
  * CHILD:  `public Int getNumber(int index)`
  * **NOTE:** When a child class overloads a method, it still inherits the original method from the parent class as well.

#### The Final Modifier
* If it's placed before any method definition then that method my not be redefined(Overidden) in a child class. However they can still be overloaded
* If it's placed in front of a class definition then that class cannot be used as a parent class to derive other classes.

#### The Super Constructor
* A child class uses the `super` keyword to invoke a Constructor of its parent class.
* Example: `super(a, b)` is a call to the parent class constructor
```java
public childClass(int a, int b, long number){
  super(a, b); // invoke the parent class Constructor
  this.number = number; // initialize instance variable
}
```
* A call to super should be the first action taken in the child class constructor definition
* A child instance variable `CANNOT` be used as an argument to super()
* If a child class constructor does not invoke the `super()` constructor then the parent no-argument constructor will be automatically invoked
  * NB: This can result in an error if the parent class does not have the `no-argument` constructor definition

#### The `this` Constructor
* From within a constructor in a class you can use the `this()` keyword to call another constructor in the same class.
* Doing this is called `Explicit Constructor Invocation`
* Example
```java
public class Rectangle {
    private int x, y;
    private int width, height;

    public Rectangle() {
        this(0, 0, 1, 1);
    }
    public Rectangle(int width, int height) {
        this(0, 0, width, height);
    }
    public Rectangle(int x, int y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }
}
```

#### Some Tips when dealing with Constructors
* An object of a child class has the type of the `child` and also the type of the `parent` class
* An object of a child class hsa the type of any `ancestor` class above it in the Hierarchy.
  * So the object of child class can be assigned to a variable of any ancestor type
* An object of a child class can be plugged in as a parameter in place of any of its ancestor types
* An object of a child class can be used anyplace that an object of any of its ancestor types can be used.
  *  **NB:** This relationship does not go the other way around.
