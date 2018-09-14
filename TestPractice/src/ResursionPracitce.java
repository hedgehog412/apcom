import java.util.Scanner;

public class ResursionPracitce {
	public static void main(String[] args){
		//stackWords();
		//System.out.println();
		//drawLine(5);
		System.out.println(fact(5));
		revDigs(135);
		System.out.println();
		hw1(123456789);
		System.out.println();
		hw1better(makeNewNum(12345678));
	}
	public static void stackWords(){
		Scanner in=new Scanner(System.in);
		String word=in.nextLine();
		if(word.equals(".")) System.out.println();
		else stackWords();
		System.out.println(word);
	}
	public static void drawLine(int n){
		if(n==0) System.out.println("That's all, folks!");
		else{
			for(int i=0;i<n;i++){
				System.out.print("*");
			}
			System.out.println();
			drawLine(n-1);//위치에 따라 순서가 바뀐다.
		}
	}
	public static int fact(int a){
		if(a==0) return 1;
		return a*fact(a-1);
	}
	public static void revDigs(int a){
		int temp=a%10;
		System.out.print(temp);
		if(a>=10){
			revDigs(a/10);
		}
	}
	public static void hw1(int a){// 123 456 789->789 456 123
		System.out.print(a%1000);
		if(a>=1000){
			hw1(a/1000);
		}
	}
	public static void hw1better(int newNum){
		
		int x;
		int y,z;
		//System.out.println(newNum);
		x=newNum%10;
		y=(newNum/10)%10;
		z=(newNum/100)%10;
		if(newNum>=1000){
			hw1better(newNum/1000);
		}
		if(z!=0){
		System.out.print(x+""+y+""+z);
		}
		else{
			System.out.print(x+""+y);
		}
	}
	public static int makeNewNum(int a){
		int newNum=0;
		while(a>0){
			newNum=newNum*10+(a%10);
			a=a/10;
		}
		return newNum;
	}
		
}
