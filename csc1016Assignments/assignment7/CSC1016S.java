/*********************************************************
*  CSC1016S Class to implements the Student Interface    *
*  Name: Tiro Modibedi                                   *
*  Student Number: MDBTIR001                             *
*  Date: 12-10-2017                                      *
*********************************************************/
public class CSC1016S implements Student{
  /*  Instance Variables  */
  private String name;
  private float finalGrade;
  private double[] grades;

  /*  Constructor  */
  public CSC1016S(){
    this.name = "no one";
    for (int i = 0; i < grades.length; i++) {
      grades[i] = 0.0;
    }
  }

  /*  Instance Methods  */
  public void setName(String name){
    this.name = name;
  }
  public String getName(){
    return name;
  }
  public void setMark (String category, int mark){
    grades = new double[4];
    if (category.equals("pracs")) {
      grades[0] = mark;
    } else if (category.equals("practests")) {
      grades[1] = mark;
    } else if (category.equals("tests")) {
      grades[2] = mark;
    } else if (category.equals("exam")) {
      grades[3] = mark;
    } else;
  }
  public float getFinal(){
    finalGrade = 0.15*grades[0] + 0.10*grades[1] + 0.15*grades[2] + 0.60*grades[3];
    return (float)finalGrade;
  }


  /*  Internal Testing  */
  public static void main(String[] args) {
    System.out.println("Test");
    CSC1016S tiro = new CSC1016S();
    tiro.setName("Tiro");
    tiro.setMark("pracs", 93);
    System.out.println(tiro.getFinal());
  }


}
