public class weather{
  public static void main(String[] args) {

    int temp = 23;

    Collator temperature = new Collator("temperature");
    Collator pressure = new Collator("pressure");
    Collator humidity = new Collator("humidity");

    temperature.recordReading(temp);

    System.out.println(temperature.maximum());




  }
}
