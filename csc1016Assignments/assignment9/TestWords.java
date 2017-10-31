public class TestWords{

  public static void main(String[] args) {


    Pattern p = new Pattern("l*ad");
    try {
      WordList w1 = WordList.readFromFile("dictionary.txt");
      for (Word w : w1) {
        if (p.matches(w)) {
          System.out.println(w);
        }
      }
    } catch (Exception e) {
      e.printStackTrace();
    }

  }
}
