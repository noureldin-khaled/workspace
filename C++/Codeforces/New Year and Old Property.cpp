#include <bits/stdc++.h>

using namespace std;

unsigned long long power(int base,int p)
{
   if (p == 0)
       return 1;
   return base*power(base,p-1);
}

int main()
{
   unsigned long long p[64];

   for(int i = 0; i < 64; i++)
       p[i] = power(2,i);

   unsigned long long a, b;
   cin >> a >> b;

   int index = 1;
   long long ans = 0;
   while(index < 64)
   {
       unsigned long long curValue = p[index];
       int pos = 2;
       int len = index+1;
       for(int i = 0; i < index; i++)
       {
           curValue += p[len-pos]-1;
           if (curValue >= a && curValue <= b)
               ans++;
           curValue++;
           pos++;
       }
       index++;
   }

   cout << ans << endl;
}
