#include <bits/stdc++.h>

using namespace std;

bool isPalindrome(long long num);
long long power(int base,int p);
long long rev(long long num);

int main()
{
   int t;
   scanf("%i",&t);

   while(t--)
   {
       long long p;
       cin >> p;

       int countt = 0;
       while(true)
       {
           if (isPalindrome(p))
               break;
           p = p + rev(p);
           countt++;
       }
       cout << countt << " " << p << endl;
   }
}

long long power(int base,int p)
{
   if (p == 0)
       return 1;
   return base*power(base,p-1);
}

long long rev(long long num)
{
   long long revnum = 0;
   int len = 0;
   long long temp = num;
   while(temp != 0)
   {
       temp /= 10;
       len++;
   }
   if (len == 0 || len == 1)
       return num;

   len--;
   while(num != 0)
   {
       int digit = num%10;
       revnum += digit*power(10,len);
       len--;
       num /= 10;
   }
   return revnum;
}


bool isPalindrome(long long num)
{
   long long revnum = rev(num);
   return num == revnum;
}
