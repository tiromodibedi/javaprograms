public class test3{
  static char[][] h(char [][] matrix,int x1,int y1, int x2,int y2){
        int dx  = x2 - x1;
        int dy  = y2 - y1;
        int y   = y1;
        int eps = 0;
        for (int x = x1; x <= x2; x++ )  {
            matrix[y][x]='*';
            eps += dy;
            if ( (eps << 1) >= dx )  {
                y++;
                eps -= dx;
            }
        }
        return matrix;
    }

    public static void main(String[] args) {
          char[][] input = {
                  {' ',' ',' ',' ',' ',' '},
                  {' ',' ',' ',' ',' ',' '},
                  {' ',' ',' ',' ',' ',' '},
                  {' ',' ',' ',' ',' ',' '},
                  {' ',' ',' ',' ',' ',' '}
          };
          char[][] matrix = h(input,0,0,4,5);
          for(int i=0;i<matrix.length;i++){
              for(int j=0;j<matrix[0].length;j++){
                  System.out.print(matrix[i][j]);
              }
              System.out.println();
          }
      }
}


public class PtLine


private void drawLine(Graphics g, int x1, int y1, int x2, int y2) {
        // delta of exact value and rounded value of the dependant variable
        int d = 0;

        int dy = Math.abs(y2 - y1);
        int dx = Math.abs(x2 - x1);

        int dy2 = (dy << 1); // slope scaling factors to avoid floating
        int dx2 = (dx << 1); // point

        int ix = x1 < x2 ? 1 : -1; // increment direction
        int iy = y1 < y2 ? 1 : -1;

        if (dy <= dx) {
            for (;;) {
                plot(g, x1, y1);
                if (x1 == x2)
                    break;
                x1 += ix;
                d += dy2;
                if (d > dx) {
                    y1 += iy;
                    d -= dx2;
                }
            }
        } else {
            for (;;) {
                plot(g, x1, y1);
                if (y1 == y2)
                    break;
                y1 += iy;
                d += dx2;
                if (d > dy) {
                    x1 += ix;
                    d -= dy2;
                }
            }
        }
    }
