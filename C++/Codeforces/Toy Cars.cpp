#include <bits/stdc++.h>

using namespace std;

int main()
{
	int n;
	scanf("%i",&n);

	vector<int> v;
	for (int i = 1; i <= n; i++)
	{
		bool valid = true;
		for (int j = 0; j < n; j++)
		{
			int a;
			scanf("%i",&a);

			if (a == 1 || a == 3)
				valid = false;
		}

		if (valid)
			v.push_back(i);
	}

	int s = v.size();
	printf("%i\n", s);
	for (int i = 0; i < s; i++)
		printf("%i ", v[i]);
}