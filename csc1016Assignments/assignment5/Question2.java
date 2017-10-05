/*********************************************************
*  Menu For Customer                                     *
*  Name: Tiro Modibedi                                   *
*  Student Number: MDBTIR001                             *
*  Date: 20-09-2017                                      *
*********************************************************/
import java.util.Scanner;

public class Question2{
  public static void main(String[] args) {
    Scanner key = new Scanner(System.in);
    char selection;
    Order order = new Order();

    System.out.println("Welcome to Great International Food Court");

    do {
      System.out.print("MENU:");
      System.out.print(" add (P)izza,");
      System.out.print(" add (C)urry,");
      System.out.print(" add (S)oft drink,");
      System.out.print(" (D)elete,");
      System.out.print(" (L)ist,");
      System.out.println(" (Q)uit");

      selection = key.next(".").charAt(0);

      if (selection == 'P' || selection == 'p') {
        System.out.println("Enter the menu item number");
        key.nextLine();
        String menuItemNo = key.nextLine();

        System.out.println("Enter the size");
        String size = key.nextLine();

        System.out.println("Enter the base");
        String base = key.nextLine();

        System.out.println("Enter extra cheese");
        String extraCheese = key.nextLine();

        System.out.println("Enter extra garlic");
        String extraGarlic = key.nextLine();

        Pizza pizza = new Pizza(menuItemNo, size, base, extraCheese, extraGarlic);
        System.out.println("Done");

        order.addItem(pizza);
      }
      else if (selection == 'C' || selection == 'c') {
        System.out.println("Enter the menu item number");
        key.nextLine();

        String menuItemNo = key.nextLine();

        System.out.println("Enter the size");
        String size = key.nextLine();

        System.out.println("Enter the curry type");
        String curryType = key.nextLine();

        Curry curry = new Curry(menuItemNo, size, curryType);

        order.addItem(curry);
        System.out.println("Done");
      }
      else if (selection == 'S' || selection == 's') {
        System.out.println("Enter the menu item number");
        key.nextLine();

        String menuItemNo = key.nextLine();

        System.out.println("Enter the size");
        String size = key.nextLine();

        System.out.println("Enter the flavour");
        String flavour = key.nextLine();

        System.out.println("Enter whether it is a bottle or can");
        String container = key.nextLine();

        SoftDrink softDrink = new SoftDrink(menuItemNo, size, flavour, container);
        System.out.println("Done");

        order.addItem(softDrink);
      }
      else if (selection == 'D' || selection == 'd') {
        System.out.println("Enter the menu item number");
        key.nextLine();
        String removeItemNumber = key.nextLine();
        //System.out.println("hello" + removeItemNumber);
        //key.nextLine();
        if (order.removeItem(removeItemNumber)) {
          System.out.println("Done");
        } else {
          System.out.println("Not found");
        }
      }
      else if (selection == 'L' || selection == 'l') {
        System.out.print(order);
        System.out.println("Done");
      } else;

    } while (selection != 'Q' && selection != 'q');
  }
}
