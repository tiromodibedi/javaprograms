/*********************************************************
*  Student Class Program                                 *
*  name: Tiro Modibedi                                   *
*  Student Number: MDBTIR001                             *
*  Date: 26-08-2017                                      *
*********************************************************/

public class Student{

  public String firstName, middleName, lastName, fullName;

  // setNames method
  public void setNames(String first, String middle, String last){
    firstName = first;
    middleName = middle;
    lastName = last;
  }

  // get fullName method
  public String getFullName(){
    String mid_init = middleName.substring(0,1);
    fullName = firstName + " " + mid_init + ". " + lastName;
    return fullName;
  }
}
