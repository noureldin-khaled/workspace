#include <bits/stdc++.h>

using namespace std;

int gcd( int a,  int b);
int main()
{
	int n;
	scanf("%i",&n);

	int arr[n];
	for (int i = 0; i < n; i++)
		scanf("%i",&arr[i]);

	int k = 0;
	vector<int> v;
	for (int i = 0; i < n-1; i++)
	{
		v.push_back(arr[i]);
		int g = gcd(arr[i], arr[i+1]);
		if (g == 1) continue;

		if (gcd(arr[i], 2) == 1 && gcd(2, arr[i+1]) == 1)
		{
			v.push_back(2);
			k++;
			continue;
		}

		int j = 3;
		while(true)
		{
			if (gcd(arr[i], j) == 1 && gcd(j, arr[i+1]) == 1)
			{
				v.push_back(j);
				k++;
				break;
			}
			j+=2;
		}
	}
	v.push_back(arr[n-1]);

	printf("%i\n", k);
	for (int i = 0; i < v.size(); i++)
		printf("%i ", v[i]);
}

int gcd( int a,  int b) 
{
	return b == 0 ? a : gcd(b, a % b);
}