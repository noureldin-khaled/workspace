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

   long int arr[n];
   for(int i = 0; i < n; i++)
       scanf("%d",&arr[i]);

   sort(arr,arr+n);
   if (arr[0] == 1)
       printf("%i",-1);
   else
       printf("%i",1);
}
