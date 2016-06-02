#include <bits/stdc++.h>

using namespace std;

int main()
{
	int n, k;
	scanf("%i%i",&n,&k);

	int cur = 1;
	int diff = k;
	int sign = 1;
	int count = 0;

	while(true)
	{
		printf("%i ", cur);
		count++;
		if (diff == 0)
			break;
		
		cur = cur + (sign*diff);
		diff--;
		sign *= (-1);
	}

	for (int i = 2+k; count < n; i++, count++)
		printf("%i ", i);
}
