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
   long long s,n;
   cin >> s >> n;

   pair<long long,long long> arr[n];

   for(int i = 0;i < n; i++){
       long long x,y;
       cin >> x >> y;

       arr[i] = make_pair(x,y);
   }

   sort(arr,arr+n);

   bool won = true;
   for(int i = 0; i < n && won; i++){
       if (s <= arr[i].first)
           won = false;
       s += arr[i].second;
   }

   if (won)
       cout << "YES" << endl;
   else
       cout << "NO" << endl;
}
