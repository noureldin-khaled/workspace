#include <bits/stdc++.h>

using namespace std;

bool triangle(int a, int b, int c);
bool segment(int a, int b, int c);
int main()
{
	int arr[4];
	for (int i = 0; i < 4; i++)
		scanf("%i",&arr[i]);

	for (int i = 0; i < 4; i++)
		for (int j = i+1; j < 4; j++)
			for (int k = j+1; k < 4; k++)
				if (triangle(arr[i], arr[j], arr[k]))
				{
					puts("TRIANGLE");
					return 0;
				}

	for (int i = 0; i < 4; i++)
		for (int j = i+1; j < 4; j++)
			for (int k = j+1; k < 4; k++)
				if (segment(arr[i], arr[j], arr[k]))
				{
					puts("SEGMENT");
					return 0;
				}

	puts("IMPOSSIBLE");
}

bool triangle(int a, int b, int c)
{
	return a < b+c && b < a+c && c < a+b;
}

bool segment(int a, int b, int c)
{
	return a == b+c || b == a+c || c == a+b;
}