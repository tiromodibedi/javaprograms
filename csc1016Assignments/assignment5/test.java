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
