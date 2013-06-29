package problems;

public class EulerClassLoader {
	public static void main(String[] args){

	    
	    
	    System.out.println("please enter a problem number");
	    String number = new java.util.Scanner(System.in).next();
	    
	    if ("all".equals(number))
	    {
	    	for(int i = 0; i < 433; i++){
	    		load(zero(i));
	    	}
	    }
	    else
	    {
	    	load(zero(number));
	    }
	    
	    
	    
	}
	
	public static void load(String problem)
	{
		ClassLoader classLoader = EulerClassLoader.class.getClassLoader();
		try {
			System.out.print(problem+": ");
	        Class<?> aClass = classLoader.loadClass("problems.p"+problem+".Problem");
	        Object ob = aClass.newInstance();
	    }catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			System.out.println("this problem is either not solved in java or not solved at all");
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
