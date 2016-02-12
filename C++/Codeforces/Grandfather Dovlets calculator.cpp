#include <bits/stdc++.h>

using namespace std;
long long getSegements(int num);

int arr[10] = {6, 2, 5, 5, 4, 5, 6, 3, 7, 6};
int main()
{
   int a, b;
   scanf("%i %i",&a, &b);

   long long ans = 0;
   for(; a <= b; a++)
       ans += getSegements(a);

   cout << ans << endl;
}

long long getSegements(int num)
{
   long long sum = 0;
   while(num > 0)
   {
       int digit = num%10;
       sum += arr[digit];
       num /= 10;
   }
   return sum;
}
