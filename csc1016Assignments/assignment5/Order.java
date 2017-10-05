/*********************************************************
*  Order For Customer                                    *
*  Name: Tiro Modibedi                                   *
*  Student Number: MDBTIR001                             *
*  Date: 20-09-2017                                      *
*********************************************************/
import java.util.ArrayList;
public class Order{
  private ArrayList<Item> order = new ArrayList<Item>();

  // constructor
  public Order(){}

  // add item to order
  public void addItem(Item item){
    order.add(item);
  }
  public Item getItem(int index){
    return order.get(index);
  }

  public void clearOrder(){
    order.clear();
  }
  public boolean removeItem(String searchItemNo){
    for (int i = 0; i < order.size(); i++) {
      if (order.get(i).getMenuItemNo().equals(searchItemNo)) {
        order.remove(i);
        return true;
      }
    }
    return false;
  }
  public String toString(){
    String str = "";
    for (int i = 0; i < order.size(); i++) {
      str += order.get(i).toString() + "\n";
    }
    return str;
  }
}
