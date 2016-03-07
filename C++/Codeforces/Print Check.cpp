#include <bits/stdc++.h>

using namespace std;

int main()
{
  int n, m, k;
  scanf("%i %i %i",&n, &m, &k);

  pair<int, int> arr[n+1][m+1];

  for (int i = 0; i < k; i++)
  {
    int t, x, c;
    scanf("%i %i %i",&t, &x, &c);

    if (t == 1) // row
      arr[x][0] = make_pair(c, i);
    else // column
      arr[0][x] = make_pair(c, i);
  }

  for (int i = 1; i < n+1; i++)
  {
    if (arr[i][0].first == 0) continue;

    for (int j = 1; j < m+1; j++)
    {
      if (arr[i][j].first == 0 || arr[i][0].second > arr[i][j].second)
      {
        arr[i][j].first = arr[i][0].first;
        arr[i][j].second = arr[i][0].second;
      } 
    }
  }

  for (int j = 1; j < m+1; j++)
  {
    if (arr[0][j].first == 0) continue;

    for (int i = 1; i < n+1; i++)
    {
      if (arr[i][j].first == 0 || arr[0][j].second > arr[i][j].second)
      {
        arr[i][j].first = arr[0][j].first;
        arr[i][j].second = arr[0][j].second;
      }
    }
  }

  for (int i = 1; i < n+1; i++)
  {
    for (int j = 1; j < m+1; j++)
      cout << arr[i][j].first << " ";
    cout << endl;
  }
}