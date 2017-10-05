/*********************************************************
*  Pizza Child Class for the order For Customer          *
*  Name: Tiro Modibedi                                   *
*  Student Number: MDBTIR001                             *
*  Date: 20-09-2017                                      *
*********************************************************/
public class Pizza extends Item{
  private String base;
  private String extraCheese;
  private String extraGarlic;

  // constructors
  public Pizza(String menuItemNo, String size, String base,
  String extraCheese, String extraGarlic){
    super(menuItemNo, size);
    this.base = base;
    this.extraCheese = extraCheese;
    this.extraGarlic = extraGarlic;
  }

  // methods
  public String toString(){
    return "Pizza: " + getMenuItemNo() + ", " + getSize() + ", " + base + ", "
     + extraCheese + ", " + extraGarlic;
  }


}
