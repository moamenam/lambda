package helloWorld1;

public class Coords<T extends TwoD> {
	T[] coords;
	Coords(T[] o){coords = o;}
	static String showXY(Coords<?> c)
	{
		String retStr = "";
		for(int i =0;i<c.coords.length;i++)
			retStr = retStr+"x="+c.coords[i].x+",y="+c.coords[i].x;
		
		return retStr;
		
	}
	
	static String showXYZ(Coords<? extends ThreeD> c)
	{
		String retStr = "";
		for(int i =0;i<c.coords.length;i++)
			retStr = retStr+"x="+c.coords[i].x+",y="+c.coords[i].x+"z="+c.coords[i].z;
		
		return retStr;
		
	}
	static String showXYZt(Coords<? extends FourD> c)
	{
		String retStr = "";
		for(int i =0;i<c.coords.length;i++)
			retStr = retStr+"x="+c.coords[i].x+",y="+c.coords[i].x+"z="+c.coords[i].z+"t="+c.coords[i].t;
		
		return retStr;
		
	}
}
