package problems.p042;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Problem {
	public boolean isTriangle(int n)
	{
		int floor_root = (int)(Math.sqrt(n * 2));
		return (floor_root * (floor_root+1)) == 2 * n;
	}
	
	public boolean isWordTriangular(String word)
	{
		int sum = 0;
		for(int i = 0; i < word.length(); i++)
		{
			sum += (word.charAt(i)-64);
		}
		return this.isTriangle(sum);
	}
	
	public Problem() throws FileNotFoundException
	{
		Scanner s = new Scanner(new File("words.txt"));
		String[] words = s.nextLine().replaceAll("\"", "").split(",");
		int sum = 0;
		for(String word : words)
			if (this.isWordTriangular(word))
				sum ++;
		System.out.println(sum);
		s.close();
	}
}
