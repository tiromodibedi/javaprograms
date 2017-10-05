/*********************************************************
*  Rectangle Subclass for VectorObject Class             *
*  Name: Tiro Modibedi                                   *
*  Student Number: MDBTIR001                             *
*  Date: 22-09-2017                                      *
*********************************************************/
public class Rectangle extends VectorObject{
  private int x_length; // width
  private int y_length; // height

  // constructors
  public Rectangle(int id, int x, int y, int x_length, int y_length){
    super(id, x, y);
    this.x_length = x_length;
    this.y_length = y_length;
  }
  public void draw(char [][] matrix){
    for (int i = 0; i < y_length; i++) {
      for (int j = 0; j < x_length; j++) {
        matrix[y + i][x + j] = '*';
      }
    }
  }
}
