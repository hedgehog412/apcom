
public class Search {
	public static boolean SequentialSearchB(int[] arr,int val){
		boolean result=false;
		int i=0;
		while(!result&&i<arr.length){
			if(arr[i]==val){
				result=true;
			}
			i++;
		}
		return result;
	}
	
	public static int SequentialSearchI(int[] arr,int val){
		int count=0;
		int i=0;
		while(i<=arr.length-1){
			if(arr[i]==val) count++;
			i++;
		}
		
		return count;
	}
	
	public static boolean BinarySearchB(int[] arr, int val){
		boolean result=false;
		Sorting.InsertionSort1(arr);
		result=BinarySearch(arr,0,arr.length-1,val);
		System.out.println(result);
		return result;
	}
	
	public static boolean BinarySearch(int[] arr, int start, int end, int val){
		int mid=(start+end)/2;
		boolean result=false;
		if(end-start>=1){
			if(val>arr[mid]){
				System.out.println(1+" "+mid);
				return BinarySearch(arr,mid+1,end,val);//return으로 해줘야 함 안 그러면 계속 덮어씌워서 없음
				
			}
			else if(val<arr[mid]){
				System.out.println(2+" "+mid);
				return BinarySearch(arr,start,mid-1,val);
				
			}
			else{
				System.out.println("OK");
				result=true;
			}
		}
		else{
			System.out.println(start+" "+end);
			System.out.println(arr[start]);
			if(val==arr[start]||val==arr[end]){
				System.out.println(3);
				result=true;
			}
		}
		return result;
	}
	
	public static int BinarySearchI(int[] arr, int val){//여기서 따로 처리해줘야 함
		int result=0;
		Sorting.InsertionSort1(arr);
		result=Binary(arr,0,arr.length-1,val);
		int count;
		if(result<0) count=0;
		else {count=1;
		int i=result;
		System.out.println(result);
		while(i<=arr.length-1&&arr[i]==arr[i+1]){
			count++;
			i++;
		}
		i=result;
		while(i>0&&arr[i]==arr[i-1]){
			count++;
			i--;
		}
		}
		return count;
	}
	
	public static int Binary(int[] arr, int start, int end, int val){
		int mid=(start+end)/2;
		int result=-1;
		if(end-start>=1){
			if(val>arr[mid]){
				System.out.println(1+" "+mid);
				return Binary(arr,mid+1,end,val);//return으로 해줘야 함 안 그러면 계속 덮어씌워서 없음
				
			}
			else if(val<arr[mid]){
				System.out.println(2+" "+mid);
				return Binary(arr,start,mid-1,val);
				
			}
			else{
				System.out.println("OK");
				result=mid;
			}
		}
		else{
			System.out.println(start+" "+end);
			System.out.println(arr[start]);
			if(val==arr[start]||val==arr[end]){
				System.out.println(3);
				result=start;
			}
		}
		return result;
	}
	
	public static void printArray(int[] a)
	{
		for(int i = 0; i < a.length; i++)
		{
			System.out.print("[" + i + "," + a[i] + "] ");
			if((i + 1) % 10 == 0) System.out.println();
		}
	}
	
	public static void main(String[] args){
		int[] arr={5,8,1,0,7,4,0,5,0};
		System.out.println("**"+BinarySearchI(arr,5));
		printArray(arr);
	}
}
