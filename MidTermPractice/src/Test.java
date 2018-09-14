
public class Test {
	public static void main (String [] args)
	{
		MidTermPracticeAP[] hi=new MidTermPracticeAP[15];
		for(int i=0;i<=14;i++)
		{
			hi[i]=new MidTermPracticeAP();
		}
		for(int i=0;i<=14;i++)
		{
			hi[i].setName(i+"번째");
			hi[i].setAge(i);
		}
		for(int i=0;i<=14;i++)
		{
			System.out.println(hi[i].getAge());
			System.out.println(hi[i].getName());
		}
		switch (5-3)
		{
			case 1:System.out.println("hey");
			
			case 2:System.out.println("no");
			
			default :System.out.println("no break");
		}
		int a=4;
		System.out.println(Math.sqrt((double) a));
		
		int[] x=new int[14];
		for(int i=0;i<=13;i++)
		{
			x[i]=i;
		}
		for(int k:x)
		{
			System.out.println(k);
		}
		
		//System.out.printf("%4.5d",4.0/3);
		
	}
}
