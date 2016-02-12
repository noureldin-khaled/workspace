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
#define toInt(x) {atoi(x.c_str())};

using namespace std;

int main()
{
   int n,m;
   scanf("%i %i",&n,&m);

   char arr[n][m];
   for(int i = 0; i < n; i++)
   {
       string line;
       cin >> line;
       for(int j = 0; j < m; j++)
           arr[i][j] = line[j];
   }

   int ans = 0;
   for(int i = 0; i < n; i++)
   {
       for(int j = 0; j < m; j++)
       {
           if (arr[i][j] == 'W' && ((i > 0 && arr[i-1][j] == 'P') || (i < n-1 && arr[i+1][j] == 'P') || (j > 0 && arr[i][j-1] == 'P') || (j < m-1 && arr[i][j+1] == 'P')))
               ans++;
       }
   }
   printf("%i",ans);
}
