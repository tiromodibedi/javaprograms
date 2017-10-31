public class Node{
  public String bookName;
  public int millionsSold;
  public Node next;

  public Node(String bookName, int millionsSold){
    this.bookName = bookName;
    this.millionsSold = millionsSold;
  }

  public void display(){
    System.out.println(bookName + ": " + millionsSold + " 000 000");
  }

  public String toString(){
    return bookName;
  }
}
