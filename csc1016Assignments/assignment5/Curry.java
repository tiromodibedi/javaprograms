/*********************************************************
*  Curry Child Class for the order For Customer          *
*  Name: Tiro Modibedi                                   *
*  Student Number: MDBTIR001                             *
*  Date: 20-09-2017                                      *
*********************************************************/
public class Curry extends Item{
  private String curryType;

  // constructors
  public Curry(String menuItemNo, String size, String curryType){
    super(menuItemNo, size);
    this.curryType = curryType;
  }

  // methods
  public String toString(){
    return "Curry: " + getMenuItemNo() + ", " + getSize() + ", " + curryType;
  }
}
