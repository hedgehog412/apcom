
public class shape2D extends Shape {
	public shape2D(String name, double value){
		super(name,value);
	}
	public double area()
	{
		return myValue*myValue;
	}
	public double perimeter(){
		return myValue;
	}
	public int compareTo(Object obj){
		final double EPSILON=1.0e-15;
		shape2D a=(shape2D) obj;
		double diff=area()-a.area();
		
		if(Math.abs(diff)<=EPSILON*Math.abs(area())){
			return 0;
		}
		else if(diff<0){
			return -1;
		}
		else{
			return 1;
		}
	}
	
	public Object max(Object a, Object b){
		if(((shape2D) a).compareTo(b)>0){
			return a;
			
		}
		else{
			return b;
		}
		
	}
	
	public boolean equals(Object a, Object b){
		if(((shape2D)a).compareTo(b)==0){
			return true;
		}
		else{
			return false;
		}
	}

}
