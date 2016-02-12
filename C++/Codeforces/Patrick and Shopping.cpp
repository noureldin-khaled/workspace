#include <bits/stdc++.h>

using namespace std;

int main()
{
   int d1,d2,d3;
   scanf("%i %i %i",&d1,&d2,&d3);

   int ans1 = 2*d1 + 2*d2;
   int ans2 = d1 + d2 + d3;
   int ans3 = min(ans1,ans2);
   int ans4 = 2*min(d1,d2) + 2*d3;
   printf("%i",min(ans3,ans4));

}
