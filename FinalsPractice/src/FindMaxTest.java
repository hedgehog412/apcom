
public class FindMaxTest {
	public static Comparable max(Comparable a, Comparable b){
		if(a.compareTo(b)>0){
			return a;
		}
		else{
			return b;
		}
	}
	public static void main (String args[]){
		Shape s1=new Circle(3.0,"Circle");
		Shape s2=new Square(4.5,"Square");
		System.out.println("Area of"+s1.getName()+" is "+s1.area());
		System.out.println("Area of"+s2.getName()+" is "+s2.area());
		Shape s3=(Shape) max(s1,s2);
		System.out.println("The larger shape is the "+s3.getName());
	}

}
