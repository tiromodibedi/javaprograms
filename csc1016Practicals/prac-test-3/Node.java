public class Node {
   private int data;
   private Node next;
   
   Node(int number) { data=number; }
   
   public Node getNext() { return next; }
   public void setNext(Node n) { next=n; }
   public boolean hasNext() { return next!=null; }
   
   public int getData() { return data; }
   public void setData(int number) { data=number; }   
   
   public String toString () { return ""+data; }
}
