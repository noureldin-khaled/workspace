#include <bits/stdc++.h>

using namespace std;

int main()
{
	int n;
	scanf("%i",&n);

	int arr[7];
	for (int i = 0; i < 7; i++)
		scanf("%i", &arr[i]);

	int day = 1;
	while (true)
	{
		n -= arr[day-1];
		if (n <= 0)
		{
			printf("%i\n", day);
			return 0;
		}

		day++;
		if (day == 8)
			day = 1;
	}
}
