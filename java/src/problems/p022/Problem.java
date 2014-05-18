package problems.p022;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class Problem {
	public static int score(String s){
		int c = 0;
		for(char k : s.toCharArray())
			c+=k-64;
		return c;
	}

	public static int score(String[] s){
		int c = 0;
		for(int i = 0; i < s.length; i++){
			int score = score(s[i]);
			c+=(i+1)*score;
		}
		return c;
	}

	public Problem() throws FileNotFoundException{
		Scanner reader = new Scanner(new File("names.txt"));
		String s = reader.nextLine();
		s = s.replaceAll("\"", "");
		String[] names = s.split(",");
		Arrays.sort(names);
		System.out.println(score(names));
	}
}
