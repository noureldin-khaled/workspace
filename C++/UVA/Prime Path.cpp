#include <bits/stdc++.h>
#define parseInt(x) atoi(x.c_str())
#define toString( x ) dynamic_cast< std::ostringstream & >( \
( std::ostringstream() << std::dec << x ) ).str()

using namespace std;

int size;
bool bs[100001];
vector<int> primes;

void sieve(int upperbound)
{
    size = upperbound+1;
    for (int i = 0; i < 100000; i++)
        bs[i] = true;
    bs[0] = bs[1] = false;

    for (long long i = 2; i < size; i++) if (bs[i])
    {
        for (long long j = i*i; j < size; j += i) 
            bs[j] = false;
        primes.push_back((int) i);
    }
}

bool isPrime(long long N)
{
    if (N <= size) return bs[N];
    for (int i = 0; i < (int)primes.size(); i++)
        if (N % primes[i] == 0) return false;
    return true;  
}

int main()
{
	sieve(100000);
	int t;
	scanf("%i",&t);

	while(t--)
	{
		int start, endd;
		scanf("%i%i",&start, &endd);

		int dist[100000];
		memset(dist, -1, sizeof dist);
		queue<int> q;
		q.push(start);
		dist[start] = 0;

		while(!q.empty())
		{
			int cur = q.front();
			q.pop();
			if (cur == endd) break;

			string s = toString(cur);
			for (int i = 0; i < 4; i++)
			{
				int j = 0;
				if (i == 0)
					j++;
				for (; j <= 9; j++)
				{
					char c = (char)(j+'0');
					if (c == s[i]) continue;

					string tmp = s;
					tmp[i] = c;
					int v = parseInt(tmp);
					if (isPrime(v) && dist[v] == -1)
					{
						dist[v] = dist[cur] + 1;
						q.push(v);
					}
				}
			}
		}

		printf("%i\n", dist[endd]);
	}
}
