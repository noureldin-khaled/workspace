#include<iostream>
#include<string>
#include<cstring>
#include<sstream>
#include<string.h>
#include<algorithm>
#include<cmath>
#include<cstdlib>
#include<vector>
#include<stdlib.h>
#include<set>
#include<stdio.h>
#include<stack>

using namespace std;

int main()
{
   int n;
   scanf("%i",&n);

   int arr[n];
   for(int i = 0; i < n; i++)
       scanf("%i",&arr[i]);

   stack<int> s;
   s.push(0);
   int maximum = arr[n-1];
   for(int i = n-2; i >= 0; i--)
   {
       if (arr[i] > maximum)
           s.push(0);
       else
           s.push(maximum-arr[i]+1);

       maximum = max(maximum,arr[i]);
   }

   for(int i = 0; i < n; i++) {
       printf("%i ",s.top());
       s.pop();
   }
}
