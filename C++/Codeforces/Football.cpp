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

   int countOne = 0;
   int countZero = 0;

   for(int i = 0; i < line.length(); i++)
   {
       if (countOne >= 7 || countZero >= 7)
       {
           puts("YES");
           return 0;
       }
       if (line[i] == '1')
       {
           countOne++;
           countZero = 0;
       }
       else
       {
           countZero++;
           countOne = 0;
       }
   }
   if (countOne >= 7 || countZero >= 7)
   {
           puts("YES");
           return 0;
   }

   puts("NO");
}
