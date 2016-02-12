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
   int n;
   cin >> n;

   int countEven = 0;
   int countOdd = 0;
   int evenIndex = -1;
   int oddIndex = -1;

   for(int i = 1; i <= n; i++){
       int a;
       cin >> a;
       if (a%2 == 0) {
           countEven++;
           evenIndex = i;
       }
       else {
           countOdd++;
           oddIndex = i;
       }
   }

   if (countEven > countOdd)
       cout << oddIndex << endl;
   else
       cout << evenIndex << endl;

}
