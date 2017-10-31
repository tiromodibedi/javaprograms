public class Solution extends LinkedList{
  // instance variables
  public int sum = 0;

  // constructor
  public Solution(){
    super();
  }
  // head.hasNext()
  // Add up Even numbers
  public int sumEven(){
    while (true) {
      if (head == null) {
        break;
      }
      if (isEven(head.getData())) {
        sum = sum + head.getData();
      }
      if (head.getNext() == null) {
        break;
      }
      head = head.getNext();
    }
    return sum;
  }

  public boolean isEven(int entry){
    if ((entry%2)==0) {
      return true;
    } else {
      return false;
    }
  }
}
