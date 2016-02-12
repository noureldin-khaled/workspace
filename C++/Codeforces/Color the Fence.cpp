#include <bits/stdc++.h>

using namespace std;

int main()
{
   int v;
   scanf("%i",&v);

   int arr[9];
   int minimum = 100005;
   int minValue = -1;
   for(int i = 0; i < 9; i++)
   {
       int a;
       scanf("%i",&a);

       arr[i] = a;
       if (arr[i] < minimum)
       {
           minimum = arr[i];
           minValue = i+1;
       }
   }

   int max_length = v/minimum;

   string res = "";
   for(int i = 0; i < max_length; i++)
       res += minValue + '0';

   v %= minimum;
   for(int i = 0; i < max_length; i++)
   {
       bool flag = true;
       v += minimum;
       for(int j = 8; j >= 0; j--)
       {
           if (v >= arr[j] && j+1 > minValue)
           {
               res[i] = (j+1) + '0';
               v -= arr[j];
               flag = false;
               break;
           }
       }
       if (flag)
           break;
   }

   if (res.empty())
       printf("%i",-1);
   else
       cout << res << endl;
}
