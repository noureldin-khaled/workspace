#include <bits/stdc++.h>

using namespace std;

long long arr[1000001];

void pre();
int main()
{
	pre();
	int n;
	while(true)
	{
		scanf("%i", &n);
		if (n <= 2) break;
		cout << arr[n] << endl;
	}
}

void pre()
{
	long long diff = 1;
	long long tmp[1000001];
	tmp[3] = 0;
	for (int i = 4; i < 1000001; i+=2, diff++)
	{
		tmp[i] = tmp[i-1]+diff;
		if (i < 1000001-1)
			tmp[i+1] = tmp[i]+diff;
	}

	arr[3] = 0;
	for (int i = 4; i < 1000001; i++)
		arr[i] = tmp[i] + arr[i-1];
}