#include <bits/stdc++.h>

using namespace std;

int main()
{
  int n;
  scanf("%i", &n);

  long long or1 = 0;
  long long or2 = 0;
  for (int i = 0; i < n; ++i)
  {
    int a;
    scanf("%i",&a);
    or1 |= a;
  }

  for (int i = 0; i < n; ++i)
  {
    int a;
    scanf("%i",&a);
    or2 |= a;
  }

  cout << or1 + or2 << endl;
}