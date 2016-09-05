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
#define EPS 1e-9

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

int main()
{
	s(n);s(q);
	int unread[n];
	int read[n];
	fill(unread, 0);
	fill(read, 0);

	vector<int> v;
	int count = 0;
	int idx = 0;
	while(q--)
	{
		s(t);s(x);
		x--;
		if (t == 1)
		{
			unread[x]++;
			v.pb(x);
			count++;
		}
		else if (t == 2)
		{
			read[x] += unread[x];
			count -= unread[x];
			unread[x] = 0;
		}
		else
		{
			for(; idx <= x; idx++)
			{
				int e = v[idx];
				if (read[e] == 0)
				{
					unread[e]--;
					count--;
				}
				else
					read[e]--;
			}
		}

		printf("%i\n", count);
	}
}
