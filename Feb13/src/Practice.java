
public class Practice {
	public static int factorial (int n){
		if(n==0){
			return 1;
		}
		else{
			int result= n*factorial(n-1);
			System.out.print(n+"*");
			return result;
		}
	}
	public static void drawLine(int n){
		if(n==0){
			System.out.println("That's it, folks!");
		}
		else{
			for(int i=1;i<=n;i++){
				System.out.print("*");
			}
			System.out.println();
			drawLine(n-1);
			for(int i=1;i<=n;i++){
				System.out.print("*");
			}
			System.out.println();
		}
	}
	public static void main (String [] args){
		System.out.println(factorial(5));
		drawLine(5);
	}
}
