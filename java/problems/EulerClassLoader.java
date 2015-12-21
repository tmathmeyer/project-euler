package problems;

import lib.Stopwatch;

public class EulerClassLoader {
	public static void main(String[] args){

	    
	    
	    System.out.println("please enter a problem number");
	    java.util.Scanner scanner = new java.util.Scanner(System.in);
        String number = scanner.next();
	    Stopwatch s = new Stopwatch();
	    
	    if ("all".equals(number) || "java".equals(number))
	    {
	    	for(int i = 0; i < 433; i++){
	    		load(zero(i), "java".equals(number));
	    	}
	    }
	    else
	    {
	    	s.start();
	    	load(zero(number), false);
	    	s.stop();
	    	System.out.println("ran in: "+s.getElapsedTime()+"ms");
	    }
	    scanner.close();
	}
	
	public static void load(String problem, boolean b)
	{
		ClassLoader classLoader = EulerClassLoader.class.getClassLoader();
		try {
			System.out.print(problem+": ");
	        Class<?> aClass = classLoader.loadClass("problems.p"+problem+".Problem");
	        @SuppressWarnings("unused")
            Object ob = aClass.newInstance();
	    }catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			if (!b)System.out.println("this problem is either not solved in java or not solved at all");
		}
	}
	
	
	
	public static String zero(String s)
	{
		while(s.length() < 3)
			s = "0"+s;
		return s;
	}
	
	public static String zero(int i)
	{
		return zero(i+"");
	}
}
