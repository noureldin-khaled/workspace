#include <bits/stdc++.h>
#define fast ios_base::sync_with_stdio(0);cin.tie(0);

using namespace std;
typedef long long ll;

int n, t, e;

int main()
{
	scanf("%i",&t);

	while(t--)
	{
		scanf("%i%i", &n, &e);

		ll st = 1;
		ll k = 1;
		ll size = n;
		ll acc = 1;
		int shift = 0;
		while(true)
		{
			if (size == 1)
			{
				cout << acc << endl;
				break;
			}

			ll start = st + shift*k;
			ll tmp = k*2;
			ll s = size;
			if (shift == 1)
				s = size/2;
			else
				s = size - size/2;

			// cout << st << " " << start << " " << size << " " << s << " " << acc << endl;

			if ((e-start)%tmp == 0 && (e-start)/tmp < s && (e-start)/tmp >= 0)
			{
				ll c = (e-start)/tmp;
				cout << acc+c << endl;
				break;
			}

			if (shift == 1)
			{
				if (size%2 != 0)
				{
					acc += size/2;
					shift = 0;
				}
				else
				{
					acc += size/2;
					shift = 1;
				}
				size -= (size/2);
			}
			else
			{
				if (size%2 != 0)
				{
					acc += (size - size/2);
					shift = 1;
				}
				else
				{
					acc += size/2;
					shift = 0;
				}
				st += k;
				size /= 2;
			}

			k *= 2;
		}
	}
}
