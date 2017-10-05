/*********************************************************
*  Soft Drink Child Class for the order For Customer     *
*  Name: Tiro Modibedi                                   *
*  Student Number: MDBTIR001                             *
*  Date: 20-09-2017                                      *
*********************************************************/
public class SoftDrink extends Item{
  private String flavour;
  private String container;

  // constructors
  public SoftDrink(String menuItemNo, String size, String flavour,
  String container){
    super(menuItemNo, size);
    this.flavour = flavour;
    this.container = container;
  }

  // methods
  public String toString(){
    return "Soft Drink: " + getMenuItemNo() + ", " + getSize() + ", " + flavour + ", "
     + container;
  }
}
