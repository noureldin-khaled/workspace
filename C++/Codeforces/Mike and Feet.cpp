#include <bits/stdc++.h>
#define fast ios_base::sync_with_stdio(0);cin.tie(0);

using namespace std;

int main()
{
	fast

	int n;
	cin >> n;
	int a[n];

	for (int i = 0; i < n; i++)
		cin >> a[i];

	int left[n];
	int right[n];

	stack<int> st;
	for (int i = 0; i < n; i++)
	{
		int idx = i;
		while(!st.empty() && a[st.top()] >= a[i])
		{
			idx = st.top();
			st.pop();
		}

		left[i] = abs(i-idx);
		if (i != idx)
			left[i] += left[idx];
		st.push(i);
	}

	while(!st.empty()) st.pop();

	for (int i = n-1; i >= 0; i--)
	{
		int idx = i;
		while(!st.empty() && a[st.top()] >= a[i])
		{
			idx = st.top();
			st.pop();
		}

		right[i] = abs(i-idx);
		if (idx != i)
			right[i] += right[idx];
		st.push(i);
	}

	int l[n+1];
	memset(l, 0, sizeof l);

	for (int i = 0; i < n; i++)
	{
		int m = left[i]+right[i]+1;
		l[m] = max(l[m], a[i]);
	}

	stack<int> res;
	int cur = 0;
	for (int i = n; i >= 1; i--)
	{
		cur = max(cur, l[i]);
		res.push(cur);
	}

	while(!res.empty())
	{
		cout << res.top() << " ";
		res.pop();
	}
}
