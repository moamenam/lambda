
package test;




public class LambdaDemo {
	public static void main(String args[]){
		MyNumber myNum;
		NumericFunc numFunc;
		
		String str = new String("Test");
		str.regionMatches(0, "Test", 0, 4);
		myNum = () ->12.12;
		System.out.println("my number = "+myNum.getNum());
		myNum = () -> Math.random()*100;
		System.out.println("my number = "+myNum.getNum());
		
		System.out.println("my number = "+myNum.getNum());
		
		myNum = () -> {
			return Math.abs(100);
		};
		
		System.out.println("my number = "+myNum.getNum());
		
		numFunc = (n) -> {
			int result = 1;
			for(int i=1;i<=n;i++) result = result*i;
			
			return result;
		};
		
		System.out.println("my number = "+numFunc.func(6));
		
		
		
		String str2 = new String(str);
		String str3 = "Test";
		
		CharSequence x = "test";
		
		
		System.out.println("str.equals(str2):"+str.equals(str2));
		
		System.out.println("str==str2:"+(str==str2));
		
		System.out.println("str==str3:"+(str.toString()==str3.toString()));
		System.out.println("str.contains(x):"+str.contains(x));
		
		
		Float fl= new Float(101.0);
		System.out.println("integer.tobinarystring:"+Integer.toHexString(37));
	}

}
