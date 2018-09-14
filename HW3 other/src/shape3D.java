
public class shape3D extends Shape{
	public shape3D(String name, double value){
		super(name,value);
	}
	public double surfaceArea()
	{
		return myValue*myValue;
	}
	public double volume(){
		return myValue*myValue*myValue;
	}
	
	public int compareTo(Object obj){
		final double EPSILON=1.0e-15;
		shape3D a=(shape3D) obj;
		double diff=volume()-a.volume();
		
		if(Math.abs(diff)<=EPSILON*Math.abs(volume())){
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
		if(((shape3D) a).compareTo(b)>0){
			return a;
			
		}
		else{
			return b;
		}
		
	}
	
	public boolean equals(Object a, Object b){
		if(((shape3D)a).compareTo(b)==0){
			return true;
		}
		else{
			return false;
		}
	}

}
