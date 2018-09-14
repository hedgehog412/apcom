
public class Sorting {
	public static void SelectionSort(int[] array){
		int index=0;
		int min=array[index];
		for(int i=0;i<array.length;i++){
			index=i;
			min=array[index];
			for(int j=index;j<array.length;j++){
				if(min>array[j]){
					min=array[j];
					index=j;
				}
			}
			swap(array,i,index);
		}
	}
	
	public static void InsertionSort1(int[] array){
		int idx=1;
		int index=idx;
		while(idx<array.length){
			for(int i=idx;i>=0;i--){
				if(array[index]<array[i]){
					swap(array,i,index);
					index=i;
				}
			}
			idx++;
			index=idx;
		}
	}
	
	public static void InsertionSort2(int[] array){
		int bound=1;
		int i;
		while(bound<array.length){
			for(i=bound;i>=0;i--){
				if(array[i]<array[bound]){
					break;
				}
			}
			insert(array,i+1,bound);
			bound++;
		}
	}
	
	public static void SelectionSort2(int[] array){
		int index=0;
		while(index<array.length){
		index=SelectionSort2(array,index);
		}
	}
	
	private static int SelectionSort2(int[] array, int idx){
		int min=array[idx];
		int index=idx;
		for(int i=idx+1;i<array.length;i++){
			if(array[i]<min){
				min=array[i];
				index=i;
			}
		}
		swap(array,index,idx);
		return idx+1;
	}
	
	public static void MergeSort(int[] array,int start,int end){
		int mid=(start+end)/2;
		
		System.out.println(start+" "+(mid)+" "+(mid+1)+" "+end);
		
		if(mid-start>=1) MergeSort(array,start,mid);
		if(end-mid-1>=1) MergeSort(array,mid+1,end);
		
		merge(array,start,mid,mid+1,end);
		
	}
	
	private static void merge(int[] array, int start1, int end1, int start2, int end2){
		System.out.println("\nStart merge : "+start1+" "+end1+" "+start2+" "+end2);
		printArray(array);
		int i=start1;
		int j=start2;
		int[] result=new int[end2-start1+1];
		int idx=0;
		while(i<=end1&&j<=end2){
			if(array[i]<array[j]){
				result[idx]=array[i];
				idx++;
				i++;
			}
			else{
				result[idx]=array[j];
				idx++;
				j++;
			}
		}
		
		while(idx<result.length){
			if(i<=end1){//조검이 바뀌어야함
				result[idx]=array[i];
				idx++;
				i++;
			}
			else if(j<=end2){
				result[idx]=array[j];
				idx++;
				j++;
			}
		}
		
		
		idx=start1;
		for(int a:result){
			//System.out.println(a);
			array[idx]=a;
			idx++;
		}
		System.out.println("\nEnd merge :");
		printArray(array);
	}
	
	public static void MergeSort2(int[] arr, int start, int end){//얘는 mergesort1과 같음
		int mid=(start+end)/2;

		System.out.println(start+" "+(mid)+" "+(mid+1)+" "+end);

		if(mid-start>=1) MergeSort2(arr,start,mid);
		if(end-mid-1>=1) MergeSort2(arr,mid+1,end);

		merge2(arr,start,mid,mid+1,end);
	}
	
	public static void merge2(int[] arr,int start1, int end1, int start2, int end2){
		System.out.println("\nStart merge : "+start1+" "+end1+" "+start2+" "+end2);
		printArray(arr);
		int i=start2;
		int j=end2;
		while(i<=j){
			swap(arr,i,j);
			System.out.println("\n\nFlipped");
			printArray(arr);
			System.out.println();
			i++;
			j--;
		}
		
		
		
		int[ ]result=new int[end2-start1+1];
		i=start1;
		j=end2;
		int idx=0;
		
		while(i<=j){
			if(arr[i]<arr[j]){
				result[idx]=arr[i];
				idx++;
				i++;
			}
			else{
				result[idx]=arr[j];
				idx++;
				j--;
			}
		}
		
		idx=start1;//조심
		for(int a:result){
			System.out.println(a);
			arr[idx]=a;
			idx++;
		}
		System.out.println("\nEnd merge :");
		printArray(arr);
		System.out.println();
	}
	
