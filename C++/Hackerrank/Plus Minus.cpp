#include <bits/stdc++.h>

using namespace std;

int main()
{
	int n;
	scanf("%i",&n);

	int pos = 0;
	int neg = 0;
	int zero = 0;

	for (int i = 0; i < n; i++)
	{
		int a;
		scanf("%i",&a);

		if (a > 0)
			pos++;
		else if (a < 0)
			neg++;
		else
			zero++;
	}

	printf("%.6f\n%.6f\n%.6f",(double)pos/n, (double)neg/n, (double)zero/n);
}
