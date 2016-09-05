#include <bits/stdc++.h>

using namespace std;

// Input macros
#define fast ios_base::sync_with_stdio(0);cin.tie(0);
#define si(n) scanf("%d",&n)
#define sii(n, m) scanf("%d%d",&n,&m)
#define siii(n, m, x) scanf("%d%d%d",&n,&m,&x)
#define sc(n) scanf(" %c",&n)
#define sd(n) scanf("%lf",&n)
#define read(s) freopen(s, "r", stdin)
#define write(s) freopen(s, "w", stdout);
#define endl '\n'

// Useful constants
#define INF (int)1e9
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
#define f first
#define s second
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

#define OFF 10

string s;
int n, m;
int dp[21][11][1001][2];

int rec(int balance, int prev, int remM, int turn);
void printSol(int balance, int prev, int remM, int turn);
int main()
{
	cin >> s;
	n = s.length();

	si(m);

	fill(dp, -1);
	if (rec(0, 0, m, 0))
	{
		puts("YES");
		printSol(0, 0, m, 0);
		puts("");
	}
	else
		puts("NO");
}

void printSol(int balance, int prev, int remM, int turn)
{
	if (remM == 0)
		return;

	int sign = turn == 0 ? 1 : -1;
	forn(i, n)
	{
		if (s[i] == '1' && (i+1) != prev && (i+1) > abs(balance) && rec(balance + (i+1)*sign, i+1, remM-1, 1-turn))
		{
			printf("%d ", i+1);
			printSol(balance + (i+1)*sign, i+1, remM-1, 1-turn);
			return;
		}
	}
}

int rec(int balance, int prev, int remM, int turn)
{
	if (remM == 0)
		return 1;
	if (abs(balance) > 10)
		return 0;
	if (dp[balance + OFF][prev][remM][turn] != -1)
		return dp[balance+ OFF][prev][remM][turn];

	int ans = 0;
	int sign = turn == 0 ? 1 : -1;
	forn(i, n)
		if (s[i] == '1' && (i+1) != prev && (i+1) > abs(balance))
			ans |= rec(balance + (i+1)*sign, i+1, remM-1, 1-turn);

	return dp[balance+ OFF][prev][remM][turn] = ans;
}