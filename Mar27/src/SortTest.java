import java.util.*;

public class SortTest//search test
{
	public static void main(String[] args) 
	{
		Random rand = new Random(10);
		int size;
		int[] array;
		int[] dup;
		if(args.length == 0)
			size = 1000;
		else
			size = Integer.parseInt(args[0]);

		array = new int[size];
		dup = new int[size];
		
		randomInitialize(array, rand);
		System.out.println("Insertion Sort...");
		duplicateArray(array, dup);
		printArray(dup);
		Random r=new Random();
		int val=99;
		System.out.println("\n\n************************\n");
		System.out.println(SequentialSearch.ifExists(dup,val )+" "+val);
		System.out.println(SequentialSearch.numExists(dup,val )+" "+val);
		System.out.println(BinarySearch.ifExists(dup,val,0,size-1 )+" "+val);
		System.out.println(BinarySearch.numExists(dup,val,0,size-1 )+" "+val);
		System.out.println("\n\n************************\n");
		MergeSort2.mergeSort(dup, 0, size-1);
		printArray(dup);

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
