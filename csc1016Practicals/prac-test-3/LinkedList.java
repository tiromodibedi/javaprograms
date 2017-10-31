public class LinkedList {
   protected Node head;

   public LinkedList () { head = null; }

   public void add ( int number ) {
      Node t = new Node (number);
      t.setNext (head);
      head = t;
   }

   public String toString () {
      Node t = head;
      if (t==null) {
          return "";
      }
      else {
          String list = t.toString();
          while (t.hasNext()) {
              t=t.getNext();
              list=list+" "+t.toString();
          }
          return list;
      }
   }
}
