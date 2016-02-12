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

using namespace std;

int main()
{
   int n,m;
   cin >> n >> m;

   char arr[n][m];

   for(int i = 0; i < n; i++)
       for(int j = 0; j < m; j++)
           arr[i][j] = '.';

   bool right = true;
   for(int i = 0; i < n; i++) {
       if (i%2 == 0){
           for (int j = 0; j < m; j++)
               arr[i][j] = '#';
       }
       else {
           if (right)
               arr[i][m-1] = '#';
           else
               arr[i][0] = '#';

           right = !right;
       }
   }

   for(int i = 0; i < n; i++) {
       for(int j = 0; j < m; j++)
           cout << arr[i][j];
       cout << endl;
   }

}
