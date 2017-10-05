public class Vehicle {
    private int numPassengers;
    private String colour;

    Vehicle(int passengers, String colour) {
        this.numPassengers = passengers;
        this.colour = colour;
    }
    // methods
    public int getPassengers(){
      return numPassengers;
    }
    public String getColour(){
      return colour;
    }

    public String toString() {
        return colour + " " + numPassengers + " passengers";
    }
}
