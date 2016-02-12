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
   cin >> n;

   char arr[n][n];

   for(int i = 0; i < n; i++){
       for(int j = 0; j < n; j++){
           char a;
           cin >> a;

           arr[i][j] = a;
       }
   }

   bool valid = true;
   for(int i = 0; i < n && valid; i++){
       for(int j = 0; j < n && valid; j++){
           int counter = 0;
           if (i > 0 && arr[i-1][j] == 'o')
               counter++;
           if (i < n-1 && arr[i+1][j] == 'o')
               counter++;
           if (j > 0 && arr[i][j-1] == 'o')
               counter++;
           if (j < n-1 && arr[i][j+1] == 'o')
               counter++;

           valid = (counter%2 == 0);
       }
   }

   if (valid)
       cout << "YES" << endl;
   else
       cout << "NO" << endl;
}
