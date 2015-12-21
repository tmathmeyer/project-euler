package problems.p031;

public class Problem {
	
	
	public int counts(int total, int[] vals)
	{
		int[] ways = new int[total+1];
		ways[0] = 1;
		 
		for (int i = 0; i < vals.length; i++) {
		    for (int j = vals[i]; j <= total; j++) {
		        ways[j] += ways[j - vals[i]];
		    }
		}
		
		return ways[total];
	}
	
	
	public Problem()
	{
		int[] vals = {1,2,5,10,20,50,100,200};
		System.out.println(counts(200, vals));
	}
}
