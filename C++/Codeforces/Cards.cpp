#include <bits/stdc++.h>

using namespace std;

int main()
{
   int n;
   scanf("%i",&n);

   string line;
   cin >> line;

   int occR = 0;
   int occG = 0;
   int occB = 0;

   for (int i = 0; i < n; i++)
   {
       if (line[i] == 'R')
           occR++;
       if (line[i] == 'G')
           occG++;
       if (line[i] == 'B')
           occB++;
   }

   if (occB > 0 && occG > 0 && occR > 0)
   {
       puts("BGR");
       return 0;
   }

   if (occB == 0 && occG > 0 && occR > 0)
   {
       printf("B");
       if (occG > 1 && occR > 1)
           printf("GR");
       else
       {
           if (occG == 1 && occR == 1)
               return 0;
           else if (occR == 1)
               printf("R");
           else
               printf("G");
       }

       return 0;
   }

   if (occG == 0 && occB > 0 && occR > 0)
   {
       if (occB > 1 && occR > 1)
           printf("BGR");
       else
       {
           if (occB == 1 && occR == 1)
               printf("G");
           else if (occR == 1)
               printf("GR");
           else
               printf("BG");
       }

       return 0;
   }

   if (occR == 0 && occB > 0 && occG > 0)
   {
       if (occB > 1 && occG > 1)
           printf("BGR");
       else
       {
           if (occB == 1 && occG == 1)
               printf("R");
           else if (occG == 1)
               printf("GR");
           else
               printf("BR");
       }

       return 0;
   }

   if (occB > 0)
   {
       puts("B");
       return 0;
   }
   if (occG > 0)
   {
       puts("G");
       return 0;
   }
   if (occR > 0)
   {
       puts("R");
       return 0;
   }

}
