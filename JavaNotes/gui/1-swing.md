## Introduction to Swing
* A GUI (Graphical User Interface) - a windowing system that interacts with the User
* The Java AWT (Abstract Window Toolkit) - original package for creating GUI's
* The **Swing** package is an improved version of the AWT
  * it does not complete the AWT
  * Some AWT classes are replaced by Swing but some are still required
* Swing GUI's are designed using a form of OOP known as Event-Driven Programming

## Event-Driven Programming
* Programming style that uses signal-and-response approach to Programming
* An event is an object that acts as a signal to another object known as a listener
* Firing the Event => sending of an Event
  * The object the fires the event is often a GUI component such as a button that
  has been clicked

## Event Listeners (often GUI components)
* Listener Object performs some action in response to the event
  * A given **component** may have any number of **listeners**
  * Each listener may respond to a different kind of event, or multiple Listeners
  may respond to the same events

## Exception Objects
* It is an event: The throwing of an Exception is an example of Firing an event
* The listener for an Exception object is the **catch** block that catches the
event.

## Event Handlers
* It is a method beloging to a listener object that specifies what needs to happen
when the listener receives an event.

## Event Firing and Event Listening
* The Component(e.g. button) fires an event
* The listener(object) invokes an event Handler(method) with the event as the argument
```java
/*
|COMPONENT| --> {EVENT} --> |LISTENER|
*/
```

## Event Driven Programming
* Objects are created that can fire events
* Listener Objects are created that can react to events
* The program itself no longer determines the order in which things can occur
  * Instead the events determine that order
* The next thing that happens depends on the event that occurs
* Methods are created that will never be Explicitly invokes unless invoked by
events.

## The JFrame Class
* is in the javax.swing package
* `public JFrame()`: constructor that creates an object of class JFrame
* `public JFrame(String title)`: JFrame constructor with a title

#### The setDefaultCloseOperation() method
* Sets the action to occur when the window close button is clicked
* Thsi is how it is implemented:
```java
public void setDefaultCloseOperation(parameter)
```
* Choose one out of the following parameters
  * `JFrame.DO_NOTHING_ON_CLOSE` : JFrame does nothing. However if there are any
  registered window listeners they are invoked
  * `JFrame.HIDE_ON_CLOSE` : hide the frame after invoking any registered window
  listeners
  * `JFrame.DISPOSE_ON_CLOSE` : Hide and Dispose after invoking any registerd
  windows. When a window is disposed the window is eliminated but the program
  does not end.
  * `JFrame.EXIT_ON_CLOSE` : Exit the application using the System exit method.
  * if none of the parameters above are specified in the `setDefaultCloseOperation()`
  then the default parameter used is: `JFrame.HIDE_ON_CLOSE`

#### Some of the Methods in the JFrame Class
```java
/*  Set the size of the calling Frame in pixels  */
public void setSize(int width, int height)

/*  Set the title of the JFrame to the string in argument  */
public void setTitle()

/*  Add a component to the JFrame  */
public void add(Component componentAdded)

/*  Set the layout manager  */
public void setLayout(LayoutManager manager)

/*  Set the menubar for the calling frame  */
public void setJMenuBar(JMenuBar menubar)

/*  Eliminate the calling Frame and it's subcomponents  */
public void dispose()
```


## A simple Window
```java
import javax.swing.JFrame; // JFrame class is the javax.swing package
import javax.swing.JButton;

public class FirstSwingDemo{
  public static final int WIDTH = 300;
  public static final int HEIGHT = 200;

  public static void main(String[] args) {
    /*  Create JFrame window  */
    JFrame firstWindow = new JFrame();
    /*  Set the size in pixels  */
    firstWindow.setSize(WIDTH, HEIGHT);
    /*  close-window button does nothing
    **  if this were not the case then on close the parameter HIDE_ON_CLOSE
    **  would be used but it would just hide the window and not end it so we
    **  won't be able to press our button that we create.  */
    firstWindow.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);

    /*  Create a Button object from the JButton Object  */
    JButton endButton = new JButton("Click to end Program");
    /*  A Listener Object is created and named buttonEar  */
    EndingListener buttonEar = new EndingListener();
    /*  The Listener Object is registered as a Listener called endButton
    **  used by the button  */
    endButton.addActionListener(buttonEar);
    /*  Add the Button to the JFrame  */
    firstWindow.add(endButton);

    firstWindow.setVisible(true);
  }
}
```

```java
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class EndingListener implements ActionListener{
  public void actionPerformed(ActionEvent e){
    System.exit(0);
  }
}
```
