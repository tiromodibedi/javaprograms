#include <iostream>
#include <cstdlib> // For EXIT_SUCCESS
using namespace std; // Make all std names global
int main()
{
  int n;
  int sum = 1; // Introduced for part (b)
  cout << "Enter a positive integer n : ";
  cin >> n;
  int a = 1, b = 0 , c = 0;

  /*
  **  1 2 3 4 5 6 7    8   9  10
  **
  **  1 1 2 3 5 8 13  21  34  55
  **
  **  n = (n-2) + (n-1)
  **
  **  the first two terms 1, 1
  */
  cout << "The first " << n << " elements of the Fibonacci sequence are: " << ’\n’;
  // The first entry
  cout << "1" << ’\n’;
  a = 1;
  if ( n > 1 ) {
    sum += 1;
    // The second entry
    cout << "1" << ’\n’;
    b = a;
    a = 1;
    if ( n > 2 ) {
      // We’ll need to juggle three values: u_n, u_(n-1), u_(n-2)
      for ( int i = 3 ; i <= n ; ++i ) {
        c = b + a;
        sum += c;
        cout << c << ’\n’;
        a = b;
        b = c;
      }
    }
  }
  // At this point: c = u_n, b = u_n, and a = u_(n-1)
  int tmp=a;
  c = b + a;
  a = b;
  b = c;
  // At this point: c = u_(n+1), b = u_(n+1), and a = u_(n), tmp=u_(n-1)
  // For part (a)
  int rhs = a*a - tmp * c;
  int lhs = 1;
  for ( int i = 1 ; i <= n-1 ; ++i ) {
    lhs *= -1;
  }
  cout << "For part (a), the right hand side of the given equation is ";
  cout << rhs << ’\n’;
  cout << "The left hand side of the give equation is " << lhs << ’\n’;
  c = b + a;
  // At this point: c = u_(n+2)
  cout << "For part (b), the sum of the first " << n << " Fibonacci numbers is ";
  cout << sum << ’\n’;
  cout << "The right hand side of the given equation is " << c - 1 << ’\n’;
  cout << ’\n’;
  return(EXIT_SUCCESS);
}
