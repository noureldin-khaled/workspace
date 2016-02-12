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

   for(int i = 0; i < n; i++){
       int a;
       scanf("%i",&a);
       arr[i] = a;
   }

   int absMin = 1001;
   for(int i = 1; i < n; i++){
       int removedElement = arr[i];

       int curMin = 0;
       for(int j = 0; j < n-1; j++){
           if (arr[j+1] == removedElement){
               if (arr[j+2]-arr[j] > curMin)
                   curMin = arr[j+2]-arr[j];
               j++;
           }
           else if (arr[j+1]-arr[j] > curMin)
                   curMin = arr[j+1]-arr[j];
       }

       if (curMin < absMin)
           absMin = curMin;
   }

   printf("%i",absMin);
}
