/*********************************************************
*  Currency Class for Creating money object              *
*  Name: Tiro Modibedi                                   *
*  Student Number: MDBTIR001                             *
*  Date: 09-09-2017                                      *
*********************************************************/
import java.util.Scanner;

public class Currency{
  // instance variables
  private String currencyCode;
  private String currencySymbol;
  private int numMinorUnits;

  // constructor
  public Currency(String currencySymbol, String currencyCode, int numMinorUnits){
    this.currencySymbol = currencySymbol;
    this.currencyCode = currencyCode;
    this.numMinorUnits = numMinorUnits;
  }

  // method for converting cents to String value of the currency
  public String format(int value){
    if (value >= 0) {
      double currencyValueDouble = Math.abs(value/(double)numMinorUnits);
      String currencyValueString = String.format("%s%1.2f", currencySymbol, currencyValueDouble);
      return currencyValueString;
    } else {
      double currencyValueDouble = Math.abs(value/(double)numMinorUnits);
      String currencyValueString = String.format("%s%s%1.2f", "-", currencySymbol, currencyValueDouble);
      return currencyValueString;
    }

  }

  public long parse(String str){
    /*
    String s = (str.substring(1)).replace(".","");
    long l = Long.parseLong(s);
    return l;
    */
    /*
    Scanner s = new Scanner(amount);
 	  s.useDelimiter("-");
    String amountString = ((s.next()).substring(1)).replace(".","");
    long amountLong = (Long.parseLong(amountString));
    return amountLong;
    */
    String empty = "";
    Scanner s = new Scanner(str);
 	  s.useDelimiter("\\D+"); // remove anything except digits
 	  while(s.hasNext()){
      	empty = empty + s.next();
    }
    long l = Long.parseLong(empty);
    return l;

  }

  // Accessor Methods
  public String symbol(){
    return currencySymbol;
  }
  public String code(){
    return currencyCode;
  }
  public int minorPerMajor(){
    return numMinorUnits;
  }
/*
  public static void main(String[] args) {
    Currency rand = new Currency("R","ZAR", 100);
    String s = rand.format(-30511);
    long a = rand.parse(s);
    System.out.println(s);
    System.out.println(a);
  }
*/
}
