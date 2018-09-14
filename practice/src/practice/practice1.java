package practice;

public class practice1 {
	public static void main (String args[])
	{
		int i,n=Integer.parseInt(args[0]),bottom=1;
		//int top=0,div=1,y=0;
		for(i=1;i<=n;i=i++)
		{
			bottom=bottom*i;
		}
		System.out.println(bottom);
		/*
	 	for(i=1;i<=n;i++)
		{
			y=bottom/i;
			top=top+y;
		}
		System.out.println(top);
		for(i=1;i<=bottom;i++)
		{
			if(bottom%i==0&&top%i==0) div=i;
		}
		top=top/div;
		bottom=bottom/div;
		System.out.println(top+"/"+bottom);
		//*/
	}

}
