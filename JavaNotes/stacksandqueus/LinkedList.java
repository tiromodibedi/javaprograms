public class LinkedList{
  public Node head;

  public LinkedList(){
    this.head = null;
  }

  // check if LinkedList is empty
  public boolean isEmpty(){
    return head==null;
  }

  /*  How to insert a New Node into the LinkedList
  **  1. New Node is created
  **  2. It's next is assigned the reference to the previous Node created
  **  3. The LinkedList's head Node is assigned reference to the newest Node. */
  public void insertFirstNode(String bookName, int millionsSold){
    Node newNode = new Node(bookName, millionsSold); // new Node
    newNode.next = head;
    head = newNode;
  }




}
