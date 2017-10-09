
public class PrintThread3 extends Thread {
	public void run(){
		while(true){
			System.out.println("실행 중");
			if(Thread.interrupted())// interrupted 상태인지 확인한다.
			//if(this.isInterrupted())
				break;
		}
		System.out.println("자원정리");
		System.out.println("실행종료");
	}
}
