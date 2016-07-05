#include <bits/stdc++.h>

using namespace std;

int main()
{
	int n;
	scanf("%i",&n);
	int minX = 1000000001;
	int minY = 1000000001;
	int maxX = -1000000001;
	int maxY = -1000000001;

	for (int i = 0; i < n; i++)
	{
		int x, y;
		scanf("%i%i",&x,&y);

		minX = min(minX, x);
		minY = min(minY, y);
		maxX = max(maxX, x);
		maxY = max(maxY, y);
	}

	int s = max(maxX - minX, maxY - minY);
	cout << (long long)s*s << endl;
}
