#include <bits/stdc++.h>

using namespace std;

int main()
{
  int n;
  scanf("%i",&n);

  long long occMale[367];
  long long occFemale[367];
  for (int i = 0; i < 367; i++)
    occMale[i] = 0;
  for (int i = 0; i < 367; i++)
    occFemale[i] = 0;

  for (int i = 0; i < n; i++)
  {
    char g;
    int a, b;
    cin >> g;
    scanf("%i %i",&a, &b);

    for (; a <= b; a++)
    {
      if (g == 'M')
        occMale[a]++;
      else
        occFemale[a]++;
    }
  }

  long long maximum = 0;

  for (int i = 1; i < 367; i++)
  {
    long long small = min(occMale[i], occFemale[i]);
    maximum = max(maximum, 2*small);
  }

  cout << maximum << endl;
}
