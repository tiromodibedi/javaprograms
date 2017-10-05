/*********************************************************
*  Order For Customer                                    *
*  Name: Tiro Modibedi                                   *
*  Student Number: MDBTIR001                             *
*  Date: 20-09-2017                                      *
*********************************************************/
public class Item{
  private String menuItemNo;
  private String size;

  // constructors
  public Item(String menuItemNo, String size){
    this.menuItemNo = menuItemNo;
    this.size = size;
  }

  // mutator methods
  public void setMenuItemNo(String num){
    this.menuItemNo = num;
  }
  public void setSize(String size){
    this.size = size;
  }

  // accessor methods
  public String getMenuItemNo(){
    return menuItemNo;
  }
  public String getSize(){
    return size;
  }
  public String toString(){
    return menuItemNo + " " + size;
  }
}
