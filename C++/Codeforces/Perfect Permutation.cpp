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
   int n;
   scanf("%i",&n);

   bool visited[n+1];

   for(int i = 0; i < n+1; i++)
       visited[i] = false;

   int res[n+1];
   for(int i = 0; i < n+1; i++)
       res[i] = -1;


   for(int i = 1; i < n+1; i++){
       if (res[i] == -1){
           bool found = false;
           for(int j = 1; j < n+1 && !found; j++){
               if (!visited[j] && j != i)
               {
                   res[i] = j;
                   res[j] = i;
                   found = true;
                   visited[j] = true;
                   visited[i] = true;
               }
           }

           if (!found){
               printf("%i",-1);
               return 0;
           }
       }
   }

   for(int i = 1; i < n+1; i++)
       if (i == n)
           printf("%i",res[i]);
       else
           printf("%i ",res[i]);


}
