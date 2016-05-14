#include <bits/stdc++.h>

using namespace std;

int main()
{
	int n, x;
	scanf("%i%i",&n, &x);

	int sum = 0;
	for (int i = 0; i < n; i++)
	{
		int a;
		scanf("%i",&a);
		sum += a;
	}

	int num = abs(sum);
	int ans = num/x;
	if (num%x != 0)
		ans++;

	printf("%i\n", ans);
}