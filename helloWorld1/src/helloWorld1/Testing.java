package helloWorld1;

public class Testing {
	public static void main(String[] args){
		System.out.println(endUp("helooz"));
	}
	
	public static String endUp(String str) {
		  if (str.length()<=3)
		    return str.toUpperCase();
		  return str.substring(0,str.length()-3)+ (str.substring(str.length()-3,str.length())).toUpperCase();
		}
}
