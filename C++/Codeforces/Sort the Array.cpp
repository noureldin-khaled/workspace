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
#include<limits>

using namespace std;

int main()
{
   long int n;
   scanf("%d",&n);

   long int arr[n];
   long int arrCopy[n];

   for(long int i = 0; i < n; i++)
   {
       long int a;
       scanf("%d",&a);
       arr[i] = a;
       arrCopy[i] = a;
   }
   sort(arr,arr+n);

   long int startPoint = -1;
   long int endPoint = -1;

   for(long int i = 0; i < n; i++)
   {
       if (arr[i] != arrCopy[i])
       {
           if (startPoint == -1)
               startPoint = i;
           endPoint = i;
       }
   }

   if (startPoint == -1 && endPoint == -1)
       printf("yes\n%d %d",1,1);
   else
   {

       for(long int s = startPoint, j = endPoint;s <= endPoint; s++,j--)
       {
           if (arr[s] != arrCopy[j])
           {
               printf("no");
               return 0;
           }
       }
       printf("yes\n%d %d",startPoint+1,endPoint+1);
   }
}
