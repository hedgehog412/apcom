
public class SequentialSearch {
	public static boolean ifExists(int[] array, int val){
		for(int a:array){
			if(a==val){
				return true;
			}
		}
		return false;
	}
	public static int numExists(int[] array, int val){
		int count=0;
		for(int a:array){
			if(a==val){
				count++;
			}
		}
		return count;
	}
}
