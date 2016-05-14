#include <bits/stdc++.h>

using namespace std;

int main()
{
	int n, m, k;
	scanf("%i%i%i",&n,&m,&k);

	int first = 0;
	int second = 0;

	for (int i = 0; i < n; i++)
	{
		int a;
		scanf("%i",&a);

		if (a == 1)
			first++;
		else
			second++;
	}

	int ans = 0;
	if (m >= first)
		m -= first;
	else
	{
		ans += first - m;
		m = 0;
	}

	if (m+k < second)
		ans += second - (m+k);

	printf("%i\n",ans);
}
