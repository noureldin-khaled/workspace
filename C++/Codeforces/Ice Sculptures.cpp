#include <bits/stdc++.h>
#define INF 20000001;

using namespace std;

int arr[20001];
int n;

int f(int start, int j);
int main()
{
	scanf("%i",&n);

	int sq = (int) sqrt(n); 

	vector<int> v;
	for(int i = 1; i <= sq; ++i)  
	{
		if(n%i == 0)
		{
			v.push_back(i);
			if(i != (n / i) && (n / i) != n)
				v.push_back(n / i);
		}
	}

	for (int i = 0; i < n; i++)
		scanf("%i",&arr[i]);

	int ans = -INF;
	for (int i = 0; i < v.size(); i++)
	{
		int j = v[i];
		for (int k = 0; k < j; k++)
			ans = max(ans, f(k, j));
	}

	printf("%i\n", ans);
}

int f(int i, int j)
{
	int res = 0;
	int k = 0;
	for (; i < n; i+=j)
	{
		res += arr[i];
		k++;
	}

	return k >= 3 ? res : -INF;
}
