#include <bits/stdc++.h>

using namespace std;

int main()
{
	int n, k;
	scanf("%i%i",&n,&k);

	int arr[n];
	for (int i = n; i > 0; i--)
		arr[n-i] = i;

	int t = n-1;
	stack<int> st;
	for (int i = 1; i < n; i++)
	{
		if (t == k) break;
		st.push(arr[i]);
		arr[i] = -1;
		t--;
	}

	while(!st.empty())
	{
		printf("%i ", st.top());
		st.pop();
	}

	for (int i = 0; i < n; i++)
		if (arr[i] != -1)
			printf("%i ", arr[i]);
}
