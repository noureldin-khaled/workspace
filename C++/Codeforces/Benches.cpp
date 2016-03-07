#include <bits/stdc++.h>

using namespace std;

int main()
{
  long long n;
  cin >> n;

  long long P = n*(n-1)*(n-2)*(n-3)*(n-4);
  long long C = P/120;

  cout << P*C << endl;
}
