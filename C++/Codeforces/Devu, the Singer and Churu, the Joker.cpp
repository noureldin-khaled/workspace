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

using namespace std;

int main()
{
   int n,d;
   cin >> n >> d;

   int arr[n];
   int sum = 0;
   for(int i = 0; i < n; i++){
       int a;
       cin >> a;
       arr[i] = a;
       sum += a;
   }

   int singingTime = (n-1)*10 + sum;
   if (singingTime > d)
       cout << -1 << endl;
   else {
       int jokes = (n-1)*2;
       int remTime = d-singingTime;
       jokes += remTime/5;
       cout << jokes << endl;
   }
}
