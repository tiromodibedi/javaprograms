import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Line2D;
import java.util.ArrayList;

import javax.swing.JPanel;

public class LinePanel extends JPanel {

 int x = 5;
 String theWord = "";
 ArrayList<String> letterList;

 public LinePanel(int num, String t, ArrayList<String> s) {
  super(); // 300,350
  setPreferredSize(new Dimension(400,400));
  setBackground(Color.RED);
  this.x = num;
  this.theWord = t;
  letterList = cloneList(s);
 }

 private ArrayList<String> cloneList(ArrayList<String> aList) {
  ArrayList<String> clonedList = new ArrayList<String>(aList.size());
  for (String letter : aList) 
   clonedList.add(letter);
  return clonedList;
 }



 public int getX() {
  return x;
 }

 public void setX(int x) {
  this.x = x;
 }

 public void paintComponent(Graphics g) {
  super.paintComponent(g);
  Graphics2D g2 = (Graphics2D) g;
  if (x == 15 || x != 15){
   Line2D line = new Line2D.Double(0, 250, 80, 250); // Creates base
   Line2D line2 = new Line2D.Double(40, 50, 40, 250); // Creates vertical line
   Line2D line3 = new Line2D.Double(40, 50, 150, 50); // Creates horizontal line
   Line2D line4 = new Line2D.Double(150, 50, 150, 80); // Creates small line to hang the man
   g2.setStroke(new BasicStroke(5.0f)); // Line thickness
   g2.setColor(Color.BLACK); // Line colour

   //draw shape of line
   g2.draw(line);
   g2.draw(line2);
   g2.draw(line3);
   g2.draw(line4);

   int x1 = 0; int y = 320;
   for (int i = 0; i < theWord.length();i++){
    g2.drawLine(x1, y, x1 + 20, y);
    x1 += 50;
   }
  }

  // head
  if (x == 5 || x < 5){
   System.out.println("uheuheuha");
   g2.setStroke(new BasicStroke(5.0f));
   g2.drawOval(135, 85, 35, 35);
  }

  // body
  if (x == 4 || x < 4){
   g2.drawLine(150, 120, 150, 190);
  }

  // left arm
  if (x == 3 || x < 3){
   g2.drawLine(150, 140, 125, 155); 
  }

  // right arm
  if (x == 2 || x < 2){
   g2.drawLine(150, 140, 175, 155); 
  }

  // left leg and foot
  if (x == 1 || x < 1){
   g2.drawLine(150, 190, 125, 200); // leg
   g2.drawLine(125, 200, 120, 190); // foot
  }

  // right leg and foot
  if (x == 0){
   g2.drawLine(150, 190, 175, 200); // leg
   g2.drawLine(175, 200, 180, 190); // foot
  }

  // Show whole word on screen
  if (x == 20){

   int x1 = 3; int y = 317;

   String temp = "";

   for (int i = 0; i < theWord.length(); i++){
    if ( letterList.contains(theWord.substring(i, i+1)) == true){
     temp += theWord.substring(i, i+1);
    }
    else{
     temp += " ";
    }
   }

   for (int i = 0; i < temp.length() ;i++){
    g2.setColor(Color.BLACK);
    Font font = new Font("Arial", Font.PLAIN, 25);
    g2.setFont(font);
    g2.drawString(temp.substring(i, i+1), x1, y);
    x1 += 50;
   }


   x1 = 3;  y = 370;
   for (int i = 0; i < letterList.size() ;i++){

    if (theWord.contains(letterList.get(i)) == false){
     g2.drawString(letterList.get(i), x1, y );
     x1 += 50;
    }

   }


  }
 }
}