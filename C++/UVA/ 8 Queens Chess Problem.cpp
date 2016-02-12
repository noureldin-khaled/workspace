#include <bits/stdc++.h>

using namespace std;

int main()
{
   int t;
   scanf("%i",&t);

   while(t--)
   {
       int arr[8];
       int x, y;
       scanf("%i %i",&x, &y);
       x--;
       y--;

       printf("SOLN       COLUMN\n #      1 2 3 4 5 6 7 8\n\n");
       int sol = 1;
       for(int i = 0; i < 8; i++)
       {
           memset(arr, -1, sizeof arr);
           arr[0] = i;
           bool can = true;
           for(int j = 0; j < 8 && can; j++)
           {
               if (0 == j || arr[j] == -1) continue;
               if (abs(0-j) == abs(arr[0]-arr[j]))
                   can = false;
           }
           if (!can)
               continue;
           for(int k = 0; k < 8; k++)
           {
               if (i == k) continue;
               memset(arr, -1, sizeof arr);
               arr[0] = i;
               arr[1] = k;
               bool can2 = true;
               for(int j = 0; j < 8 && can2; j++)
               {
                   if (1 == j || arr[j] == -1) continue;
                   if (abs(1-j) == abs(arr[1]-arr[j]))
                       can2 = false;
               }
               if (!can2)
                   continue;

               for(int r = 0; r < 8; r++)
               {
                   if (r == k || r == i) continue;
                   memset(arr, -1, sizeof arr);
                   arr[0] = i;
                   arr[1] = k;
                   arr[2] = r;
                   bool can3 = true;
                   for(int j = 0; j < 8 && can3; j++)
                   {
                       if (2 == j || arr[j] == -1) continue;
                       if (abs(2-j) == abs(arr[2]-arr[j]))
                           can3 = false;
                   }
                   if (!can3)
                       continue;

                   for(int l = 0; l < 8; l++)
                   {
                       if (l == r || l == k || l == i) continue;
                       memset(arr, -1, sizeof arr);
                       arr[0] = i;
                       arr[1] = k;
                       arr[2] = r;
                       arr[3] = l;

                       bool can4 = true;
                       for(int j = 0; j < 8 && can4; j++)
                       {
                           if (3 == j || arr[j] == -1) continue;
                           if (abs(3-j) == abs(arr[3]-arr[j]))
                               can4 = false;
                       }
                       if (!can4)
                           continue;

                       for(int m = 0; m < 8; m++)
                       {
                           if (m == l || m == r || m == k || m == i) continue;
                           memset(arr, -1, sizeof arr);
                           arr[0] = i;
                           arr[1] = k;
                           arr[2] = r;
                           arr[3] = l;
                           arr[4] = m;

                           bool can5 = true;
                           for(int j = 0; j < 8 && can5; j++)
                           {
                               if (4 == j || arr[j] == -1) continue;
                               if (abs(4-j) == abs(arr[4]-arr[j]))
                                   can5 = false;
                           }
                           if (!can5)
                               continue;

                           for(int n = 0; n < 8; n++)
                           {
                               if (n == m || n == l || n == r || n == k || n == i) continue;
                               memset(arr, -1, sizeof arr);
                               arr[0] = i;
                               arr[1] = k;
                               arr[2] = r;
                               arr[3] = l;
                               arr[4] = m;
                               arr[5] = n;

                               bool can6 = true;
                               for(int j = 0; j < 8 && can6; j++)
                               {
                                   if (5 == j || arr[j] == -1) continue;
                                   if (abs(5-j) == abs(arr[5]-arr[j]))
                                       can6 = false;
                               }
                               if (!can6)
                                   continue;

                               for(int s = 0; s < 8; s++)
                               {
                                   if (s == n || s == m || s == l || s == r || s == k || s == i) continue;
                                   memset(arr, -1, sizeof arr);
                                   arr[0] = i;
                                   arr[1] = k;
                                   arr[2] = r;
                                   arr[3] = l;
                                   arr[4] = m;
                                   arr[5] = n;
                                   arr[6] = s;

                                   bool can7 = true;
                                   for(int j = 0; j < 8 && can7; j++)
                                   {
                                       if (6 == j || arr[j] == -1) continue;
                                       if (abs(6-j) == abs(arr[6]-arr[j]))
                                           can7 = false;
                                   }
                                   if (!can7)
                                       continue;

                                   for(int b = 0; b < 8; b++)
                                   {
                                       if (b == s || b == n || b == m || b == l || b == r || b == k || b == i) continue;
                                       memset(arr, -1, sizeof arr);
                                       arr[0] = i;
                                       arr[1] = k;
                                       arr[2] = r;
                                       arr[3] = l;
                                       arr[4] = m;
                                       arr[5] = n;
                                       arr[6] = s;
                                       arr[7] = b;

                                       bool can8 = true;
                                       for(int j = 0; j < 8 && can8; j++)
                                       {
                                           if (7 == j || arr[j] == -1) continue;
                                           if (abs(7-j) == abs(arr[7]-arr[j]))
                                               can8 = false;
                                       }
                                       if (!can8)
                                           continue;

                                       if (arr[y] == x)
                                       {
                                           if (sol < 10)
                                               printf(" ");
                                           printf("%i      %i %i %i %i %i %i %i %i\n",sol,i+1,k+1,r+1,l+1,m+1,n+1,s+1,b+1);
                                           sol++;
                                       }
                                   }
                               }
                           }
                       }
                   }
               }
           }
       }

       if (t > 0)
           puts("");
   }
}
