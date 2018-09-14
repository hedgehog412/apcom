
public abstract class Shape implements Comparable{
	private String myName;
	
	public Shape(String name){
		myName=name;
	}
	
	public String getName(){
		return myName;
	}
	public abstract double area();
	
	public abstract double perimeter();
	
	public double semiPerimeter(){
		return perimeter()/2;
	}
	
	public int compareTo(Object a){
		final double EPSILON=1.0e-15;
		 Shape rhs=(Shape) a;
		 double diff=area()-rhs.area();
		 if(Math.abs(diff)<=EPSILON*Math.abs(area())){
			 return 0;
		 }
		 else if(diff<0) return -1;
		 else return 1;
	}
}
