#include <bits/stdc++.h>
#define MAX 21
#define INF 1000000000

using namespace std;

int arr[MAX];
int tracks, n;

vector<int> rec(int index, vector<int> v, int sumSoFar);
int getsum(vector<int> v);
int main()
{
	while(scanf("%i%i",&n,&tracks) != EOF)
	{
		for (int i = 0; i < tracks; i++)
			scanf("%i",&arr[i]);

		vector<int> v;
		vector<int> res = rec(0, v, 0);
		for (int i = 0; i < res.size(); i++)
			printf("%i ", res[i]);
		printf("sum:%i\n",getsum(res));
		
	}
}

int getsum(vector<int> v)
{
	int sum = 0;

	for (int i = 0; i < v.size(); i++)
		sum += v[i];
	return sum;
}

vector<int> rec(int index, vector<int> v, int sumSoFar)
{
	if (sumSoFar > n)
	{
		vector<int> temp;
		temp.push_back(-INF);
		return temp;
	}

	if (index == tracks)
		return v;

	vector<int> leave = rec(index+1, v, sumSoFar);
	v.push_back(arr[index]);
	vector<int> take = rec(index+1, v, sumSoFar + arr[index]);

	int sum1 = 0;
	int sum2 = 0;
	for (int i = 0; i < leave.size(); i++)
		sum1 += leave[i];
	for (int i = 0; i < take.size(); i++)
		sum2 += take[i];

	if (sum1 > sum2)
		return leave;
	else
		return take;
}