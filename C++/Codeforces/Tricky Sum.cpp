#include <bits/stdc++.h>

using namespace std;

int main()
{
   int arr[30];
   int num = 1;
   for(int i = 0; i < 30; i++)
   {
       arr[i] = num;
       num*=2;
   }

   int t;
   scanf("%i",&t);

   while(t--)
   {
       int n;
       scanf("%i",&n);

       long long ans = ((long long)n*(n+1))/2;
       for(int i = 0; i < 30; i++)
       {
           if (arr[i] > n) break;
           ans -= 2*arr[i];
       }
       cout << ans << endl;
   }
}
