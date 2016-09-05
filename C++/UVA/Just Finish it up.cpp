#include <bits/stdc++.h>

using namespace std;

// Input macros
#define fast ios_base::sync_with_stdio(0);cin.tie(0);
#define s(n) int n; scanf("%d",&n)
#define sc(n) char n; scanf(" %c",&n)
#define sl(n) long long n; scanf("%lld",&n)
#define sd(n) double n; scanf("%lf",&n)
#define ss(n, sz) char str[sz]; scanf("%s",str); string n = str

// Useful constants
#define INF (int)2e9
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
	s(t);
	forn(c, t)
	{
		s(n);
		int a[n];
		int q[n];
		forn(i, n)
		{
			scanf("%i", &a[i]);
		}

		forn(i, n)
		{
			scanf("%i", &q[i]);
		}
		
		int fuel = 0;
		int st = 0;
		forn(i, n)
		{
			fuel += a[i];
			if (fuel < q[i])
			{
				fuel = 0;
				st = i+1;
			}
			else
				fuel -= q[i];
		}

		printf("Case %i: ", c+1);
		if (fuel == 0)
			puts("Not possible");
		else
		{
			bool valid = true;
			forn(i, n)
			{
				fuel += a[i];
				if (fuel < q[i])
				{
					valid = false;
					break;
				}
				else
					fuel -= q[i];
			}

			if (!valid)
				puts("Not possible");
			else
				printf("Possible from station %i\n", st+1);
		}
	}
}