import java.util.*;

public class SortTest//quick
{
	public static void main(String[] args) 
	{long startTime = System.nanoTime();
		Random rand = new Random(10);
		int size;
		int[] array;
		int[] dup;
		if(args.length == 0)
			size = 21;
		else
			size = Integer.parseInt(args[0]);

		array = new int[size];
		dup = new int[size];
		randomInitialize(array, rand);
long [] time=new long[5];
		
		randomInitialize(array, rand);
		//for(int i=0;i<5;i++){
			startTime = System.nanoTime();
		System.out.println("Section Sort...");
		duplicateArray(array, dup);
		printArray(dup);
		QuickSort.sort(dup,0,size-1);
		System.out.println();
		printArray(dup);
		System.out.println(test(dup));
		
		randomInitialize(array, rand);
		long endTime = System.nanoTime();
		System.out.println("Took "+(endTime - startTime) + " ns");
		//time[i]=endTime-startTime;
		
		//System.out.println((time[0]+time[1]+time[2]+time[3]+time[4])/5);
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
