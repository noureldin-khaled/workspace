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
   int n,k;
   cin >> n >> k;

   int peopleQualified = 0;
   for(int i = 0; i < n; i++){
       int y;
       cin >> y;

       if (y+k <=5)
           peopleQualified++;
   }

   cout << (peopleQualified/3) << endl;
}
