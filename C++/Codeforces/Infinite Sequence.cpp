#include <bits/stdc++.h>

using namespace std;

int main()
{
  long long n;
  cin >> n;

  long long pos = 1;
  long long cur = 1;
  while (pos + cur <= n) {
    pos += cur;
    cur++;
  }

  long long ans = 1;
  if (pos != n)
    ans += (n-pos);
  cout << ans << endl;
}
