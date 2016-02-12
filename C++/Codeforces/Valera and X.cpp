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
   cin >> n;

   char arr[n][n];

   for(int i = 0; i < n; i++)
       for(int j = 0; j < n; j++){
           char c;
           cin >> c;
           arr[i][j] = c;
   }

   char diagonal = arr[0][0];
   char others = arr[0][1];

   bool valid = true;

   if (others == diagonal)
       valid = false;
   for(int i = 0; i < n && valid; i++)
       for(int j = 0; j < n && valid; j++){
           if (i == j || j == n-i-1){
               if (arr[i][j] != diagonal)
                   valid = false;
           }
           else {
              if (arr[i][j] != others)
                   valid = false;
           }
   }

   if (valid)
       cout << "YES" << endl;
   else
       cout << "NO" << endl;
}
