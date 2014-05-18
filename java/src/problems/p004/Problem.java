package problems.p004;

import java.util.ArrayList;

public class Problem {
	public Problem()
	{
		ArrayList<String> all = new ArrayList<String>();
		for (int i = 900; i<1000; i++){
			for (int j = 900; j<1000; j++){
				String s = (i*j)+"";
				if (s.equals(new StringBuffer(s).reverse().toString()))all.add(s);
			}
		}
		int i = 0;
		for (String s : all)i = Integer.parseInt(s)>i ? Integer.parseInt(s) : i;
		System.out.println(i);
	}
}
