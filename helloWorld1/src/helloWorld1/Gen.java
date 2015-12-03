package helloWorld1;

public class Gen<T> {
	T ob;
	Gen(T o){
		ob = o;
	}
	T getOB(){
		return ob;
	}
	String showType(){
		return ob.getClass().getName(); 
	}
	
	boolean equals(Gen<T> ob2){
		if (ob== ob2)
			return true;
		return false;
	}
	
	boolean equals2(Gen<?> ob2){
		if (ob.getClass().getName()== ob2.getClass().getName())
			return true;
		return false;
	}
}
