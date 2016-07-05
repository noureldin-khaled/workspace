package DataStructures;

public class FenwickTree {
	int n;
	int[] ft;
	int[] array;

	public FenwickTree(int n, int[] arr) {
		this.n = n;
		ft = new int[n+1]; // one based.
		array = arr;
		
		for (int i = 0; i < n; i++)
			update_point(i+1, arr[i]);
	}

	// O(log n). Gets the sum from 1 to b.
	public int rsq(int b) {
		int sum = 0;
		while(b > 0) {
			sum += ft[b];
			b -= LSOne(b);
		}

		return sum;
	}

	public int rsq(int l, int r) {
		return rsq(r) - rsq(l-1);
	}

	// O(log n). Update means increment or decrement.
	public void update_point(int k, int val) {
		while(k <= n) {
			ft[k] += val;
			k += LSOne(k);
		}
	}
	
	// New value not increment or decrement.
	public void update_point_new(int k, int newVal) {
		int diff = newVal - array[k-1];
		array[k-1] = newVal;
		update_point(k, diff);
	}

	public void scale(int c) {	
		for(int i = 1; i <= n; ++i)	ft[i] *= c;	
	}

	public int LSOne(int i) {
		return i & (-i);
	}
}
