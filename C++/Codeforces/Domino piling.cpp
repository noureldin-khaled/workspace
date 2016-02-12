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
   int M,N;
   scanf("%d %d",&M,&N);

   bool arr[M][N];
   int ans = 0;
   int dx[] = {0,1,0,-1};
   int dy[] = {1,0,-1,0};

   for(int i = 0; i < M; i++)
       for(int j = 0; j < N; j++)
           arr[i][j] = false;

   for(int i = 0; i < M; i++)
       for(int j = 0; j < N; j++)
       {
           if (!arr[i][j])
           {
               for(int r = 0; r < 4; r++)
               {
                   int newI = i + dx[r];
                   int newJ = j + dy[r];

                   if (newI >= 0 && newI < M && newJ >= 0 && newJ < N && !arr[newI][newJ])
                   {
                       arr[i][j] = arr[newI][newJ] = true;
                       ans++;
                       break;
                   }
               }
           }
       }

   printf("%d",ans);
}
