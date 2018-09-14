
public class MidTermPractice {
	public static void main (String [] args)
	{
		/*호감볍 
		int m,n,t;
		m=Integer.parseInt(args[0]);
		n=Integer.parseInt(args[1]);
		
		for(;n!=0;)
		{
			if(m>=n)
			{
				m=m-n;
			}
			else
			{
				t=m;
				m=n;
				n=t;
			}
		}
		System.out.println(m);
		//*/
		
		/*호제볍 
		int m,n,t;
		m=Integer.parseInt(args[0]);
		n=Integer.parseInt(args[1]);
		
		for(;n!=0;)
		{
			if(m>=n)
			{
				m=m%n;
			}
			else
			{
				t=m;
				m=n;
				n=t;
			}
		}
		System.out.println(m);
		//*/
		
		/*swap
		int x=8, y=7, t;
		t=x;
		x=y;
		y=t;
		System.out.println(x+" "+y);
		//*/
		
		/*피보나치 수열 
		int x1,x2=1,sum=0,t;
		System.out.print(0);
		x1=0;
		int n=Integer.parseInt(args[0]);
		for(int i=3;x2<=n;i++)
		{
			sum=sum+x2;
			System.out.print("+"+x2);
			t=x1;
			x1=x2;
			x2=t+x2;
		}
		System.out.print("="+sum);
		//*/
		
		/*1/2-1/3+1/5-1/7+...
		int flag=0, n=Integer.parseInt(args[0]),div=0;
		final double TOP=1.0;
		double sum=0.0;
		
		for(int i=1;i<=n;i++)
		{
			for(int j=1;j<=i;j++)
			{
				if(i%j==0) div+=1;
			}
			if(div==2) {
				if(flag==0) 
					{
					sum=sum+TOP/i;
					flag=1;
					}
				else 
					{
					sum=sum-TOP/i;
					flag=0;
					}
			}
			div=0;
		}
		System.out.println(sum);
		//*/
		
		/*초항이 2이고 공비가 2인 등비수열 초항부터 n번째 항까지의 합은 얼마인지 출력하시오.+n번째 항
		int  sum=2,num=2;
		int n=Integer.parseInt(args[0]);
		
		for(int i=2;i<=n;i++)
		{
			num=num*2;
			sum=sum+num;
		}
		System.out.println(sum+" "+num);
		
		//*/
		
		//System.out.println(Integer.toBinaryString());
		//System.out.println(Float.MIN_VALUE);
		//int x=5;
		//System.out.println(x=x++-++x);
		/*
		int n, a, k, b, sum;
		n=Integer.parseInt(args[0]);
		sum=0;
		a=3;
		for (k=1;k<=n;k++){ 
		a=3;
		for (b=1;b<k;b++){
		a=a*2;
		}
		sum=sum+a;
		}
		System.out.println(sum);
		//*/
		/*
		char x='A';
		for(int i=1;i<=4;i++)
		{
			for(int j=1;j<=i;j++)
			{
				System.out.print(x);
				x++;
			}
			System.out.println();
			x='A';
		}
		//*/
		
		double sum=0.0;
		double top=1.0;
		int flag=0;
		int n=Integer.parseInt(args[0]);
		int div=0;
		for(int i=1;i<=n;i++)
		{
			for(int j=1;j<=i;j++)
			{
				if(i%j==0) div++;
			}
			if(div==2){if(flag==0)
			{
				sum=sum+top/i;
				top=top+1.0;
				flag=1;
			}
			else{
				sum=sum-top/i;
				top=top+1.0;
				flag=0;
			}
			}
			div=0;
		}
		System.out.println(sum);
	}

}
