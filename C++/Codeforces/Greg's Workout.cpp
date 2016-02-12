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
   int n;
   scanf("%i",&n);

   int chest = 0;
   int biceps = 0;
   int backk = 0;

   int c = 1;
   for(int i = 0; i < n; i++){
       int a;
       scanf("%i",&a);
       if (c == 1){
           chest+=a;
           c = 2;
       }
       else if (c == 2){
           biceps+=a;
           c = 3;
       }
       else
       {
           backk+=a;
           c = 1;
       }
   }

   if (chest > biceps && chest > backk)
       printf("%s","chest");
   if (biceps > chest && biceps > backk)
       printf("%s","biceps");
   if (backk > biceps && backk > chest)
       printf("%s","back");

}
