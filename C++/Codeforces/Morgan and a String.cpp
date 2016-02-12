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
   int t;
   scanf("%i",&t);

   while(t-->0)
   {
       string A;
       string B;
       cin >> A >> B;

       string res = "";

       long int i = 0;
       long int j = 0;
       long int Alength = A.length();
       long int Blength = B.length();

       while(i < Alength && j < Blength)
       {
           if (A[i] == B[j])
           {
               long int k = i;
               long int r = j;
               while(A[k] == B[r])
               {
                   if (k >= Alength)
                   {
                       for (;r < Blength; r++)
                           res += B[r];
                       cout << res << endl;
                       return 0;
                   }

                   if (r >= Blength)
                   {
                       for (;k < Alength; k++)
                           res += A[k];
                       cout << res << endl;
                       return 0;
                   }
                   res += A[k];
                   k++;
                   r++;
               }
               if (A[k] < B[r])
               {
                   res += A[k];
                   i = k+1;
               }
               else
               {
                   res += B[r];
                   j = r+1;
               }
           }
           else if (A[i] < B[j])
           {
               res += A[i];
               i++;
           }
           else
           {
               res += B[j];
               j++;
           }
       }
       for(;i < Alength; i++)
           res += A[i];
       for(;j < Blength; j++)
           res += B[j];

       cout << res << endl;
   }
}
