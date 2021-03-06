/*********************************************************
*  Vline Subclass for VectorObject Class                 *
*  Name: Tiro Modibedi                                   *
*  Student Number: MDBTIR001                             *
*  Date: 22-09-2017                                      *
*********************************************************/
public class VLine extends VectorObject{
  private int length;

  // constructors
  public VLine(int id, int x, int y, int length){
    super(id, x, y);
    this.length = length;
  }
  public void draw(char [][] matrix){
    for (int i = 0; i < length; i++) {
      matrix[y + i][x] = '*';
    }
  }
}
