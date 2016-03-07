#include <bits/stdc++.h>

using namespace std;

int main()
{
  int n;
  scanf("%i", &n);

  long long arr[n];
  arr[0] = 2;
  for (int i = 1; i < n; i++)
    arr[i] = arr[i-1]*2;

  long long ans = 0;
  for (int i = 0; i < n; i++)
    ans += arr[i];

  cout << ans << endl;
}
