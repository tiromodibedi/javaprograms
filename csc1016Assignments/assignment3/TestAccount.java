/***********************************************************
*  TestAccount Class: Test the Account Class               *
*  Name: Tiro Modibedi                                     *
*  Student Number: MDBTIR001                               *
*  Date: 09-09-2017                                        *
***********************************************************/

public class TestAccount{
  public static void main(String[] args) {

    // setting up a new Account
    Account myAccount = new Account("premium", 55);

    System.out.println("Test 1");
    System.out.println("Checking Account Details");
    if (myAccount.checkBalance() == 0
        && myAccount.getMyPlanName() == "premium") {
        System.out.println("Initial Account Balance: " + myAccount.checkBalance());
        System.out.println("My current plan: " + myAccount.getMyPlanName());
        System.out.println("My call rate: " + myAccount.getMyCallRate());
        System.out.println("Status: First Test Passed.");
    } else {
      System.out.println("Status: First Test Failed!");
    }

    System.out.println("\nTest 2");
    System.out.println("Make a call with zero Account balance.");
    if (!myAccount.makeCall(25)) {
      System.out.println("Insufficient balance to make the call. Please Recharge your Account!");
      System.out.println("Status: Second Test Passed.");
    } else {
      System.out.println("Status: Second Test Failed!");
    }

    System.out.println("\nTest 3");
    System.out.println("Topping up my Account Balance and Checking");
    myAccount.topBalance(2000);
    if (myAccount.checkBalance() == 2000) {
      System.out.println("Account Topped up succesfully");
      System.out.println("Status: Third Test Passed.");
    } else {
      System.out.println("Status: Third Test Failed!");
    }

    System.out.println("\nTest 4");
    System.out.println("Making a call for 20 seconds and checking balance");
    myAccount.makeCall(20);
    if (myAccount.checkBalance() == 900) {
      System.out.println("Call made succesfully!");
      System.out.println("Account balance after call is: " + myAccount.checkBalance());
      System.out.println("Status: Fourth Test Passed.");
    } else {
      System.out.println("Status: Fourth Test Failed!");
    }

    System.out.println("\nTest 5");
    System.out.println("Make another call for 20 seconds again!");
    if (!myAccount.makeCall(20)) {
      System.out.println("Insufficient balance to make the call. Please Recharge your Account!");
      System.out.println("Status: Fifth Test Passed.");
    } else {
      System.out.println("Status: Fifth Test Failed!");
    }

  }
}
