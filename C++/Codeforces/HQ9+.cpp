#include<iostream>
#include<string>
#include<cstring>
#include<sstream>
#include<string.h>
#include<algorithm>
#include<cmath>
#include<cstdlib>
#include<vector>
#include<stdlib.h>
#include<set>
#include<stdio.h>

using namespace std;

int main()
{
   string line;
   cin >> line;

   for(int i = 0; i < line.length(); i++)
   {
       if (line[i] == 'H' || line[i] == 'Q' || line[i] == '9')
       {
           cout << "YES";
           return 0;
       }
   }
   cout << "NO";
}
