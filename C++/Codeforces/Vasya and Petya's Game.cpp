#include<iostream>
#include<string>
#include<cstring>
#include<sstream>
#include<string.h>
#include<algorithm>
#include<cmath>
#include<math.h>
#include<fstream>
#include<cstdlib>
#include<vector>
#include<stdlib.h>
#include<set>
#include<stdio.h>
#include<limits>

using namespace std;

bool isPrime(int number);

int power(int base,int p)
{
   if (p == 0)
       return 1;
   return base*power(base,p-1);
}

int main()
{
   int n;
   scanf("%d",&n);

   vector<int> arr;
   for(int i = 2; i <= n; i*=2)
       arr.push_back(i);
   for(int i = 3; i <= n; i+=2){
       if (isPrime(i)){
           arr.push_back(i);
           for(int j = 2; pow(i,j) <= n; j++)
               arr.push_back((int)pow(i,j));
       }
   }

   int sizee = arr.size();
   printf("%d\n",sizee);

   for(int i = 0; i < sizee; i++)
       if (i == sizee-1)
           printf("%d",arr[i]);
       else
           printf("%d ",arr[i]);

}

bool isPrime(int number) {
   int i;
   for (i=2; i*i<=number; i++) {
       if (number % i == 0) return false;
   }
   return true;
}
