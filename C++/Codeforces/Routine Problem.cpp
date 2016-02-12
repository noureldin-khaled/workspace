#include <bits/stdc++.h>

using namespace std;

long long gcd(long long a, long long b)
{
   return b == 0 ? a : gcd(b, a % b);
}

long long lcm(long long a,long long b)
{
	return (a*b)/gcd(a,b);
}

int main()
{
   long long a,b,c,d;
   cin >> a >> b >> c >> d;

   long long lcm_a_c = lcm(a,c);
   long long lcm_b_d = lcm(b,d);

   if (b*(lcm_a_c/a) >= d*(lcm_a_c/c))
   {
       b *= lcm_a_c/a;
       d *= lcm_a_c/c;
       a = c = lcm_a_c;
   }
   else
   {
       a *= lcm_b_d/b;
       c *= lcm_b_d/d;
       b = d = lcm_b_d;
   }

   long long totalArea = a*b;
   long long filmArea = c*d;

   long long emptyArea = totalArea-filmArea;

   long long g = gcd(emptyArea,totalArea);
   cout << emptyArea/g << "/" << totalArea/g << endl;
}
