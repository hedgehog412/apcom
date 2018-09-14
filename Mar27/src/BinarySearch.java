
public class BinarySearch {
	public static void print(int[]array){
		System.out.print("[");
		for(int a:array){
			System.out.print(a+", ");
		}
		System.out.println("]");
	}
	public static boolean ifExists(int[] arr,int val,int start, int end){
		MergeSort2.mergeSort(arr,0,arr.length-1);
		int mid=(start+end)/2;
		
		if(end-start>=1){
		if(arr[mid]==val){
			return true;
		}
		else if(arr[mid]<val){
			return ifExists(arr,val,mid,end);
		}
		else if(arr[mid]>val){
			return ifExists(arr,val,start,mid);
		}
		}
			return false;
	}
	public static int numExists(int[] arr, int val, int start, int end){
		MergeSort2.mergeSort(arr,0,arr.length-1);
		int mid=(start+end)/2;
		int count=0;
		
		if(end-start>=1){
			if(arr[mid]==val){
				count++;
				int i=mid-1;
				while(i>=start&&arr[i]==val){
					count++;
					i--;
				}
				i=mid+1;
				while(i<=end&&arr[i]==val){
					count++;
					i++;
				}
				return count;
			}
			else if(arr[mid]<val){
				count=numExists(arr,val,mid,end);
			}
			else{
				count=numExists(arr,val,start,mid);
			}
		}
		return count;
	}
}
