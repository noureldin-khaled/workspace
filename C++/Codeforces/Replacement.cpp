#include <bits/stdc++.h>

using namespace std;

int main()
{
	int n, m;
	scanf("%i%i",&n,&m);

	string line;
	cin >> line;

	int fs = 0;
	for (int i = 0; i < n-1; i++)
		if (line[i] == '.' && line[i+1] == '.')
			fs++;

	while(m--)
	{
		int index;
		char letter;
		scanf("%i %c", &index, &letter);
		index--;

		if (line[index] == '.' && letter != '.')
		{
			if (index > 0 && index < n-1)
			{
				if (line[index+1] == '.' && line[index-1] == '.')
					fs -= 2;
				else if (line[index+1] == '.' || line[index-1] == '.')
					fs--;
			}
			else
			{
				if (index > 0)
				{
					if (line[index-1] == '.')
						fs--;
				}
				else
				{
					if (line[index+1] == '.')
						fs--;
				}
			}

		}
		else if (line[index] != '.' && letter == '.')
		{
			if (index > 0 && index < n-1)
			{
				if (line[index+1] == '.' && line[index-1] == '.')
					fs += 2;
				else if (line[index+1] == '.' || line[index-1] == '.')
					fs++;
			}
			else
			{
				if (index > 0)
				{
					if (line[index-1] == '.')
						fs++;
				}
				else
				{
					if (line[index+1] == '.')
						fs++;
				}
			}
		}

		line[index] = letter;

		printf("%i\n", fs);
	}
}