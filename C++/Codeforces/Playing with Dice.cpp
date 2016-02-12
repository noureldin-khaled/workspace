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
   int a,b;
   scanf("%i %i",&a,&b);

   int firstWins = 0;
   int secondWins = 0;
   int draw = 0;

   for(int i = 1; i <= 6; i++){
       int firstDist = abs(a-i);
       int secondDist = abs(b-i);

       if (firstDist == secondDist)
           draw++;
       else if (firstDist < secondDist)
           firstWins++;
       else
           secondWins++;
   }

   printf("%i %i %i",firstWins,draw,secondWins);
}
