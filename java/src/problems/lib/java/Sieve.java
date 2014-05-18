package problems.lib.java;

public class Sieve
{
	public static int[] sieve(int top)
	{
		boolean[] vals = new boolean[top+1];
		IL l = new IL(2);
		for(int i=2; i <= top; i++)
		{
			if (!vals[i])
			{
				for(int j = i*2; j<=top; j+=i)
				{
					vals[j] = true;
				}
				if (i != 2)
				{
					IL k = new IL(i, l);
					l = k;
				}
			}
		}
		
		int[] res = new int[l.k];
		for(int i = res.length-1; i>=0; i--)
		{
			res[i] = l.v;
			l = l.l;
		}
		return res;
	}
}

class IL 
{
	IL l;
	int k;
	int v;
	public IL(int val, IL l) {
		this.v = val;
		this.l = l;
		this.k = l.k+1;
	}
	
	public IL(int v)
	{
		this.v = v;
		this.k = 1;
	}
}