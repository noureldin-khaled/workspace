#include <bits/stdc++.h>

using namespace std;

int main()
{
	long long ax, ay, bx, by, tx, ty;
	cin >> ax >> ay >> bx >> by >> tx >> ty;

	int n;
	scanf("%i",&n);

	pair<double, int> saveByA[n];
	pair<double, int> saveByB[n];
	double ans = 0;
	for (int i = 0; i < n; i++)
	{
		int x, y;
		scanf("%i%i",&x,&y);

		double distFromBin = sqrt((long long)(x-tx)*(x-tx) + (long long)(y-ty)*(y-ty));
		double distFromA = sqrt((long long)(x-ax)*(x-ax) + (long long)(y-ay)*(y-ay));
		double distFromB = sqrt((long long)(x-bx)*(x-bx) + (long long)(y-by)*(y-by));

		saveByA[i] = make_pair((2*distFromBin - (distFromBin + distFromA)), i);
		saveByB[i] = make_pair((2*distFromBin - (distFromBin + distFromB)), i);
		ans += 2*distFromBin;
	}

	sort(saveByA, saveByA + n);
	reverse(saveByA, saveByA + n);
	sort(saveByB, saveByB + n);
	reverse(saveByB, saveByB + n);

	if (n == 1)
		ans -= max(saveByA[0].first, saveByB[0].first);
	else
	{
		double ans1 = ans;
		if (saveByA[0].second != saveByB[0].second)
			ans1 -= (saveByA[0].first + saveByB[0].first);
		else 
			ans1 -= max(saveByA[0].first + saveByB[1].first, saveByA[1].first + saveByB[0].first);

		double adil = ans - saveByA[0].first;
		double bera = ans - saveByB[0].first;
		ans = min(ans1, min(adil, bera));
	}

	printf("%.12f\n", ans);
}
