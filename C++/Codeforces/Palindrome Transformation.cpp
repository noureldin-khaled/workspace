#include <bits/stdc++.h>

using namespace std;

// Input macros
#define fast ios_base::sync_with_stdio(0);cin.tie(0);
#define s(n) int n; scanf("%d",&n)
#define sc(n) char n; scanf(" %c",&n)
#define sl(n) long long n; scanf("%I64d",&n)
#define sd(n) double n; scanf("%lf",&n)
#define read(s) freopen(s, "r", stdin)
#define write(s) freopen(s, "w", stdout);

// Useful constants
#define INF 2e9
#define EPS 1e-5

// Useful hardware instructions
#define bitcount __builtin_popcount
#define gcd __gcd

// Traversal macros
#define forn(i,n) for (int i = 0; i < n; i++)
#define forr(i,n) for (int i = n-1; i >= 0; i--)
#define forall(i,a,b,x) for (int i = a; i < b; i+=x)
#define foreach(v, c) for (typeof(c.begin()) v = c.begin(); v != c.end(); v++)

// Useful container manipulation
#define all(a) a.begin(), a.end()
#define in(a, b) (b.find(a) != b.end())
#define pb push_back
#define fill(a,v) memset(a, v, sizeof a)
#define sz(a) ((int)(a.size()))
#define mp make_pair
#define parseInt(x) atoi(x.c_str())
#define parseLong(x) atol(x.c_str())
#define charToInt(x) x - '0'
#define intToChar(x) x + '0'
#define toString(x) dynamic_cast< std::ostringstream & >( \
( std::ostringstream() << std::dec << x ) ).str()

// Printing
#define print(a,s) {forn(i, s) { if (i > 0) printf(" "); printf("%i", a[i]);} puts("");}

typedef long long ll;
typedef pair<int, int> ii;
typedef pair<long long, long long> llll;
typedef vector<int> vi;
typedef vector<long long> vl;
typedef vector<pair<int, int> > vii;
typedef vector<pair<long long, long long> > vll;

int diff(char a, char b);
int main()
{
	s(n);s(p);
	p--;

	string s;
	cin >> s;
	int c = 0;

	int minimum = -1;
	int maximum = -1;
	for (int i = 0; i < n/2; i++)
	{
		if (s[i] != s[n-1-i])
		{
			if (p < n/2)
			{
				if (minimum == -1 || i < minimum)
					minimum = i;
				if (maximum == -1 || i > maximum)
					maximum = i;
			}
			else
			{
				if (minimum == -1 || (n-1-i) < minimum)
					minimum = (n-1-i);
				if (maximum == -1 || (n-1-i) > maximum)
					maximum = (n-1-i);
			}
			c += diff(s[i], s[n-1-i]);
		}
	}

	if (minimum != -1 && maximum != -1)
		c += min(abs(p-maximum), abs(p-minimum)) + abs(maximum-minimum);

	printf("%i\n", c);
}

int diff(char a, char b)
{
	int res1 = 0;
	char t = a;
	while(t != b)
	{
		t++;
		res1++;
		if (t > 'z')
			t = 'a';
	}

	int res2 = 0;
	t = a;
	while (t != b)
	{
		t--;
		res2++;
		if (t < 'a')
			t = 'z';
	}

	return min(res1, res2);
}