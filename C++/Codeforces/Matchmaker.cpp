#include <bits/stdc++.h>

using namespace std;

int main()
{
	int n, m;
	scanf("%i%i", &n,&m);

	pair<int, int> markers[n];
	pair<int, int> caps[m];
	for (int i = 0; i < n; i++)
	{
		int x, y;
		scanf("%i%i",&x,&y);

		markers[i] = make_pair(x, y);
	}

	for (int i = 0; i < m; i++)
	{
		int x, y;
		scanf("%i%i",&x,&y);

		caps[i] = make_pair(x, y);
	}

	sort(markers, markers+n);
	sort(caps, caps+m);

	int index1 = 0;
	int index2 = 0;

	int c = 0;
	int b = 0;
	while(index1 < n && index2 < m)
	{
		if (markers[index1].first == caps[index2].first)
		{
			if (markers[index1].second == caps[index2].second)
			{
				b++;
				c++;
				markers[index1] = make_pair(-1,-1);
				caps[index2] = make_pair(-1,-1);
				index1++;
				index2++;
			}
			else if (markers[index1].second < caps[index2].second)
				index1++;
			else 
				index2++;
		}
		else if (markers[index1].first < caps[index2].first)
			index1++;
		else
			index2++;
	}

	for (int i = 0; i < n; i++)
	{
		pair<int, int> cur = markers[i];
		markers[i] = make_pair(cur.second, cur.first);
	}

	for (int i = 0; i < m; i++)
	{
		pair<int, int> cur = caps[i];
		caps[i] = make_pair(cur.second, cur.first);
	}

	sort(markers, markers+n);
	sort(caps, caps+m);
	
	index1 = 0;
	index2 = 0;
	while(index1 < n && index2 < m)
	{
		if (markers[index1].first == -1 && markers[index1].second == -1)
		{
			index1++;
			continue;
		}

		if (caps[index2].first == -1 && caps[index2].second == -1)
		{
			index2++;
			continue;
		}

		if (markers[index1].first == caps[index2].first)
		{
			c++;
			index1++;
			index2++;
		}
		else if (markers[index1].first < caps[index2].first)
			index1++;
		else
			index2++;
	}

	printf("%i %i\n",c,b);
}
