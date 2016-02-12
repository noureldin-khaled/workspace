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
int lcm(int a,int b);
int lcm3(int a,int b,int c) ;
int lcm4(int a,int b,int c,int d);
int main()
{
   int k,l,m,n,d;
   cin >> k >> l >> m >> n >> d;

   int n1 = d/k + d/l + d/m + d/n;
   int n2 = d/lcm(k,l) + d/lcm(k,m) + d/lcm(k,n) + d/lcm(l,m) + d/lcm(l,n) + d/lcm(m,n);
   int n3 = d/lcm3(k,l,m) + d/lcm3(k,l,n) + d/lcm3(k,m,n) + d/lcm3(l,m,n);
   int n4 = d/lcm4(k,l,m,n);
   int res = n1-n2+n3-n4;
   cout << res << endl;
}

int lcm(int a,int b){
   int maximum = (a > b) ? a : b;
   do {
       if (maximum%a == 0 && maximum%b == 0)
           return maximum;
       else
           ++maximum;
   }
   while (true);
}

int lcm3(int a,int b,int c) {
   return lcm(a,lcm(b,c));
}

int lcm4(int a,int b,int c,int d) {
   return lcm(lcm(a,b),lcm(c,d));
}
