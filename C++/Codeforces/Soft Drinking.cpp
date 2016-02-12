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
   int n, k, l, c, d, p, nl, np;
   cin >> n >> k >> l >> c >> d >> p >> nl >> np;

   int ans = (k*l)/nl;

   int tmp = c*d;
   if (tmp < ans)
       ans = tmp;

   tmp = p/np;
   if (tmp < ans)
       ans = tmp;

   ans /= n;
   cout << ans << endl;
}
