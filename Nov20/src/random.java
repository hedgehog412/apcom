import chn.util.*;
public class random {
	public static void main(String[] args){
	//Math.random의 확률 확인
		//*
	int n;
	SimpleIO in=new SimpleIO();
	int num;
	int[] count=new int[10];
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
	
	
	int c=1;
	
	for(int a:count){
		System.out.println(c+"구간이 나온 횟수는 "+a);
		c++;
	}
	
	c=1;
	int avg=0;
	for(double a:prob){
		System.out.println(c+"구간의 확률은 "+a);
		c++;
		avg=avg+(int)Math.round(a);
	}
	avg=avg/10;
	System.out.println();
	int diff=0;
	for(int i=0;i<10;i++){
		diff=diff+(count[i]-num/10)*(count[i]-num/10);
	}
	System.out.println("분산은 "+(diff/num));
	System.out.println("표준편차는 "+Math.sqrt(diff/num));
	System.out.println("확률 평균은 "+avg);
	}
}
}
