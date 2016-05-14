#include <bits/stdc++.h>

using namespace std;

int main()
{
	int n, k, q;
	scanf("%i%i%i", &n, &k, &q);

	int arr[n];
	for (int i = 0; i < n; i++)
		scanf("%i",&arr[i]);

	priority_queue<pair<int,int> > pq;
	while(q--)
	{
		int type, id;
		scanf("%i%i",&type, &id);

		if (type == 1)
			pq.push(make_pair(arr[id-1], id));
		else
		{
			bool found = false;
			int i = 0;
			priority_queue<pair<int,int> > tmp;

			while(!pq.empty() && i < k)
			{
				pair<int, int> cur = pq.top();
				pq.pop();
				tmp.push(cur);
				if (id == cur.second)
				{
					found = true;
					break;
				}
				i++;
			}

			while(!tmp.empty())
			{
				pq.push(tmp.top());
				tmp.pop();
			}

			if (found)
				puts("YES");
			else
				puts("NO");
		}
	}

}
