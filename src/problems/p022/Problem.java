package problems.p022;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class Problem {
	public static int score(String s){
		int c = 0;
		String[] letters = s.split("");
		for(String ss : letters)
			if(ss.length() > 0)c+=ss.charAt(0)-64;
		return c;
	}

	public static int score(String[] s){
		int c = 0;
		for(int i = 0; i < s.length; i++){
			int score = score(s[i]);
			c+=(i+1)*score;
			//System.out.println(s[i] +"  "+ score);
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
