#include <bits/stdc++.h>

using namespace std;

int main()
{
	int n;
	scanf("%i",&n);

	priority_queue<int, vector<int>, greater<int> > pq;
	for (int i = 0; i < n; i++)
	{
		int a;
		scanf("%i",&a);

		pq.push(a);
	}
	
	int s = pq.size();
	int ans = 0;	
	while(s > 0)
	{
		int cur = pq.top();pq.pop();
		s--;
		int nxt = -1;
		if (s > 0)
			nxt = pq.top();

		if (cur == nxt)
		{
			pq.pop();
			s--;
			pq.push(cur+1);
			s++;
		}
		else
			ans++;
	
	}
	printf("%i\n", ans);
}
