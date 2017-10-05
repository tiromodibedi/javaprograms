/*********************************************************
*  Currency Class for Creating money object              *
*  Name: Tiro Modibedi                                   *
*  Student Number: MDBTIR001                             *
*  Date: 09-09-2017                                      *
*********************************************************/
import java.util.Scanner;

public class Money{
  private Currency currency;
  private long minorUnitAmount;
  private String amount;

  // constructors
  public Money(String amount, Currency currency){
    this.currency = currency;
    this.amount = amount;
    //minorUnitAmount = currency.minorPerMajor();
  }
  public Money(long minorUnitAmount, Currency currency){
    this.currency = currency;
    this.minorUnitAmount = minorUnitAmount;
  }

  // Methods
  public long longAmount(){
    return currency.parse(amount);
  }
  public Currency currency(){
    return currency;
  }
  public Money add(Money other){
    long result = longAmount() + other.longAmount();
    int intResult = (int) result;
    Money newMoney = new Money(currency.format(intResult), currency());
    return newMoney;
  }
  public Money subtract(Money other){
    long result = longAmount() - other.longAmount();
    int intResult = (int) result;
    Money newMoney = new Money(currency.format(intResult), currency());
    return newMoney;
  }
  public String toString(){
    int i = (int) longAmount();
    return currency.format(i);
  }
/*
  public static void main(String[] args) {
    Currency currency = new Currency("R", "ZAR", 100);
    Money money = new Money("R14.50", currency);
    Money otherMoney = new Money("R20.00", currency);
    Money result = money.add(otherMoney);
    System.out.println(money.longAmount());
    System.out.println(otherMoney.toString());
    System.out.println(result.toString());
    System.out.println("Currency(): Currency("+money.currency().symbol()+", "+money.currency().code()+", "+money.currency().minorPerMajor()+")");
    //System.out.println(money.add(otherMoney));
  }
*/

}
