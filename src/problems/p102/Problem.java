package problems.p102;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Problem {
	public boolean isInCenter(Point p1, Point p2, Point p3, Point p)
	{
		float alpha = ((p2.y - p3.y)*(p.x - p3.x) + (p3.x - p2.x)*(p.y - p3.y)) /
		        ((p2.y - p3.y)*(p1.x - p3.x) + (p3.x - p2.x)*(p1.y - p3.y));
		float beta = ((p3.y - p1.y)*(p.x - p3.x) + (p1.x - p3.x)*(p.y - p3.y)) /
		       ((p2.y - p3.y)*(p1.x - p3.x) + (p3.x - p2.x)*(p1.y - p3.y));
		float gamma = 1.0f - alpha - beta;
		return (gamma > 0 && alpha > 0 && beta > 0);
	}
	
	public boolean isInCenter(Triangle t, Point p)
	{
		return this.isInCenter(t.a,  t.b, t.c, p);
	}
	
	
	TList t = null;
	public void readTriangles(Scanner s) {
		while(s.hasNext()){
			TList t2 = new TList();
			String tline = s.nextLine();
			String[] vals = tline.split(",");
			int[] v = new int[vals.length];
			for(int i = 0; i < vals.length; i++) v[i] = Integer.parseInt(vals[i]);
			t2.t = new Triangle();
			t2.t.a = new Point();
			t2.t.b = new Point();
			t2.t.c = new Point();
			t2.t.a.x = v[0];
			t2.t.a.y = v[1];
			t2.t.b.x = v[2];
			t2.t.b.y = v[3];
			t2.t.c.x = v[4];
			t2.t.c.y = v[5];
			t2.n = t;
			t = t2;
		}
	}
	
	public int CheckTs()
	{
		int count = 0;
		Point o = new Point();
		o.x = 0;
		o.y = 0;
		while(t != null && t.t != null)
		{
			if (this.isInCenter(t.t, o))
				count++;
			t = t.n;
		}
		return count;
		
	}
	
	
	public Problem() throws FileNotFoundException
	{
		Scanner s = new Scanner(new File("triangles.txt"));
		this.readTriangles(s);
		System.out.println(this.CheckTs());
	}
}

class Point {
	float x;
	float y;
	public String toString()
	{
		return "("+x+","+y+")";
	}
}

class Triangle {
	Point a, b, c;
	public String toString(){
		return "A"+a+", B"+b+", C"+c;
	}
}

class TList {
	TList n;
	Triangle t;
}
