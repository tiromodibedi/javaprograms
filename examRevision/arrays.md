## Arrays

## Declare an array
```java
int[] ages; // declaring an array
ages = new int[5]; // initialising an array by setting it's size

/*  Or this can be done in one step */
int[] ages = new int[5];
```

## Storing Objects
* Create a student class to model a student.
* Now manipulate the class with Arrays
```java
public class Student{
  private String name;
  private String studentNumber;

  public Student(String name, String studentNumber){
    this.name = name;
    this.studentNumber;
  }

  public void setName(String name){
    this.name = name;
  }
  public void setStudentNumber(String studentNumber){
    this.studentNumber = studentNumber;
  }

  public String getName(){
    return name;
  }
  public String getStudentNumber(){
    return studentNumber;
  }
}
```

#### Storing Student Objects with Arrays
```java
Student[] students = new Student[2];

students[0] = new Student("Tiro", "MDBTIR001");
students[1] = new Student("Maria", "KETMAR001");

// Loop Through them
for (int i = 0; i <= students.length; i++) {
  System.out.println(students[0].getName());
}

// use forEach Loop
for (student : students) {
  System.out.println(student.getName());
}
```

#### Multidimensional Arrays
```java
int[][] grid = new int[3][4];

/*
 [[0,0,0,0], [0,0,0,0], [0,0,0,0]]
*/

for (int i = 0; i <= grid.length; i++) {
  for (int j = 0; j <= grid[i].length; j++) {
    System.out.println(grid[i][j]);
  }
}

```
