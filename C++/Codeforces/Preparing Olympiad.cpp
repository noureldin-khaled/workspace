#include <bits/stdc++.h>

using namespace std;

int n, l, r, x;
int arr[16];

int rec(int index, int difficulty, int minimum, int maximum);
int main()
{
	scanf("%i%i%i%i",&n,&l,&r,&x);

	for (int i = 0; i < n; i++)
		scanf("%i",&arr[i]);

	printf("%i\n", rec(0, 0, -1, -1));
}

int rec(int index, int difficulty, int minimum, int maximum)
{
	if (index == n)
	{
		int difference = maximum - minimum;
		if (difference >= x && difficulty >= l && difficulty <= r)
			return 1;
		return 0;
	}

	int take = rec(index+1, difficulty+arr[index], minimum == -1 ? arr[index] : min(minimum, arr[index]), maximum == -1 ? arr[index] : max(maximum, arr[index]));
	int leave = rec(index+1, difficulty, minimum, maximum);

	return take+leave;
}
