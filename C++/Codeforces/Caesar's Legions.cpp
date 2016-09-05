#include <bits/stdc++.h>

using namespace std;

// Input macros
#define fast ios_base::sync_with_stdio(0);cin.tie(0);
#define s(n) int n; scanf("%d",&n)
#define sc(n) char n; scanf(" %c",&n)
#define sd(n) double n; scanf("%lf",&n)
#define read(s) freopen(s, "r", stdin)
#define write(s) freopen(s, "w", stdout);

// Useful constants
#define INF 1e16
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
#define first f
#define second s
#define parseInt(x) atoi(x.c_str())
#define parseLong(x) atol(x.c_str())
#define charToInt(x) x - '0'
#define intToChar(x) x + '0'
#define toString(x) dynamic_cast< std::ostringstream & >( \
( std::ostringstream() << std::dec << x ) ).str()

// Printing
#define print(a,s) {forn(i, s) { if (i > 0) cout << " "; cout << a[i];} puts("");}

typedef long long ll;
typedef pair<int, int> ii;
typedef pair<long long, long long> llll;
typedef vector<int> vi;
typedef vector<long long> vl;
typedef vector<pair<int, int> > vii;
typedef vector<pair<long long, long long> > vll;

#define MOD (int)1e8

int n1, n2, k1, k2;
int dp[101][101][2][11];

int rec(int remN1, int remN2, int lst, int prev);
int main()
{
	scanf("%i%i%i%i",&n1,&n2,&k1,&k2);
	fill(dp, -1);
	printf("%i\n", (rec(n1-1, n2, 0, 1)%MOD + rec(n1, n2-1, 1, 1)%MOD)%MOD);
}

int rec(int remN1, int remN2, int lst, int prev)
{
	if (remN1 == 0 && remN2 == 0)
		return 1;
	if (dp[remN1][remN2][lst][prev] != -1)
		return dp[remN1][remN2][lst][prev];

	int ans = 0;
	if (remN1 > 0)
	{
		if (lst == 1)
			ans = (ans%MOD + rec(remN1-1, remN2, 0, 1)%MOD)%MOD;
		else if (prev < k1)
			ans = (ans%MOD + rec(remN1-1, remN2, 0, prev+1)%MOD)%MOD;
	}

	if (remN2 > 0)
	{
		if (lst == 0)
			ans = (ans%MOD + rec(remN1, remN2-1, 1, 1)%MOD)%MOD;
		else if (prev < k2)
			ans = (ans%MOD + rec(remN1, remN2-1, 1, prev+1)%MOD)%MOD;
	}

	return dp[remN1][remN2][lst][prev] = ans%MOD;
}
