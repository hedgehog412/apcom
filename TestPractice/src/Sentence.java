
public class Sentence {
	private String mySentence;
	private int myNumWords;
	
	public Sentence(String str){
		mySentence=str;
		myNumWords=1;
		for(int i=0;i<str.length();i++){
			if(str.charAt(i)==' '){
				myNumWords++;
			}
		}
	}
	
	public int getNumWords(){
		return myNumWords;
	}
	
	public String getSentence(){
		return mySentence;
	}
	
	private static String removeBlanks(String s){
		String result="";
		s=s.trim();
		int index=0;
		for(int i=index;i<s.length();i++){
			if(s.charAt(i)==' '){
				result=result+s.substring(index,i);
				index=i+1;
			}
		}
		result=result+s.substring(index,s.length());
		return result;
	}
	
	private static String lowerCase(String s){
		return s.toLowerCase();
	}
	
	private static String removePunctuation(String s){
		String result="";
		s=s.trim();
		int index=0;
		for(int i=index;i<s.length();i++){
			if(s.charAt(i)<'A'||s.charAt(i)>'z'){
				result=result+s.substring(index,i);
				index=i+1;
			}
		}
		result=result+s.substring(index,s.length());
		return result;
	}
	
	public boolean isPalindrome(){
		String temp=removeBlanks(mySentence);
		temp=removePunctuation(temp);
		temp=lowerCase(temp);
		return isPalindrome(temp,0,temp.length()-1);
	}
	
	public boolean isPalindrome(String str, int start, int end){
		if(start==end||end==start+1&&str.charAt(start)==str.charAt(end)){
			return true;
		}
		if(str.charAt(start)==str.charAt(end)){
			return isPalindrome(str,start+1,end-1);
		}
		else{
			return false;
		}
	}
	
	public static void main(String[] args){
		Sentence str=new Sentence("aavbcvaa");
		System.out.println(str.getNumWords());
		System.out.println(removeBlanks(str.getSentence()));
		System.out.println(removePunctuation(str.getSentence()));
		System.out.println(str.isPalindrome());
	}
}
