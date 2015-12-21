package problems.p044;

public class Problem {
	public boolean isPenta(int i)
	{
		int v = (int) Math.sqrt(24*i + 1);
		return (v*v == 24*i+1 && v%6==5);
	}
	
	public Problem()
	{
		int result = 0;
		boolean notFound = true;
		int i = 1;
		 
		while (notFound) {
		    i++;
		    int n = i * (3 * i - 1) / 2;
		 
		    for (int j = i-1; j > 0; j--) {
		        int m = j * (3 * j - 1) / 2;
		        if (isPenta(n - m) && isPenta(n + m)) {
		            result = n-m;
		            notFound = false;
		            break;
		        }
		    }
		}
		
		System.out.println(result);
	}
}
