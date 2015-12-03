package helloWorld1;

import java.applet.*;
import java.awt.*;
import static java.lang.Math.*;

public class HelloWorld1 extends Applet {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6750240424119199058L;

	public void paint(Graphics g)
	{
		int i= 100;
		g.drawString("first applet:"+ String.valueOf(i), 20, 20);
		/*C c=new C() ;
		@SuppressWarnings("unused")
		A a=new A();
		c.j=10;
		c.i=15;
		
		C ob;
		
		ob = c;
		if(ob instanceof A)
		{
			g.drawString("ob instanceof A"+ String.valueOf(((A)ob).i), 40, 40);
		}
		
		if(ob instanceof A)
		{
			g.drawString("ob cast of C"+ String.valueOf(((C)ob).k), 60, 60);
		}
		
		g.drawString("pow(10,10): "+ String.valueOf(pow(10,10)), 40, 80);*/
		
		Gen<Integer> iob;
		iob = new Gen<Integer>(100);
		g.drawString(iob.showType(),20,40);
		
		int v = iob.getOB();
		g.drawString(String.valueOf(v),20,60);
		
		Gen<String> strob;
		strob = new Gen<String>("My name is Moamen");
		g.drawString(strob.showType(),20,80);
		
		String y = strob.getOB();
		g.drawString(y,20,100);
		
		C c= new C(10,10);
		Gen<C> Aob;
		
		Aob = new Gen<C>(c);
		g.drawString(Aob.showType(),20,120);
		
		//int sum = Aob.getOB().i+Aob.getOB().j;
		
		A a = Aob.getOB();
		//g.drawString(String.valueOf(a.i+a.j),20,140);
		
		TwoD[] twoD= {
			new TwoD(0, 0),
			new TwoD(10, 10),
			new TwoD(20, 20),
			new TwoD(30, 30),
		};
		
		Coords<TwoD> coords = new Coords<>(twoD);
		g.drawString(Coords.showXY(coords),20,140);
		
		FourD[] fourD= {
				new FourD(0, 0, 0, 0),
				new FourD(10, 10, 10, 10),
				new FourD(20, 20, 20, 20),
				new FourD(30, 30, 30, 30),
			};
		Coords<FourD> coords2 = new Coords<>(fourD);
		g.drawString(Coords.showXY(coords2),20,140);

	}
	
}

