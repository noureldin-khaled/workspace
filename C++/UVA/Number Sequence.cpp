#include <bits/stdc++.h>

using namespace std;

// Input macros
#define fast ios_base::sync_with_stdio(0);cin.tie(0);
#define s(n) int n; scanf("%d",&n)
#define sc(n) char n; scanf(" %c",&n)
#define sl(n) long long n; scanf("%I64d",&n)
#define sd(n) double n; scanf("%lf",&n)
#define ss(n, sz) char str[sz]; scanf("%s",str); string n = str
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
	vll v;

	int i = 1;
	long long idx = i;
	long long len = 1;
	while(idx <= 2147483647)
	{
		v.pb(mp(idx, idx+len-1));
		idx += len;
		i++;
		len += toString(i).length();
	}
	int l = v.size();

	string s = "";
	int ln = 0;
	int num = 1;
	while(ln <= 1000000)
	{
		string tmp = toString(num);
		s += tmp;
		ln += tmp.length();
		num++;
	}

	s(t);
	while(t--)
	{
		s(k);

		int low = 0;
		int high = l-1;
		int ans = -1;
		while(low <= high)
		{
			int mid = low + (high-low)/2;

			if (k >= v[mid].first && k <= v[mid].second)
			{
				ans = mid;
				break;
			}
			else if (k > v[mid].second)
				low = mid+1;
			else
				high = mid-1;
		}

		printf("%i\n", s[k-v[ans].first] - '0');
	}
}
