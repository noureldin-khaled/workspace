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
   int a,b,s;
   scanf("%d %d %d",&a,&b,&s);

   if (a < 0)
       a*=-1;
   if (b < 0)
       b*=-1;
   int diff = s-(a+b);
   if (s < a+b)
       puts("No");
   else if (diff%2 == 0)
       puts("Yes");
   else
       puts("No");
}
