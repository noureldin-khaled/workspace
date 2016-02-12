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
#include<set>

using namespace std;

int main()
{
   int n;
   scanf("%i",&n);

   int arr[n];
   for(int i = 0; i < n; i++)
       scanf("%i",&arr[i]);

   sort(arr,arr+n);
   while(arr[0] != arr[n-1])
   {
       arr[n-1] = arr[n-1] - arr[0];
       sort(arr,arr+n);
   }

   int ans = 0;
   for(int i = 0; i < n; i++)
       ans += arr[i];
   printf("%i",ans);
}
