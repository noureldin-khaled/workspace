#include <bits/stdc++.h>
#define EPS 1e-9

using namespace std;

double arr[200005];

bool valid(double ans, int n);
int main()
{
	int n, w;
	scanf("%i%i",&n,&w);

	n = n << 1;
	for (int i = 0; i < n; i++)
		scanf("%lf",&arr[i]);

	sort(arr, arr+n);
	double low = 0.0;
	double high = w/1.0;
	double ans = -1;

	for (int i = 0; i < 64; i++)
	{
		double mid = (high+low)/2.0;

		if (valid(mid, n))
		{
			ans = mid;
			low = mid;
		}
		else
			high = mid;
	}

	printf("%.7lf\n", ans);

	return 0;
}

bool valid(double ans, int n)
{
	n = n >> 1;
	double x = ans/3.0/n;

	double g = x;
	double b = 2*x;
	for (int i = 0; i < n; i++)
		if (g > arr[i] + EPS)
			return false;

	for (int i = n; i < (n << 1); i++)
		if (b > arr[i] + EPS)
			return false;

	return true;
}