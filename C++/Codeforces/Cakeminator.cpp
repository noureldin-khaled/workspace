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

bool contains(set<int> a,int num);
int main()
{
   int n,m;
   cin >> n >> m;

   char arr[n][m];
   set<int> invalidRows;
   set<int> invalidColumns;

   for(int i = 0; i < n; i++){
       for(int j = 0; j < m; j++){
           char c;
           cin >> c;
           if (c == 'S'){
               invalidRows.insert(i);
               invalidColumns.insert(j);
           }
           arr[i][j] = c;
       }
   }

   int cellsEaten = 0;
   for(int i = 0;i < n;i++){
       if (contains(invalidRows,i))
           continue;
       for(int j = 0;j < m;j++){
           if (arr[i][j] == '.'){
               cellsEaten++;
               arr[i][j] = 'E';
           }
       }
   }

   for(int j = 0;j < m;j++){
       if (contains(invalidColumns,j))
           continue;
       for(int i = 0;i < n;i++){
           if (arr[i][j] == '.'){
               cellsEaten++;
               arr[i][j] = 'E';
           }
       }
   }

   cout << cellsEaten << endl;
}

bool contains(set<int> a,int num){
   for (set<int>::iterator i = a.begin(); i != a.end(); i++) {
       int element = *i;
       if (element == num)
           return true;
   }
   return false;
}
