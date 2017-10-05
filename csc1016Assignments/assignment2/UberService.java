/*********************************************************
*  UberService Class Program                             *
*  name: Tiro Modibedi                                   *
*  Student Number: MDBTIR001                             *
*  Date: 26-08-2017                                      *
*********************************************************/

public class UberService {
  // declare instance variables private to the class (accessible only inside this class)
  private String serviceName;
  private int costTime;
  private int costDist;
  private int fixedFee;
  private int cancelCharge;

  // Class constructor
  public void setDetails(String name, int costPerMin, int costPerKM, int baseFee, int cancellationFee){
    serviceName = name;
    costTime = costPerMin;
    costDist = costPerKM;
    fixedFee = baseFee;
    cancelCharge = cancellationFee;
  }
  // set service name
  public void setName(String name){
    serviceName = name;
  }
  // get service name code
  public String getName(){
    return serviceName;
  }

  public void setCostPerMinute(int cents){
    costTime = cents;
  }

  public int getCostPerMinute(){
    return costTime;
  }

  public void setCostPerKilometre(int cents){
    costDist = cents;
  }

  public int getCostPerKilometre(){
    return costDist;
  }

  public void setBaseFare(int cents){
    fixedFee = cents;
  }

  public int getBaseFare(){
    return fixedFee;
  }

  public void setCancellationFee(int n){
    cancelCharge = n;
  }

  public int getCancellationFee(){
    return cancelCharge;
  }

  // method for calculating the fare
  public double calculateFare(double minutes, double distance){
    double costForDistance = distance * getCostPerKilometre();
    double costForTime = minutes * getCostPerMinute();
    double fare = getBaseFare() + costForTime + costForDistance;
    return fare;
  }

}
