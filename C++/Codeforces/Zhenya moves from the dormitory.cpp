#include <bits/stdc++.h>
#define fast ios_base::sync_with_stdio(0);cin.tie(0);

using namespace std;

int main()
{
	int maxRent, adv1, adv2;
	scanf("%i%i%i",&maxRent, &adv1, &adv2);

	int n;
	scanf("%i",&n);
	pair<int, int> a[n];
	for (int i = 0; i<  n; i++)
	{
		int m, adv;
		scanf("%i%i",&m,&adv);
		a[i] = make_pair(m, adv);
	}

	int q;
	scanf("%i",&q);
	pair<int, pair<int, int> > b[q];

	for (int i = 0; i<  q; i++)
	{
		int type, m, adv;
		scanf("%i%i%i",&type,&m,&adv);

		b[i] = make_pair(type , make_pair(m, adv));
	}

	int ans = -1;
	int partner = -1;
	int room = -1;

	for (int i = 0; i < q; i++)
	{
		if (maxRent >= b[i].second.first)
		{
			int cur = b[i].second.second;
			if (b[i].first == 1)
				cur += adv1;
			else
				cur += adv2;
			if (ans == -1 || cur > ans)
			{
				ans = cur;
				room = i;
			}
		}
	}

	for (int i = 0; i < n; i++)
	{
		for (int j = 0; j < q; j++)
		{
			if (b[j].first == 1) continue;
			double halfRent = b[j].second.first/2.0;
			if (maxRent >= halfRent && a[i].first >= halfRent)
			{
				int cur = b[j].second.second + a[i].second;
				if (ans == -1 || cur > ans)
				{
					ans = cur;
					room = j;
					partner = i;
				}
			}
		}
	}

	if (ans == -1)
		puts("Forget about apartments. Live in the dormitory.");
	else 
	{
		if (partner == -1)
		{
			printf("You should rent the apartment #%i alone.\n", room+1);
		}
		else
		{
			printf("You should rent the apartment #%i with the friend #%i.\n", room+1, partner+1);
		}
	}
}