#include <bits/stdc++.h>

using namespace std;

long long Ceil(long long a, long long b) ;
int main()
{
	int n, h, k;
	scanf("%i%i%i",&n,&h,&k);

	long long cur = 0;
	long long ans = 0;
	for (int i = 0; i < n; i++)
	{
		int a;
		scanf("%i",&a);

		if (cur + a <= h)
			cur += a;
		else
		{
			int tol = h - a;
			int rid = cur - tol;
			if (rid < k)
				rid = k;

			long long b = Ceil(rid, k);
			ans += b;

			cur -= b*k;
			if (cur < 0)
				cur = 0;
			cur += a;
		}

	}

	if (cur > 0)
		ans += Ceil(cur, k);

	cout << ans << endl;
}

long long Ceil(long long a, long long b) 
{
  return a%b == 0 ? a/b : a/b + 1;
}