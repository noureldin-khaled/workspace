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
   int arr[4];
   scanf("%i %i %i %i",&arr[0],&arr[1],&arr[2],&arr[3]);

   string line;
   cin >> line;

   int ans = 0;
   for(int i = 0; i < line.length(); i++)
       ans += arr[(line[i]-'0')-1];

   printf("%d",ans);
}
