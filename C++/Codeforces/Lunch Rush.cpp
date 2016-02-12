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
   long long n,k;
   cin >> n >> k;

   long long maximum = -1000000001;
   for(int i = 0; i < n; i++){
       long long f,t;
       cin >> f >> t;

       if (t > k)
           f -= (t-k);

       if (f > maximum)
           maximum = f;
   }

   cout << maximum << endl;
}
