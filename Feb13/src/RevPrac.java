
public class RevPrac {
	public static void rev(int n){
		System.out.print(n%1000+" ");
		if(n/1000!=0){
			rev(n/1000);
		}
		//바보야 이렇게 간단한 거였어!!!
	}
	public static void main (String[] args){
		rev(123456789);
	}
}
