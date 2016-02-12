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
   long long v;
   cin >> n >> v;

   vector<int> ans;
   for(int i = 1; i <= n; i++){
       int k;
       cin >> k;
       long long arr[k];
       for(int j = 0; j < k; j++){
           long long s;
           cin >> s;
           arr[j] = s;
       }

       for(int j = 0; j < k; j++){
           if (v > arr[j]){
               ans.push_back(i);
               break;
           }
       }
   }

   int size = ans.size();
   cout << size << endl;
   for(int i = 0; i < size; i++)
       if (i == size-1)
           cout << ans[i];
       else
           cout << ans[i] << " ";
}
