#include <bits/stdc++.h>
#define fast ios_base::sync_with_stdio(0);cin.tie(0);

using namespace std;

int n, m;
int a[100005];
vector<pair<int, int> > b;
int len;

bool valid(int ans);
bool there(int l, int r);
bool there(long long l, long long r);
int main()
{
	fast
	cin >> n >> m;

	for (int i = 0; i < n; i++)
		cin >> a[i];

	int prev = -1000000001;
	int last = 0;
	for (int i = 0; i < m; i++)
	{
		int p;
		cin >> p;

		if (p == prev)
		{
			pair<int, int> cur = b.back();
			b.pop_back();
			b.push_back(make_pair(cur.first, cur.second+1));
			last = cur.second+1;
		}
		else
		{
			b.push_back(make_pair(p, last+1));
			last++;
		}

		prev = p;
	}
	len = b.size();

	int low = 0;
	int high = 2000000001;
	int ans = -1;

	while(low <= high)
	{
		int mid = low + (high-low)/2;

		if (valid(mid))
		{
			ans = mid;
			high = mid-1;
		}
		else
			low = mid+1;
	}

	cout << ans << endl;
}

bool valid(int ans)
{
	bool valid = true;
	
	for (int i = 0; i < n; i++)
	{
		long long l = (long long)a[i]-ans;
		long long r = (long long)a[i]+ans;

		valid &= there(l, r);
	}

	return valid;
}

bool there(long long l, long long r)
{
	int low = 0;
	int high = len-1;
	int ans1 = -1;

	while(low <= high)
	{
		int mid = low + (high-low)/2;

		if (b[mid].first <= r)
		{
			ans1 = mid;
			low = mid+1;
		}
		else
			high = mid-1;
	}

	if (ans1 == -1)
		return false;

	low = 0;
	high = len-1;
	int ans2 = -1;

	while(low <= high)
	{
		int mid = low + (high-low)/2;

		if (b[mid].first < l)
		{
			ans2 = mid;
			low = mid+1;
		}
		else
			high = mid-1;
	}

	int term = 0;
	if (ans2 != -1)
		term = b[ans2].second;
	return (b[ans1].second - term) > 0;
}