	public static void QuickSort(int[] arr,int start, int end){
		
		int idx=start;
		int pivot=arr[start];
		int up=start+1;
		int down=end;
		int i=1, j=1;
		System.out.println("\n*****"+pivot+" "+start+" "+end+"*******\n");
		while(up<=down){//****=들어가야 함
			
			//*
			while(up<=down&&pivot>arr[up]){
				up++;
			}
			while(up<=down&&pivot<arr[down]){//조검에 =들어가기
				down--;
			}
			//*/
			if(up>down){
				idx=up-1;
				swap(arr,idx,start);
				System.out.println("\n"+up+" "+down+" "+idx+"\n");
				printArray(arr);
			}
			else if(up==down){//얘가 안들어가면 무한 루프가 됨
					idx=up;
					swap(arr,idx,start);
					System.out.println("\n"+up+" "+down+" "+idx+"\n");
					printArray(arr);
				break;
			}
			else{
				swap(arr,up,down);
				System.out.println("\n"+up+" "+down+"\n");
				printArray(arr);
			}
		}
		
		//*
		if(start<idx){
			QuickSort(arr, start, idx-1);
		}
		if((idx+1)<=end){
			QuickSort(arr,idx+1,end);
		}
		//*/
	}
	
	public static void HeapSort(int[] arr){
		heap(arr);
		int[]result=new int[arr.length];
		int arrLength=arr.length;
		result[0]=arr[0];
		arr[0]=0;
		int fin=1;
		
		while(arrLength>=0&&fin<=result.length-1){
			int a=0;
			int idx=1;
			while(a==0){
				if(idx*2>arrLength-1){
					a=1;
				}
				else if(idx*2+1>arrLength-1){
					if(arr[idx*2]<arr[idx]){//얘를 또 조건을 나눠야 함
					printArray(arr);
					swap(arr,idx,idx*2);
					a=1;
					idx=idx*2;
					System.out.println("arr 1 "+idx);
					printArray(arr);
					}
					else{
						System.out.println("arr 1-2 "+idx);
						printArray(arr);
						a=1;
					}
				}
				else if(arr[idx*2]<=arr[idx*2+1]){
					if(arr[idx]>=arr[idx*2]){
						swap(arr,idx,idx*2);
						idx=idx*2;
						System.out.println("arr 2 "+idx);
						printArray(arr);
					}
					else{
						a=1;
					}
				}
				else{
					if(arr[idx]>=arr[idx*2+1]){
						swap(arr,idx,idx*2+1);
						System.out.println("arr 3 "+idx+" "+arrLength);
						printArray(arr);
						idx=idx*2+1;
					}
					else a=1;
				}
			}
			
			
			result[fin]=pop(arr,arrLength);
			System.out.println("arr 4 "+idx);
			printArray(arr);
			System.out.println("result");
			printArray(result);
			arrLength--;
			fin++;
		}
		int i=0;
		for(int a:result){
			arr[i]=a;
			i++;
		}
	}
	
	public static void HeapSort2(int[] arr){
		heap(arr,0,arr.length-1);
		int i=1;
		int[] result=new int[arr.length];
		result[0]=arr[0];
		
		while(i<=result.length-1){
			System.out.println(i);
		result[i]=pop(arr,i,arr.length-i);
		heap(arr,i,arr.length-1);
		printArray(result);
		i++;
		}
		
		for(int a:result){
			arr[i]=a;
			i++;
		}
	}
	
	public static void heap(int[] arr, int start,int end){
		int[] heap=new int[end+1];//+1해줘야 함
		int idx=1;
		int i=start;
		int real=start;
		int a=0;
		int temp=idx;
		while(idx<=end){
			heap[idx]=arr[i];
			temp=idx;//temp 사용해야 함
			while(a==0){
				if(heap[temp]<=heap[temp/2]){
					swap(heap,temp+real,temp/2+real);
					temp=temp/2;
				}
				else{
					a=1;
				}
			}
			a=0;
			idx++;
			i++;
		}
		i=0;
		for(int b=1;b<=heap.length-1;b++){
			arr[i]=heap[b];
			i++;
		}
	}
	
	///////////////////////////////////////////////////////////////////
	public static void swap(int[]arr, int a, int b){
		int temp=arr[a];
		arr[a]=arr[b];
		arr[b]=temp;
	}
	
	public static void insert(int[] arr,int idx,int validx){
		int temp=arr[validx];
		for(int i=validx;i>idx;i--){
			int t=arr[i-1];
			arr[i]=t;
		}
		arr[idx]=temp;
	}
	
	public static void printArray(int[] a)
	{
		for(int i = 0; i < a.length; i++)
		{
			System.out.print("[" + i + "," + a[i] + "] ");
			if((i + 1) % 10 == 0) System.out.println();
		}
	}
	
	public static int pop(int[] arr,int start,int arrLength){
		int temp=arr[start];
		arr[start]=arr[arrLength-1];
		arr[arrLength-1]=0;
		return temp;
	}
	
	public static boolean test(int[] a)
	{
		for(int i=0;i<a.length-1;i++){
			if(a[i]>a[i+1]) return false;
		}
		return true;
	}
	//////////////////////////////////////////////////////////////
	public static void main(String[] args){
		int[] arr={10,80,30,90,40,50,70};
		HeapSort2(arr);
		System.out.println("\nRESULT");
		printArray(arr);
		System.out.println(test(arr));
	}
}
