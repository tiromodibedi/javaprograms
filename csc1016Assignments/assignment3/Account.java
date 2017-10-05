/***********************************************************
*  Account Class: uses Plan class to manage mobile account *
*  Name: Tiro Modibedi                                     *
*  Student Number: MDBTIR001                               *
*  Date: 09-09-2017                                        *
***********************************************************/

public class Account{
  private Plan myPlan;
  private int accountBalance;

  // constructor
  public Account(String planName, int callCharge){
    myPlan = new Plan(planName, callCharge);
    accountBalance = 0;
  }

  // mutator methods
  public void setPlanDetails(String planName, int callRate){
    myPlan.setPlanName(planName);
    myPlan.setCallRate(callRate);
  }

  // accessor methods
  public String getMyPlanName(){
    return myPlan.getPlanName();
  }
  public int getMyCallRate(){
    return myPlan.getCallRate();
  }
  public int checkBalance(){
    return accountBalance;
  }

  // top up account balance top up
  public void topBalance(int topUpValue){
    accountBalance = accountBalance + topUpValue;
  }

  public boolean makeCall(int callDuration){
    int charge = (int) myPlan.calculateCharge(callDuration);
    if (accountBalance >= charge) {
      accountBalance = accountBalance - charge;
      return true;
    } else {
      return false;
    }
  }

}
