#include <bits/stdc++.h>

using namespace std;

int main()
{
	int n;
	scanf("%i",&n);

	int weeks = n/7;
	int offDays = weeks*2;
	int rem = n%7;

	int min = offDays;
	int max = offDays;
	if (rem > 0) {
		if (rem == 6)
			min++;

		max += 2;
		if (rem == 1)
			max--;
	}

	printf("%i %i",min,max);
}	
