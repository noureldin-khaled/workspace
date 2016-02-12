#include<iostream>
#include<string>
#include<cstring>
#include<sstream>
#include<string.h>
#include<algorithm>
#include<cmath>
#include<fstream>
#include<cstdlib>
#include<vector>
#include<stdlib.h>

using namespace std;

int main()
{
  int x1,y1,x2,y2;
  cin >> x1 >> y1 >> x2 >> y2;

  if (x1 == x2){
           int length = y2-y1;
           int x3 = x1 + length;
           if (x3 > 1000)
               x3 = x1 - length;
           int y3 = y1;
           int x4 = x3;
           int y4 = y2;

           if (x3 <= 1000 && x3 >= -1000 && y3 <= 1000 && y3 >= -1000 && x4 <= 1000 && x4 >= -1000 && y4 <= 1000 && y4 >= -1000)
               cout << x3 << " " << y3 << " " << x4 << " " << y4 << endl;
           else
               cout << -1 << endl;
  }
  else if (y1 == y2){
       int length = x2 - x1;
       int x3 = x1;
       int y3 = y1 + length;
       if (y3 > 1000)
           y3 = y1 - length;
       int x4 = x2;
       int y4 = y3;

       if (x3 <= 1000 && x3 >= -1000 && y3 <= 1000 && y3 >= -1000 && x4 <= 1000 && x4 >= -1000 && y4 <= 1000 && y4 >= -1000)
               cout << x3 << " " << y3 << " " << x4 << " " << y4 << endl;
           else
               cout << -1 << endl;
  }
  else {
       if (abs(x1-x2) == abs(y1-y2)){
           int x3 = x1;
           int y3 = y2;
           int x4 = x2;
           int y4 = y1;

            if (x3 <= 1000 && x3 >= -1000 && y3 <= 1000 && y3 >= -1000 && x4 <= 1000 && x4 >= -1000 && y4 <= 1000 && y4 >= -1000)
               cout << x3 << " " << y3 << " " << x4 << " " << y4 << endl;
           else
               cout << -1 << endl;
       }
       else
           cout << -1 << endl;
  }
}
