## Linked Lists Data Structures
* Capsules of data known as Nodes which are connected via Links
* The links are pointer/memory addresses of the next node/capsule

[12 | --]--> [99 | --]--> [37 | --]-->[X]

* It consists of single chain of Nodes
* Each Node contains data and a link to the next node. The link allows the lists
* ... to be traversed...
* The first Node is called the Head Node.
* The last Node is called the 'end' marker.

#### Advantages of Linked Lists
* They can grow dynamically as the program goes on (number of items increase)

#### Disadvantages of Linked Lists
* No direct access to data objects
  * need to iterate over all the Nodes starting a the head node until the desired item is found
* Computationally More expensive since each node needs to store a reference to the next Node

#### Minimal Components needed to work with Linked Lists and shit...
* Node Class
  * Item to store
  * Link to the Next Node
* Linked List Class
  * Insert Method = adds a new node to the list
  * Delete = deletes a node from the list
  * Size = returns the size of the Linked List
  * Contans = return true if an element is in the Linked List

#### NODE CLASS
```java
public class Node{
  private String item;
  private Node link;
  private int count;

  public Node(){
    link = null;
    item = null;
    count = 0;
  }

  public Node(String item, Node link, int count){
    this.item = item;
    this.link = link;
    this.count = count;
  }

  public void setData(String item, int count){
    this.item = item;
    this.count = count;
  }

  public setLink(Node link){
    this.link = link;
  }

  public  String getItem(){
    return item;
  }

  public int getCount(){
    return count;
  }

  public Node getLink(){
    return link;
  }
}
```

#### Sample Linked List class
* The head Node allows us to access the entire List.
* A variable of type Node is used to store the reference to the head node.
  * This variable is not the head node, nor is it a node
  * It simply contains a reference to the head node

```java
public class LinkedList{
  private Node head;

  public LinkedList(){
    head = null;
  }

  // Adds a node to start the list with specified Data
  // The added node will be the first node in the lists
  public void(String itemName, int itemCount){
    head = new Node(itemName, itemCount, head);
  }

  // Delete head Node
  public boolean deleteHeadNode(){
    if (head != null) {
      head = head.getLink();
      return true;
    }
    else {
      return false;
    }
  }

  // number of nodes in the list
  public int size(){
    int counter = 0;
    Node position = head;
    while(position != null){
      counter++;
      position = position.getLink();
    }
    return counter;
  }

  // contains
  public boolean contains(String item){
    return (find(item) =! null);
  }

  // Finds the first node conating the target item and return reference to that
  //...node.. if the target is not in the list null is returned.

  private Node find(String target){
    Node position = head;
    String itemAtPosition;
    while(position != null){
      itemAtPosition = position.getItem();
      if (itemAtPosition.equals(target)) {
        return position;
      }
      position = position.getLink();
    }
    return null;
  }

  private void outputList(){
    Node position = head;
    while(position != null){
      System.out.println(position.getItem() + " " + position.getCount());
      position = position.getLink();
    }
  }  
}

```
