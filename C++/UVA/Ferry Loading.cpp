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
// #define print(a,s) {forn(i, s) { if (i > 0) printf(" "); printf("%i", a[i]);} puts("");}

typedef long long ll;
typedef pair<int, int> ii;
typedef pair<long long, long long> llll;
typedef vector<int> vi;
typedef vector<long long> vl;
typedef vector<pair<int, int> > vii;
typedef vector<pair<long long, long long> > vll;

int n, len;
int a[2000];
int b[2000];
int dp[2000][10001];

int rec(int idx, int leftLane);
void print(int idx, int leftLane);
int main()
{
	s(t);
	while(t--)
	{
		scanf("%i",&n);
		n *= 100;

		len = 0;
		while(true)
		{
			s(m);
			if (m == 0)
				break;

			a[len++] = m;
		}

		b[0] = 0;
		forall(i, 1, len, 1)
		{
			b[i] = b[i-1] + a[i-1];
		}

		fill(dp, -1);
		printf("%i\n", rec(0, 0));
		print(0, 0);
		if (t > 0)
			puts("");
	}
}

void print(int idx, int leftLane)
{
	if (idx == len)
		return;

	int optimal = rec(idx, leftLane);

	int rightLane = b[idx] - leftLane;
	int choice1 = -1;
	if (a[idx]+leftLane <= n)
		choice1 = 1 + rec(idx+1, leftLane+a[idx]);

	int choice2 = -1;
	if (a[idx]+rightLane <= n)
		choice2 = 1 + rec(idx+1, leftLane);

	if (optimal == choice1)
	{
		puts("port");
		print(idx+1, leftLane+a[idx]);
	}
	else if (optimal == choice2)
	{
		puts("starboard");
		print(idx+1, leftLane);
	}
	else
		return;
}

int rec(int idx, int leftLane)
{
	if (idx == len)
		return 0;

	if (dp[idx][leftLane] != -1)
		return dp[idx][leftLane];

	int rightLane = b[idx] - leftLane;

	int choice1 = 0;
	if (a[idx]+leftLane <= n)
		choice1 = 1 + rec(idx+1, leftLane+a[idx]);

	int choice2 = 0;
	if (a[idx]+rightLane <= n)
		choice2 = 1 + rec(idx+1, leftLane);

	return dp[idx][leftLane] = max(choice1, choice2);
}