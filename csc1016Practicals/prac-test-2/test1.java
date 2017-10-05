public class test1{
  private int id;
  private String name;
  private String city;

  public test1(int id, String name, String city){
    this.id = id;
    this.name = name;
    this.city = city;
  }
  // Methods
  public int getId(){
    return id;
  }
  public String getName(){
    return name;
  }
  public String getCity(){
    return city;
  }
  //
  public String toString(){
    return id + " " + name + " " + city;
  }


  // the main method
  public static void main(String[] args) {
    System.out.println("Tiro");
    test1 s1 = new test1(10,"tiro","Gaborone");
    System.out.println(s1);
  }
}
