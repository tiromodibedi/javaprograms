/*********************************************************
*  Point Line Subclass for VectorObject Class            *
*  Name: Tiro Modibedi                                   *
*  Student Number: MDBTIR001                             *
*  Date: 22-09-2017                                      *
*********************************************************/
/*
public class PtLine extends VectorObject{
  private int px; // x2
  private int py; // y2
  private int qx; // x1
  private int qy; // y1

  // constructor
  public PtLine(int id, int x, int y, int qx, int qy){
    super(id, x, y);
    this.qx = qx;
    this.qy = qy;
  }

  public void draw(char[][] matrix){
    px = super.x; // x2
    py = super.y; // y2
    boolean steep = Math.abs(qy - py) > Math.abs(qx - px);
    int tempo;
    if (steep) {
      // swap x2 and y2
      //swap(px, py);
      //swap(qx, qy);
      tempo = px;
      px = py;
      py = tempo;
      tempo = qx;
      qx = qy;
      qy = tempo;
    } if (px > qx) {
      //swap(px, qx);
      //swap(py, qy);
      tempo = px;
      px = qx;
      qx = tempo;
      tempo = py;
      py = qy;
      qy = tempo;
    }
    int xChange = qx - px;
    if (xChange != 0) {
      int yChange = Math.abs(qy - py);
      double eChange = (double) yChange / (double) xChange;
      int y = py;
      int ys;
      double e = 0;
      if (py < qy) {
        ys = 1;
      } else {
        ys = -1;
      }
      for (int i = px; i <= qx; i++) {
          if (steep) {
            matrix[i][y] = '*';
          } else {
            matrix[y][i] = '*';
          }
          e = e + eChange;
          if (e > 0.5) {
              y = y + ys;
              e = e - 1;
          }
      }
    } else {
      for ( int i=0; i<(qy - py); i++ ){
        matrix[py+i][px] = '*';
      }
    }
  }

  public static void swap(int n1, int n2){
    int temp = n1;
    n1 = n2;
    n2 = n1;
  }
}
*/
public class PtLine extends VectorObject{
   private char[][] matrix;
   private int x0; // x coordinate of first point
   private int y0; // y coordinate of first point

   public PtLine(int id, int ax, int ay, int x0, int y0){
      super (id, ax,ay);
      this.x0 = x0;
      this.y0 = y0;
   }

   public void draw(char [][] matrix){
     int x1 = super.ax; // x coordinate of second point
     int y1 = super.ay; // y coordinate of second point

     int d = 0;

     int deltaY = Math.abs(y0 - y1);
     int deltaX = Math.abs(x0 - x1);

     int secDeltaY = (deltaY << 1);
     int secDeltaX = (deltaX << 1);

     int ix = x1 < x0 ? 1 : -1;
     int iy = y1 < y0 ? 1 : -1;

     if (deltaY <= deltaX) {
         for (;;) {
             matrix[x1][y1] = '*';
             if (x1 == x0)
                 break;
             x1 += ix;
             d += secDeltaY;
             if (d > deltaX) {
                 y1 += iy;
                 d -= secDeltaX;
             }
         }
     } else {
         for (;;) {
             matrix[x1][y1] = '*';
             if (y1 == y0)
                 break;
             y1 += iy;
             d += secDeltaX;
             if (d > deltaY) {
                 x1 += ix;
                 d -= secDeltaY;
             }
         }
     }
   }
}
