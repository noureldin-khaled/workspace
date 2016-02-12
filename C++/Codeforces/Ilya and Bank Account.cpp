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

using namespace std;

long long rec(int n);
int main()
{
   long long n;
   cin >> n;

   if (n >= 0)
       cout << n << endl;
   else {
      long long choice1 = n/10;
      long long choice2 = (n/100)*10 + (n%10);

      if (choice1 > choice2)
           cout << choice1 << endl;
      else
           cout << choice2 << endl;
   }
}
