#include <bits/stdc++.h>
#define to_string(x) dynamic_cast< std::ostringstream & >( \
       ( std::ostringstream() << std::dec << x ) ).str()
#define to_int(x) atoi(x.c_str())

using namespace std;

int main()
{
  long long x, y, m;
  cin >> x >> y >> m;

  if (m <= x || m <= y)
  {
    cout << 0 << endl;
    return 0;
  }

  if (x <= 0 && y <= 0)
  {
    cout << -1 << endl;
    return 0;
  }

  long long ans = 0;
  if (x < 0)
  {
    long long posX = abs(x);
    ans = ceil((posX*1.0)/y);
    if (posX%y == 0)
      x = 0;
    else
    {
      long long rem = posX%y;
      x = rem*(-1) + y;
    }
  }
  else if (y < 0)
  {
    long long posY = abs(y);
    ans = ceil((posY*1.0)/x);
    if (posY%x == 0)
      y = 0;
    else
    {
      long long rem = posY%x;
      y = rem*(-1) + x;
    }
  }

  queue<pair<pair<long long, long long> , long long> > q;
  q.push(make_pair(make_pair(x, y) , 0));
  while(!q.empty())
  {
    pair<pair<long long, long long> , long long> parent = q.front();
    q.pop();

    if (parent.first.first >= m || parent.first.second >= m)
    {
      ans += parent.second;
      break;
    }

    long long newNum = parent.first.first + parent.first.second;
    q.push(make_pair(make_pair(newNum, max(parent.first.first, parent.first.second)) , parent.second+1));
  }

  cout << ans << endl;
}
