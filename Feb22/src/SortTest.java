import java.util.*;

public class SortTest//insertion 

{
	
	public static void main(String[] args) 
	{
		
		Random rand = new Random(10);
		int size;
		int[] array;
		int[] dup;
		if(args.length == 0)
			size = 10000;
		else
			size = Integer.parseInt(args[0]);

		array = new int[size];
		dup = new int[size];
		long [] time=new long[5];
		
		randomInitialize(array, rand);
for(int i=0;i<5;i++){
	long startTime = System.nanoTime();
		System.out.println("Insertion Sort...");
		duplicateArray(array, dup);
		printArray(dup);
		System.out.println("\n\n************************\n");
		InsertionSort.sort2(dup);
		System.out.println("\n\n************************\n");
		printArray(dup);
		System.out.println(test(dup));
		long endTime = System.nanoTime();
		System.out.println("Took "+(endTime - startTime) + " ns"); 
		time[i]=endTime-startTime;
}
System.out.println((time[0]+time[1]+time[2]+time[3]+time[4])/5);
	}

	public static void duplicateArray(int[] array, int[] dup)
	{
		int n = array.length;

		for(int i = 0; i < n; i++)
		{
			dup[i] = array[i];
		}
	}

	public static void randomInitialize(int[] a, Random r)
	{
		for(int i = 0; i < a.length; i++)
			a[i] = r.nextInt(100);
	}

	public static void printArray(int[] a)
	{
		for(int i = 0; i < a.length; i++)
		{
			System.out.print("[" + i + "," + a[i] + "] ");
			if((i + 1) % 10 == 0) System.out.println();
		}
	}
	
	public static boolean test(int[] a)
	{
		for(int i=0;i<a.length-1;i++){
			if(a[i]>a[i+1]) return false;
		}
		return true;
	}
	
}
