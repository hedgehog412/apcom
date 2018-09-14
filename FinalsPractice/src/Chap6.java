import java.util.*;
public class Chap6 {
	public static void main (String[] args){
		int[] a;
		a=getIntegers();
		System.out.println(countEven(a));
		printArray(a);
		changeEven(a);
		printArray(a);
		changeArray(a);
		printArray(a);
		swap(a,0,3);
		printArray(a);
		System.out.println(findMin(a));
		
	}
	public static int countEven(int[] arr){
		int count=0;
		for(int a:arr){
			if(a%2==0) count++;
		}
		return count;
	}
	public static void changeEven(int [] arr){
		for(int i=0;i<arr.length;i++){
			if(i%2==0) arr[i]=0;
		}
	}
	public static void printArray(int[] a){
		for(int i=0;i<a.length;i++){
			System.out.print("["+(i)+" , "+a[i]+"]");
		}
		System.out.println();
	}
	public static int findMin(int[] a){
		int minIndex=0;
		for(int i=1;i<a.length;i++){
			if(a[minIndex]>a[i]) {
				minIndex=i;
			}
		}
		return minIndex;
	}
	public static void changeArray(int[] a){
		for(int i=0;i<a.length;i++){//for-each loop won't work
			a[i]+=3;
		}
	}
	public static void swap(int[] a, int x, int y)
	{
		int i=a[x];
		a[x]=a[y];
		a[y]=i;
	}
	public static int[] getIntegers(){
		Scanner sc=new Scanner(System.in);
		final int NUM_ELEMENTS=sc.nextInt();
		int[] a=new int[NUM_ELEMENTS];
		for(int i=0;i<a.length;i++){
			a[i]=sc.nextInt();
		}
		return a;
	}
	public static int countNegs(int[] a){
		int count=0;
		for(int i:a){
			if(i<0) count++;
		}
		return count;
	}
}
