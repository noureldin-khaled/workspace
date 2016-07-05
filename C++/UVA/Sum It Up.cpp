#include <bits/stdc++.h>

using namespace std;

int t, n;
int arr[13];
vector<int> res;
bool found;
vector<vector<int> > taken;

void go(int index, int sumSoFar);
bool valid();
int main()
{
	while(true)
	{
		scanf("%i%i",&t,&n);
		if (n == 0) break;

		for (int i = 0; i < n; i++)
			scanf("%i",&arr[i]);

		found = false;
		res.clear();
		taken.clear();
		printf("Sums of %i:\n", t);
		go(0, 0);
		if (!found)
			puts("NONE");
	}
}

void go(int index, int sumSoFar)
{
	if (sumSoFar == t)
	{
		if (!valid())
			return;

		vector<int> tmp;
		for (int i = 0; i < res.size(); i++)
		{
			if (i > 0)
				printf("+");
			printf("%i", res[i]);
			tmp.push_back(res[i]);
		}
		taken.push_back(tmp);
		found = true;
		puts("");
		return;
	}
	if (index == n)
		return;

	res.push_back(arr[index]);
	go(index+1, sumSoFar+arr[index]);
	res.pop_back();
	go(index+1, sumSoFar);
}

bool valid()
{
	int len = res.size();
	for (int i = 0; i < taken.size(); i++)
	{
		vector<int> cur = taken[i];
		if (cur.size() == len)
		{
			bool same = true;
			for (int j = 0; j < len && same; j++)
				if (cur[j] != res[j])
					same = false;

			if (same)
				return false;
		}
	}

	return true;
}
