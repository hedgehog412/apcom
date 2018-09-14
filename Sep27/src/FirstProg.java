
public class FirstProg {
	static int age;
	static String name;
	public int method1 (int myAge)
	{
		return myAge;
	}
	public static String method2 (String myName)
	{
		return myName;
		
	}
	public static void main (String []args)
	{
		System.out.println(method2("전지"));
		//System.out.println(method1(5));//를 하면 static main method에서 nonstatic을 써야 하니까 에러가 뜸 
	}
}
