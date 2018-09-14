
public class Sep27 {
	private static int noInstance=1;
	public void Student ()
	{
		noInstance++;//Student object가 만들어진 횟수를 말함
	}
	//*/
	public static void main (String [] args){
		for(int i=1;i<=15;i++)
		{
		Student hi=new Student();
		}
	System.out.println(noInstance);//만약에 noInstance가 static이 아니면 main method에서 못 가져옴
	}
}
