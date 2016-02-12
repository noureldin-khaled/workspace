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
   long long n;
   cin >> n;

   pair<long long,long long> arr[n];

   for(int i = 0; i < n; i++){
       long long a,b;
       cin >> a >> b;

       arr[i] = make_pair(a,b);
   }

   sort(arr,arr+n);

   long long minimum = arr[0].second;
   bool valid = false;
   for(int i = 1; i < n && !valid; i++){
       if (arr[i].second < minimum)
           valid = true;
       minimum = arr[i].second;
   }

   if (valid)
       cout << "Happy Alex" << endl;
   else
       cout << "Poor Alex" << endl;
}
