package problems.p067;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Problem
{
	public int[][] vals = new int[100][];

	public void initArrays(Scanner s)
	{
		for(int i = 0; i < vals.length; i++)
		{
			vals[i] = new int[i+1];
			for(int j = 0; j <= i; j++)
			{
				vals[i][j] = s.nextInt();
			}
		}
	}

	public void run()
	{
		for(int i = vals.length-2; i >= 0; i--)
		{
			for(int j = 0; j < vals[i].length; j++)
			{
				vals[i][j] += vals[i+1][j]>vals[i+1][j+1] ? vals[i+1][j] : vals[i+1][j+1];
			}
		}
	}

	public Problem() throws FileNotFoundException
	{
		Scanner s = new Scanner(new File("triangle.txt"));
		this.initArrays(s);
		this.run();
		System.out.println(vals[0][0]);
	}
}