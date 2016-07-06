package problems.p056;

import lib.Numbers;

public class Problem
{
	public Problem()
	{
	    System.out.println("<html><body><table>");
	    for(int i = 1; i <= 9; i++)
	    {
	        System.out.println("<tr>");
	        for(int j = 1; j <= 9; j++)
	        {
	            System.out.println("<td>"+digisum(Numbers.pow(i, j))+"</td>");
	        }
	        System.out.println("</tr>");
	    }
	    System.out.println("</table></body></html>");
	}
	
	public int digisum(int i)
	{
	    int res = 0;
	    while(i > 0)
	    {
	        res += (i%10);
	        i /= 10;
	    }
	    return res;
	}
}
