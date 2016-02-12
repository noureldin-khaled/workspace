#include <bits/stdc++.h>

using namespace std;

int main()
{
   int x1, y1, x2, y2;
   scanf("%i %i",&x1, &y1);
   scanf("%i %i",&x2, &y2);

   long long ans = max(abs(x1-x2) , abs(y1-y2));
   cout << ans << endl;
}
