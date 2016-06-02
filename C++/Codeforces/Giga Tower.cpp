#include <bits/stdc++.h>

using namespace std;

bool isLucky(int num);
int main()
{
	int a;
	scanf("%i",&a);

	a++;
	int ans = 1;
	while(true)
	{
		if (isLucky(a)) 
		{
			printf("%i\n", ans);
			return 0;
		}
		a++;
		ans++;
	}
}

bool isLucky(int num)
{
	if (num < 0) num*=-1;
	while(num > 0)
	{
		int digit = num%10;
		if (digit == 8) return true;
		num/=10;
	}
	return false;
}