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
#include<stdio.h>

using namespace std;

int main()
{
   long int n,m;
   scanf("%d %d",&n,&m);

   long int arr[m];

   for(long int i = 0; i < m; i++)
   {
       long int a;
       scanf("%d",&a);
       arr[i] = a;
   }

   long int house = 1;
   long long timeTaken = 0;
   for(long int i = 0; i < m; i++)
   {
       if (arr[i] >= house)
           timeTaken += arr[i]-house;
       else
           timeTaken += n - house + arr[i];

       house = arr[i];
   }

   printf("%I64d",timeTaken);
}
