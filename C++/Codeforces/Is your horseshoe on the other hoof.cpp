#include<iostream>
#include<string>
#include<cstring>
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
   long int arr[4];

   for(int i = 0; i < 4; i++)
       scanf("%d",&arr[i]);

   int ans = 0;
   for(int i = 0; i < 4; i++){
       if (arr[i] == -1) continue;
       for(int j = i+1; j < 4; j++)
               if (arr[i] == arr[j]) {
                   ans++;
                   arr[j] = -1;
               }
   }


   printf("%i",ans);
}
