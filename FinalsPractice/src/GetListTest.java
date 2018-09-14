import java.util.*;
public class GetListTest {
	public static List<Integer> getList(){
		List<Integer> a=new ArrayList<Integer>();
		Scanner sc=new Scanner(System.in);
		int x;
		do{
			System.out.println("put in an integer, 0 means stop");
			x=sc.nextInt();
			a.add(x);
		}while(x!=0);
		
		return a;
	}
	
	public static void writeLIst(List<Integer> a){
		System.out.println("List is: "+a);
	}
}
