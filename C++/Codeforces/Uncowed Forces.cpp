/*input
55 66 75 44 47
6 0 6 6 10
19 0

*/

#include <bits/stdc++.h>

using namespace std;

int main()
{
	double time[5];
	double wrongs[5];

	for (int i = 0; i<  5; i++)
		cin >> time[i];
	
	for (int i = 0; i<  5; i++)
		cin >> wrongs[i];

	double hs, hu;
	cin >> hs >> hu;

	double ans = 0;
	for (int i = 0; i < 5; i++)
	{
		double x = 500*(i+1);
		double first = 0.3*x;
		double second = (1-(time[i]/250))*x - 50*wrongs[i];

		ans += max(first, second);
	}
	

	ans += hs*100;
	ans -= hu*50;

	cout << ans << endl;
}