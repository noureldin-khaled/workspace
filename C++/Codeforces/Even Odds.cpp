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

using namespace std;


int main()
{
   long long n,k;
   cin >> n >> k;

   long long length = n;
   if (n%2 != 0)
       length++;
   if (k <= (length/2)){
       long long i = 1;
       long long num = 1;
       while(i < k){
           num+=2;
           i++;
       }
       cout << num << endl;
   }
   else {
       long long i = (length/2)+1;
       long long num = 2;
       while(i < k){
           num+=2;
           i++;
       }
       cout << num << endl;
   }
}
