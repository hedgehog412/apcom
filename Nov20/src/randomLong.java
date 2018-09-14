import chn.util.SimpleIO;
public class randomLong {
	public static void main(String[] args){
		//Math.random의 확률 확인
			//*
		int n;
		SimpleIO in=new SimpleIO();
		long num;
		long[] count=new long[10];
		double[] prob=new double[10];
		
		for(;;){
			num=in.readInt();
			if(num==0){
				break;
			}
		for(int i=0;i<count.length;i++){
			count[i]=0;
		}
		
		for(int i=1;i<=num;i++){
		n=(int)(Math.random()*10)+1;
		
		count[n-1]+=1;
		
		}
		
		for(int i=0;i<count.length;i++){
			prob[i]=count[i]*100/num;
		}
		
		System.out.println("\n***********************\n");
		System.out.println("Tried "+num+"times\n");
		int i=1;
		
		for(long c:count){
			System.out.println(i+"구간이 나온 횟수는 "+c);
			i++;
		}
		
		i=1;
		System.out.println();
		for(double a:prob){
			System.out.println(i+"구간의 확률은 "+a);
			i++;
		}
		
		long diff=0;
		for( i=0;i<10;i++){
			diff=diff+(count[i]-num/10)*(count[i]-num/10);
		}
		System.out.println("\n분산은 "+(diff/num));
		System.out.println("표준편차는 "+Math.sqrt(diff/num));
		
		System.out.println("\n****************\n");
		}
	}

}
