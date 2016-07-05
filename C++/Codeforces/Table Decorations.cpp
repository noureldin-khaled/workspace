#include <bits/stdc++.h>

using namespace std;

int main()
{
	long long r, g, b;
	cin >> r >> g >> b;

	long long arr[3];
	arr[0] = r;
	arr[1] = g;
	arr[2] = b;

	sort(arr, arr+3);

	long long ans = 0;			
	if (arr[2] < 2*(arr[0] + arr[1]))
		ans += (arr[0]+arr[1]+arr[2]) / 3;
	else
		ans += (long long)arr[0]+arr[1];

	cout << ans << endl;
}
