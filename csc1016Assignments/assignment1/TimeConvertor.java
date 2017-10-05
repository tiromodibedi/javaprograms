/*********************************************************
*  Time Converter Program converts time in 24 to 12 hr   *
*  name: Tiro Modibedi                                   *
*  Student Number: MDBTIR001                             *
*  Date: 22-08-2017                                      *
*********************************************************/

// import the Scanner class and make it available for our project
import java.util.Scanner;

public class TimeConvertor{

   public static void main(String[] args){
      // creates an object of the class Scanner and names the object keyboard
      Scanner keyboard = new Scanner(System.in);
      String newTime;

      // prompt user input
      System.out.println("Enter a time ([h]h:mm [am|pm])");
      String time = keyboard.nextLine();

      // split the time into an array
      String[] timeArray = time.split(":");

      // extract the hours and the minutes from the time
      String hh = timeArray[0];
      String mm = timeArray[1].substring(0,2);

      // check if the input time is in 12hr or 24hr notation
      if(timeArray[1].endsWith("m")){
         String am_pm = timeArray[1].substring(3);
         if (am_pm.equals("am")) {
           if (hh.length() == 2) {
             if (hh.equals("12")) {
               newTime = "00" + ":" + mm;
             } else {
               newTime = hh + ":" + mm;
             }
           } else {
             newTime = "0" + hh + ":" + mm;
           }
         } else {
           if (hh.equals("12")) {
             newTime = hh + ":" + mm;
           } else {
             int HH = Integer.parseInt(hh) + 12;
             newTime = HH + ":" + mm;
           }
         }
      }

      else{
        int HH = Integer.parseInt(hh);
        // if it is in 24 hour format
        if (HH == 0) {
          HH =+ 12;
          newTime = HH + ":" + mm + " am";
        } else if (HH < 12) {
          newTime = HH + ":" + mm + " am";
        } else if ( HH == 12) {
          newTime = HH + ":" + mm + " pm";
        } else {
          HH = HH - 12;
          newTime = HH + ":" + mm + " pm";
        }
      }

      System.out.println(newTime);
   }
}
