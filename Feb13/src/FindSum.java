
public class FindSum {
	private static int sum(int n){
		if(n==1) return 1;
		return n+sum(n-1);
	}
	public static int getSum(int n) throws Exception{
		if(n>0) return sum(n);
		else throw new IllegalArgumentException("Can't find sum for negative number");
	}
}
