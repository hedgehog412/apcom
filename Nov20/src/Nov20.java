import java.util.*;
public class Nov20 {
	public static void main (String [] args){
		//Nov14에서 한 예제 참고
		//쌤 풀이
		/*
		final int TRIAL=10;
		Scanner sc=new Scanner (System.in);
		int n, count=0, sum=0;
		
		System.out.println("입력해");
		for(int i=1;i<=TRIAL;i++){
			count++;
			System.out.print(i+"번째 입력");
			n=sc.nextInt();
			if(!(n>=1&&n<=100)){
				System.out.print("다시 입력");
				i--;
			}
			else sum+=n;
		}
		System.out.println("정상입력된"+TRIAL+"의 합"+sum);
		System.out.println("정상입력된"+TRIAL+"의 평균"+(double)sum/10);
		System.out.println(count+"번 실행");
		//*/
		
		/*continue 사용 
		final int TRIAL=10;
		Scanner sc=new Scanner (System.in);
		int n, count=0, sum=0;
		
		System.out.println("입력해");
		for(int i=1;i<=TRIAL;i++){
			count++;
			System.out.print(i+"번째 입력");
			n=sc.nextInt();
			if(!(n>=1&&n<=100)){
				System.out.print("다시 입력");
				i--;
				continue;//아래에 나오는 문장을 다 무시해서 다음으로 이동(안 써도 됨 b/c 보조 수단임)
			}
			sum+=n;
		}
		System.out.println("정상입력된"+TRIAL+"의 합"+sum);
		System.out.println("정상입력된"+TRIAL+"의 평균"+(double)sum/10);
		System.out.println(count+"번 실행");
		//*/
		
		//57. 승부가 날 때까지 가위바위보 계속-56번에서 추가
		/*
		Scanner sc=new Scanner(System.in);
		int me;
		
		for(;;){
		System.out.println("1~3사이의 정수를 입력하세요. 1은 가위, 2는 바위, 3은 보입니다");
		
		for(;;){
		me=sc.nextInt();
		if(!(me>=1&&me<=3))
		{
			System.out.println("좋은 말로 할 때 1~3 사이 입력해!!!");
		}
		else{break;}
		}//이부분을 조금 바꿔봤음 
		/*쌤 방법
		 * for(;!(me>=1&&me<=3);){
		 * me=sc.nextInt();
		 * if(!(me>=1&&me<=3)System.out.println("again");
		 * }
		 */
		/*	
		System.out.print("나는 ");
		
		System.out.print(me==1?"가위":me==2?"바위":me==3?"보":"입력에러");
		
		System.out.println(" 냈습니다");
		
		int com;
		com=(int)(Math.random()*3.0+1.0);
		System.out.print("컴퓨터는 ");
		if(com==1) System.out.print("가위");
		else if(com==2) System.out.print("바위");
		else System.out.print("보");
		System.out.println(" 냈습니다");
		
		//효율을 위해
		 * if(me==com) continue;
		 * 밑에 지움, break는 else 다음에
		 */
		
		/*
		int res=(me-com+3)%3;
		
		if(res==1){
		System.out.println("내가 이겼음");
		System.out.println("***********************");
		break;
		}
		
		else if(res==0){
		System.out.println("서로 비겼음");
		System.out.println("***********************");
		System.out.println("다시 시작하세요");
		}
		
		else{
		System.out.println("컴퓨터가 이겼음");
		System.out.println("***********************");
		break;
		}
		
		
		}
//*/
		
	}

}
