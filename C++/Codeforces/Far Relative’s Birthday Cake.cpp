#include <bits/stdc++.h>

using namespace std;

int main()
{
  int n;
  scanf("%i",&n);
  char grid[n][n];

  for (int i = 0; i < n; i++)
  {
    string line;
    cin >> line;
    for (int j = 0; j < n; j++)
      grid[i][j] = line[j];
  }

  long long ans = 0;
  for (int i = 0; i < n; i++)
  {
    int cur = 0;
    for (int j = 0; j < n; j++)
      if (grid[i][j] == 'C')
        cur++;
    ans += (long long)(cur*(cur-1))/2;
  }


  for (int j = 0; j < n; j++)
  {
    int cur = 0;
    for (int i = 0; i < n; i++)
      if (grid[i][j] == 'C')
        cur++;
    ans += (long long)(cur*(cur-1))/2;
  }

  cout << ans << endl;
}
