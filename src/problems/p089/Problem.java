package problems.p089;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Problem {
	
	
	
	public Problem() throws FileNotFoundException {
		Scanner reader = new Scanner(new File("roman.txt"));
		int sum = 0;
		
		while(reader.hasNext()){
			String r_o = reader.nextLine();
			int val = fromRomanNumeral(r_o);
			String r_n = toRoman(val);
			int diff = r_o.length() - r_n.length();
			sum += diff;
		}
		
		System.out.println(sum);
		
	}
	
	
	
	
	
	
	
	
	public int fromRomanNumeral(String num) {
		num = num.replaceAll("IX", "VIV");
		num = num.replaceAll("IV", "IIII");

		num = num.replaceAll("XC", "LXXXX");
		num = num.replaceAll("XL", "XXXX");
		
		num = num.replaceAll("CM", "DCCCC");
		num = num.replaceAll("CD", "CCCC");
		
		char[] c = num.toCharArray();
		int sum = 0;
		for(char k : c) {
			if (k == 'I')
				sum++;
			if (k == 'V')
				sum+=5;
			if (k == 'X')
				sum+=10;
			if (k == 'L')
				sum+=50;
			if (k == 'C')
				sum+=100;
			if (k == 'D')
				sum+=500;
			if (k == 'M')
				sum+=1000;
		}
		
		return sum;
	}
	
	public String toRoman(int i){
		
		StringBuilder bs = new StringBuilder();
		
		while (i >= 1000){
			bs.append("M");
			i-=1000;
		}
		while (i >= 900) {
			bs.append("CM");
			i-=900;
		}
		while(i >= 500) {
			bs.append("D");
			i-=500;
		}
		while(i >= 400) {
			bs.append("CD");
			i-=400;
		}
		while(i >= 100) {
			bs.append("C");
			i-=100;
		}
		while(i >= 90) {
			bs.append("XC");
			i-=90;
		}
		while(i >= 50) {
			bs.append("L");
			i-=50;
		}
		while(i >= 40) {
			bs.append("XL");
			i-=40;
		}
		while(i >= 10){
			bs.append("X");
			i-=10;
		}
		while(i >= 9) {
			bs.append("IX");
			i-=9;
		}
		while(i >= 5) {
			bs.append("V");
			i-=5;
		}
		while(i >= 4){
			bs.append("IV");
			i-=4;
		}
		while(i >= 1) {
			bs.append("I");
			i-=1;
		}
		
		return bs.toString();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
