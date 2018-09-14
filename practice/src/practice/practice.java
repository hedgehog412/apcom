package practice;

public class practice 
{
	public static void main (String args[])
	{
		int top, bottom, i, n, div=0,x=0;
		n=Integer.parseInt(args[0]);
		top=0;
		bottom=1;
		for(i=1;i<=n;i++)
		{
			for(x=1;x<=i;x++)
			{
				if(i%x==0) div=div+1;
			}
			if(div==2) bottom=bottom*i;
			div=0;
		}
		System.out.println(bottom);
			for(i=1;i<=n;i++)
			{
				for(x=1;x<=i;x++)
				{
					if(i%x==0) div=div+1;
				}
			if(div==2) top=top+bottom/i;
			div=0;
		}
		System.out.println(top);
		for(i=1;i<=bottom;i++)
		{
			if(bottom%i==0&&top%i==0) x=i;
		}
		System.out.println(x);
		System.out.println(top/x+"/"+bottom/x);
	}
}
