
public abstract class Shape implements Comparable {
	private String myName;
	protected static double myValue;
	public Shape(String name, double value){
		myName=name;
		myValue=value;
	}
	
	public String getName(){
		return myName;
	}
	
	public abstract int compareTo(Object obj);
	
	public abstract Object max(Object a, Object b);
	
	public abstract boolean equals(Object a, Object b);

}
