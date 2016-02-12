#include <bits/stdc++.h>

using namespace std;

int main()
{
   int n;
   scanf("%i",&n);

   int s = 1000000005;
   int fo = -1;
   int lo = -1;

   int arr[n];
   for(int i = 0; i < n; i++)
   {
       int a;

       scanf("%i",&a);

       if (a < s)
           s = a;
       arr[i] = a;
   }

   long long ans = ((long long)n*s);
   vector<int> v;
   for(int i = 0; i < n; i++)
   {
       if (arr[i] == s)
           v.push_back(i);
   }


   int index = -1;
   int sizee = v.size();
   if (sizee == 1)
       index = v[0];
   else
   {
       int maximum = 0;
       for(int i = 0; i < sizee-1; i++)
       {
           if (v[i+1]-v[i] > maximum)
           {
               maximum = v[i+1]-v[i]-1;
               index = v[i];
           }
       }

       if (((n-1) - v[sizee-1])+v[0] > maximum)
           index = v[sizee-1];
   }

   index++;
   if (index == n)
       index = 0;

   while(true)
   {
       if (arr[index] == s)
           break;

       ans++;
       index++;
       if (index == n)
           index = 0;
   }

   cout << ans << endl;

}
