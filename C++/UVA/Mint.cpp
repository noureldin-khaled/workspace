#include <bits/stdc++.h>

using namespace std;

long long gcd(long long a, long long b);
long long lcm(long long a,long long b);
int main()
{
	while(true)
	{
		int n, t;
		scanf("%i%i",&n,&t);

		if (n == 0 && t == 0) break;

		int a[n];

		for (int i = 0; i < n; i++)
			scanf("%i",&a[i]);

		while(t--)
		{
			int d;
			scanf("%i",&d);

			long long res1 = -1;
			long long res2 = -1;
			for (int i = 0; i < n; i++)
				for (int j = i+1; j < n; j++)
					for (int k = j+1; k < n; k++)
						for (int r = k+1; r < n; r++)
						{
							long long l = lcm(lcm(a[i], a[j]), lcm(a[k], a[r]));
							
							long long low = 0;
							long long high = 1000000000;
							long long ans1 = -1;

							while(low <= high)
							{
								long long mid = low + (high-low)/2;

								if (l*mid <= d)
								{
									ans1 = mid;
									low = mid+1;
								}
								else
									high = mid-1;
							}

							low = 0;
							high = 1000000000;
							long long ans2 = -1;

							while(low <= high)
							{
								long long mid = low + (high-low)/2;

								if (l*mid >= d)
								{
									ans2 = mid;
									high = mid-1;
								}
								else
									low = mid+1;
							}

							if (res1 == -1 || l*ans1 > res1)
								res1 = l*ans1;

							if (res2 == -1 || l*ans2 < res2)
								res2 = l*ans2;
						}	


			cout << res1 << " " << res2 << endl;
		}
	}

}

long long gcd(long long a, long long b)
{
    return b == 0 ? a : gcd(b, a % b);
}

long long lcm(long long a,long long b)
{
	return (a*b)/gcd(a,b);
}