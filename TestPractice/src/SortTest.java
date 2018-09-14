import java.util.Random;

public class SortTest
{
	public static void main(String[] args) 
	{
		Random rand = new Random(10);
		int size;
		int[] array;
		int[] dup;
		if(args.length == 0)
			size = 12;
		else
			size = Integer.parseInt(args[0]);

		array = new int[size];
		dup = new int[size];
		
		randomInitialize(array, rand);
		System.out.println("Selection Sort...");
		duplicateArray(array, dup);
		printArray(dup);
		System.out.println("\n\n************************\n");
		//Sorting.SelectionSort2(dup);
		printArray(dup);
		System.out.println(test(dup));
		
		randomInitialize(array, rand);
		System.out.println("Insertion Sort...");
		duplicateArray(array, dup);
		printArray(dup);
		System.out.println("\n\n************************\n");
		//Sorting.InsertionSort2(dup);
		printArray(dup);
		System.out.println(test(dup));
		
		randomInitialize(array, rand);
		System.out.println("Merge Sort...");
		duplicateArray(array, dup);
		printArray(dup);
		System.out.println("\n\n************************\n");
		//Sorting.MergeSort2(dup,0,dup.length-1);
		printArray(dup);
		System.out.println(test(dup));
		
		randomInitialize(array, rand);
		System.out.println("Quick Sort...");
		duplicateArray(array, dup);
		printArray(dup);
		System.out.println("\n\n************************\n");
		Sorting.QuickSort(dup,0,dup.length-1);
		printArray(dup);
		System.out.println(test(dup));
		
		randomInitialize(array, rand);
		System.out.println("Heap Sort...");
		duplicateArray(array, dup);
		printArray(dup);
		System.out.println("\n\n************************\n");
		//Sorting.HeapSort(dup);
		printArray(dup);
		System.out.println(test(dup));

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
