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
  int n,m;
  cin >> n >> m;

  int minimum = 20005;
  for(int i = 0; i <= n ; i++) {
       if (i%2 != 0)
           continue;
       int moves = (n-i) + (i/2);
       if (moves%m == 0 && moves < minimum)
           minimum = moves;
  }

  if (minimum == 20005)
       cout << -1 << endl;
  else
       cout << minimum << endl;

}
