/*********************************************************
*  Plan Class for determining the account details        *
*  Name: Tiro Modibedi                                   *
*  Student Number: MDBTIR001                             *
*  Date: 09-09-2017                                      *
*********************************************************/
public class Plan{
  // instance variables
  private String planName;
  private int callRate;

  // constructor
  public Plan(String planName, int callRate){
    this.planName = planName;
    this.callRate = callRate;
  }


  // mutator methods
  public void setCallRate(int callRate){
    this.callRate = callRate;
  }
  public void setPlanName(String planName){
    this.planName = planName;
  }

  // accessor methods
  public String getPlanName(){
    return planName;
  }
  public int getCallRate(){
    return callRate;
  }

  // method for calculating charge of a call in cents.
  public double calculateCharge(int secondsDuration){
    int callDuration = secondsDuration;
    double callCharge = callDuration*callRate;
    return callCharge;
  }
}
